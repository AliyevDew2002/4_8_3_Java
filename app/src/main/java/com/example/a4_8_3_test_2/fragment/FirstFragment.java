package com.example.a4_8_3_test_2.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.example.a4_8_3_test_2.R;
import com.example.a4_8_3_test_2.activity.MainActivity;
import com.example.a4_8_3_test_2.adapter.Contact_Adapter;
import com.example.a4_8_3_test_2.databinding.ActivityFirstFragmentBinding;
import com.example.a4_8_3_test_2.listner.SelektListener;
import com.example.a4_8_3_test_2.model.Contact;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    FirstListner   listener;
    ActivityFirstFragmentBinding binding;
    Context context;
//14ta odam

    String[] manzil={

            "Farg'ona tumani xonqiz qishlog'i!",
            "Farg'ona tumani oqoltin ko'chasi!",
            "Farg'ona tumani terakzor ko'chasi!",
            "Farg'ona tumani uzumzor ko'chasi!",
            "Farg'ona tumani oqoltin ko'chasi!",
            "Farg'ona tumani xonqiz qishlog'i!",
            "Farg'ona tumani oqoltin ko'chasi!",
            "Farg'ona tumani oqoltin ko'chasi!",
            "Farg'ona tumani qo'rg'ontepa qishlog'i!",
            "Farg'ona tumani oqoltin ko'chasi!",
            "Farg'ona tumani xonqiz qishlog'i!",
            "Farg'ona tumani xonqiz qishlog'i!",
            "Farg'ona tumani xonqiz qishlog'i!",
            "Farg'ona tumani chimyon qishlog'i!"
    };
    String[] name={"Shaxzod","Feyzullo","Muhriddin","Jasur","Usmonali","Ali","Shuhrat","Sodiq","Asilbek","Azizbek","Abdukarim","Sherzod","Mustafo","Rahmon"};
    String[] number={"+99890_583_84_22","+99891_015_45_48","+99891_931_49_73","+99890_732_13_62","+99890_573_16_95","+99890_321_12_32","+99890_594_32_19","+99890_654_98_89","+99891_324_98_54","+99890_457_98_23","+99891_015_48_79","+99890_932_25_19","+99890_762_24_21","99891_066_78_15"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_first_fragment,container,false);
        binding=ActivityFirstFragmentBinding.inflate(getLayoutInflater());
        view=binding.getRoot();
        initViews(view);
        return view;
    }
    void initViews(View view){
        //binding.recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerView);
        refreshAdapter(prepareList());



    }

    public void openItemDetail(Contact contact){
        Log.d("@@@","Bosildi:"+contact.getNumber());

        listener.onFisrtSend(contact);



    }

    private ArrayList<Contact> prepareList(){
        ArrayList<Contact> contacts= new ArrayList<>();
        for (int i=0; i< name.length; i++){
            contacts.add(new Contact(R.drawable.contact,number[i],name[i],manzil[i]));
        }
        return contacts;
    }

    void refreshAdapter(ArrayList<Contact> contacts){
        Contact_Adapter adapter=new Contact_Adapter(this,contacts);
        binding.recyclerView.setAdapter(adapter);


    }



    public interface FirstListner{
        void onFisrtSend(Contact contact);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FirstListner){
            listener=(FirstListner) context;
        }else {
            throw new RuntimeException(context.toString()+"Qandaydir Xato Yuz berdi");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
