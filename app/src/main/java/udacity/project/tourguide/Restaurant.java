package udacity.project.tourguide;

import java.util.ArrayList;

public class Restaurant {

    public final static String CAFE = "cafe";
    public final static String FAST_FOOD = "fastFood";
    public final static String ARABIC = "arabic";
    public static ArrayList<Restaurant> CAFES = new ArrayList<>();
    public static ArrayList<Restaurant> FATST_FOODS = new ArrayList<>();
    public static ArrayList<Restaurant> ARABICS = new ArrayList<>();

    private int restaurantName;
    private int restaurantPhoto;
    private String type;
    private String rating;
    private String webSite;
    private String phone;
    private String mail;
    private String address;
    private int about;

    public Restaurant(String type, int name, int photo, String rating, String webSite, String phone, String mail, String address, int about) {
        this.type = type;
        restaurantName = name;
        restaurantPhoto = photo;
        this.rating = rating;
        this.webSite = webSite;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.about = about;
    }

    public int getRestaurantName() {
        return restaurantName;
    }

    public int getRestaurantPhoto() {
        return restaurantPhoto;
    }

    public String getType() {
        return type;
    }

    public static ArrayList<Restaurant> getARABICS() {
        return ARABICS;
    }

    public static ArrayList<Restaurant> getCAFES() {
        return CAFES;
    }

    public static ArrayList<Restaurant> getFatstFoods() {
        return FATST_FOODS;
    }

    public String getRating() {
        return rating;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getWebSite() {
        return webSite;
    }

    public int getAbout() {
        return about;
    }
}
