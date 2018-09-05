package com.test.api.facade.impl;

import com.test.api.common.BuildParams;
import com.test.api.facade.ProductFacade;
import com.test.api.model.Product;
import com.test.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public boolean createProduct(Product product) {
        if(BuildParams.checkNotNull(product)){
            product.setGmt_create(BuildParams.formatTime());
            productRepository.save(product);
            return true;
        }
        return false;
    }
    @Override
    public List<Product> queryProductList() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> queryProductById(String id) {
        if(!StringUtils.isEmpty(id)){
          return  productRepository.findById(id);
        }
        return null;
    }
    @Override
    public List<Product> queryProductByCategory(int category) {
        return productRepository.findByCategory(category);
    }
    @Override
    public boolean removeProduct(String id) {
        if(!StringUtils.isEmpty(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
