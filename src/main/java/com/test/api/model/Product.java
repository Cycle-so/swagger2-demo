package com.test.api.model;

import com.test.api.common.AllowNull;
import com.test.api.common.Required;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    @Id
    @AllowNull
    private String id;
    @AllowNull
    private String gmt_create;
    @AllowNull
    private String gmt_modify;
    private int is_delete;
    private int status;
    private String name;
    private String image;
    private int price;
    private int count;
    private int category;

}
