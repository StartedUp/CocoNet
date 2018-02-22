package com.coconet.mit.commons.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Prithu on 4/2/18.
 */
@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;

    private String url;

    private int size;

    private int type;

}
