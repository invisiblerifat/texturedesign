package com.cms.zerodimension;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.Item;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{
    List<Item> itemList;
    @BindView(R.id.bottom_toolbar)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.slider)
    SliderLayout sliderLayout ;
    HashMap<String, String> HashMapForURL ;

    HashMap<String, Integer> HashMapForLocalRes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        itemList=new ArrayList<>();
        itemList.add(new Item(1,"c1010","New Item",R.drawable.img));
        itemList.add(new Item(2,"c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Item(3,"c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Item(4,"c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Item(5,"c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Item(6,"c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Item(7,"c1017","New Item 2",R.drawable.img_9));
        itemList.add(new Item(1,"c1010","New Item",R.drawable.img));
        itemList.add(new Item(2,"c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Item(3,"c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Item(4,"c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Item(5,"c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Item(6,"c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Item(7,"c1017","New Item 2",R.drawable.img_9));
        itemList.add(new Item(1,"c1010","New Item",R.drawable.img));
        itemList.add(new Item(2,"c1012","New Item 2",R.drawable.img_1));
        itemList.add(new Item(3,"c1013","New Item 2",R.drawable.img_2));
        itemList.add(new Item(4,"c1014","New Item 2",R.drawable.img_3));
        itemList.add(new Item(5,"c1015","New Item 2",R.drawable.img_4));
        itemList.add(new Item(6,"c1016","New Item 2",R.drawable.img_7));
        itemList.add(new Item(7,"c1017","New Item 2",R.drawable.img_9));
        RecyclerView recyclerView=findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(this,itemList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setNestedScrollingEnabled(false);
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

        AddImageUrlFormLocalRes();
        for(String name : HashMapForLocalRes.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(3000);

        sliderLayout.addOnPageChangeListener(MainActivity.this);
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline(){

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        HashMapForURL.put("Donut", "http://androidblog.esy.es/images/donut-2.png");
        HashMapForURL.put("Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        HashMapForURL.put("Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        HashMapForURL.put("GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");
    }

    public void AddImageUrlFormLocalRes(){

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("CupCake", R.drawable.img);
        HashMapForLocalRes.put("Donut", R.drawable.img_1);
        HashMapForLocalRes.put("Eclair", R.drawable.img_2);
        HashMapForLocalRes.put("Froyo", R.drawable.img_3);
        HashMapForLocalRes.put("GingerBread", R.drawable.img_4);

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
