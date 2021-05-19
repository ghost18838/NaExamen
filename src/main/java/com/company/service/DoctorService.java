package com.company.service;

import com.company.dao.DAO;
import com.company.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DoctorService implements DAO<Doctor,Integer> {
    private SessionFactory sessionFactory;
    public DoctorService(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Doctor> readByAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("FROM Doctor", Doctor.class).list();
        }
    }

    @Override
    public Doctor read(Integer integer) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Doctor.class, integer);
        }
    }

    @Override
    public void create(Doctor doctor) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Doctor doctor) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(doctor);
            session.getTransaction().commit();
        }
    }
}
