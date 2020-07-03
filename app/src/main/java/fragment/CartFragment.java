package fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import androidx.core.app.Fragment;
import androidx.core.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ws.design.stardelivery.R;

public class CartFragment extends Fragment {
    int defult = 220;
    int result;

    TextView plus_text, increase_txt, minus_txt, add_item_txt;
    LinearLayout add_cart_linear, item_incrementcart_linear;
    TextView total;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);

        view.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

//        view.findViewById(R.id.changeaddress_txt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getContext(), ChangeAddressActivity.class);
//                startActivity(i);
//            }
//        });

//        view.findViewById(R.id.process_linear).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getContext(), PaymentsActivity.class);
//                startActivity(i);
//            }
//        });
//        plus_text = view.findViewById(R.id.plus_text);
//        increase_txt = view.findViewById(R.id.increase_txt);
//        minus_txt = view.findViewById(R.id.minus_txt);
//        add_item_txt = view.findViewById(R.id.add_item_txt);
//        add_cart_linear = view.findViewById(R.id.add_cart_linear);
//        item_incrementcart_linear = view.findViewById(R.id.item_incrementcart_linear);
//        total = view.findViewById(R.id.total);
//
//        add_item_txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                add_item_txt.setVisibility(View.GONE);
//                add_cart_linear.setVisibility(View.VISIBLE);
//
//            }
//        });
//
//        plus_text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int count = Integer.parseInt(String.valueOf(increase_txt.getText()));
//                count++;
//                result = defult * count;
//                increase_txt.setText(String.valueOf(count));
//                total.setText(String.valueOf(result));
//
//                Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
//                increase_txt.startAnimation(animation1);
//            }
//        });
//
//        minus_txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int count = Integer.parseInt(String.valueOf(increase_txt.getText()));
////                condition last value is 1
//                if (count > 1) {
//                    count--;
//                    result = result - defult;
//                    // result = defult - count;
//                    increase_txt.setText(String.valueOf(count));
//                    total.setText(String.valueOf(result));
//                } else {
//                    add_item_txt.setVisibility(View.VISIBLE);
//                    add_cart_linear.setVisibility(View.GONE);
//                }
//
//                Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
//                increase_txt.startAnimation(animation1);
//            }
//        });

        Toolbar toolbar = view.findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolbarLayout);
        ctl.setTitle("CART (Lunchbox)");
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
       // ctl.setContentScrim(getDrawable(R.color.white));
       ctl.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        ctl.setExpandedTitleTextAppearance(R.style.expandedAppBar);
        ctl.setExpandedTitleColor(Color.parseColor("#000000"));
        ctl.setCollapsedTitleTextColor(Color.parseColor("#000000"));
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.roboto_medium);
        ctl.setCollapsedTitleTypeface(typeface);
        ctl.setExpandedTitleTypeface(typeface);
        return view;
    }
}
