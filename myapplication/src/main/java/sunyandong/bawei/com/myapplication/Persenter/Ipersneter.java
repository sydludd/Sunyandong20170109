package sunyandong.bawei.com.myapplication.Persenter;

import sunyandong.bawei.com.myapplication.Bean.Bean;
import sunyandong.bawei.com.myapplication.Model.Imodel;
import sunyandong.bawei.com.myapplication.View.Iview;

/**
 * Created by 悻 on 2018/1/11.
 */

public class Ipersneter implements Imodel.ScuMod{
   Imodel imodel;
  Iview iview;

    public Ipersneter(Iview iview) {
        this.iview = iview;
        imodel=new Imodel();
        imodel.setScuMod(this);
    }

    @Override
    public void ZC(Bean bean) {
        iview.onZuo(bean);

    }

    public void shower(){
        imodel.Shardd();
    }
}
