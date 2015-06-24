package com.itech.mybabygrowing;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.itech.adapter.MyPagerAdapter;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class MainActivity extends ActionBarActivity implements MaterialTabListener {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private MaterialTabHost materialTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     /*  getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_bar_title);
*/

        getSupportActionBar().setTitle("Accueille");
        getSupportActionBar().setSubtitle("");

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        viewPager = (ViewPager) findViewById(R.id.pager);

        materialTabHost = (MaterialTabHost) findViewById(R.id.tabs);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), this) ;

        viewPager.setAdapter(myPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                materialTabHost.setSelectedNavigationItem(position);
            }


        });

        for (int i = 0; i < myPagerAdapter.getCount(); i++) {
            materialTabHost.addTab(
                    materialTabHost.newTab()
                            .setIcon(getResources().getDrawable(R.drawable.guide_icon_info_grey))
                            .setTabListener(this)
            );
        }


        /*materialTabHost.setDistributeEvenly(true);

        materialTabHost.setCustomTabView(R.layout.custom_tab_view, R.id.tabsText);
        materialTabHost.setBackgroundColor(getResources().getColor(R.color.primary_color));
        materialTabHost.setSelectedIndicatorColors(getResources().getColor(R.color.accent_color));

        materialTabHost.setViewPager(viewPager);
*/
        ///*set image icon floating*/
      /* ImageView icon = new ImageView(this);
        icon.setImageDrawable(getResources().getDrawable(R.drawable.heart));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();


        actionButton.setPosition(2, (FrameLayout.LayoutParams) actionButton.getLayoutParams());
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(MaterialTab materialTab) {
        viewPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
