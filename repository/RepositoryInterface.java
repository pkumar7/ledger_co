package repository;

import java.util.ArrayList;

import domain.entities.EntityInterface;

public interface RepositoryInterface {

    public void save(EntityInterface entity);
    public EntityInterface get(String id);
    public EntityInterface update(EntityInterface entity);
    public ArrayList<EntityInterface> search(String... queries); // supporting only name search as of now, can be extended
}
