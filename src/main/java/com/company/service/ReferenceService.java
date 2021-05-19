package com.company.service;

import com.company.dao.DAO;
import com.company.model.Reference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReferenceService implements DAO<Reference, Integer> {
    private SessionFactory sessionFactory;
    public ReferenceService (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Reference> readByAll() {
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("FROM Reference",Reference.class).list();
        }
    }

    @Override
    public Reference read(Integer integer) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Reference.class, integer);
        }
    }

    @Override
    public void create(Reference reference) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(reference);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Reference reference) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(reference);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Reference reference) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(reference);
            session.getTransaction().commit();
        }
    }
}
