package com.example.a4_8_3_test_2.fragment;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a4_8_3_test_2.R;
import com.example.a4_8_3_test_2.databinding.ActivitySecondFragmentBinding;
import com.example.a4_8_3_test_2.model.Contact;

public class SecondFragment extends Fragment {
    ActivitySecondFragmentBinding binding;
    SecondListner listner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_second_fragment,container,false);
       binding=ActivitySecondFragmentBinding.inflate(getLayoutInflater());
       view=binding.getRoot();
       initViews();
        return view;
    }
    void initViews(){





    }


    public interface SecondListner{

        void onSeconSend(Contact contact);


    }

    public void updateSecondObject(Contact contact){
        binding.rasm.setImageResource(contact.getPhoto());
        binding.ism.setText(contact.getName());
        binding.raqam.setText(contact.getNumber());
        binding.manzil.setText(contact.getManzil());


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SecondListner){
            listner = (SecondListner) context;
        }else {
            throw  new RuntimeException(context.toString()+"Nimadir yuz berdi bu xato!");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }

}
