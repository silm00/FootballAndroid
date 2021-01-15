package com.example.footbaltest.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailLeague{

    @SerializedName("leagues")
    private List<LeaguesItem> leagues;

    public void setLeagues(List<LeaguesItem> leagues){
        this.leagues = leagues;
    }

    public List<LeaguesItem> getLeagues(){
        return leagues;
    }

    @Override
    public String toString(){
        return
                "ResponseDetailLeague{" +
                        "leagues = '" + leagues + '\'' +
                        "}";
    }
}
