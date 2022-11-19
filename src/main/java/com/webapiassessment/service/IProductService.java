package com.webapiassessment.service;

import com.webapiassessment.dto.ProductListDTO;
import com.webapiassessment.entity.Product;

public interface IProductService {

    Product save(Product p);

    Product findById(Integer id);

    ProductListDTO findAll();
}