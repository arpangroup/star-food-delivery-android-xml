package model;

public class RecommendedModel {

    Integer birani;
    String rice_txt,paneer_txt;

    public Integer getBirani() {
        return birani;
    }

    public void setBirani(Integer birani) {
        this.birani = birani;
    }

    public String getRice_txt() {
        return rice_txt;
    }

    public void setRice_txt(String rice_txt) {
        this.rice_txt = rice_txt;
    }

    public String getPaneer_txt() {
        return paneer_txt;
    }

    public void setPaneer_txt(String paneer_txt) {
        this.paneer_txt = paneer_txt;
    }

    public RecommendedModel(Integer birani, String rice_txt, String paneer_txt) {
        this.birani = birani;
        this.rice_txt = rice_txt;
        this.paneer_txt = paneer_txt;
    }
}
