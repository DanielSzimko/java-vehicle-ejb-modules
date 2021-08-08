package hu.ulyssys.java.course.javaee.demo.vehicle.mbean;

import hu.ulyssys.java.course.javaee.demo.vehicle.entity.AbstractEntity;
import hu.ulyssys.java.course.javaee.demo.vehicle.entity.Plane;
import hu.ulyssys.java.course.javaee.demo.vehicle.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {

   private List<T> list;

   private T selectedEntity;

   @Inject
   protected CoreService<T> service;

    public void initSave() {
        selectedEntity = initNewEntity();
    }

    public void save() {
        if (selectedEntity.getId() == null) {
            service.add(selectedEntity);
            list = service.getAll();
            selectedEntity = initNewEntity();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            service.update(selectedEntity);
            list = service.getAll();
            selectedEntity = initNewEntity();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }

        PrimeFaces.current().executeScript("PF('"+ dialogName()+"').hide()");


    }

    public void remove() {
        service.remove(selectedEntity);
        list = service.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        selectedEntity = initNewEntity();
    }

    protected abstract String dialogName();
    protected abstract T initNewEntity();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }
}
