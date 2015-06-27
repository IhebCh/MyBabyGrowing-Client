package com.itech.mybabygrowing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itech.adapter.MePagerAdapter;
import com.itech.tab.PagerSlidingTabStrip;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p/>
 * to handle interaction events.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends Fragment   {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPager viewPager;
    private PagerSlidingTabStrip pagerSlidingTabStrip;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MePagerAdapter mePagerAdapter;
    private Activity activity;

    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeFragment newInstance(String param1, String param2) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me, container, false);
        // Inflate the layout for this fragment

        pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);

        viewPager = (ViewPager) view.findViewById(R.id.pager);

        mePagerAdapter = new MePagerAdapter(getChildFragmentManager(), getActivity());

        viewPager.setAdapter(mePagerAdapter);

        pagerSlidingTabStrip.setViewPager(viewPager);

        pagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((ActionBarActivity)activity).getSupportActionBar().setSubtitle(mePagerAdapter.changeSubtitle(position));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /*viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //    pagerSlidingTabStrip.update
                //    pagerSlidingTabStrip.setSelectedNavigationItem(position);
            }
        });

       /* for (int i = 0; i < mePagerAdapter.getCount(); i++) {
            pagerSlidingTabStrip.addTab(
                    pagerSlidingTabStrip.newTab()
                            .setIcon(getResources().getDrawable(R.drawable.baby_btn))
                            .setTabListener(this)
            );
        }*/
        ((ActionBarActivity)activity).getSupportActionBar().setSubtitle(mePagerAdapter.changeSubtitle(0));

        return view;
    }


    @Override
    public void onAttach(Activity activity) {


        this.activity=activity ;
        ((ActionBarActivity)activity).getSupportActionBar().setTitle("Moi");

        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface TabChangeTitleListener{

        public String changeSubtitle(int position);
    }

}
