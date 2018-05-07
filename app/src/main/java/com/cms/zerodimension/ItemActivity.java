package com.cms.zerodimension;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemActivity extends AppCompatActivity {
    @BindView(R.id.item_code)
    TextView codeTextView;
    @BindView(R.id.item_price)
    TextView descTextView;
    @BindView(R.id.item_thumnail)
    ImageView imageView;
    @BindView(R.id.rating)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        int thumbnail=getIntent().getExtras().getInt("ITEM_THUMBNAIL");
        String code=getIntent().getExtras().getString("ITEM_CODE");
        String desc=getIntent().getExtras().getString("DESCRIPTION");
        codeTextView.setText(code);
        descTextView.setText(desc);
        imageView.setImageResource(thumbnail);
        ratingBar.setRating(5);
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
