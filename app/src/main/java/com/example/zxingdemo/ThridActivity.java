package com.example.zxingdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class ThridActivity extends AppCompatActivity {

    private Button button_content;
    private Button button1_content;
    private EditText edit_content;
    private ImageView image_content;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        button_content = findViewById(R.id.button_content);
        button1_content = findViewById(R.id.button1_content);
        edit_content = findViewById(R.id.edit_content);
        image_content = findViewById(R.id.image_content);

        /**
         * 生成二维码图片
         */
        button_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textContent = edit_content.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThridActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                edit_content.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.drawable.yingbao));
                image_content.setImageBitmap(mBitmap);
            }
        });
        /**
         * 生成不带logo的二维码图片
         */
        button1_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textContent = edit_content.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(ThridActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                edit_content.setText("");
                mBitmap = CodeUtils.createImage(textContent, 400, 400, null);
                image_content.setImageBitmap(mBitmap);
            }
        });
    }
}
