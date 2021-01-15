package com.example.footbaltest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footbaltest.R;
import com.example.footbaltest.Adapter.AdapterLeaguePager;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeagueDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivLogoDetail)
    ImageView ivLogoDetail;

    @BindView(R.id.tvNamaDetail)
    TextView tvNamaDetail;

    @BindView(R.id.tvTeamDetail)
    TextView tvTeamDetail;

    @BindView(R.id.tlPager)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;


    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_detail);

        ButterKnife.bind(this);

        Bundle mBundle = getIntent().getExtras();
        tvNamaDetail.setText(mBundle.getString("nama"));
        tvTeamDetail.setText(mBundle.getString("keterangan"));

        Picasso.get().load(mBundle.getString("logo")).resize(100, 100)
                .into(ivLogoDetail);

        id=mBundle.getString("id");



        tabLayout.addTab(tabLayout.newTab().setText("Next Match"));
        tabLayout.addTab(tabLayout.newTab().setText("Last Match"));


        AdapterLeaguePager pagerAdapter = new AdapterLeaguePager(getSupportFragmentManager(),tabLayout.getTabCount(),id);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
