package us.mifeng.rxjavaandandroidandeventbus.connector;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import us.mifeng.rxjavaandandroidandeventbus.bean.FenLeiBean;

/**
 * Created by shido on 2017/8/21.
 */

public interface API {
    @GET("index.php?m=Api&c=Goods&a=goodsCategoryList")
    Observable<FenLeiBean> getBean(@QueryMap HashMap<String,String> map);
}
