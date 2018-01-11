package sunyandong.bawei.com.myapplication.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 悻 on 2018/1/2.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        /**
         注意：
         1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
         2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
         传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
         切记不要胡乱强转！
         */

        //第一种方法：Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);

        //第二种方法：Picasso 加载图片简单用法
        //Picasso.with(context).load(path).into(imageView);

        //第三种方法：fresco加载图片简单用法，记得要写下面的createImageView方法
        //Uri uri = Uri.parse((String) path);
        //imageView.setImageURI(uri);
    }
    @Override
    public ImageView createImageView(Context context) {
        //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
        //SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
        return null;
    }
}