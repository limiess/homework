package com.example.homework1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.homework1.R;
import com.example.homework1.msgType.MessageEvent;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        EventBus.getDefault().register(this);
        //back按钮
        Button button=(Button) findViewById(R.id.back);
        Drawable drawable=(Drawable) getResources().getDrawable(R.drawable.back_button_background);
        drawable.setBounds(0,0,180,80);
        button.setCompoundDrawables(drawable,null,null,null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("back"));
            }
        });

        //back按钮中的图片视图(覆盖了按钮及其背景)
        Uri uri = Uri.parse("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F00%2F92%2F85%2F4456f23be8baf9c.jpg&refer=http%3A%2F%2Fku.90sjimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1654845717&t=0655a01b4e1835b4763f8ebcc5b4aa2e");
        SimpleDraweeView backView = (SimpleDraweeView) findViewById(R.id.back_view);
        backView.setImageURI(uri);
        //web视图
        WebView webView =(WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:") ) {
                    view.loadUrl(url);
                    return false;
                }else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            }
        });
        webView.loadUrl("https://www.baidu.com");
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(MessageEvent message) {
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}