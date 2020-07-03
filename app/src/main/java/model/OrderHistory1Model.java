package model;

public class OrderHistory1Model {
    Integer pavbhaji_img;
    String delivered_txt;

    public OrderHistory1Model(Integer pavbhaji_img, String delivered_txt) {
        this.pavbhaji_img = pavbhaji_img;
        this.delivered_txt = delivered_txt;
    }

    public Integer getPavbhaji_img() {
        return pavbhaji_img;
    }

    public void setPavbhaji_img(Integer pavbhaji_img) {
        this.pavbhaji_img = pavbhaji_img;
    }

    public String getDelivered_txt() {
        return delivered_txt;
    }

    public void setDelivered_txt(String delivered_txt) {
        this.delivered_txt = delivered_txt;
    }
}
