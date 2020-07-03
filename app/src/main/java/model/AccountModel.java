package model;

public class AccountModel {
    String pavbhaji_txt;
    Integer pavbhaji_img;

    public String getPavbhaji_txt() {
        return pavbhaji_txt;
    }

    public void setPavbhaji_txt(String pavbhaji_txt) {
        this.pavbhaji_txt = pavbhaji_txt;
    }

    public Integer getPavbhaji_img() {
        return pavbhaji_img;
    }

    public void setPavbhaji_img(Integer pavbhaji_img) {
        this.pavbhaji_img = pavbhaji_img;
    }

    public AccountModel(String pavbhaji_txt, Integer pavbhaji_img) {
        this.pavbhaji_txt = pavbhaji_txt;
        this.pavbhaji_img = pavbhaji_img;
    }
}
