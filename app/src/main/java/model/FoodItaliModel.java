package model;

public class FoodItaliModel {
    Integer pavbhaji;
    String address;

    public FoodItaliModel(Integer pavbhaji, String address) {
        this.pavbhaji = pavbhaji;
        this.address = address;
    }

    public Integer getPavbhaji() {
        return pavbhaji;
    }

    public void setPavbhaji(Integer pavbhaji) {
        this.pavbhaji = pavbhaji;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
