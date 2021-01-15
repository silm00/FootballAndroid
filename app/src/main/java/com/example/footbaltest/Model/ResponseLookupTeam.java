package com.example.footbaltest.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLookupTeam{

    @SerializedName("teams")
    private List<TeamsItem> teams;

    public void setTeams(List<TeamsItem> teams){
        this.teams = teams;
    }

    public List<TeamsItem> getTeams(){
        return teams;
    }

    @Override
    public String toString(){
        return
                "ResponseLookupTeam{" +
                        "teams = '" + teams + '\'' +
                        "}";
    }
}
