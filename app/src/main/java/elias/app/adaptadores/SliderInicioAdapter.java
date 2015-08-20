/*
package elias.app.adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import elias.app.enchiloe.R;

*/
/**
 * Created by Elias Millachine on 20-08-2015.
 *//*

public class SliderInicioAdapter extends FragmentPagerAdapter {
    Context cx;
    int[] imagenes;
    FragmentPagerAdapter fm;

    public SliderInicioAdapter(FragmentManager fm) {
        super(fm);
    }
*/
/*
    public SliderInicioAdapter(Context cx,  fm, int[]images) {
        super(fm);
        this.cx = cx;
        this.imagenes = images;
        this.fm = fm;

    }*//*



    @Override
    public View instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)cx.getSystemService(cx.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_slider_inicio, container, false);

        ImageView imageView = (ImageView) v.findViewById(R.id.imgSliderItem);
        imageView.setImageResource(imagenes[position]);
        container.addView(v);
        return v;
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public Fragment getItem(int position) {
        return new PlaceSlideFragment(imagenes[position]);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    public final class PlaceSlideFragment extends Fragment {
        int imageResourceId;

        public PlaceSlideFragment(int i) {
            imageResourceId = i;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            ImageView image = new ImageView(getActivity());
            image.setImageResource(imageResourceId);

            LinearLayout layout = new LinearLayout(getActivity());
            // layout.setLayoutParams(new LinearLayout.LayoutParams());

            layout.setGravity(Gravity.CENTER);
            layout.addView(image);

            return layout;
        }

    }
}


*/
