package com.test.api.controller;

import com.test.api.common.ResultBean;
import com.test.api.facade.ProductFacade;
import com.test.api.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/product")
@Api(value = "product",description = "商品类接口")
public class ProductController {
    @Autowired
    private ProductFacade productFacade;

    @PostMapping(value = "create")
    @ApiOperation(value = "新增商品",notes = "新增商品")
    public ResultBean<Boolean> createProduct(Product product) {
        return new ResultBean<>(productFacade.createProduct(product));
    }
    @GetMapping(value = "list")
    @ApiOperation(value = "获取商品列表",notes = "获取商品列表")
    public ResultBean<List<Product>> queryProductList() {
        return new ResultBean<>(productFacade.queryProductList());
    }
    @GetMapping(value = "queryById")
    @ApiOperation(value = "根据id获取商品信息",notes = "根据id获取商品信息")
    public ResultBean<Optional<Product>> queryProductByid(@RequestParam(value = "id")String id) {
        return new ResultBean<>(productFacade.queryProductById(id));
    }
    @PostMapping(value = "queryByCategory")
    @ApiOperation(value = "根据类目获取商品列表",notes = "根据类目获取商品列表")
    public ResultBean<List<Product>> queryByCategory(@RequestParam(value = "category_id")int category) {
        return new ResultBean<>(productFacade.queryProductByCategory(category));
    }
    @DeleteMapping(value = "del")
    @ApiOperation(value = "删除单个商品",notes = "删除单个商品")
    public ResultBean<Boolean> removeProduct(@RequestParam(value = "id")String id) {
        return new ResultBean<>(productFacade.removeProduct(id));
    }
}
