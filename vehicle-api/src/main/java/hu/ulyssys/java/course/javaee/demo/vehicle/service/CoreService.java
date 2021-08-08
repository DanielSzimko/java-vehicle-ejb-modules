package hu.ulyssys.java.course.javaee.demo.vehicle.service;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractVehicle;

import java.util.List;

public interface CoreService<T> {
    List<T> getAll();

    void add(T entity);

    void remove(T entity);

    void update(T entity);

    T findById(Long id);
}
