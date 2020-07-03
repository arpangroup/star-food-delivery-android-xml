package ws.design.stardelivery;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;


public class AddDeliveryLocationActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    LinearLayout linear_home, linear_office, liner_other;
    ImageView home_img, office_img, other_img;
    TextView home_txt, office_txt, other_txt;
    View view1, view2, view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_location);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);


        linear_home = findViewById(R.id.linear_home);
        linear_office = findViewById(R.id.linear_office);
        liner_other = findViewById(R.id.liner_other);

        home_img = findViewById(R.id.home_img);
        office_img = findViewById(R.id.office_img);
        other_img = findViewById(R.id.other_img);

        home_txt = findViewById(R.id.home_txt);
        office_txt = findViewById(R.id.office_txt);
        other_txt = findViewById(R.id.other_txt);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);

        linear_home.setOnClickListener(this);
        linear_office.setOnClickListener(this);
        liner_other.setOnClickListener(this);
    }
/*-----------Custom style apply in Map-----------------*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney1 = new LatLng(22.270407, 73.196789);

        DrawMarker.getInstance(this).draw(mMap, sydney1, R.drawable.ic_home_location, "Origin Location");
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e("MapActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapActivity", "Can't find style. Error: ", e);
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 15.0f ) );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_home:
                home_img.setColorFilter(Color.parseColor("#2546b0"));
                office_img.setImageResource(R.drawable.ic_office_gray);
                other_img.setImageResource(R.drawable.more);
                other_img.setColorFilter(Color.parseColor("#1c1a2f"));

                home_txt.setTextColor(Color.parseColor("#2546b0"));
                office_txt.setTextColor(Color.parseColor("#1c1a2f"));
                other_txt.setTextColor(Color.parseColor("#1c1a2f"));

                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.GONE);
                break;

            case R.id.linear_office:
                home_img.setColorFilter(Color.parseColor("#1c1a2f"));
                office_img.setImageResource(R.drawable.ic_office_blue);
                other_img.setImageResource(R.drawable.more);
                other_img.setColorFilter(Color.parseColor("#1c1a2f"));

                home_txt.setTextColor(Color.parseColor("#1c1a2f"));
                office_txt.setTextColor(Color.parseColor("#2546b0"));
                other_txt.setTextColor(Color.parseColor("#1c1a2f"));

                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.GONE);
                break;

            case R.id.liner_other:
                home_img.setColorFilter(Color.parseColor("#1c1a2f"));
                office_img.setImageResource(R.drawable.ic_office_gray);
                other_img.setImageResource(R.drawable.more);
                other_img.setColorFilter(Color.parseColor("#2546b0"));

                home_txt.setTextColor(Color.parseColor("#1c1a2f"));
                office_txt.setTextColor(Color.parseColor("#1c1a2f"));
                other_txt.setTextColor(Color.parseColor("#2546b0"));

                view1.setVisibility(View.GONE);
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.VISIBLE);
                break;
        }
    }
}
