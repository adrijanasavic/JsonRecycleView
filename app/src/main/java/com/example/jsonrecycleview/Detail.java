package com.example.jsonrecycleview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName( "Name" )
    @Expose
    private String name;
    @SerializedName( "Age" )
    @Expose
    private Integer age;

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
