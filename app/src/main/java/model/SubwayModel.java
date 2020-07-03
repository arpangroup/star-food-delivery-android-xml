package model;

public class SubwayModel {
    String opRoad_txt,rating_txt,time_txt;

    public SubwayModel(String opRoad_txt, String rating_txt, String time_txt) {
        this.opRoad_txt = opRoad_txt;
        this.rating_txt = rating_txt;
        this.time_txt = time_txt;
    }

    public String getOpRoad_txt() {
        return opRoad_txt;
    }

    public void setOpRoad_txt(String opRoad_txt) {
        this.opRoad_txt = opRoad_txt;
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
}
