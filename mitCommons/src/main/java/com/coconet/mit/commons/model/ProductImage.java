package com.coconet.mit.commons.model;

import javax.persistence.*;

/**
 * Created by Prithu on 4/2/18.
 */
@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;

    private String url;

    private int size;

    private int type;
    /*ALTER TABLE product_image
    ADD CONSTRAINT FK_ProductImage
    FOREIGN KEY (product_id) REFERENCES product(id);*/
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public int getId() {
        return id;
    }

    public ProductImage setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductImage setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ProductImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getSize() {
        return size;
    }

    public ProductImage setSize(int size) {
        this.size = size;
        return this;
    }

    public int getType() {
        return type;
    }

    public ProductImage setType(int type) {
        this.type = type;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public ProductImage setProduct(Product product) {
        this.product = product;
        return this;
    }

}
