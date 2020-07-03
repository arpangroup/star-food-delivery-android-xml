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

public class TrackOrder4Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng origin, destination;
    private Object BitmapDescriptorFactory;

    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_order4);


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map4);
        mapFragment.getMapAsync(this);


        LinearLayout linearLayout = findViewById(R.id.bottomSheet4);
        sheetBehavior = BottomSheetBehavior.from(linearLayout);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        origin = new LatLng(22.306456, 73.179591);
        destination = new LatLng(22.307846, 73.180428);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                origin).zoom(15).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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
    }
}