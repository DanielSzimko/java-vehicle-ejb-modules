package hu.ulyssys.java.course.javaee.demo.vehicle.dao.impl;

import hu.ulyssys.java.course.javaee.demo.vehicle.dao.ShipDAO;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ShipDAOImpl extends CoreDAOImpl<Ship> implements ShipDAO {

    @Override
    protected Class<Ship> getManagedClass() {
        return Ship.class;
    }
}
