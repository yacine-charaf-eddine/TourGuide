package udacity.project.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DetailsActivity extends AppCompatActivity {

    public static final String ITEM_POSITION = "itemPosition";
    public static final String ITEM_TYPE = "itemType";
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.backdrop)
    ImageView imageView;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.txt_name)
    TextView name;
    @BindView(R.id.txt_about)
    TextView txtAbout;
    @BindView(R.id.ic_website)
    ImageView ic_web;
    @BindView(R.id.ic_phone)
    ImageView ic_phone;
    @BindView(R.id.ic_mail)
    ImageView ic_mail;
    @BindView(R.id.ic_place)
    ImageView ic_place;
    private String itemType;
    private Restaurant restaurant;
    private Hotel hotel;
    private Uri dataUri;
    private String action;

    @OnClick({R.id.ic_website, R.id.ic_phone, R.id.ic_mail, R.id.ic_place})
    public void click(ImageView img) {
        switch (img.getId()) {
            case R.id.ic_website:
                if (itemType.equals(Hotel.HOTEL)) {
                    dataUri = Uri.parse(hotel.getWebSite());
                } else {
                    dataUri = Uri.parse(restaurant.getWebSite());
                }
                action = Intent.ACTION_VIEW;
                break;
            case R.id.ic_phone:
                if (itemType.equals(Hotel.HOTEL)) {
                    dataUri = Uri.parse("tel:" + hotel.getPhone());
                } else {
                    dataUri = Uri.parse("tel:" + restaurant.getPhone());
                }
                action = Intent.ACTION_DIAL;
                break;
            case R.id.ic_mail:
                if (itemType.equals(Hotel.HOTEL)) {
                    dataUri = Uri.parse("mailto:" + hotel.getMail());
                } else {
                    dataUri = Uri.parse("mailto:" + restaurant.getMail());
                }

                action = Intent.ACTION_SENDTO;
                break;
            case R.id.ic_place:
                if (itemType.equals(Hotel.HOTEL)) {
                    dataUri = Uri.parse(hotel.getAddress());
                } else {
                    dataUri = Uri.parse(restaurant.getAddress());
                }
                action = Intent.ACTION_VIEW;
                break;
        }
        Intent intent = new Intent(action, dataUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int itemPosition = intent.getIntExtra(ITEM_POSITION, -1);
        itemType = intent.getStringExtra(ITEM_TYPE);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setTitle(itemType);

        switch (itemType) {
            case Restaurant.CAFE:
                restaurant = Restaurant.getCAFES().get(itemPosition);
                setData(restaurant.getRestaurantName(), restaurant.getRestaurantPhoto(), restaurant.getAbout());
                break;
            case Restaurant.FAST_FOOD:
                restaurant = Restaurant.getFatstFoods().get(itemPosition);
                setData(restaurant.getRestaurantName(), restaurant.getRestaurantPhoto(), restaurant.getAbout());
                break;
            case Restaurant.ARABIC:
                restaurant = Restaurant.getARABICS().get(itemPosition);
                setData(restaurant.getRestaurantName(), restaurant.getRestaurantPhoto(), restaurant.getAbout());
                break;
            case Hotel.HOTEL:
                hotel = AppData.getHotels().get(itemPosition);
                setData(hotel.getHotelName(), hotel.getHotelPhoto(), hotel.getAbout());
                break;
            case Place.PLACE:
                Place place = AppData.getPlaces().get(itemPosition);
                setData(place.getPlaceName(), place.getPlacePhoto(), place.getAbout());
                ic_mail.setVisibility(View.GONE);
                ic_phone.setVisibility(View.GONE);
                ic_web.setVisibility(View.GONE);
                ic_place.setVisibility(View.GONE);
        }
    }

    void setData(int mName, int photo, int about) {

        name.setText(mName);
        Glide.with(this).load(photo).into(imageView);
        txtAbout.setText(about);
    }
}
