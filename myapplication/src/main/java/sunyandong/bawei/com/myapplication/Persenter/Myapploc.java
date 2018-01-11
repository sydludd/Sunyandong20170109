package sunyandong.bawei.com.myapplication.Persenter;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 悻 on 2018/1/11.
 */

public class Myapploc extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
