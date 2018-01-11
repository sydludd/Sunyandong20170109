package sunyandong.bawei.com.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import sunyandong.bawei.com.myapplication.Adapter.Myadapter;
import sunyandong.bawei.com.myapplication.Bean.Bean;
import sunyandong.bawei.com.myapplication.Persenter.Ipersneter;
import sunyandong.bawei.com.myapplication.View.Iview;

public class MainActivity extends AppCompatActivity implements Iview{

    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Ipersneter ipersneter=new Ipersneter(this);
        ipersneter.shower();

        init();
    }

    private void init() {
        rec = (RecyclerView) findViewById(R.id.rec);
    }

    @Override
    public void onZuo(Bean bean) {
        rec.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        rec.setAdapter(new Myadapter(bean,MainActivity.this));
    }
}
