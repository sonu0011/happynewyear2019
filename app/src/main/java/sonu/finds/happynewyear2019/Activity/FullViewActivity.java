package sonu.finds.happynewyear2019.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.icu.util.Output;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
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

public class FullViewActivity extends AppCompatActivity {
    GifImageView gifImageView;
    int image,imageboolean,gifboolean;
    ImageView saveimage,shareiamge; File file;
    ProgressDialog progressDialog;
    private static final String TAG = "FullViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gifImageView =findViewById(R.id.fullviewimage);
        image = getIntent().getIntExtra("imagevalue",0);
        imageboolean = getIntent().getIntExtra("imageboolean",0);
        gifboolean = getIntent().getIntExtra("gifboolean",0);
        gifImageView.setImageResource(image);
        saveimage =findViewById(R.id.saveimage);
        shareiamge =findViewById(R.id.shareimage);
        saveimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        Toast.makeText(FullViewActivity.this, "Image  Successfully saved to \n"+name.getAbsolutePath()+"/"+image+".jpeg", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                if (gifboolean == 1){
                    Log.d(TAG, "onClick: gif image");
                    try
                    {
                        File path = Environment.getExternalStorageDirectory();
                        File name = new File(path + "/HNY2019/");
                        if (!name.exists()) {
                            name.mkdirs();
                        }
                        File file = new File(name, String.valueOf(image) + ".gif");
                       // File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "shared_gif_shai" + System.currentTimeMillis() + ".gif");
                        Log.d(TAG, "on do in background, url open connection");

                        InputStream is = getResources().openRawResource(image);
                        Log.d(TAG, "on do in background, url get input stream");
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
                        Toast.makeText(FullViewActivity.this, "GIF  Successfully saved to \n"+name.getAbsolutePath()+"/"+image+".gif", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            
        });
        

        shareiamge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = null;
                bitmap = ((BitmapDrawable)gifImageView.getDrawable()).getBitmap();
//               Uri uri =  Uri.parse("android.resource://sonu.finds.happynewyear2019/drawable/"+R.drawable.chr_gif_1);
//
//                Intent intent =new Intent(Intent.ACTION_SEND);
//                intent.setType("image/*");
//                intent.putExtra(Intent.EXTRA_STREAM,uri);
//               Intent intent1 =  Intent.createChooser(intent,"Share Image");
//               startActivity(intent1);
                if (imageboolean ==2) {
                    file= new File(getExternalCacheDir(), String.valueOf(image) + ".png");
                }
                if (gifboolean == 1){
                     file = new File(getExternalCacheDir(), String.valueOf(image) + ".gif");

                }
                try {
                    FileOutputStream fileOutputStream =new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    file.setReadable(true,true);
                    Intent intent =new Intent(Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(file));
                    intent.setType("image/png");
                    startActivity(Intent.createChooser(intent,"Share Via"));

                } catch (FileNotFoundException e) {
                    Log.d(TAG, "onClick: "+e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onClick: "+e.getMessage());
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
}
