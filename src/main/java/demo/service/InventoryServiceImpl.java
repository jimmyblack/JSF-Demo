// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package demo.service;

import demo.model.CarInventory;
import demo.service.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(CarInventory carInventory) throws BusinessException {
        try {
            entityManager.persist(carInventory);
            entityManager.flush();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public void update(CarInventory carInventory) throws BusinessException {
        try {
            entityManager.merge(carInventory);
            entityManager.flush();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public void delete(Long id) throws BusinessException {
        try {
            CarInventory carInventory = entityManager.find(CarInventory.class, id);
            if (carInventory != null) {
                entityManager.remove(carInventory);
            }
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<CarInventory> findAll() throws BusinessException {
        return entityManager.createQuery("from demo.model.CarInventory").getResultList();
    }

    @Override
    public CarInventory findById(Long id) throws BusinessException {
        return entityManager.find(CarInventory.class, id);
    }

}