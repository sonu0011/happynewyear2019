package sonu.finds.happynewyear2019.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
public class ShyariFragment extends Fragment {
    TabLayout tabLayout;
    View view;
    RecyclerView recyclerView;
    List<NewyearModel> list;
    private static final String TAG = "NewYearFragment";
    LinearLayoutManager linearLayout;
    CommonAdapter commonAdapter;
    public static final String right="”";
    public static final String left ="“";


    public ShyariFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shyari, container, false);

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
                list.add(new NewyearModel(left+" Year is neither end or nor beginning But a going on, with all the wisdom that Experience can instill in us, We wish you New Year 2019"+" "+right));
                list.add(new NewyearModel(left+" When you are lonely, I wish you Love When you are down, I wish you Joy When you are troubled I wish you Peace When things seem empty, I wish you Hope With all above wishes, Have A Very Happy New Year 2019 "+" "+right));
                list.add(new NewyearModel(left+" Year is neither end or nor beginning, But a going on, with all the wisdom that, Experience can instill in us, We wish you New Year 2019"+" "+right));
                list.add(new NewyearModel(left+" Oh my Dear, Forget ur Fear, Let all ur Dreams be Clear, Never put Tear, Please Hear, I want to tell one thing in ur Ear Wishing u a very Happy NEW YEAR"+" "+right));
                list.add(new NewyearModel(left+" To End Something Old, Will Start Something New, Wishing You With Mighty Heart, Though The Words Are Very Few"+" "+right));
                list.add(new NewyearModel(left+" May the New Year bring you courage to break, your resolutions early! My own plan is to swear, off every kind of virtue, so that I triumph even when I fall!, Wishing you Happy New Year."+" "+right));
                list.add(new NewyearModel(left+" One Glass Water, One Glass Bear, Oh my dear, Happy New Year. Wishing you Happy New Year."+" "+right));
                list.add(new NewyearModel(left+" Nights are Dark but Days are Light, Wish your Life will always be Bright, So my Dear don’t get Fear, Coz, God Gift us a “BRAND NEW YEAR” HAPPY NEW YEAR 2019"+" "+right));
                list.add(new NewyearModel(left+" Μay smile Νever leave yοur lips, and Α Ηealthy glow stay οn your cheeks, Μay all yοur desires turn Τrue, Τhis is my Νew Year Wish fοr you. Happy New Year "+" "+right));
                list.add(new NewyearModel(left+" Μay light always Βe around yοu, hope Αlways surround yοu. Μay your wοunds fade οut, Ηeart embrace Κindness, love Αnd wisdom"+" "+right));
                list.add(new NewyearModel(left+" New year comes again and again, To spread the spirit and celebration, Have a wonderful New Year party, And Happy New Year with joy and peace"+" "+right));
                list.add(new NewyearModel(left+" When no one is there with me, you are sure to come and hold my hand, when no one is near, you are sitting beside me to comfort me. Lots of lovely kisses and hugs for New Year"+" "+right));
                list.add(new NewyearModel(left+" Before any one wishes you, my new year wishes come to you, to wish you all the happiness of the world, New Year Greetings with tons of love and care."+" "+right));
                list.add(new NewyearModel(left+" Another Fresh New Year Is Here… Another Year To Live! To Banish Worry, Doubt, And Fear, To Love And Laugh And Give!"+" "+right));
                list.add(new NewyearModel(left+" I Would Just Like To Express How Much Joy You Have Given Me, And Wish For Your Joy And Happiness In Return. Happy New Year!"+" "+right));
                list.add(new NewyearModel(left+" As The New Year Approaches Us With New Hopes, Here Is Wishing You And Your Family A Wonderful Year Ahead. Happy New Year."+" "+right));
                list.add(new NewyearModel(left+" Nights are dark but days are light,\n" +
                        "Wish your life will always be bright.\n" +
                        "So my Dear don’t get Fear\n" +
                        "Because,\n" +
                        "God gift us a “Brand New Year”\n" +
                        "\n" +
                        "Happy New Year 2018"+" "+right));
                list.add(new NewyearModel(left+" Don’t think about yesterday,\n" +
                        "Think about tomorrow\n" +
                        "Because tomorrow is a chance to correct\n" +
                        "The mistake of yesterday.\n" +
                        "\n" +
                        "Wishing You 2018 Happy New Year"+" "+right));
                list.add(new NewyearModel(left+" I like to spend my New Years’ eves,\n" +
                        "In solitude, in humble prayer,\n" +
                        "In thanks for each year, as it leaves,\n" +
                        "For one more year of God’s sweet care.\n" +
                        "\n" +
                        "Wishing You Happy New Year \uD83D\uDE42"+" "+right));
                list.add(new NewyearModel(left+" Spread satisfaction, move kilometers, be current at trials May this season provides achievements, Pleasures and wants the better way of way of lifestyle."+" "+right));
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
        list.add(new NewyearModel(left+" फूल खिलेंगे गुलशन में खूबसूरती नज़र आएगी,\n" +
                "बीते साल की खट्टी मीठी यादें संग रह जाएगी,\n" +
                "आओ मिलकर जशन मनाएं नए साल का हँसी ख़ुशी से,\n" +
                "नए साल की पहली सुबह ख़ुशियाँ अनगिनत लाएगी।\n" +
                "नए साल की हार्दिक शुभकामनाएं ।"+" "+right));
        list.add(new NewyearModel(left+" पुराना साल सबसे हो रहा है दूर,\n" +
                "पुराना साल सबसे हो रहा है दूर,\n" +
                "क्या करे यही है कुदरत का दस्तूर,\n" +
                "बीती यादे सोच कर उदास न हो तुम ,\n" +
                "करो खुशियों के साथ नये साल को मंजूर"+" "+right));
        list.add(new NewyearModel(left+" सोचा किसी अपने से बात करे,\n" +
                "सोचा किसी अपने से बात करे,\n" +
                "अपने किसी खास को याद करे!\n" +
                "किया जो फैसला नए साल की शुभकामनाए देने का,\n" +
                "दिल ने कहा क्यों न शुरुआत आप से करे"+" "+right));
        list.add(new NewyearModel(left+" सबके दिलों में हो सबके लिए प्यार;\n" +
                "आने वाला हर दिन लाए खुशियों का त्यौहार,\n" +
                "इस उम्मीद के साथ आओ भूलके सारे गम,\n" +
                "न्यू इयर को हम सब करें वेलकम।\n" +
                "नए साल कि शुभकामनाये ।"+" "+right));
        list.add(new NewyearModel(left+" दुआ मिले बंडो से,\n" +
                "साथ मिले अपनो से,\n" +
                "रहमत मिले रब से,\n" +
                "प्यार मिले सब से,\n" +
                "यही दुआ है मेरी रब से,\n" +
                "के आप खुश रहे सबसे,\n" +
                "\n" +
                "नए साल कि शुभकामनाये "+" "+right));
        list.add(new NewyearModel(left+" हर नया साल आएगा,\n" +
                "हर पुराना साल जाएगा,\n" +
                "पर तेरा यह यार तुझको,\n" +
                "कभी भुला ना पाएगा,\n" +
                "नए साल की शुभकामनाएं ।"+" "+right));
        list.add(new NewyearModel(left+" दोस्त को दोस्ती से पहले,\n" +
                "प्यार को मोहब्बत से पहले,\n" +
                "खुशी को गम से पहले,\n" +
                "और आप को सब्से से पहले,\n" +
                "\n" +
                "― नव वर्ष की हार्दिक शुभकामनायें!"+" "+right));
        list.add(new NewyearModel(left+" सदा दूर रहो ग़म की परछाइयों से,\n" +
                "सामना ना हो कभी तन्हाइयों से,\n" +
                "हर अरमान हर ख़्वाब पूरा हो आपका,\n" +
                "यही दुआ है दिल की गहराइयों से!!\n" +
                "नए साल की हार्दिक शुभकामनाएं ।"+" \uD83D\uDC4C"+right));
        list.add(new NewyearModel(left+" इस नये साल मेी जो तू चाहे वो तेरा हो हर दिन खूबसूरत और रातें रोशन हो कामयाबी चूमती रहे तेरे कदम हमेशा हमेशा यार मुबारक हो तुझे नया साल मेरे दोस्त..!"+" "+right));
        list.add(new NewyearModel(left+" हम आपके दिल में रहते हैं, सारे दर्द आपके सहते हैं, कोई हम से पहले विश न कर दे आपको, इस लिए सबसे पहले हैप्पी न्यू ईयर कहते हैं."+" "+right));
        list.add(new NewyearModel(left +
                "आपकी आँखों मे सजे है जो भी सपने, और दिल मे छुपी है जो भी अभिलाषाएं। यह नव वर्ष उन्हें सच कर जाए , आपके लिए यही है हमारी शुभकामनाएं। नया साल मुबारक़ हो।"+" "+right));
        list.add(new NewyearModel(left+" जब से ये नया साल आया !\n" +
                "जुबा पे तेरा नाम लाया !!\n" +
                "छुपते – छुपते मिलना हैं होता !\n" +
                "मुहब्बत में कैसा मुकाम लाया !!"+" "+right));
        list.add(new NewyearModel(left+" बीत गया जो साल भूल जायें, नए साल को हँस कर गले लगाए, करते है हम रब से दुआ सिर झुका के, इस साल आपके सारे सपने पूरे हो जाये।"+" "+right));
        list.add(new NewyearModel(left+" दिल से निकली ये दुआ है हमारी, ज़िन्दगीं में मिले आपको खुशियां सारी गम ना दे ख़ुदा कभी आपको चाहे कम कर दे खुशियाँ हमारी।"+" "+right));
        list.add(new NewyearModel(left+" नए साल का स्वागत उत्साह के साथ करें क्योंकि ये हमारी गलतियों को सुधारने का एक दूसरा मौका है। नव वर्ष मंगलमय हो।"+" "+right));
        list.add(new NewyearModel(left+" बीत गयी जो साल भूल जाए इन नये साल को गले लगाए करते है.. दुआ हम रब से सर झुकाके इस साल के सारे सपने पूरे हो, आपके नया साल मुबारक हो..Happy New Year"+" "+right));
        list.add(new NewyearModel(left+" मुबारक हो  तुम्हेई नये साल का नया महीना इस साल तुम्हारी दामन खुशियों से भर जाए जो तुम माँगो वो तुम्हे मिल जाए बस ये दुआ है हमारी..! नये साल की हार्दिक शुभकामनायें"+" "+right));
        list.add(new NewyearModel(left+" दुआ है की कामयाबी के हर शिखर पे आप का नाम होगा , आपके हर कदम पर दुनिया का सलाम होगा हिम्मत से मुश्किलों का सामना करना हमारी दुआ है, की वक़्त भी एक दिन आपका गुलाम होगा. नये साल की हार्दिक शुभकामनायें"+" "+right));
        list.add(new NewyearModel(left+" खुदा करे के नया साल आपको रास आ जाएजिसे आप चाहते हो वो आपके पास आ जाये,आप सारा साल कंवारे न रहे.आपका रिश्ता ले कर आपकी सास आ जाए नए साल कि शुभकामनाये ।"+" "+right));
        list.add(new NewyearModel(left+" बीत गया जो साल भूल जाएँ,\n" +
                "इस नए साल को गले लगाएँ,\n" +
                "करते हैं हम दुआ रब से सर झुका के,\n" +
                "इस साल के सारे सपने पूरे हों आपके।\n" +
                "नव वर्ष की हार्दिक शुभकामनाएं!"+" "+right));

        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setHorizontalFadingEdgeEnabled(true);
        recyclerView.setHasFixedSize(true);
        commonAdapter =new CommonAdapter(list,getContext(),4);
        recyclerView.setAdapter(commonAdapter);


    }

}
