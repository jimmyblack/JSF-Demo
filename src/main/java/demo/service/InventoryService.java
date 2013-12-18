/*
 * Copyright (c) 2013. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package demo.service;// --------------------------------------------------------------------------

import demo.model.CarInventory;
import demo.service.exception.BusinessException;

import java.util.List;

public interface InventoryService {

    void create(CarInventory carInventory) throws BusinessException;

    void update(CarInventory carInventory) throws BusinessException;

    void delete(Long id) throws BusinessException;

    List<CarInventory> findAll() throws BusinessException;

    CarInventory findById(Long id) throws BusinessException;

}
