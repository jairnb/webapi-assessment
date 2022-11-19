package com.webapiassessment.service;

import com.webapiassessment.dto.OrderListDTO;
import com.webapiassessment.dto.OrderSaveDTO;
import com.webapiassessment.entity.Order;

public interface IOrderService {

    Order save(OrderSaveDTO o);
    Order update(Integer id, Order o);
    Order findById(Integer id);

    OrderListDTO findAll();

    void createDummyOrder();
}