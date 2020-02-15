package udacity.project.tourguide;

import java.util.ArrayList;

// Class for storing all the HOTELS, RESTAURANTS and PLACES in ArrayLists
class AppData {

    private static final ArrayList<Restaurant> RESTAURANTS = new ArrayList<Restaurant>() {{

        add(new Restaurant(Restaurant.CAFE, R.string.Mama_Jamila_Cafe, R.drawable.mama_jamila_cafe, "4.1", "https://www.facebook.com/MamaJamilaKSA", "+966 12 530 3715", "mamajamila@gmail.com", "geo:0,0?q=Sheikh Mohamed Ben Jaber Street, Mecca Saudi Arabia", R.string.Mama_Jamila_about));
        add(new Restaurant(Restaurant.CAFE, R.string.Strawberry_and_Cheese, R.drawable.strawberry_cheese, "4.2", "https://www.facebook.com/StrawberryandCheese1999", "+966 50 553 6688", "strawberry.and.cheese@hotmail.com", "geo:0,0?q=6963 Shaikh Hasan Almashat Mecca, Saudi Arabia", R.string.Strawberry_and_Cheese_about));
        add(new Restaurant(Restaurant.CAFE, R.string.Zamzam_Lobby_Lounge, R.drawable.lobby_lounge, "4.5", "https://www.pullman-zamzam-makkah.com/ar/", "+966 12 571 5555", "h6036-rm1@accor.com", "geo:0,0?q=Abraj Al Bait Complex, King Abdel Aziz Endowment, 21955 MAKKAH", R.string.Zamzam_Lobby_Lounge_about));
        add(new Restaurant(Restaurant.FAST_FOOD, R.string.Burger_King, R.drawable.burger_king, "4.5", "https://www.bk.com/", "1-866-394-2493", "bk@gmail.com", "geo:0,0?q=Abraj Al-Bait Food Court, Mecca 24231 Saudi Arabia", R.string.Burger_King_about));
        add(new Restaurant(Restaurant.FAST_FOOD, R.string.pizza_hut, R.drawable.pizza_hut, "3.6", "https://www.pizzahut.com.sa/en/home", "+966 920000910", "pizzahutsa@pizzahut.com.sa m", "geo:0,0?q=Pizza Hut, 6861, Mecca 24231, Saudi Arabia", R.string.pizza_hut_about));
        add(new Restaurant(Restaurant.FAST_FOOD, R.string.Al_Tazaj, R.drawable.altazaj, "3.9", "http://www.taza.com.sa/", "+966 9200 11200", "taza@gmail.com", "geo:0,0?q=TAZAJ, An Nuzhah, Makkah 24225, Saudi Arabia", R.string.Al_Tazaj_about));
        add(new Restaurant(Restaurant.ARABIC, R.string.al_Kawthar_Lounge, R.drawable.al_kawthar_lounge, "4.6", "https://conradhotels3.hilton.com/en/hotels/saudi-arabia/conrad-makkah-MAKCICI/index.html", "+96612530877", "MAKCI.Hotel@conradhotels.com", "geo:0,0?q=Ibrahim Al Khalil Street Conrad Makkah Hotel, Mecca 19923 Saudi Arabia", R.string.al_Kawthar_Lounge_about));
        add(new Restaurant(Restaurant.ARABIC, R.string.al_Khairat, R.drawable.al_khairat, "4.7", "http://www.swissotel.com/hotels/makkah-al-maqam/dining/al-khairat-restaurant/", "8001166555 ", "reservations.almaqam@swissotel.com", "geo:0,0?q=Ibrahim Al-Khaleel Street, Mecca Saudi Arabia", R.string.al_Khairat_about));
        add(new Restaurant(Restaurant.ARABIC, R.string.al_Atbaq, R.drawable.al_atbaq, "4.3", "https://alatbaqrestaurant.business.site/", "+966 12 543 3337", "jansher.malik@icloud.com", "geo:0,0?q=Hussain Arab Street, Nuzzah Dist, Mecca, Saudia Arabia, Mecca Saudi Arabia", R.string.al_Atbaq_about));

    }};

    private static final ArrayList<Hotel> hotels = new ArrayList<Hotel>() {{
        add(new Hotel(R.string.hotel_Pullman_ZamZam, R.drawable.pullman_zazam_hotel, "4.0", "https://www.pullman-zamzam-makkah.com/", "+966 12 571 5555", "H6036@accor.com", "geo:0,0?q=Abraj Al Bait Complex King Abdel Aziz Endowment, Mecca 21955 Saudi Arabia", R.string.hotel_Pullman_ZamZam_about));
        add(new Hotel(R.string.hotel_Hilton, R.drawable.hilton_hotel, "4.5", "https://hiltonhonors3.hilton.com/en/index.html", "00 1 800 445 8667", "hilton_ksa@gmail.com", "geo:0,0?q=Jabal Omar, Ibrahim Al Khalil Ibrahim Al Khalil St., Mecca 21955 Saudi Arabia", R.string.hotel_Hilton_about));
        add(new Hotel(R.string.hotel_Jabal_Omar_Hyatt_Regency, R.drawable.jabal_omar_hyatt_regency_hotel, "4.5", "https://www.hyatt.com/", "00 966 12 526 7222", "hayat_mecca@gmail.com", "geo:0,0?q=Jabal Omar, Ibrahim Al Khalil Street, Mecca 21955 Saudi Arabia", R.string.hotel_Jabal_Omar_Hyatt_Regency_about));
        add(new Hotel(R.string.hotel_Jabal_Omar_Marriott, R.drawable.mariot_hotel, "4.5", "https://www.marriott.com/default.mi", "00 1 844 631 0595", "mariot_sa@gmail.com", "geo:0,0?q=Umm Al Qura, Ash Shubaikah, Mecca 21955 Um Al Quraa Street, Mecca 21955 Saudi Arabia", R.string.hotel_Jabal_Omar_Marriott_about));
    }};

    private static final ArrayList<Place> places = new ArrayList<Place>() {{
        add(new Place(R.string.Kaaba, R.drawable.kaaba, R.string.Kaaba_about));
        add(new Place(R.string.Jabal_al_Nour, R.drawable.jabal_al_nour, R.string.Jabal_al_Nour_about));
        add(new Place(R.string.Abraj_Al_Bait_Towers, R.drawable.abrajal_bait, R.string.Abraj_Al_Bait_Towers_about));
    }};

    static ArrayList<Hotel> getHotels() {
        return hotels;
    }

    static ArrayList<Place> getPlaces() {
        return places;
    }

    static void initializeData() {

        if (Restaurant.getCAFES().size() == 0) {
            for (Restaurant r : RESTAURANTS) {
                if (r.getType().equals(Restaurant.CAFE)) {
                    Restaurant.CAFES.add(r);
                } else if (r.getType().equals(Restaurant.FAST_FOOD)) {
                    Restaurant.FATST_FOODS.add(r);
                } else {
                    Restaurant.ARABICS.add(r);
                }
            }
        }
    }
}
