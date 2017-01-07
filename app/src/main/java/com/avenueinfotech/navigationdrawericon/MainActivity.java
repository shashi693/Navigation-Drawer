package com.avenueinfotech.navigationdrawericon;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.ToggleDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.OnCheckedChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by suken on 07-01-2017.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.drawer_recyclerView) RecyclerView drawerRecyclerView;
    private Drawer.Result navigationDrawerLeft;
    private Drawer.Result getNavigationDrawerRight;
    private AccountHeader.Result headerNavigationLeft;

    private OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(IDrawerItem iDrawerItem, CompoundButton compoundButton, boolean b) {
            Toast.makeText(MainActivity.this, "OnCheckedChangeListener: "+( b ? "true" : "false"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
//                drawerLayout.setDrawerListener(drawerToggle);
//                drawerToggle.syncState();

//        List<String> rows= new ArrayList<>();
//        rows.add("option 1");
//        rows.add("opton 2: A longer option");
//        rows.add("option 3: The longest option of all");
//
//        DrawerAdapter drawerAdapter = new DrawerAdapter(rows);
//        drawerRecyclerView.setAdapter(drawerAdapter);
//        drawerRecyclerView.setHasFixedSize(true);
//        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //navigation Drawer
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(0)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {

                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(MainActivity.this, "onItemLongClick: "+i, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();

            navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Carros Esportives").withIcon(getResources().getDrawable(R.drawable.car_1)));
            navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Audi Delecus").withIcon(getResources().getDrawable(R.drawable.audi)));
            navigationDrawerLeft.addItem(new DividerDrawerItem());
            navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Ferrai dex").withIcon(getResources().getDrawable(R.drawable.ferrai)));
            navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Mercedes dex").withIcon(getResources().getDrawable(R.drawable.mercedes)));
            navigationDrawerLeft.addItem(new SectionDrawerItem().withName("configuration"));
            navigationDrawerLeft.addItem(new SwitchDrawerItem().withName("Notification").withChecked(true).withOnCheckedChangeListener(mOnCheckedChangeListener));
            navigationDrawerLeft.addItem(new ToggleDrawerItem().withName("News").withChecked(true).withOnCheckedChangeListener(mOnCheckedChangeListener));

            //End Right
        getNavigationDrawerRight = new Drawer()
                .withActivity(this)
//                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.END)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(MainActivity.this, "onItemClick: "+i, Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l, IDrawerItem iDrawerItem) {
                        Toast.makeText(MainActivity.this, "onItemLongClick: "+i, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();
    }
}
