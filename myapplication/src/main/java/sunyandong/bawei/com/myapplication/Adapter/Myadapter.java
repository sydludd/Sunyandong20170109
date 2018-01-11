package sunyandong.bawei.com.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import sunyandong.bawei.com.myapplication.Bean.Bean;
import sunyandong.bawei.com.myapplication.R;
import sunyandong.bawei.com.myapplication.Utils.GlideImageLoader;

/**
 * Created by 悻 on 2018/1/11.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_PULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_LEFT_IMAGE = 2;
    private Bean object;
    private Context context;

    public Myadapter(Bean object, Context context) {
        this.object = object;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_PULL_IMAGE){
            View view= LayoutInflater.from(context).inflate(R.layout.itemb,parent,false);
            return new sViewHodler(view);
        }else if(viewType==TYPE_RIGHT_IMAGE){
            View view1= LayoutInflater.from(context).inflate(R.layout.itemphone,parent,false);
            return new sViewHolder1(view1);
        }else{
            View view2= LayoutInflater.from(context).inflate(R.layout.itemconne,parent,false);
            return new sViewHolder2(view2);
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof sViewHodler){
            List<String> list=new ArrayList<>();
            List<Bean.DataBean> list1=object.getData();
            for (int i=0;i<list1.size();i++){
                //Log.d(TAG, "onBindViewHolder: "+list1.);
                list.add(list1.get(i).getIcon());
            }
            String str=list1.get(position).getIcon();

            String[] strs=str.split("\\|");
            for (int i=0;i<strs.length;i++){
                list.add(strs[i]);
            }
            ((sViewHodler) holder).ban.setImages(list).isAutoPlay(true).setImageLoader(new GlideImageLoader()).start();
        }if (holder instanceof sViewHolder1){
            ((sViewHolder1) holder).recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
            ((sViewHolder1) holder).recyclerView.setAdapter(new Myadapter2(object.getMiaosha().getList(),context));
        }if(holder instanceof  sViewHolder2){
            String str=object.getTuijian().getList().get(position).getImages();
            String[] strs=str.split("\\|");


            ((sViewHolder2) holder).img.setImageURI(strs[0]);
            ((sViewHolder2) holder).tv2.setText(object.getTuijian().getList().get(position).getPrice()+"");
            ((sViewHolder2) holder).tv1.setText(object.getTuijian().getList().get(position).getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public void onAttachedToRecyclerView(RecyclerView recyclerView) {

        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager=recyclerView.getLayoutManager();

        if(manager instanceof GridLayoutManager){

            final GridLayoutManager gridLayoutManager= (GridLayoutManager) manager;

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

                @Override

                public int getSpanSize(int position) {

                    int type=getItemViewType(position);

                    switch (type){

                        case TYPE_PULL_IMAGE:

                            return 2;

                        case TYPE_RIGHT_IMAGE:

                            return 2;

                        case TYPE_LEFT_IMAGE:

                            return 1;

                    }

                    return 0;

                }

            });

        }

    }


    @Override

    public int getItemViewType(int position) {

        if (position==0){

            return TYPE_PULL_IMAGE;

        }else if(position==1)

        {

            return TYPE_RIGHT_IMAGE;

        }else

            return TYPE_LEFT_IMAGE;

    }
    private class sViewHodler extends RecyclerView.ViewHolder{
    private Banner ban;
        public sViewHodler(View itemView) {
            super(itemView);
            ban=itemView.findViewById(R.id.banner);
        }
    }
    private class sViewHolder1 extends RecyclerView.ViewHolder{

        private RecyclerView recyclerView;
        public sViewHolder1(View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.reccc);
        }
    }
    private class sViewHolder2 extends RecyclerView.ViewHolder{
             private SimpleDraweeView img;
        private TextView tv1;
        private TextView tv2;

        public sViewHolder2(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
