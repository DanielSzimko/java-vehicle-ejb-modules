package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractVehicle extends AbstractEntity implements VehicleTypeAware {
    // long - 0 primitive
    // Long - null referencia/objektum típusú

    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "type")
    private String type;

    public AbstractVehicle() {
    }

    public AbstractVehicle(Long id, String manufacturer, String type) {
        super();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public VehicleType getVehicleType() {
        return null;
    }
}
