package uz.nits.maydontop.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uz.nits.maydontop.R;

public class StadionActivity extends AppCompatActivity implements OnMapReadyCallback {
    private TextView locationTV;
    private ImageView backButton;
    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stadion_layout);
        locationTV = findViewById(R.id.locationId);
        backButton = findViewById(R.id.stadion_back);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationTV.setOnClickListener(view -> {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/5evnDhs6cnm4gFW76"));
            startActivity(mapIntent);
        });

        backButton.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(41.022391, 71.657563);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Namangan Nits"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f));
    }
}
