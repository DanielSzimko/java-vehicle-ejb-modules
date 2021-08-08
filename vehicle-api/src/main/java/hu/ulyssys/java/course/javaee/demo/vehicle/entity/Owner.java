package hu.ulyssys.java.course.javaee.demo.vehicle.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicle_owner")
public class Owner extends AbstractEntity {

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private Set<Car> cars;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Plane> planes;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Ship> ships;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        if (!super.equals(o)) return false;

        Owner owner = (Owner) o;

        if (lastName != null ? !lastName.equals(owner.lastName) : owner.lastName != null) return false;
        if (firstName != null ? !firstName.equals(owner.firstName) : owner.firstName != null) return false;
        if (registrationDate != null ? !registrationDate.equals(owner.registrationDate) : owner.registrationDate != null)
            return false;
        if (cars != null ? !cars.equals(owner.cars) : owner.cars != null) return false;
        if (planes != null ? !planes.equals(owner.planes) : owner.planes != null) return false;
        return ships != null ? ships.equals(owner.ships) : owner.ships == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        result = 31 * result + (planes != null ? planes.hashCode() : 0);
        result = 31 * result + (ships != null ? ships.hashCode() : 0);
        return result;
    }
}
