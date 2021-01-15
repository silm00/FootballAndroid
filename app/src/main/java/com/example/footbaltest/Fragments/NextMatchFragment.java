package com.example.footbaltest.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.footbaltest.R;
import com.example.footbaltest.Adapter.AdapterNextMatch;
import com.example.footbaltest.Client.ApiInterface;
import com.example.footbaltest.Client.RetrofitClient;
import com.example.footbaltest.Model.ResponseNextMatch;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NextMatchFragment extends Fragment {

    String idLeague;

    @BindView(R.id.rvNextMatchFragment)
    RecyclerView rvNextMatchFragment;

    AdapterNextMatch adapter;
    ApiInterface apiInterface;



    public NextMatchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NextMatchFragment newInstance(String idLeague) {
        NextMatchFragment fragment = new NextMatchFragment();
        Bundle args = new Bundle();
        args.putString("id", idLeague);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idLeague = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_next_match, container, false);

        ButterKnife.bind(this,view);

        apiInterface= RetrofitClient.getRetrofitClient().create(ApiInterface.class);

        adapter=new AdapterNextMatch(getContext(),apiInterface);

        rvNextMatchFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNextMatchFragment.setAdapter(adapter);


        nextmath();

        return view;
    }

    public  void  nextmath(){
        Call<ResponseNextMatch> api=apiInterface.getNextEventByLeague(idLeague);

        api.enqueue(new Callback<ResponseNextMatch>() {
            @Override
            public void onResponse(Call<ResponseNextMatch> call, Response<ResponseNextMatch> response) {
                if (response.isSuccessful()){
                    adapter.setItems(response.body().getEvents());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseNextMatch> call, Throwable t) {

            }
        });



    }
}
