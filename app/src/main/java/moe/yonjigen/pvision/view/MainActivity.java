package moe.yonjigen.pvision.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import moe.yonjigen.pvision.PvisionData;
import moe.yonjigen.pvision.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS);
//        OkHttpClient client = builder.build();
//        //构造Request对象
//        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
//        Request request = new Request.Builder()
//                .get()
//                .url("https://i.pximg.net/c/600x600/img-master/img/2019/03/15/00/17/52/73684216_p0_master1200.jpg")
//                .removeHeader("User-Agent")
//                .addHeader("User-Agent", PvisionData.USER_AGENT)
//                .addHeader("Referer", "https://www.pixiv.net")
//                .build();
////        Request request = new Request.Builder().get().url("https://m.baidu.com").build();
//        Call call = client.newCall(request);
//        //异步调用并设置回调函数
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//                System.out.println("失败了");
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            byte[] imageByte = response.body().bytes();
//                            Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
//                            Glide.with(MainActivity.this).load(bitmap).into(imageView);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        });
    }
}