package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Car;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CarService;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.OwnerService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CarCRUDMbean implements Serializable {

    private List<Car> list;
    private List<Owner> ownerList;

    private Car selectedCar;
    private Long selectedCarOwnerId;
    private boolean inFunction;

    @Inject
    private CarService carService;
    @Inject
    private OwnerService ownerService;

    @PostConstruct
    private void init() {
        list = carService.getAll();
        selectedCar = new Car();
        ownerList = ownerService.getAll();
    }

    public void initSave() {
        selectedCar = new Car();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        if (selectedCar.getId() == null) {
            carService.add(selectedCar);
            list = carService.getAll();
            selectedCar = new Car();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            carService.update(selectedCar);
            list = carService.getAll();
            selectedCar = new Car();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }

        PrimeFaces.current().executeScript("PF('carDialog').hide()");


    }

    public void remove() {
        carService.remove(selectedCar);
        list = carService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedCar = new Car();
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
