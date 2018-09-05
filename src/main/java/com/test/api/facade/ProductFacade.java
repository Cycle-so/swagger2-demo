package com.test.api.facade;

import com.test.api.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductFacade {
    /**新建商品**/
    boolean createProduct(Product product);
    /**查询商品列表**/
    List<Product> queryProductList();
    /**根据id查询商品**/
    Optional<Product> queryProductById(String id);
    /**根据类目查询商品**/
    List<Product> queryProductByCategory(int category);
    /**删除商品**/
    boolean removeProduct(String id);
}
