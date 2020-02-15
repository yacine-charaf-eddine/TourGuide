package udacity.project.tourguide;

public class Hotel {

    public static final String HOTEL = "hotel";

    private int hotelName;
    private int hotelPhoto;
    private String rating;
    private String webSite;
    private String phone;
    private String mail;
    private String address;
    private int about;

    public Hotel(int name, int photo, String rating, String webSite, String phone, String mail, String address, int about) {
        hotelName = name;
        hotelPhoto = photo;
        this.rating = rating;
        this.webSite = webSite;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.about = about;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getRating() {
        return rating;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public int getHotelName() {
        return hotelName;
    }

    public int getHotelPhoto() {
        return hotelPhoto;
    }

    public int getAbout() {
        return about;
    }

    public String getAddress() {
        return address;
    }
}
