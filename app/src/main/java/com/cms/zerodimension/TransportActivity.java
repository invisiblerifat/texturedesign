package com.cms.zerodimension;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.Item;
import model.Transport;

public class TransportActivity extends AppCompatActivity {

    @BindView(R.id.bottom_toolbar)
    BottomNavigationView bottomNavigationView;
    List<Transport> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        ButterKnife.bind(this);
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        itemList=new ArrayList<>();
        itemList.add(new Transport("c1010","New Item",R.drawable.img));
        itemList.add(new Transport("c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Transport("c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Transport("c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Transport("c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Transport("c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Transport("c1017","New Item 2",R.drawable.img_9));
        itemList.add(new Transport("c1010","New Item",R.drawable.img));
        itemList.add(new Transport("c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Transport("c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Transport("c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Transport("c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Transport("c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Transport("c1017","New Item 2",R.drawable.img_9));
        itemList.add(new Transport("c1010","New Item",R.drawable.img));
        itemList.add(new Transport("c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Transport("c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Transport("c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Transport("c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Transport("c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Transport("c1017","New Item 2",R.drawable.img_9));
        bottomNavigationView.getMenu().getItem(2).setChecked(true);
        RecyclerView recyclerView=findViewById(R.id.recyclerview_id);
        TransportRecyclerViewAdapter recyclerViewAdapter=new TransportRecyclerViewAdapter(this,itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(recyclerViewAdapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }else if(item.getItemId()==R.id.category){
                    Intent intent=new Intent(getApplicationContext(),CategoryActivity.class);
                    startActivity(intent);
                }else if(item.getItemId()==R.id.update){
                    Intent intent=new Intent(getApplicationContext(),TransportActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_search,menu);
        MenuItem item=menu.findItem(R.id.menu_search);
        //SearchView searchView=(SearchView)item.getActionView();
        com.miguelcatalan.materialsearchview.MaterialSearchView searchView = (com.miguelcatalan.materialsearchview.MaterialSearchView) findViewById(R.id.search_view);
        searchView.setMenuItem(item);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new com.miguelcatalan.materialsearchview.MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
