package udacity.project.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Restaurant> restaurants;
    private ArrayList<Hotel> hotels;
    private ArrayList<Place> places;
    private String mType;
    private itemClickListner mItemClickListener;
    private Context context;

    MyRecyclerViewAdapter(String mType, Context context) {
        this.mType = mType;
        this.context = context;
        switch (mType) {
            case Restaurant.CAFE:
                restaurants = Restaurant.getCAFES();
                break;
            case Restaurant.FAST_FOOD:
                restaurants = Restaurant.getFatstFoods();
                break;
            case Restaurant.ARABIC:
                restaurants = Restaurant.getARABICS();
                break;
            case Hotel.HOTEL:
                hotels = AppData.getHotels();
                break;
            case Place.PLACE:
                places = AppData.getPlaces();
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        if (mType.equals(Restaurant.CAFE) || mType.equals(Restaurant.FAST_FOOD) || mType.equals(Restaurant.ARABIC)) {
            Restaurant restaurant = restaurants.get(i);
            if (restaurant != null) {
                Glide.with(context).load(restaurant.getRestaurantPhoto()).into(myViewHolder.imgCover);
                myViewHolder.txtName.setText(restaurant.getRestaurantName());
                myViewHolder.txtRating.setText(restaurant.getRating());
            }
        } else if (mType.equals(Hotel.HOTEL)) {
            Hotel hotel = hotels.get(i);
            if (hotel != null) {
                Glide.with(context).load(hotel.getHotelPhoto()).into(myViewHolder.imgCover);
                myViewHolder.txtName.setText(hotel.getHotelName());
                myViewHolder.txtRating.setText(hotel.getRating());
            }
        } else {
            Place place = places.get(i);
            if (place != null) {
                Glide.with(context).load(place.getPlacePhoto()).into(myViewHolder.imgCover);
                myViewHolder.txtName.setText(place.getPlaceName());
                myViewHolder.start.setVisibility(View.INVISIBLE);
            }
        }

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(myViewHolder.getAdapterPosition(), mType);
            }
        });

    }

    @Override
    public int getItemCount() {

        if (mType.equals(Restaurant.CAFE) || mType.equals(Restaurant.FAST_FOOD) || mType.equals(Restaurant.ARABIC)) {
            if (restaurants != null) {
                return restaurants.size();
            } else {
                return 0;
            }
        } else if (mType.equals(Hotel.HOTEL)) {
            if (hotels != null) {
                return hotels.size();
            } else {
                return 0;
            }
        } else if (places != null) {
            return places.size();
        } else {
            return 0;
        }
    }

    void setmItemClickListner(itemClickListner mItemClickListner) {
        this.mItemClickListener = mItemClickListner;
    }

    public interface itemClickListner {
        void onItemClick(int position, String type);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.img_cover)
        ImageView imgCover;
        @Nullable
        @BindView(R.id.txt_name)
        TextView txtName;
        @Nullable
        @BindView(R.id.txt_rating)
        TextView txtRating;
        @BindView(R.id.ic_start)
        ImageView start;

        MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
