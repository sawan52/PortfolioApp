package com.example.portfolioapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.cv.CVFragment;
import com.example.portfolioapp.home.HomeFragment;
import com.example.portfolioapp.portfolio.PortfolioFragment;
import com.example.portfolioapp.sidemenu.Callback;
import com.example.portfolioapp.sidemenu.MenuAdapter;
import com.example.portfolioapp.sidemenu.MenuItem;
import com.example.portfolioapp.sidemenu.MenuUtil;
import com.example.portfolioapp.team.TeamFragment;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView RvMenu;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        // setup side menu

        setupSideMenu();

        // set the default fragment when activity launches

        setHomeFragment();

        //setHomeFragment();
        //setCVFragment();
        //setTeamFragment();
        setPortfolioFragment();

    }

    private void setupSideMenu() {

        RvMenu = findViewById(R.id.rv_side_menu);

        // get menu list items which will get data from a static data

        menuItems = MenuUtil.getMenuList();

        adapter = new MenuAdapter(menuItems, this);
        RvMenu.setLayoutManager(new LinearLayoutManager(this));
        RvMenu.setAdapter(adapter);

    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setPortfolioFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE:
                setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE:
                setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE:
                setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:
                setPortfolioFragment();
                break;
            default:
                setHomeFragment();

        }

        // highlight the selected menu items

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();

    }
}
