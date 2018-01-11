package sunyandong.bawei.com.myapplication.Utils;

import retrofit2.http.GET;
import rx.Observable;
import sunyandong.bawei.com.myapplication.Bean.Bean;

/**
 * Created by 悻 on 2018/1/9.
 */

public interface Api {
    @GET(URL.Last_TWO)
    Observable<Bean> Zuo();
}

