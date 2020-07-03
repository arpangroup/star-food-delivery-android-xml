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
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.AccountAdapter;
import model.AccountModel;
import ws.design.stardelivery.FavouriteRestaurantActivity;
import ws.design.stardelivery.R;

public class MoreFragment extends Fragment {
    LinearLayout myAccount_1, myAccount_2, linear_selection,food_linear1, food_linear2, favourite_linear;


    String[] pavbhaji_txt = {"Pavbhaji 2X, Extra bun 4X", "Chole Kulche 1X, Kulcha 3X,\nPepsi 500ml 3X"};
    Integer[] pavbhaji_img = {R.drawable.pavbhaji, R.drawable.chana_img};
    RecyclerView recyclerView;
    AccountAdapter accountAdapter;
    ArrayList<AccountModel> accountModels;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);

        food_linear1 = view.findViewById(R.id.food_linear1);
        food_linear2 = view.findViewById(R.id.food_linear2);

        favourite_linear = view.findViewById(R.id.favourite_linear);
        favourite_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), FavouriteRestaurantActivity.class);
                startActivity(i);
            }
        });

        food_linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_linear1.setVisibility(View.GONE);
                food_linear2.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        food_linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food_linear1.setVisibility(View.VISIBLE);
                food_linear2.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
            }
        });

        /*----------Recycler view code------------*/
        recyclerView = view.findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        accountModels = new ArrayList<>();

        for (int i = 0; i < pavbhaji_txt.length; i++) {
            AccountModel ab = new AccountModel(pavbhaji_txt[i], pavbhaji_img[i]);
            accountModels.add(ab);
        }
        accountAdapter = new AccountAdapter(getContext(), accountModels);
        recyclerView.setAdapter(accountAdapter);

        myAccount_1 = view.findViewById(R.id.myAccount_1);
        myAccount_2 = view.findViewById(R.id.myAccount_2);
        linear_selection = view.findViewById(R.id.linear_selection);

        myAccount_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAccount_1.setVisibility(View.GONE);
                myAccount_2.setVisibility(View.VISIBLE);
                linear_selection.setVisibility(View.VISIBLE);

            }
        });

        myAccount_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAccount_1.setVisibility(View.VISIBLE);
                myAccount_2.setVisibility(View.GONE);
                linear_selection.setVisibility(View.GONE);
            }
        });
        return view;
    }
}
