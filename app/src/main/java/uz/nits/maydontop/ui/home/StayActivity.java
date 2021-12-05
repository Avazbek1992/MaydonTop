package uz.nits.maydontop.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import uz.nits.maydontop.R;
import uz.nits.maydontop.helper.DataStorage;

public class StayActivity extends AppCompatActivity {
    private Spinner spinner_country;
    private Spinner spinner_district;
    private DataStorage storage;
    private ArrayAdapter<String> countryAdapter;
    private ArrayAdapter<String> districtAdapter;
    private int index = 0;
    private ArrayList<String> districtArray;
    private Button button;
    private ImageView backButton;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stay_activity);

        storage = new DataStorage(this);
        backButton = findViewById(R.id.stay_back);
        button = findViewById(R.id.tanlashButton);
        spinner_country = findViewById(R.id.spinner_country);
        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, storage.getCountry());
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_country.setAdapter(countryAdapter);

        districtArray = new ArrayList<>();
        districtArray.add("<<---Tumanni tanlash--->>");
        spinner_district = findViewById(R.id.spinner_district);
        districtAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, storage.getDistrict(index));
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_district.setAdapter(districtAdapter);

        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                System.out.println("Selected: " + index);
                if (i == 0) {
                    districtArray.clear();
                    districtArray.add("<<---Tumanni tanlash--->>");
                } else {
                    districtArray = storage.getDistrict(index);
                }
                districtAdapter = new ArrayAdapter<>(StayActivity.this, android.R.layout.simple_spinner_item, districtArray);
                districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_district.setAdapter(districtAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        button.setOnClickListener(view -> {
            startActivity(new Intent(StayActivity.this, AddressActivity.class));
        });

        backButton.setOnClickListener(view -> onBackPressed());
    }
}
