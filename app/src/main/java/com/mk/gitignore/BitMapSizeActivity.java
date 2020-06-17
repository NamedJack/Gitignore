package com.mk.gitignore;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BitMapSizeActivity extends AppCompatActivity {
    private static final String TAG = BitMapSizeActivity.class.getSimpleName();
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView = findViewById(R.id.image);
        printfBitmapSize(imageView);
    }

    int byteCount;
    private void printfBitmapSize(ImageView imageView){
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                byteCount = bitmap.getAllocationByteCount();
            }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1){
                //API 12
                byteCount = bitmap.getByteCount();
            } else {
                //earlier version
                byteCount = bitmap.getRowBytes() * bitmap.getHeight();
            }
            Log.d(TAG, "size == "+byteCount);
        } else {
            Log.d(TAG, "size == null");
        }
    }

}
