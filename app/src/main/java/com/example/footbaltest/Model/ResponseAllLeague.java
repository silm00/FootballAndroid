package com.example.footbaltest.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseAllLeague{

    @SerializedName("countrys")
    private List<CountrysItem> countrys;

    public void setCountrys(List<CountrysItem> countrys){
        this.countrys = countrys;
    }

    public List<CountrysItem> getCountrys(){
        return countrys;
    }

    @Override
    public String toString(){
        return
                "ResponseAllLeague{" +
                        "countrys = '" + countrys + '\'' +
                        "}";
    }
}
