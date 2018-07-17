package com.coconet.mit.commons.model;

import com.coconet.mit.commons.enums.MeasurmentUnitsEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
    @Column(name="measurement_unit", nullable=false)
    private int measurementUnit;
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

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "minimum_quantity")
    private BigDecimal minimumQuantity;

    @Column(name = "active", nullable=false)
    private boolean active;

    @OneToMany(targetEntity = ProductImage.class, mappedBy = "product",cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductImage> productImages;
    /*@JsonIgnore
    @OneToMany(targetEntity = SubscriptionPlan.class, mappedBy = "product",cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SubscriptionPlan> subscriptionPlan;*/

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

    public int getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(int measurementUnit) {
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

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public Product setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
        return this;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getMinimumQuantity() {
        return minimumQuantity;
    }

    public Product setMinimumQuantity(BigDecimal minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Product setActive(boolean active) {
        this.active = active;
        return this;
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

    public MeasurmentUnitsEnum returnMeasurementUnit(int measurementUnitCode){
        List<MeasurmentUnitsEnum> measurmentUnits = Arrays.asList(MeasurmentUnitsEnum.values());
        for(MeasurmentUnitsEnum measurmentUnitsEnum:measurmentUnits){
            if(measurementUnitCode==measurmentUnitsEnum.getUnitCode()){
                return measurmentUnitsEnum;
            }
        }
        return null;
    }
}
