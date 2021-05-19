package com.company.service;

import com.company.dao.DAO;
import com.company.model.Pacient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PacientService implements DAO<Pacient,Integer> {
    private SessionFactory sessionFactory;
    public PacientService(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Pacient> readByAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("FROM Pacient", Pacient.class).list();
        }
    }

    @Override
    public Pacient read(Integer integer) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Pacient.class, integer);
        }
    }

    @Override
    public void create(Pacient pacient) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(pacient);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Pacient pacient) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(pacient);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Pacient pacient) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(pacient);
            session.getTransaction().commit();
        }
    }
}
