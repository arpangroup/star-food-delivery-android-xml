package model;

public class BasmatiModel {
    Integer nonveg_img;
    String biryani_txt;

    public Integer getNonveg_img() {
        return nonveg_img;
    }

    public void setNonveg_img(Integer nonveg_img) {
        this.nonveg_img = nonveg_img;
    }

    public String getBiryani_txt() {
        return biryani_txt;
    }

    public void setBiryani_txt(String biryani_txt) {
        this.biryani_txt = biryani_txt;
    }

    public BasmatiModel(Integer nonveg_img, String biryani_txt) {
        this.nonveg_img = nonveg_img;
        this.biryani_txt = biryani_txt;
    }
}
