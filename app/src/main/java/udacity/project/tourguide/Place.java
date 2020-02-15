package udacity.project.tourguide;

public class Place {
    public static final String PLACE = "place";
    private int placeName;
    private int placePhoto;
    private int about;

    public Place(int name, int photo, int about) {
        placeName = name;
        placePhoto = photo;
        this.about = about;
    }

    public int getAbout() {
        return about;
    }

    public int getPlaceName() {
        return placeName;
    }

    public int getPlacePhoto() {
        return placePhoto;
    }
}
