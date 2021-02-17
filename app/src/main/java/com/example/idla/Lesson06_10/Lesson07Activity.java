package com.example.idla.Lesson06_10;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;

import com.example.idla.BaseActivity;
import com.example.idla.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Lesson07Activity extends BaseActivity {

    //static不行, 一定要final
    final int kCameraIntentRequestCode = 1000;
    final int kAlbumIntentRequestCode = 2000;
    final int kFileIntentRequestCode = 3000;

    private ImageView imageView;// = findViewById(R.id.imageView4); //太早取了, 閃退要看Debug那邊
    private SimpleDraweeView simpleDraweeView;
    private FrameLayout frameLayout;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson07);

        imageView = findViewById(R.id.imageView4);
        frameLayout = findViewById(R.id.frame_layout1);

    }

    public void changeAvatar(View view)
    {
        Dialog dialog = new AlertDialog.Builder(this)

            .setTitle("請選擇頭像來源")
            .setPositiveButton("相機", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),kCameraIntentRequestCode);
                }
            })
            .setNegativeButton("相簿", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent,kAlbumIntentRequestCode);
                }
            })
            .setNeutralButton("檔案", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("*/*");
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), kFileIntentRequestCode);
                }
            })
            .create();

        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK || data == null)
        {
            return;
        }

        switch (requestCode)
        {
            case kCameraIntentRequestCode:
            {
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(rotateBitmapByDegree(bitmap, getBitmapDegree(data)));
                break;
            }
            case kAlbumIntentRequestCode:
            case kFileIntentRequestCode:
            {

                ContentResolver contentResolver = this.getContentResolver();
                try
                {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver,data.getData());
                    imageView.setImageBitmap(rotateBitmapByDegree(bitmap, getBitmapDegree(data)));
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }

    private int getBitmapDegree(Intent data) {
        int degree = 0;
        try {

            Uri uri = data.getData();
            InputStream inputStream = getContentResolver().openInputStream(uri);

            // 從指定路徑下讀取圖片，並獲取其EXIF資訊
            ExifInterface exifInterface = new ExifInterface(inputStream);
            // 獲取圖片的旋轉資訊
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,-1);
            Log.d("!!!!", "原度數為: " + orientation);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int degrees) {
        if (degrees == 0 || null == bitmap) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (null != bitmap) {
            bitmap.recycle();
        }
        return bmp;
    }

    public void tryImageViewOnClick(View view)
    {
        changeAvatar(null);
    }
}
