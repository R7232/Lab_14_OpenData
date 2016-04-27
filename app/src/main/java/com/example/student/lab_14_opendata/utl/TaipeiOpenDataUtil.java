package com.example.student.lab_14_opendata.utl;


import android.util.Log;

import com.example.student.lab_14_opendata.api.TaipeiAttractionsOpenData;
import com.example.student.lab_14_opendata.benas.TaipeAttractionsBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaipeiOpenDataUtil {

    public static final String TAG = "loadOpenData";

    public static void loadTapipeiAttractions(){

        Call<TaipeAttractionsBean> call = TaipeiAttractionsOpenData.apiService.getAttractionslnTaipeiBean();
        call.enqueue(new Callback<TaipeAttractionsBean>() {
            @Override
            public void onResponse(Call<TaipeAttractionsBean> call, Response<TaipeAttractionsBean> response) {

                    if (!response.isSuccessful()){
                        Log.d(TAG,"onResponse() : Unsuccessful , response_code = " + response.code());
                        return;
                    }

                    TaipeAttractionsBean bean = response.body();
                    Log.d(TAG,"onResponse() : Successful");
                    Log.d(TAG,"count = " + bean.getResult().getCount());

                    // 使用傳統 for 迴圈性能較佳
                    for(int i = 0 ; i < bean.getResult().getCount(); i++){

                        Log.d(TAG,"---------------" +i+ "---------------");

                        TaipeAttractionsBean.ResultBean.ResultsBean attraction =
                                bean.getResult().getAttractions().get(i);

                        List<String> list = ImageUrlParser.split(attraction.getImagesURLs());
                        logAttaraction(attraction);
                        logImageUrls(list);
                    }

            }

            @Override
            public void onFailure(Call<TaipeAttractionsBean> call, Throwable t) {

            }
        });
    }

    private static void logAttaraction(TaipeAttractionsBean.ResultBean.ResultsBean attraction){
       Log.d(TAG, attraction.getStitle() + "");
        /* Log.d(TAG, attraction.getCategory() + "");
        Log.d(TAG, attraction.getIntroduction() + "");
        Log.d(TAG, attraction.getAddress() + "");
        Log.d(TAG, attraction.getTransportation() + "");
        Log.d(TAG, attraction.getMRT() + "");
        Log.d(TAG, attraction.getLatitude() + "");
        Log.d(TAG, attraction.getLongitude() + "");
        Log.d(TAG, attraction.getMemoTime() + "");  */
        Log.d(TAG, attraction.getImagesURLs() + "");
    }

    private static class ImageUrlParser{

        public static List<String> split(String urls){
            if(urls == null || urls.length()==0){
                return null ;
            }
            List<String> list = new ArrayList<>();
            int start = urls.indexOf("http");
            int end = 0 ;
            while (start >= 0){
                end = urls.indexOf("http", start+1);
                if (end < 0){
                    list.add(urls.substring(start,urls.length()));
                    break;
                }
                list.add(urls.substring(start,end));
                start = end ;
            }
            return list ;
        }
    }

    private static void logImageUrls(List<String> list){
        for (int j = 0 ; j < list.size() ; j++){
            Log.d(TAG,list.get(j).toString());
        }
    }
}
