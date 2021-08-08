package hu.ulyssys.java.course.javaee.demo.vehicle.service.impl;


import hu.ulyssys.java.course.javaee.demo.vehicle.dao.CoreDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

//Ezt nevezik generikus megoldásnak
public abstract class AbstractServiceImpl<T extends AbstractEntity> implements CoreService<T> {

    @Inject
    protected CoreDAO<T> dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    @Override
    public void add(T entity) {
        dao.save(entity);
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity.getId());
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }

}
