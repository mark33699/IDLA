package com.example.idla.Lesson07;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.idla.BaseActivity;
import com.example.idla.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.FileNotFoundException;
import java.io.IOException;

//import androidx.exifinterface.media.ExifInterface; //會FileNotFoundException
//import android.support.media.ExifInterface //有這東東嗎？

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

//        Fresco.initialize(this);
//        simpleDraweeView = new SimpleDraweeView(this); //直接閃退...
//        simpleDraweeView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
//        simpleDraweeView.setBackgroundColor(getResources().getColor(R.color.green));
//        frameLayout.addView(simpleDraweeView);
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
                imageView.setImageBitmap(bitmap);
                break;
            }
            case kAlbumIntentRequestCode:
            case kFileIntentRequestCode:
            {

                ContentResolver contentResolver = this.getContentResolver();
                try
                {
                    //要API28以上, 不然會閃
//                    ImageDecoder.Source source = ImageDecoder.createSource(contentResolver,data.getData());
//                    Bitmap bmp = ImageDecoder.decodeBitmap(source);

//                    Bitmap bmp = MediaStore.Images.Media.getBitmap(contentResolver,data.getData());

//                    imageView.setImageBitmap(bmp);
//                    imageView.setImageBitmap(rotateBitmapByDegree(bmp,getBitmapDegree(data.getData().getPath())));
//                    simpleDraweeView.setImageURI(data.getData());

                    selectedImagePath = getRealPathFromURIPath(data.getData(), this);
                    Bitmap bmp = MediaStore.Images.Media.getBitmap(contentResolver,data.getData());
                    imageView.setImageBitmap(rotateBitmapByDegree(bmp,getBitmapDegree(selectedImagePath)));
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
        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity)
    {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null)
        {
            return contentURI.getPath();
        }
        else
            {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

//    private Bitmap getRotatedBitmap(Bitmap originBitmap)
//    {
//        try
//        {
//            ExifInterface exifInterface = new ExifInterface(String.valueOf(originBitmap));
//            int intOrientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL);
//            switch (intOrientation)
//            {
//                case
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }

    private int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 從指定路徑下讀取圖片，並獲取其EXIF資訊
            ExifInterface exifInterface = new ExifInterface(path);
            // 獲取圖片的旋轉資訊
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,-1);
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_DATETIME) + "");
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_MAKE) + "");
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_MODEL) + "");
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP) + "");
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_Y_RESOLUTION) + "");
            Log.d("MF",exifInterface.getAttribute(ExifInterface.TAG_COLOR_SPACE) + "");
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
//        Bitmap returnBm = null;
//
//        // 根據旋轉角度，生成旋轉矩陣
//        Matrix matrix = new Matrix();
//        matrix.postRotate(degree);
//        try {
//            // 將原始圖片按照旋轉矩陣進行旋轉，並得到新的圖片
//            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
//        } catch (OutOfMemoryError e) {
//        }
//        if (returnBm == null) {
//            returnBm = bm;
//        }
//        if (bm != returnBm) {
//            bm.recycle();
//        }
//        return returnBm;
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
}
