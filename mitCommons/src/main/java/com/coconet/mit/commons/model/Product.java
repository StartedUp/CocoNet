package com.coconet.mit.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Prithu on 04-03-2017.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name="product_name", nullable=false)
    private String productName;
    @NotEmpty
    @Column(name="measurement_unit", nullable=false)
    private String measurementUnit;
    @Column(name="variety_name")
    private String varietyName;
    @Column(name="colour")
    private String colour;
    @Column(name="size_in_word")
    private String sizeInWord;
    @Column(name = "size_in_number", nullable = false)
    private BigDecimal sizeInNumber;
    /*@NotEmpty
    @NotNull
    @DecimalMax("50.0")*/
    @Column(name = "price_per_unit", nullable = false)
    private BigDecimal pricePerUnit;
    @JsonIgnore
    @OneToMany(targetEntity = SubscriptionPlan.class, mappedBy = "product",cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SubscriptionPlan> subscriptionPlan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSizeInWord() {
        return sizeInWord;
    }

    public void setSizeInWord(String sizeInWord) {
        this.sizeInWord = sizeInWord;
    }

    public BigDecimal getSizeInNumber() {
        return sizeInNumber;
    }

    public void setSizeInNumber(BigDecimal sizeInNumber) {
        this.sizeInNumber = sizeInNumber;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }

    @Override
    public int hashCode() {
        return this.id+"".hashCode();
    }
}
