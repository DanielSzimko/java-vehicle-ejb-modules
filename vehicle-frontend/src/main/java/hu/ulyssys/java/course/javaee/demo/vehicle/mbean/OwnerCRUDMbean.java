package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Owner;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Ship;
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
public class OwnerCRUDMbean implements Serializable {

    private List<Owner> list;
    private Owner selectedOwner;

    private boolean inFunction;

    @Inject
    private OwnerService ownerService;

    @PostConstruct
    private void init() {
        list = ownerService.getAll();
        //Reflection
        selectedOwner = new Owner();
    }

    public void initSave() {
        selectedOwner = new Owner();
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        if (selectedOwner.getId() == null) {
            ownerService.add(selectedOwner);
            list = ownerService.getAll();
            selectedOwner = new Owner();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));
        } else {
            ownerService.update(selectedOwner);
            list = ownerService.getAll();
            selectedOwner = new Owner();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
        inFunction = false;
        PrimeFaces.current().executeScript("PF('ownerDialog').hide()");
    }

    public void remove() {
        ownerService.remove(selectedOwner);
        list = ownerService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedOwner = new Owner();

    }

    public List<Owner> getList() {
        return list;
    }

    public void setList(List<Owner> list) {
        this.list = list;
    }

    public Owner getSelectedOwner() {
        return selectedOwner;
    }

    public void setSelectedOwner(Owner selectedOwner) {
        this.selectedOwner = selectedOwner;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}
