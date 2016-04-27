package com.example.student.lab_14_opendata.model;

import com.example.student.lab_14_opendata.benas.TaipeAttractionsBean;

import java.util.List;

public class TaipeiAttractions {

    private static TaipeAttractionsBean bean ;
    private static List<TaipeAttractionsBean.ResultBean.ResultsBean> attractions ;
    private static List<String> imageUrlsList ;

    public TaipeiAttractions() {

    }

    public int getCount(){
        return bean.getResult().getCount();
    }

    public String getSubTitle(int index){
        return attractions.get(index).getStitle();
    }

    public String getCategory(int index){
        return attractions.get(index).getCategory();
    }


    public static List<String> getImageUrlsList() {
        return imageUrlsList;
    }
}
