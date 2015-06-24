package com.itech.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.itech.mybabygrowing.MotherGuideFragment;
import com.itech.mybabygrowing.MotherWeightFragment;
import com.itech.mybabygrowing.R;

/**
 * Created by oSunshine on 24/06/2015.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new MotherGuideFragment();

            case 1:
                return new MotherWeightFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.guide_icon_info_grey);
        drawable.setBounds(0,0,36,36);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}
