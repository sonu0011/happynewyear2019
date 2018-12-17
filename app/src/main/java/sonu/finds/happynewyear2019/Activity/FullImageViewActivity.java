package sonu.finds.happynewyear2019.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import pl.droidsonroids.gif.GifImageView;
import sonu.finds.happynewyear2019.R;

public class FullImageViewActivity extends AppCompatActivity {
    GifImageView gifImageView;
    int image, imageboolean, gifboolean;
    ImageView saveimage, shareiamge;
    File file;
    private static final String TAG = "FullImageViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gifImageView = findViewById(R.id.fullviewimage);
        image = getIntent().getIntExtra("imagevalue", 0);
        imageboolean = getIntent().getIntExtra("imageboolean", 0);
        gifboolean = getIntent().getIntExtra("gifboolean", 0);
        gifImageView.setImageResource(image);
        saveimage = findViewById(R.id.saveimage);
        shareiamge = findViewById(R.id.shareimage);
        saveimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        //do work
                        saveImage();
                    }
                    else {
                        ActivityCompat.requestPermissions(FullImageViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    }
                }
                else {
                    saveImage();

                }

            }

        });


        shareiamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageboolean == 2) {
                    Bitmap bitmap = null;
                    bitmap = ((BitmapDrawable) gifImageView.getDrawable()).getBitmap();
                    file = new File(getExternalCacheDir(), String.valueOf(image) + ".png");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        file.setReadable(true, true);
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                        intent.setType("image/png");
                        startActivity(Intent.createChooser(intent, "Share Via"));

                    } catch (FileNotFoundException e) {
                        Log.d(TAG, "onClick: " + e.getMessage());
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.d(TAG, "onClick: " + e.getMessage());
                    }


                }
                if (gifboolean == 1) {
                    try {


                        File file1 = new File(getExternalCacheDir(), String.valueOf(image) + ".gif");
                        InputStream is = getResources().openRawResource(image);
                        BufferedInputStream bis = new BufferedInputStream(is);
                        Log.d(TAG, "on do in background, create buffered input stream");

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        Log.d(TAG, "on do in background, create buffered array output stream");

                        int current = 0;

                        Log.d(TAG, "on do in background, write byte to baos");
                        while ((current = bis.read()) != -1) {
                            baos.write(current);
                        }
                        FileOutputStream fos = new FileOutputStream(file1);
                        fos.write(baos.toByteArray());

                        Log.d(TAG, "on do in background, write to fos");
                        fos.flush();

                        fos.close();
                        is.close();
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file1));
                        intent.setType("image/gif");
                        startActivity(Intent.createChooser(intent, "Share Gif Via"));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    void saveImage(){
        if (imageboolean == 2) {
            //for simple images
            Log.d(TAG, "onClick:  simpleimage");

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image);
            File path = Environment.getExternalStorageDirectory();
            File name = new File(path + "/HNY2019/");
            if (!name.exists()) {
                name.mkdirs();
            }
            File filenmae = new File(name, String.valueOf(image) + ".jpeg");
            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(filenmae);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                Toast.makeText(FullImageViewActivity.this, "Image  Successfully saved to \n" + name.getAbsolutePath() + "/" + image + ".jpeg", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        if (gifboolean == 1) {
            Log.d(TAG, "onClick: gif image");
            try {
                File path = Environment.getExternalStorageDirectory();
                File name = new File(path + "/HNY2019/");
                if (!name.exists()) {
                    name.mkdirs();
                }
                File file = new File(name, String.valueOf(image) + ".gif");
                // File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "shared_gif_shai" + System.currentTimeMillis() + ".gif");
                InputStream is = getResources().openRawResource(image);
                BufferedInputStream bis = new BufferedInputStream(is);
                Log.d(TAG, "on do in background, create buffered input stream");

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                Log.d(TAG, "on do in background, create buffered array output stream");
                int current = 0;

                Log.d(TAG, "on do in background, write byte to baos");
                while ((current = bis.read()) != -1) {
                    baos.write(current);
                }


                Log.d(TAG, "on do in background, done write");

                Log.d(TAG, "on do in background, create fos");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(baos.toByteArray());

                Log.d(TAG, "on do in background, write to fos");
                fos.flush();

                fos.close();
                is.close();
                Log.d(TAG, "on do in background, done write to fos");
                Toast.makeText(FullImageViewActivity.this, "GIF  Successfully saved to \n" + name.getAbsolutePath() + "/" + image + ".gif", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
           saveImage();
            //resume tasks needing this permission
        }
        else if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(this, "Please give us storage permission to perform this action", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri =Uri.fromParts("package",getPackageName(),null);
            intent.setData(uri);
            startActivityForResult(intent, 123);
        }
        else {
            ActivityCompat.requestPermissions(FullImageViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==123){
            if (data == null){

               // ActivityCompat.requestPermissions(FullImageViewActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            File dir = getExternalCacheDir();
           boolean b = deleteDir(dir);
            Log.d(TAG, "onDestroy: "+b);
        } catch (Exception ignored) {}
    }
    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}
