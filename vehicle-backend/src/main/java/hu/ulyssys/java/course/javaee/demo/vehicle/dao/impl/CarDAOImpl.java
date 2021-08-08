package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.CarDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;

import javax.ejb.Stateless;

@Stateless
public class CarDAOImpl extends CoreDAOImpl<Car> implements CarDAO{

    @Override
    protected Class<Car> getManagedClass() {
        return Car.class;
    }
}
