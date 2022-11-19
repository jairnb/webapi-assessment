package com.webapiassessment.service.impl;

import com.webapiassessment.dto.ProductListDTO;
import com.webapiassessment.entity.Product;
import com.webapiassessment.repository.ProductRepository;
import com.webapiassessment.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private ProductRepository productRepository;
    @Override
    public Product save(Product p) {
        return this.productRepository.save(p);
    }

    @Override
    public Product findById(Integer id) {
        Optional<Product> p = this.productRepository.findById(id);
        return p.isPresent() ? p.get() : null;
    }

    @Override
    public ProductListDTO findAll() {
        List<Product> productList = productRepository.findAll();
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setCustomers(productList);
        return productListDTO;
    }
}