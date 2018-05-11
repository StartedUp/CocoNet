package com.coconet.mit.commons.enums;

/**
 * Created by Balaji on 11/5/18.
 */
public enum MeasurmentUnitsEnum {
    GRAMS("grams"),
    KG("killo_grams"),
    METER("meter"),
    PIECE("piece"),
    LITER("liter"),
    NUMBER("number");

    private String value;

    MeasurmentUnitsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
