package fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.RestaurentSearchAdapter;
import model.RestaurentSearchModel;
import ws.design.stardelivery.R;
import ws.design.stardelivery.SearchActivity;

public class SearchFragment extends Fragment {
    String[] brown_burger_txt = {"Brown Burger", "Pavbhaji", "Cafe Mocha"};

     RecyclerView recyclerView;
     RestaurentSearchAdapter adapter;
     ArrayList<RestaurentSearchModel> models;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);

        view.findViewById(R.id.re_search_linear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), SearchActivity.class);
                startActivity(i);
            }
        });
        recyclerView = view.findViewById(R.id.restaurant_search_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        models = new ArrayList<>();

        for (int i = 0; i < brown_burger_txt.length; i++) {
            RestaurentSearchModel ab = new RestaurentSearchModel(brown_burger_txt[i]);
            models.add(ab);
        }
        adapter = new RestaurentSearchAdapter(getContext(), models);
        recyclerView.setAdapter(adapter);
        return  view;
    }

}
