package com.company.dao;


import java.util.List;

public interface DAO<Entity, Key>{
    List<Entity>readByAll();
    Entity read (Key key);
    void create(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);

}
