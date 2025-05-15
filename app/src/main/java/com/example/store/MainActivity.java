package com.example.store;

import android.os.Bundle;
import android.view.Menu;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.store.databinding.ActivityMainBinding;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding activityMainBinding;
    NavGraph bottomGraph;
    NavGraph drawerGraph;

NavController navController;
AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);



        // نوار ابزار
        setSupportActionBar(activityMainBinding.toolbar);

        // تنظیم NavController و گراف‌ها
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavInflater inflater = navController.getNavInflater();

        bottomGraph = inflater.inflate(R.navigation.navgraph);
        drawerGraph = inflater.inflate(R.navigation.navgraphdrawer);

        // پیش‌فرض: گراف bottom
        navController.setGraph(bottomGraph);

        // تنظیم دکمه‌های BottomNavigation (SmoothBottomBar)
        activityMainBinding.bottomNavigation.setOnItemSelectedListener((OnItemSelectedListener) pos -> {
            navController.setGraph(bottomGraph);
            switch (pos) {
                case 0:
                    navController.navigate(R.id.homeFragment);
                    break;
                case 1:
                    navController.navigate(R.id.ordersFragment);
                    break;
                case 2:
                    navController.navigate(R.id.shoppingcartFragment);
                    break;
                case 3:
                    navController.navigate(R.id.signFragment);
                    break;
            }
            return true;
        });

        // تنظیم آیتم‌های Drawer (NavigationView)
        activityMainBinding.navigationview.setNavigationItemSelectedListener(item -> {
            navController.setGraph(drawerGraph);

            int id = item.getItemId();
            Bundle bundle = new Bundle();

            if (id == R.id.nav_women_clothing) {
                bundle.putString("category", "women");
                navController.navigate(R.id.clothingListFragment, bundle);
            } else if (id == R.id.nav_men_clothing) {
                bundle.putString("category", "men");
                navController.navigate(R.id.clothingListFragment, bundle);
            } else if (id == R.id.nav_kids_clothing) {
                bundle.putString("category", "kids");
                navController.navigate(R.id.clothingListFragment, bundle);
            } else if (id == R.id.nav_special_offer) {
                bundle.putString("category", "sale");
                navController.navigate(R.id.clothingListFragment, bundle);
            } else {
                NavigationUI.onNavDestinationSelected(item, navController);
            }

            activityMainBinding.drawerlayout.closeDrawer(GravityCompat.START);
            return true;
        });

        // AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.clothingListFragment, R.id.aboutUsFragment, R.id.callUsFragment)
                .setOpenableLayout(activityMainBinding.drawerlayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }



    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}