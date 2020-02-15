package udacity.project.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs = new String[3];

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabs[0] = context.getString(R.string.tab_cafe);
        tabs[1] = context.getString(R.string.tab_fastFood);
        tabs[2] = context.getString(R.string.tab_arabic);
    }

    @Override
    public Fragment getItem(int i) {

        if (i == 0) {
            return CategoryFragment.createInstance(Restaurant.CAFE);
        } else if (i == 1) {
            return CategoryFragment.createInstance(Restaurant.FAST_FOOD);
        } else
            return CategoryFragment.createInstance(Restaurant.ARABIC);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

}
