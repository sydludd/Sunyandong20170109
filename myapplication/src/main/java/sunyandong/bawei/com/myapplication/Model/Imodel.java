package sunyandong.bawei.com.myapplication.Model;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sunyandong.bawei.com.myapplication.Bean.Bean;
import sunyandong.bawei.com.myapplication.Utils.Api;
import sunyandong.bawei.com.myapplication.Utils.RetrofitUnitl;
import sunyandong.bawei.com.myapplication.Utils.URL;

/**
 * Created by 悻 on 2018/1/11.
 */

public class Imodel {
    ScuMod scuMod;

    public void setScuMod(ScuMod scuMod) {
        this.scuMod = scuMod;
    }

    public void Shardd(){
        OkHttpClient ok=new OkHttpClient.Builder()
                .build();
        RetrofitUnitl.getInstance(URL.FRIST_ONE,ok)
                .setCreate(Api.class)
                .Zuo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        scuMod.ZC(bean);
                    }
                });
    }

    public interface ScuMod{
        void ZC(Bean bean);
    }
}
