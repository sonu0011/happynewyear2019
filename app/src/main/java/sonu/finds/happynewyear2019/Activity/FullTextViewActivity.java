package sonu.finds.happynewyear2019.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import sonu.finds.happynewyear2019.R;

public class FullTextViewActivity extends AppCompatActivity {
    TextView fulltextview;
    ImageView copytext,sharetext;
    String intenttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_text_view);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colortext)));


        fulltextview =findViewById(R.id.setfulltext);
        copytext =findViewById(R.id.copytext);
        sharetext =findViewById(R.id.sharetext);
        intenttext =getIntent().getStringExtra("fulltext");
        fulltextview.setText(intenttext);
        copytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", intenttext);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(FullTextViewActivity.this, "Text Copied to Clipboard", Toast.LENGTH_SHORT).show();

            }
        });
        sharetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,intenttext);
                startActivity(Intent.createChooser(intent,"Share Using.."));

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
