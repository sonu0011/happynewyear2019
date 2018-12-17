package sonu.finds.happynewyear2019.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sonu.finds.happynewyear2019.Adapters.CommonAdapter;
import sonu.finds.happynewyear2019.Models.NewyearModel;
import sonu.finds.happynewyear2019.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChristmasFragment extends Fragment {
    TabLayout tabLayout;
    View view;
    RecyclerView recyclerView;
    List<NewyearModel> list;
    private static final String TAG = "NewYearFragment";
    GridLayoutManager gridLayoutManager;
    CommonAdapter commonAdapter;



    public ChristmasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_christmas, container, false);

        list =new ArrayList();
        gridLayoutManager =new GridLayoutManager(getContext(),2);
        recyclerView =view.findViewById(R.id.newyear_recycleview);
        tabLayout =view.findViewById(R.id.newyear_tablayou);
        IntialLoad();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0){
                    IntialLoad();

                }
                if (tab.getPosition() ==1){
                    LoadGif();
                }


            }

            private void LoadGif() {
                list.clear();
                list.add(new NewyearModel(R.drawable.chr_gif_1));
                list.add(new NewyearModel(R.drawable.chr_gif_2));
                list.add(new NewyearModel(R.drawable.chr_gif_3));
                list.add(new NewyearModel(R.drawable.chr_gif_4));
                list.add(new NewyearModel(R.drawable.chr_gif_5));
                list.add(new NewyearModel(R.drawable.chr_gif_6));
                list.add(new NewyearModel(R.drawable.chr_gif_7));
                list.add(new NewyearModel(R.drawable.chr_gif_8));
                list.add(new NewyearModel(R.drawable.chr_gif_9));
                list.add(new NewyearModel(R.drawable.chr_gif_10));
                list.add(new NewyearModel(R.drawable.chr_gif_11));
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setHorizontalFadingEdgeEnabled(true);
                recyclerView.setHasFixedSize(true);
                commonAdapter =new CommonAdapter(list,getContext(),1);
                recyclerView.setAdapter(commonAdapter);

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return  view;
    }
    private void IntialLoad() {
        list.clear();
        list.add(new NewyearModel(R.drawable.chr_img_1));
        list.add(new NewyearModel(R.drawable.chr_img_2));
        list.add(new NewyearModel(R.drawable.chr_img_3));
        list.add(new NewyearModel(R.drawable.chr_img_4));
        list.add(new NewyearModel(R.drawable.chr_img_5));
        list.add(new NewyearModel(R.drawable.chr_img_6));
        list.add(new NewyearModel(R.drawable.chr_img_7));
        list.add(new NewyearModel(R.drawable.chr_img_8));
        list.add(new NewyearModel(R.drawable.chr_img_9));
        list.add(new NewyearModel(R.drawable.chr_img_10));
        list.add(new NewyearModel(R.drawable.chr_img_11));
        list.add(new NewyearModel(R.drawable.chr_img_12));
        list.add(new NewyearModel(R.drawable.chr_img_13));
        list.add(new NewyearModel(R.drawable.chr_img_14));
        list.add(new NewyearModel(R.drawable.chr_img_15));
        list.add(new NewyearModel(R.drawable.chr_img_16));
        list.add(new NewyearModel(R.drawable.chr_img_17));
        list.add(new NewyearModel(R.drawable.chr_img_18));
        list.add(new NewyearModel(R.drawable.chr_img_19));
        list.add(new NewyearModel(R.drawable.chr_img_20));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHorizontalFadingEdgeEnabled(true);
        recyclerView.setHasFixedSize(true);
        commonAdapter =new CommonAdapter(list,getContext());
        recyclerView.setAdapter(commonAdapter);


    }

}
