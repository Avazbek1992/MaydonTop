package uz.nits.maydontop.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import uz.nits.maydontop.R;

public class AddressCustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> addressArrayList;

    public AddressCustomAdapter(Context mContext, ArrayList<String> mAddressArrayList) {
        context = mContext;
        addressArrayList = mAddressArrayList;
    }

    @Override
    public int getCount() {
        return addressArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder")
        View root = LayoutInflater.from(context).inflate(R.layout.address_custom_layout, viewGroup, false);
        return root;
    }
}
