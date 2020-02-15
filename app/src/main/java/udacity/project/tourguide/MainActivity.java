package udacity.project.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    final Fragment hotelFragment = new HotelFragment();
    final Fragment placeFragment = new PlaceFragment();
    final Fragment foodFragment = new FoodFragment();
    final FragmentManager fm = getSupportFragmentManager();
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    Fragment active = hotelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AppData.initializeData();

        fm.beginTransaction().add(R.id.container, hotelFragment).hide(hotelFragment).commit();
        fm.beginTransaction().add(R.id.container, foodFragment).hide(foodFragment).commit();
        fm.beginTransaction().add(R.id.container, placeFragment).hide(placeFragment).commit();
        fm.beginTransaction().show(active).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_hotels:
                        fm.beginTransaction().hide(active).show(hotelFragment).commit();
                        active = hotelFragment;
                        return true;
                    case R.id.action_food:
                        fm.beginTransaction().hide(active).show(foodFragment).commit();
                        active = foodFragment;
                        return true;
                    case R.id.action_places:
                        fm.beginTransaction().hide(active).show(placeFragment).commit();
                        active = placeFragment;
                        return true;
                }
                return false;
            }
        });


    }
}
