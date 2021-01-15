package com.example.footbaltest.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footbaltest.R;
import com.example.footbaltest.Adapter.AdapterLastMatch;
import com.example.footbaltest.Client.ApiInterface;
import com.example.footbaltest.Client.RetrofitClient;
import com.example.footbaltest.Model.ResponseLastMatch;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LastMatchFragment extends Fragment {

    String idLeague;

    @BindView(R.id.rvNextMatchFragment)
    RecyclerView rvNextMatchFragment;

    AdapterLastMatch adapter;
    ApiInterface apiInterface;



    public LastMatchFragment() {
        // Required empty public constructor
    }

    //TODO: Rename and change types and number of parameters
    public static LastMatchFragment newInstance(String idLeague) {
        LastMatchFragment fragment = new LastMatchFragment();
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

        adapter=new AdapterLastMatch(getContext(),apiInterface);
        rvNextMatchFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNextMatchFragment.setAdapter(adapter);


        nextmath();

        return view;
    }

    public  void  nextmath(){

        Call<ResponseLastMatch> api=apiInterface.getLastEventByLeague(idLeague);

        api.enqueue(new Callback<ResponseLastMatch>() {
            @Override
            public void onResponse(Call<ResponseLastMatch> call, Response<ResponseLastMatch> response) {
                if (response.isSuccessful()){
                    adapter.setItems(response.body().getEvents());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseLastMatch> call, Throwable t) {

            }
        });



    }
}
