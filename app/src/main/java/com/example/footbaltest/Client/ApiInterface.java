package com.example.footbaltest.Client;

import com.example.footbaltest.Model.ResponseAllLeague;
import com.example.footbaltest.Model.ResponseDetailLeague;
import com.example.footbaltest.Model.ResponseLastMatch;
import com.example.footbaltest.Model.ResponseLookupTeam;
import com.example.footbaltest.Model.ResponseNextMatch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_all_leagues.php?c=England&s=Soccer")
    Call<ResponseAllLeague> getAllLeague();

    @GET("lookupleague.php")
    Call<ResponseDetailLeague> getDetailLeague(@Query("id") String id);

    @GET("eventsnextleague.php")
    Call<ResponseNextMatch> getNextEventByLeague(@Query("id") String id);

    @GET("eventpastleague.php")
    Call<ResponseLastMatch> getLastEventByLeague(@Query("id") String id);

    @GET("lookupteam.php")
    Call<ResponseLookupTeam> getLookupTeam(@Query("id")String id);

}

