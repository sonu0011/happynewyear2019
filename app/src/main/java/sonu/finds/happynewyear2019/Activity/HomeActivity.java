package sonu.finds.happynewyear2019.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import sonu.finds.happynewyear2019.Fragments.ChristmasFragment;
import sonu.finds.happynewyear2019.Fragments.NewYearFragment;
import sonu.finds.happynewyear2019.Fragments.QuotesFragment;
import sonu.finds.happynewyear2019.Fragments.ShyariFragment;
import sonu.finds.happynewyear2019.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new NewYearFragment())
                .commit();
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
        getMenuInflater().inflate(R.menu.home, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_newyear) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new NewYearFragment())
                    .commit();
        } else if (id == R.id.nav_chrimstmas) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ChristmasFragment())
                    .commit();

        } else if (id == R.id.nav_quotes) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new QuotesFragment())
                    .commit();

        } else if (id == R.id.nav_shyari) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ShyariFragment())
                    .commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_more_apps) {

        } else if (id == R.id.nav_facebook) {


        } else if (id == R.id.nav_youtube) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
