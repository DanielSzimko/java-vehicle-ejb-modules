package hu.ulyssys.java.course.javaee.demo.vehicle.dao;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;

import java.util.List;

public interface OwnerDAO extends CoreDAO<Owner>{

    Owner findByName(String name);

}
