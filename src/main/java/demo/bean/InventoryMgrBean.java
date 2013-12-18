// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package demo.bean;

import demo.model.CarInventory;
import demo.service.InventoryService;
import demo.service.exception.BusinessException;
import demo.util.UIConstants;
import demo.util.UITools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import java.util.List;

@Component
@ManagedBean(name = "inventoryMgrBean")
@Scope("session")
@Transactional
public class InventoryMgrBean extends AbstractBackingBean {

    public static final Logger LOGGER = LoggerFactory.getLogger(InventoryMgrBean.class);

    enum Navigation {
        ADD_CAR_LIST_ACT("addCarLstAct"),
        EDIT_CAR_LIST_ACT("editCarLstAct"),
        VIEW_CAR_LIST_ACT("viewCarLstAct");

        String action;

        public String getAction() {
            return action;
        }
        private Navigation(String action) {
            this.action = action;
        }
    }

    @ManagedProperty(value = "#{carInventory}")
    private List<CarInventory> carInventory;

    @ManagedProperty(value = "#{selectedCar}")
    private CarInventory selectedCar;
    private boolean newCar;

    @Autowired
    private InventoryService inventoryService;

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Inventory re/initialization
     */
    private void initInventoryList() {
        try {
            carInventory = inventoryService.findAll();
        } catch (BusinessException e) {
            LOGGER.error("Error while retrieving car inventory list", e);
            UITools.addErrorMessage(getContext(), "Error retrieving the inventory list");
        }
    }

    /**
     * List actions: add, edit, delete
     *
     */
    /**
     * Add car - List action
     */
    public String addCarListAction() {
        setNewCar(true);
        selectedCar = new CarInventory();

        return Navigation.ADD_CAR_LIST_ACT.getAction();
    }

    /**
     * Edit car - List action
     */
    public String editCarListAction() {
        setNewCar(false);
        return Navigation.EDIT_CAR_LIST_ACT.getAction();
    }

    /**
     * Edit car - List action listener
     */
    public void editCarListActionListener(ActionEvent event) {
        Long carId = (Long) event.getComponent().getAttributes().get(UIConstants.CAR_ID_REQ_PARAM);

        try {
            selectedCar = inventoryService.findById(carId);
        } catch (BusinessException e) {
            LOGGER.error("Error while retrieving car inventory", e);
            UITools.addErrorMessage(getContext(), "Error while retrieving car inventory");
        }

        if (selectedCar == null) {
            // popup message
        }
    }

    /**
     * Delete car - List action
     */
    public void deleteCarListActionListener(ActionEvent event) {
        Long carId = (Long) event.getComponent().getAttributes().get(UIConstants.CAR_ID_REQ_PARAM);

        try {
            inventoryService.delete(carId);
        } catch (BusinessException e) {
            LOGGER.error("Error while deleting carId: " + carId, e);
            UITools.addErrorMessage(getContext(), "Error while deleting carId: " + carId);
        }

        initInventoryList();
    }


    /**
      * Form actions: create, update, delete
      *
      */
    /**
     * Create car - From action
     */
    public String createCarFormAction() {
        try {
            inventoryService.create(selectedCar);
        } catch (BusinessException e) {
            LOGGER.error("Error while creating a carInventory", e);
            UITools.addErrorMessage(getContext(), "Error while creating a carInventory");
        }

        // reinitialize inventory
        initInventoryList();

        return Navigation.VIEW_CAR_LIST_ACT.getAction();
    }

    /**
     * Update car - Form action
     */
    public String updateCarFormAction() {
        try {
            inventoryService.update(selectedCar);
        } catch (BusinessException e) {
            LOGGER.error("Error while updating", e);
            UITools.addErrorMessage(getContext(), "Error while updating");
        }

        // reinitialize inventory
        initInventoryList();

        return Navigation.VIEW_CAR_LIST_ACT.getAction();
    }

    public String deleteCarListAction() {
        return Navigation.VIEW_CAR_LIST_ACT.getAction();
    }
    /**
     * Cancel - Form action
     *
     * @return
     */
    public String cancelFormAction() {
        setNewCar(false);

        // reinitialize inventory
        initInventoryList();

        return Navigation.VIEW_CAR_LIST_ACT.getAction();
    }

    public List<CarInventory> getCarInventory() {
        LOGGER.info("retrieving car inventory");
        if (carInventory == null) {
            initInventoryList();
        }
        return carInventory;
    }

    public void setCarInventory(List<CarInventory> carInventory) {
        this.carInventory = carInventory;
    }

    public CarInventory getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarInventory selectedCar) {
        this.selectedCar = selectedCar;
    }

    public boolean isNewCar() {
        return newCar;
    }

    public void setNewCar(boolean newCar) {
        this.newCar = newCar;
    }

}