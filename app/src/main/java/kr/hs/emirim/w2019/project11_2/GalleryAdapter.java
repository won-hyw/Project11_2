package kr.hs.emirim.w2019.project11_2;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    Context context;
    int[] posterIds = {R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
                       R.drawable.poster06, R.drawable.poster07, R.drawable.poster08, R.drawable.poster09, R.drawable.poster10};
    int[] titleIds = {R.string.title01, R.string.title02, R.string.title03, R.string.title04, R.string.title05,
                      R.string.title06, R.string.title07, R.string.title08, R.string.title09, R.string.title10};
    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
    }

    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setImageResource(posterIds[position]);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgvLarge.setImageResource(posterIds[pos]);
                Toast toast = new Toast(context);
                View toastView = View.inflate(context, R.layout.toast1, null);
                TextView textTitle = toastView.findViewById(R.id.text_title);
                textTitle.setText(titleIds[pos]);
                toast.setView(toastView);
                toast.show();
            }
        });

        return imgv;
    }
}
