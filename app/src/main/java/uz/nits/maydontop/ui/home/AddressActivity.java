package uz.nits.maydontop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import uz.nits.maydontop.R;
import uz.nits.maydontop.adapter.AddressCustomAdapter;

public class AddressActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> addressArrayList;
    ImageView backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        listView = findViewById(R.id.addressListView);
        backButton = findViewById(R.id.address_back);

        addressArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            addressArrayList.add("1");
        }

        listView.setAdapter(new AddressCustomAdapter(AddressActivity.this, addressArrayList));
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            startActivity(new Intent(AddressActivity.this, StadionActivity.class));
        });

        backButton.setOnClickListener(view -> onBackPressed());
    }
}
