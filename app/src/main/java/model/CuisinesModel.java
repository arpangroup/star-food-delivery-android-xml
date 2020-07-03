package model;

public class CuisinesModel {

    Integer chinesses_img;
    String no_of_restaurants_txt,chinesses_txt;

    public CuisinesModel(Integer chinesses_img, String no_of_restaurants_txt, String chinesses_txt) {
        this.chinesses_img = chinesses_img;
        this.no_of_restaurants_txt = no_of_restaurants_txt;
        this.chinesses_txt = chinesses_txt;
    }

    public Integer getChinesses_img() {
        return chinesses_img;
    }

    public void setChinesses_img(Integer chinesses_img) {
        this.chinesses_img = chinesses_img;
    }

    public String getNo_of_restaurants_txt() {
        return no_of_restaurants_txt;
    }

    public void setNo_of_restaurants_txt(String no_of_restaurants_txt) {
        this.no_of_restaurants_txt = no_of_restaurants_txt;
    }

    public String getChinesses_txt() {
        return chinesses_txt;
    }

    public void setChinesses_txt(String chinesses_txt) {
        this.chinesses_txt = chinesses_txt;
    }
}
