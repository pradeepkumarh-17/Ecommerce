package com.ecommerce.model;

public class Product {

    private int productId;
    private int categoryId;

    private String name;
    private String brand;
    private String description;

    private double price;
    private double discountPrice;

    private String size;
    private String color;
    private String ageGroup;
    private String material;
    private String gender;

    private int stock;

    private String imageUrl;

    /* NEW FIELDS */
    private double rating;
    private int reviewsCount;

    private String features;
    private String deliveryInfo;
    private String tags;

    public Product() {}

    /* PRODUCT ID */
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    /* CATEGORY ID */
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /* NAME */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* BRAND */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /* DESCRIPTION */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* PRICE */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /* DISCOUNT PRICE */
    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    /* SIZE */
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /* COLOR */
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /* AGE GROUP */
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    /* MATERIAL */
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    /* GENDER */
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /* STOCK */
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /* IMAGE URL */
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /* RATING */
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /* REVIEWS COUNT */
    public int getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    /* FEATURES */
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    /* DELIVERY INFO */
    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    /* TAGS */
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}