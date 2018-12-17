package sonu.finds.happynewyear2019.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import sonu.finds.happynewyear2019.Adapters.CommonAdapter;
import sonu.finds.happynewyear2019.Models.NewyearModel;
import sonu.finds.happynewyear2019.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishesFragment extends Fragment {
    TabLayout tabLayout;
    View view;
    RecyclerView recyclerView;
    List<NewyearModel> list;
    private static final String TAG = "NewYearFragment";
    LinearLayoutManager linearLayout;
    CommonAdapter commonAdapter;
    public static final String right="”";
    public static final String left ="“";


    public WishesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quotes, container, false);

        list =new ArrayList();
        linearLayout =new LinearLayoutManager(getContext());
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
                list.add(new NewyearModel("“May the spirit of the season of,\n" +
                        "New year fill your heart,\n" +
                        "with serenity and peace,\n" +
                        "Wish you a happy new year!”\""));
                list.add(new NewyearModel("“You are a unique one in my life\n" +
                        "I will always value you\n" +
                        "Thank you for being a aspect of my life\n" +
                        "Happy New Year 2019”"));
                list.add(new NewyearModel("“Years come, and Years go,\n" +
                        "but our friendship has stood the test of time, " +
                        "wishing you the best in this upcoming year.”"));
                list.add(new NewyearModel("“Wishing you and your family good health, happiness,\n" +
                        "success and prosperity in the coming year!\n" +
                        "Have a great start to a great year!”"));
                list.add(new NewyearModel(left+"New dreams, new hopes, new experiences and new joys: wishing my new love a very Happy New Year." +
                        right));
                list.add(new NewyearModel(left+"All my wishes, all my hopes, all my dreams, and mostly all my love for a Happy New Year."+right));
                list.add(new NewyearModel(left+"Another year has passed, another year has come. I wish for you that, with every year, you achieve all of your dreams. May God pour love and care on you! Happy New Year"+right));
                list.add(new NewyearModel(left+"On the road to success, the rule is to always to look ahead. May you reach your destination, and may your journey be wonderful. Happy New Year 2019."+right));
                list.add(new NewyearModel(left+"Don’t forget the past, learn from it. Happy New Year"+right));
                list.add(new NewyearModel(left+"Cheers to the New Year. May it be a memorable one! Happy New Year."+right));
                list.add(new NewyearModel(left+"It is time to forget the past and celebrate a new beginning. Happy New Year." +
                        right));
                list.add(new NewyearModel(left+"Let go of the past behind you. Right ahead, lies a new beginning. Make it a memorable experience. Happy New Year." +
                        right));
                list.add(new NewyearModel(left+"You are a unique one in my life I will always value you Thank you for being a aspect of my life" +
                        right));
                list.add(new NewyearModel(left+"Write it on your heart that every day is the best in the year. Happy New Year 2019." +
                        right));
                list.add(new NewyearModel(left+"Wish you joy, peace, love, happiness around the world. Let’s Celebrate! Happy New Year." +
                        right));
                list.add(new NewyearModel(left+"Here’s wishing that all your wishes of money, fame and happiness come true this year! Wish you a Happy New Year." +
                        right));
                list.add(new NewyearModel(left+"In this New Year….. may good luck and good fortune always be with you!" +
                        right));
                list.add(new NewyearModel(left+"Happy New Year 2019 To the very special person In my life." +
                        right));
                list.add(new NewyearModel(left+"This wish is for the most special person In the world. Happy New Year 2019." +
                        right));
                list.add(new NewyearModel(left+"My dear! I wish You Happy New Year from the Core of My Heart I hope this year will become a Jolly Year for You I hope Our Love Increase in this Year" +right));

                recyclerView.setLayoutManager(linearLayout);
                recyclerView.setHorizontalFadingEdgeEnabled(true);
                recyclerView.setHasFixedSize(true);
                commonAdapter =new CommonAdapter(list,getContext(),4);
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
        list.add(new NewyearModel(left+"नया साल, नयी उम्मीदें, नए विचार और नयी शुरुवात भगवन करें आपकी हर दुआ हकीकत बन जाये! ― नया साल आपको मुबारक हो!"+right));
        list.add(new NewyearModel(left+"इस रिश्ते को यूँ ही बनाये रखना,\n" +
                "दिल में यादों के चिराग जलाये रखना,\n" +
                "बहुत प्यारा सफर रहा 2018 का…\n" +
                "बस ऐसा ही साथ 2019 में भी बनाये रखना।\n" +
                "नव वर्ष की शुभ कामनाएं..!"+right));
        list.add(new NewyearModel(left+"बीत गया जो साल भूल जाएँ,\n" +
                "इस नए साल को गले लगाएँ,\n" +
                "करते हैं हम दुआ रब से सर झुका के,\n" +
                "इस साल के सारे सपने पूरे हों आपके।\n" +
                "नव वर्ष की हार्दिक शुभकामनाएं!"+right));
        list.add(new NewyearModel(left+"सब गमो को भुला दो, एक नयी शुरुआत करो, नयी उम्मीदों का सागर है चलो अब कुछ अच्छा काम करो.!"+right));
        list.add(new NewyearModel(left+"नया सवेरा एक नई किरण के साथ, नया दिन एक प्यारी मुस्कान के साथ। आपको ये नया साल मुबारक हो मेरी ढेर सारी दुआओं के साथ। नया साल मुबारक हो।"+right));
        list.add(new NewyearModel(left+"पुराना साल सबसे हो रहा है दूर,\n" +
                "क्या करें यही है कुदरत का दस्तूर,\n" +
                "पुरानी यादें सोच कर उदास ना हो तुम,\n" +
                "नया साल आया है चलो,\n" +
                "धूम मचा ले धूम मचा ले धूम।\n" +
                "नव वर्ष की हार्दिक शुभकामनाएं"+right));
        list.add(new NewyearModel(left+"आ गले लग जा मेरे यार दे दू जादू की झप्पी दो,\n" +
                "चार ऐसे ही कट जाये ज़िन्दगी विथौत एनी रिस्क\n" +
                "इस उम्मीद के साथ विश यू अ वैरी हैप्पी न्यू इयर"+right));
        list.add(new NewyearModel(left+"सबके दिलो में हो सबके लिए प्यार\n" +
                "आने वाला हर दिन लाये खुशियों का त्यौहार\n" +
                "इस उम्मीद का साथ आओ भूलके सारे ग़म\n" +
                "न्यू इयर को हम सब करे वेलकम"+right));
        list.add(new NewyearModel(left+"इस नए साल में\n" +
                "जो तू चाहे वो तेरा हो,\n" +
                "हर दिन ख़ूबसूरत और रातें रोशन हो,\n" +
                "कामियाबी चूमते रहे तेरे कदम हमेशा यार,\n" +
                "नया साल मुबारक हो तुझे मेरे यार"+right));
        list.add(new NewyearModel(left+"ना ज़रुरत है चाँद सितारों की ,\n" +
                "ना ज़रूरत है फालतू यारों की ,\n" +
                "एक दोस्त चाहिए आपके जैसा ,\n" +
                "जो watt लगा दे हज़ारों की…\n" +
                "Happy New Year 2019"+right));
        list.add(new NewyearModel(left+"आपकी आँखों में सजे है जो भी सपने,\n" +
                "और दिल में छुपी है जो भी अभिलाषाएं!\n" +
                "यह नया वर्ष उन्हें सच कर जाए;\n" +
                "आप के लिए यही है हमारी शुभकामनायें!"+right));
        list.add(new NewyearModel(left+"हर बार जब भी नया साल आता हैं,\n" +
                "हम दुआ करते हैं कि आपको इस साल भी\n" +
                "वह सब मिले जो आपका दिल चाहता हैं.\n" +
                "नया साल आपको मुबारक हो!"+right));
        list.add(new NewyearModel(left+"नया साल आया बनकर उजाला;\n" +
                "खुल जाए आपकी किस्मत का ताला;\n" +
                "हमेशा आप पर मेहरबान रहे ऊपर वाला;\n" +
                "यही दुआ करता है आपका ये चाहने वाला!\n" +
                "नया साल मुबारक"+right));
        list.add(new NewyearModel(left+"दिन को रात से पहले, चांद को सितारों से पहले.\n" +
                "दिल को धड़कन से पहले और आपको सबसे पहले.\n" +
                "Happy New Year 2019"+right));
        list.add(new NewyearModel(left+"मेरी दुआ हैं कि आपको आने वाले साल में 12 महीने खुशियां मिलें,\n" +
                "52 हफ्ते कामयाबी मिले और 365 दिन मजेदार रहें,\n" +
                "नए साल की ढ़ेर सारी शुभकामनाएं"+right));
        list.add(new NewyearModel(left+"हर साल आता है, हर साल जाता है,\n" +
                "इस नये साल में आपको वो सब मिले;\n" +
                "जो आपका दिल चाहता है,\n" +
                "Happy New Year 2019"+right));
        list.add(new NewyearModel(left+"नये साल की सुबह के साथ\n" +
                "आपकी ज़िन्दगी भी उजालो से भर जाये\n" +
                "ये दुआ करेंगे नया साल आपको और आपके परिवार को मुबारक हो\n" +
                "न्यू ईयर 2019"+right));
        list.add(new NewyearModel(left+"भूल जाओ बीते हुए कल को\n" +
                "दिल में बसालो आने वाले कल को,\n" +
                "मुस्कुराओ चाहे जो बी हो पल,\n" +
                "खुसिया लेकर आयेगा आने वाला कल\n" +
                "नए साल 2019 कि शुभकामनाये ।"+right));
        list.add(new NewyearModel(left+"आपके सारे गम खुशियों में तोल दूँ,\n" +
                "अपने सारे राज़ आपके सामने खोल दूँ\n" +
                "कोई मुझसे पहले न बोल दे,\n" +
                "इसलिए सोचा क्यों न आज ही,\n" +
                "आपको हैप्पी न्यू इयर बोल दूँ!..!!!!"+right));
        list.add(new NewyearModel(left+"गुल ने गुलशन से गुलफाम भेजा है,\n" +
                "सितारो ने आसमान से सलाम भेजा है,\n" +
                "मुबारक हो आपको नया साल,\n" +
                "हम ने ये ADVANCE में ये पैगाम भेजा है!!\n" +
                "नए साल की हार्दिक शुभकामनाएं ।"+right));


                recyclerView.setLayoutManager(linearLayout);
        recyclerView.setHorizontalFadingEdgeEnabled(true);
        recyclerView.setHasFixedSize(true);
        commonAdapter =new CommonAdapter(list,getContext(),4);
        recyclerView.setAdapter(commonAdapter);


    }

}
