package sunyandong.bawei.com.myapplication.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import sunyandong.bawei.com.myapplication.Bean.Bean;
import sunyandong.bawei.com.myapplication.R;

/**
 * Created by 悻 on 2018/1/11.
 */

public class Myadapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Bean.MiaoshaBean.ListBeanX> listBeanXes=new ArrayList<>();
    private Context context;

    public Myadapter2(List<Bean.MiaoshaBean.ListBeanX> listBeanXes, Context context) {
        this.listBeanXes = listBeanXes;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemp,parent,false);

        return new sVioewHole(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        sVioewHole sViewHodler= (Myadapter2.sVioewHole) holder;
        String str=listBeanXes.get(position).getImages();
        String[] strs=str.split("\\|");
        Uri uri=Uri.parse(strs[0]);
        sViewHodler.img.setImageURI(uri);
        sViewHodler.tv1.setText(listBeanXes.get(position).getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return listBeanXes.size();
    }
    private class sVioewHole extends RecyclerView.ViewHolder{

        private SimpleDraweeView img;
        private TextView tv1;
        public sVioewHole(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.Phoneimg);
            tv1=itemView.findViewById(R.id.phoneprice);
        }
    }
}
