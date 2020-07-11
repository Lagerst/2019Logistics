package com.project.server.searchOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.javafx.beans.IDProperty;


public class Neworder {

    @JsonProperty(value="num")
    public String num;
    @JsonProperty(value = "name")
    public String name;
    @JsonProperty(value = "type")
    public String type;
    @JsonProperty(value = "storage")
    public String storage;
    @JsonProperty(value = "date1")
    public String data1;
    @JsonProperty(value = "date2")
    public  String data2;
    @JsonProperty(value = "province")
    public  String province;
    @JsonProperty(value = "city")
    public String city;
    @JsonProperty(value = "district")
    public  String district;
    @JsonProperty(value = "address")
    public String address;
    @JsonProperty(value = "quantity")
    public  String quantity;
    @JsonProperty(value = "desc")
    public  String desc;


    public String toString(){
        return "num:"+num+" name:"+name+" type:"+type+" storage:"+storage+" date1:"+data1+" data2:"+data2;
    }
}
