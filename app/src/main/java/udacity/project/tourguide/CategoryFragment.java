package udacity.project.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment {

    private static final String KEY_TYPE = "keyType";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private String mType;

    public static CategoryFragment createInstance(String type) {

        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TYPE, type);
        categoryFragment.setArguments(args);
        return categoryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getString(KEY_TYPE);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        ButterKnife.bind(this, rootView);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(mType, getContext());

        myRecyclerViewAdapter.setmItemClickListner(new MyRecyclerViewAdapter.itemClickListner() {
            @Override
            public void onItemClick(int position, String type) {

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.ITEM_POSITION, position);
                intent.putExtra(DetailsActivity.ITEM_TYPE, mType);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(myRecyclerViewAdapter);

        return rootView;
    }
}
