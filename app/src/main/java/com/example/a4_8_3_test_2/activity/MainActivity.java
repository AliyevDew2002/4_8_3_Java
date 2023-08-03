package com.example.a4_8_3_test_2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.a4_8_3_test_2.R;
import com.example.a4_8_3_test_2.databinding.ActivityMainBinding;
import com.example.a4_8_3_test_2.fragment.FirstFragment;
import com.example.a4_8_3_test_2.fragment.SecondFragment;
import com.example.a4_8_3_test_2.model.Contact;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstListner, SecondFragment.SecondListner {


    ActivityMainBinding binding;
    FirstFragment firstFragment;
    SecondFragment secondFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        initViews();



        }
        void initViews(){


            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.firstFragment,firstFragment)
                    .replace(R.id.secondFragment,secondFragment)
                    .commit();

        }

    @Override
    public void onFisrtSend(Contact contact) {
        secondFragment.updateSecondObject(contact);
    }


    @Override
    public void onSeconSend(Contact contact) {

    }
}
