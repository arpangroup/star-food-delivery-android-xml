package ws.design.stardelivery;

import android.content.res.Resources;
import androidx.core.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import java.util.ArrayList;
import java.util.List;


public class OnTheWayActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private LatLng origin, destination;
    private List<LatLng> route;

    private static final LatLng POINT_A = new LatLng(22.304384, 73.178062);

    private static final LatLng POINT_B = new LatLng(22.306885, 73.179704);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_the_way);

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

        createRoute();
    }

    private void createRoute()
    {
        if (route == null) {
            route = new ArrayList<>();
        } else {
            route.clear();
        }

        route.add(new LatLng(22.304384, 73.178062));
        route.add(new LatLng(22.304354, 73.178536));
        route.add(new LatLng(22.304483, 73.178708));
        route.add(new LatLng(22.304503, 73.179223));
        route.add(new LatLng(22.304433, 73.179738));
        route.add(new LatLng(22.304959, 73.179910));
        route.add(new LatLng(22.305505, 73.179942));
        route.add(new LatLng(22.305781, 73.179137));
        route.add(new LatLng(22.306467, 73.179023));
        route.add(new LatLng(22.307092, 73.179152));
        route.add(new LatLng(22.307072, 73.179452));
        route.add(new LatLng(22.306854, 73.179677));
        route.add(new LatLng(22.306885, 73.179704));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(POINT_A);
                builder.include(POINT_B);
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 200);
                mMap.moveCamera(cu);
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);

                startAnim();
            }
        });
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

    private void startAnim() {
        if (mMap != null) {
            MapAnimator.getInstance().animateRoute(mMap, route);
        }    else {
            Toast.makeText(getApplicationContext(), "Map not ready", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
