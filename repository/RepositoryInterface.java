package repository;

import domain.entities.EntityInterface;

public interface RepositoryInterface {

    public void save(EntityInterface entity);
    public EntityInterface get(String id);
    public EntityInterface update(EntityInterface entity);
    public EntityInterface search(String name); // supporting only name search as of now, can be extended
}
