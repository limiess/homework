package com.example.homework1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.homework1.R;
import com.example.homework1.msgType.MessageEvent;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        //web按钮
        Button button=(Button) findViewById(R.id.buttongo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
        Uri uri = Uri.parse("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F03%2F50%2F44%2F5bbc21aea2050_610.jpg&refer=http%3A%2F%2Fpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654843129&t=6e184aeb104b3116f5fa4d988a5fe951");
        SimpleDraweeView browseView = (SimpleDraweeView) findViewById(R.id.browse_view);
        browseView.setImageURI(uri);

        //帧测试按钮
        Button button1=(Button) findViewById(R.id.buttonfm);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FragmentTestActivity.class);
                startActivity(intent);
            }
        });
    }

}