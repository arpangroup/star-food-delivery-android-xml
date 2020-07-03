package ws.design.stardelivery;

import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import androidx.core.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;

public class TrackOrder1Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng sydney1;
    private LatLng sydney2;
    private LatLng origin, destination;
    private Object BitmapDescriptorFactory;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order1);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LinearLayout linearLayout = findViewById(R.id.bottomSheet1);
        sheetBehavior = BottomSheetBehavior.from(linearLayout);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        sydney1 = new LatLng(22.272918, 73.190565);
        sydney2 = new LatLng(22.270407, 73.196789);

        DrawMarker.getInstance(this).draw(mMap, sydney1, R.drawable.ic_home_location, "Origin Location");
        DrawMarker.getInstance(this).draw(mMap, sydney2, R.drawable.ic_restaurant, "TASTE OF BOMBAY\n" +
                "SANDWICH");
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                sydney1).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e("MapActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapActivity", "Can't find style. Error: ", e);
        }
    }
}
