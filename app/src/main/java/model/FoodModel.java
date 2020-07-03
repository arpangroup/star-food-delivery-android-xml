package model;

public class FoodModel {

    Integer food_img;
    String discount_txt,coupon_txt,restaurants_txt;

    public Integer getFood_img() {
        return food_img;
    }

    public void setFood_img(Integer food_img) {
        this.food_img = food_img;
    }

    public String getDiscount_txt() {
        return discount_txt;
    }

    public void setDiscount_txt(String discount_txt) {
        this.discount_txt = discount_txt;
    }

    public String getCoupon_txt() {
        return coupon_txt;
    }

    public void setCoupon_txt(String coupon_txt) {
        this.coupon_txt = coupon_txt;
    }

    public String getRestaurants_txt() {
        return restaurants_txt;
    }

    public void setRestaurants_txt(String restaurants_txt) {
        this.restaurants_txt = restaurants_txt;
    }

    public FoodModel(Integer food_img, String discount_txt, String coupon_txt, String restaurants_txt) {
        this.food_img = food_img;
        this.discount_txt = discount_txt;
        this.coupon_txt = coupon_txt;
        this.restaurants_txt = restaurants_txt;
    }
}
