package fragment;


import android.graphics.Color;
import android.os.Bundle;
import androidx.core.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.OfferAdapter;
import model.RecommendedModel;
import ws.design.stardelivery.R;

public class OfferFragment extends Fragment implements View.OnClickListener {

    View view;
    TextView veg_txt,non_veg_txt,rs_txt;


    Integer[] birani = {R.drawable.offerimg1, R.drawable.offerimg2, R.drawable.offerimg3,
            R.drawable.offerimg4, R.drawable.offerimg5, R.drawable.offerimg6};

    String[] rice_txt = {"Basmati Rice Lunchbox", "Basmati Rice Lunchbox", "Kulcha Bread Lunchbox"
            , "Basmati Rice Lunchbox", "Maji Varieties", "Maji Varieties"};

    String[] panner_txt = {"Paneer Biryani", "Chicken Biryani", "Chole Kulcha Lunchbox "
            , "Dal Makhani & Rice", "Egg Afghani Thou", "Egg Afghani Thou"};

    private RecyclerView recyclerView1;
    private OfferAdapter offerAdapter;
    private ArrayList<RecommendedModel> recommendedModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_offer, container, false);

        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        veg_txt = (TextView)view.findViewById(R.id.veg_txt);
        non_veg_txt = (TextView)view.findViewById(R.id.non_veg_txt);
        rs_txt = (TextView)view.findViewById(R.id.rs_txt);

        veg_txt.setOnClickListener(this);
        non_veg_txt.setOnClickListener(this);
        rs_txt.setOnClickListener(this);

        rs_txt.setTextColor(Color.parseColor("#ffffff"));
        rs_txt.setBackgroundResource(R.drawable.rectangle_blue);

        //1
        recyclerView1 = view.findViewById(R.id.offer_recycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        recommendedModels = new ArrayList<>();

        for (int i = 0; i < birani.length; i++) {
            RecommendedModel ab = new RecommendedModel(birani[i], rice_txt[i], panner_txt[i]);
            recommendedModels.add(ab);
        }
        offerAdapter = new OfferAdapter(getContext(), recommendedModels);
        recyclerView1.setAdapter(offerAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.veg_txt:
                veg_txt.setTextColor(Color.parseColor("#ffffff"));
                non_veg_txt.setTextColor(Color.parseColor("#777779"));
                rs_txt.setTextColor(Color.parseColor("#777779"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_blue);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                rs_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                break;

            case R.id.non_veg_txt:
                veg_txt.setTextColor(Color.parseColor("#777779"));
                non_veg_txt.setTextColor(Color.parseColor("#ffffff"));
                rs_txt.setTextColor(Color.parseColor("#777779"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_blue);
                rs_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                break;

            case R.id.rs_txt:
                veg_txt.setTextColor(Color.parseColor("#777779"));
                non_veg_txt.setTextColor(Color.parseColor("#777779"));
                rs_txt.setTextColor(Color.parseColor("#ffffff"));

                veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                non_veg_txt.setBackgroundResource(R.drawable.rectangle_gray_border);
                rs_txt.setBackgroundResource(R.drawable.rectangle_blue);
                break;
        }
    }
}
