package ws.design.stardelivery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class RateFiledPopActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_rate_popup_filled);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        String hh = getIntent().getStringExtra("rating");
        ratingBar.setRating(Float.parseFloat(hh));
    }
}
