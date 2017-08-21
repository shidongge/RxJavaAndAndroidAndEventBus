package us.mifeng.rxjavaandandroidandeventbus.utils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.mifeng.rxjavaandandroidandeventbus.bean.FenLeiBean;
import us.mifeng.rxjavaandandroidandeventbus.connector.API;

/**
 * Created by shido on 2017/8/21.
 */

public class HttpLoper {
    private static final String TAG = "HttpLoper";
    private static HttpLoper httpLoper = new HttpLoper();
    private final Retrofit retrofit;
    private final API api;

    public HttpLoper(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://shop.sdlinwang.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(API.class);


    }
    public static HttpLoper getIntence(){

        return httpLoper;
    }
    public void getUrl(){
        HashMap<String,String> map = new HashMap<>();
        Observable<FenLeiBean> bean = api.getBean(map);
        bean.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<FenLeiBean>() {
                    @Override
                    public void call(FenLeiBean bean) {
                        EventBus.getDefault().post(new FirstEvent(bean.getMsg()));
                    }
                });
    }
}
