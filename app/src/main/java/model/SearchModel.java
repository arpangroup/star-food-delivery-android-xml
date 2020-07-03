package model;

public class SearchModel {
    Integer chinesses_img;
    String lunchbox_txt,side_txt,areya_txt,discount_txt,rating_txt,time_txt;

    public Integer getChinesses_img() {
        return chinesses_img;
    }

    public void setChinesses_img(Integer chinesses_img) {
        this.chinesses_img = chinesses_img;
    }

    public String getLunchbox_txt() {
        return lunchbox_txt;
    }

    public void setLunchbox_txt(String lunchbox_txt) {
        this.lunchbox_txt = lunchbox_txt;
    }

    public String getSide_txt() {
        return side_txt;
    }

    public void setSide_txt(String side_txt) {
        this.side_txt = side_txt;
    }

    public String getAreya_txt() {
        return areya_txt;
    }

    public void setAreya_txt(String areya_txt) {
        this.areya_txt = areya_txt;
    }

    public String getDiscount_txt() {
        return discount_txt;
    }

    public void setDiscount_txt(String discount_txt) {
        this.discount_txt = discount_txt;
    }

    public String getRating_txt() {
        return rating_txt;
    }

    public void setRating_txt(String rating_txt) {
        this.rating_txt = rating_txt;
    }

    public String getTime_txt() {
        return time_txt;
    }

    public void setTime_txt(String time_txt) {
        this.time_txt = time_txt;
    }

    public SearchModel(Integer chinesses_img, String lunchbox_txt, String side_txt, String areya_txt, String discount_txt, String rating_txt, String time_txt) {
        this.chinesses_img = chinesses_img;
        this.lunchbox_txt = lunchbox_txt;
        this.side_txt = side_txt;
        this.areya_txt = areya_txt;
        this.discount_txt = discount_txt;
        this.rating_txt = rating_txt;
        this.time_txt = time_txt;
    }
}
