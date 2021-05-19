package com.company.controller;

import com.company.dao.DAO;
import com.company.model.Doctor;
import com.company.model.Pacient;
import com.company.model.Reference;
import com.company.service.DoctorService;
import com.company.service.PacientService;
import com.company.service.ReferenceService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class MainController {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    ObservableList<Pacient> pacients = FXCollections.observableArrayList();
    ObservableList<Reference> references = FXCollections.observableArrayList();

    @FXML
    private BorderPane borderPane;


    @FXML
    private TableView<Doctor> tableViewDoctors;

    @FXML
    private TableColumn<Doctor, Integer> doctorId;

    @FXML
    private TableColumn<Doctor, String> doctorFio;

    @FXML
    private TableColumn<Doctor, String> doctorProfession;

    @FXML
    private TableColumn<Doctor, String> doctorCategories;

    @FXML
    private TableColumn<Doctor, String> doctorImage;

    @FXML
    private TableView<Pacient> tableViewPacients;

    @FXML
    private TableColumn<Pacient, Integer> pacientId;

    @FXML
    private TableColumn<Pacient, String> pacientFio;

    @FXML
    private TableColumn<Pacient, Date> pacientDate;

    @FXML
    private TableColumn<Pacient, String> pacientImage;

    @FXML
    private TableView<Reference> tableViewReference;

    @FXML
    private TableColumn<Reference, Integer> referenceId;

    @FXML
    private TableColumn<Reference, Date> referenceDate;

    @FXML
    private TableColumn<Reference, String> referenceDaignosis;

    @FXML
    private TableColumn<Reference, Integer> referenceCost;

    @FXML
    private TableColumn<Reference, Integer> referencePacientId;

    @FXML
    private ImageView imageView;

    @FXML
    void deleteAction(ActionEvent event) {
        Doctor t1 = (tableViewDoctors.getSelectionModel().selectedItemProperty().getValue());
        DoctorService doctorService = new DoctorService(sessionFactory);
        doctorService.delete(t1);
        doctors.remove(t1);

    }

    @FXML
    private void initialize(){
        DAO<Doctor, Integer> doctorIntegerDAO = new DoctorService(sessionFactory);
        DAO<Pacient, Integer> pacientIntegerDAO = new PacientService(sessionFactory);
        DAO<Reference, Integer> referenceIntegerDAO = new ReferenceService(sessionFactory);
        doctors.addAll(doctorIntegerDAO.readByAll());
        pacients.addAll(pacientIntegerDAO.readByAll());
        references.addAll(referenceIntegerDAO.readByAll());

        tableViewDoctors.setItems(doctors);
        tableViewPacients.setItems(pacients);
        tableViewReference.setItems(references);

        doctorId.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getId()));
        doctorFio.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getFio()));
        doctorCategories.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getCategories()));
        doctorProfession.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getProfession()));
        doctorImage.setCellValueFactory(c ->
                new SimpleObjectProperty<>(c.getValue().getMainImagePath()));
        tableViewDoctors.getSelectionModel().selectedItemProperty().addListener((observableValue, doctor, t1) ->{
            if (t1!=null){
                imageView.setImage(new Image("\\"+t1.getMainImagePath()));
            }
        });



    }

}
