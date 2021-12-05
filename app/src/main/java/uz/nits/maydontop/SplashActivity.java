package uz.nits.maydontop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uz.nits.maydontop.ui.LoginFragment;

public class SplashActivity extends AppCompatActivity{

    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_layout);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_splash, new LoginFragment())
                        .commit();
            } catch (IllegalStateException | InterruptedException ignored) {
                // There's no way to avoid getting this if saveInstanceState has already been called.
            }

        }).start();
    }
}
