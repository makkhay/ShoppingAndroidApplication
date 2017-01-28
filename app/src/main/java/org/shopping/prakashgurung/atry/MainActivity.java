package org.shopping.prakashgurung.atry;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.shopping.prakashgurung.atry.R;

import org.shopping.prakashgurung.atry.Fragments.FeaturedFragment;
import org.shopping.prakashgurung.atry.Fragments.onSaleFragment;
import org.shopping.prakashgurung.atry.Fragments.upcomingFragment;
import org.shopping.prakashgurung.atry.Recycler.Album;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private static final String TAG_SORT_NAME="sortPrice";
    private static final String TAG_FACE="iconFace";
    private static final String TAG_FAV="iconFav";
    SimpleRatingBar ratingBar;

    Context c;
    ArrayList<Album> albums;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);








        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       ratingBar = (SimpleRatingBar) findViewById(R.id.ratingBarID);

        Button rating = (Button) findViewById(R.id.ratingBarID);

        //Setting up FAB button
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.plus);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(image).build();
        /**
         * Setting up icons from drawable source
         */
        ImageView iconFav = new ImageView(this);
        iconFav.setImageResource(R.drawable.rating);
        ImageView iconSort = new ImageView(this);
        iconSort.setImageResource(R.drawable.cool);
        ImageView iconFacebook = new ImageView(this);
        iconFacebook.setImageResource(R.drawable.share);


        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        // Changing size of the icon
        FloatingActionButton.LayoutParams params = new FloatingActionButton.LayoutParams(160,160);
        itemBuilder.setLayoutParams(params);
        SubActionButton buttonFav = itemBuilder.setContentView(iconFav).build();
        SubActionButton buttonSort = itemBuilder.setContentView(iconSort).build();
        SubActionButton buttonFace = itemBuilder.setContentView(iconFacebook).build();

        // Setting tags for buttons
        buttonFav.setTag(TAG_FAV);
        buttonSort.setTag(TAG_SORT_NAME);
        buttonFace.setTag(TAG_FACE);

        // Setting button to onClick
        buttonFav.setOnClickListener(this);
        buttonSort.setOnClickListener(this);
        buttonFace.setOnClickListener(this);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this).addSubActionView(buttonFace)
                .addSubActionView(buttonFav).addSubActionView(buttonSort).attachTo(actionButton).build();


//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, String.valueOf(ratingBar.getRating()), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        ViewPager vp = (ViewPager) findViewById(R.id.mViewpager_ID);
        this.addPages(vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.mtab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(listener(vp));

        tabLayout.getTabAt(0).setIcon(R.drawable.suitcase);
        tabLayout.getTabAt(1).setIcon(R.drawable.sale);
        tabLayout.getTabAt(2).setIcon(R.drawable.planner);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // add all pages


    private void addPages(ViewPager pager){
        MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
        adapter.addPage(new FeaturedFragment());
        adapter.addPage(new onSaleFragment());
        adapter.addPage(new upcomingFragment());

     pager.setAdapter(adapter);

    }

    private TabLayout.OnTabSelectedListener listener( final ViewPager pager){

        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.about){
            Intent intent = new Intent(this,about.class);
             startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_gallery) {



            Intent intent = new Intent(this,favorite.class);

           
            //intent.putExtra(Intent.EXTRA_TEXT, albums.get(pos).getImage());
            startActivity(intent);


            Toast.makeText(MainActivity.this, "Photos will be uploaded soon.", Toast.LENGTH_SHORT).show();



        } else if (id == R.id.nav_manage) {

            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(myAppLinkToMarket);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(MainActivity.this, "Google play opening....", Toast.LENGTH_SHORT).show();



        } else if (id == R.id.nav_report) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"maakkhay@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Bug report");

            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }



        } else if (id == R.id.nav_send) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"manvik1752@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Shopping");

            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     *
     * on Click button for FAB button
     */

    @Override
    public void onClick(View v) {
//
//        Snackbar.make(v, String.valueOf(ratingBar.getRating()) + "Rating Saved", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();




        int id = v.getId();
       if(id ==R.id.ratingBarID){
           Toast.makeText(MainActivity.this, "Rating Saved", Toast.LENGTH_SHORT).show();

       }

        if(v.getTag().equals(TAG_FAV)){
            Toast.makeText(MainActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
        }
       if(v.getTag().equals(TAG_FACE)){

           String message = "Check out this cool shopping app.\n https://play.google.com/store/apps/details?id=org.shopping.prakashgurung.atry ";
           Intent share = new Intent(Intent.ACTION_SEND);
           share.setType("text/plain");
           share.putExtra(Intent.EXTRA_TEXT, message);

           startActivity(Intent.createChooser(share, "Please share my app, Thanks!!"));



        } if(v.getTag().equals(TAG_SORT_NAME)){


            Toast.makeText(MainActivity.this, "Coming soon haha", Toast.LENGTH_SHORT).show();
        }

    }
//    @Override
//    public void onItemClick(View v, int pos) {
//
//            Intent intent = new Intent(this,favorite.class);
//
//            intent.putExtra(Intent.EXTRA_TEXT, albums.get(pos).getImage());
//            startActivity(intent);
//
//
//    }

}
