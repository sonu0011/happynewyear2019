package sonu.finds.happynewyear2019.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import sonu.finds.happynewyear2019.Activity.FullImageViewActivity;
import sonu.finds.happynewyear2019.Activity.FullTextViewActivity;
import sonu.finds.happynewyear2019.Models.NewyearModel;
import sonu.finds.happynewyear2019.R;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {
    List<NewyearModel> list;
    Context context;
    int i=0;


    public CommonAdapter(List<NewyearModel> list, Context context, int i) {
        this.list = list;
        this.context = context;
        this.i = i;
    }

    public CommonAdapter(List<NewyearModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (i == 1) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.giflayout, parent, false));


        }
       else if (i==4){
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.textlayout, parent, false));

        }
        else {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewyearModel model = list.get(position);
        if (i == 1) {
            holder.gifImageView.setImageResource(model.getImage());

        }
        if (i==4){
            holder.textView.setText(model.getText());

        }
        if (i==0){
            holder.imageView.setImageResource(model.getImage());

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        GifImageView gifImageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (i==4){
                textView =itemView.findViewById(R.id.text);
            }
            if (i==1){
                gifImageView =itemView.findViewById(R.id.gifmodel);
            }
            if (i == 0){
                imageView = itemView.findViewById(R.id.imagemodel);

            }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1) {
                    int imageid = list.get(getAdapterPosition()).getImage();
                    Intent intent = new Intent(context, FullImageViewActivity.class);
                    intent.putExtra("gifboolean",1);
                    intent.putExtra("imagevalue", imageid);
                    context.startActivity(intent);
                }
                if (i == 4){
                    Intent intent = new Intent(context, FullTextViewActivity.class);
                    intent.putExtra("fulltext", list.get(getAdapterPosition()).getText());
                    context.startActivity(intent);
                }
                else {
                    int imageid = list.get(getAdapterPosition()).getImage();
                    Intent intent = new Intent(context, FullImageViewActivity.class);
                    intent.putExtra("imageboolean",2);
                    intent.putExtra("imagevalue", imageid);
                    context.startActivity(intent);

                }
            }
        });
        }


    }
}
