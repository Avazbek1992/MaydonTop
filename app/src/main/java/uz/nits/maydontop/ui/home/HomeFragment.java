package uz.nits.maydontop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import uz.nits.maydontop.R;
import uz.nits.maydontop.helper.DataStorage;

public class HomeFragment extends Fragment implements
        AdapterView.OnItemSelectedListener {
    private DataAdapter mAdapter;
    private DataStorage storage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        storage = new DataStorage();
        final GridView g = root.findViewById(R.id.gridView1);
        mAdapter = new DataAdapter(getActivity());
        g.setAdapter(mAdapter);
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener((parent, v, position, id) -> {
            Intent intent = new Intent(getActivity(), StayActivity.class);
            intent.putExtra(storage.getKEY_ID(), id);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}