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
import android.widget.TextView;

import java.util.ArrayList;

import adapter.DishesCartAdapter;
import model.DishesModel;
import ws.design.stardelivery.R;
import ws.design.stardelivery.SearchActivity;

public class DoshRateFragment extends Fragment {

    View view;
    /*------------Rate Dosh Data1------------*/
    String[] dosa_txt1 = {"Sada dosa", "Sada Rawa Dosa", "Sada Corn Dosa"};

    private RecyclerView recyclerView;
    private DishesCartAdapter dishesCartAdapter;
    private ArrayList<DishesModel> dishesModels;

    /*------------Rate Dosh Data2------------*/
    String[] dosa_txt12 = {"Sada dosa", "Sada Rawa Dosa", "Sada Corn Dosa"};

    private RecyclerView recyclerView1;
    private DishesCartAdapter dishesCartAdapter1;
    private ArrayList<DishesModel> dishesModels1;

    TextView dosh_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dosh_rate, container, false);

        dosh_list = view.findViewById(R.id.dosh_list);
        dosh_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                intent.putExtra("sadaDosa","sadaDosa");
                startActivity(intent);
            }
        });

        /*--------Dosh1 RecyclerView Code Here-------------- */
        recyclerView = view.findViewById(R.id.rate_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dishesModels = new ArrayList<>();

        for (int i = 0; i < dosa_txt1.length; i++) {
            DishesModel model = new DishesModel(dosa_txt1[i]);
            dishesModels.add(model);
        }
        dishesCartAdapter = new DishesCartAdapter(getContext(), dishesModels);
        recyclerView.setAdapter(dishesCartAdapter);


        /*--------Dosh2 RecyclerView Code Here-------------- */
        recyclerView1 = view.findViewById(R.id.rate1_recycler);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        dishesModels1 = new ArrayList<>();

        for (int i = 0; i < dosa_txt12.length; i++) {
            DishesModel ab = new DishesModel(dosa_txt12[i]);
            dishesModels1.add(ab);
        }
        dishesCartAdapter1 = new DishesCartAdapter(getContext(), dishesModels1);
        recyclerView1.setAdapter(dishesCartAdapter1);
        return view;
    }
}