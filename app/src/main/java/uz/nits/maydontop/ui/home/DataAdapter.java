package uz.nits.maydontop.ui.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import uz.nits.maydontop.R;

public class DataAdapter extends BaseAdapter {

    private static final int[] mImages = {
            R.drawable.maydon_top, R.drawable.mehmonxona_, R.drawable.basseyn_top,
            R.drawable.masjid_top, R.drawable.poliklinika, R.drawable.dantist_,
            R.drawable.veterinariya_, R.drawable.supermarket_, R.drawable.fitness_club_,
            R.drawable.avto_servis_, R.drawable.avto, R.drawable.eko_bozor_,
            R.drawable.kutubxona_, R.drawable.kafe_restoran_, R.drawable.kovorking_,
            R.drawable.mtm_, R.drawable.internet_, R.drawable.landshaft_,
            R.drawable.mtm_, R.drawable.internet_, R.drawable.landshaft_,
            R.drawable.mtm_, R.drawable.internet_, R.drawable.landshaft_,
            R.drawable.mtm_, R.drawable.internet_, R.drawable.landshaft_,
    };

    private Context mContext;

    public DataAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public Object getItem(int position) {
        return mImages[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_grid, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.imageViewItem = convertView.findViewById(R.id.imageViewGrid);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        viewHolder.imageViewItem.setImageResource(mImages[position]);

        return convertView;
    }

    static class ViewHolderItem {
        ImageView imageViewItem;
    }
}