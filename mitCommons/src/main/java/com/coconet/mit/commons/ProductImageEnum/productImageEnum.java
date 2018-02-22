package com.coconet.mit.commons.ProductImageEnum;

public enum productImageEnum {

    SMALL(0, "small"),
    MEDIUM(1, "medium"),
    LARGE(2, "large"),
    THUMBNAIL(3, "thumbnail");
    private int imageSize;
    private String sizeName;

    productImageEnum(int imageSize, String sizeName) {
        this.imageSize = imageSize;
        this.sizeName = sizeName;
    }

    public int getImageSize() {
        return imageSize;
    }

    public String getSizeName() {
        return sizeName;
    }
}