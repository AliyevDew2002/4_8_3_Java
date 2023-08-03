package com.example.a4_8_3_test_2.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4_8_3_test_2.databinding.ActivityMainBinding;
import com.example.a4_8_3_test_2.databinding.ContactQolipBinding;
import com.example.a4_8_3_test_2.fragment.FirstFragment;
import com.example.a4_8_3_test_2.listner.SelektListener;
import com.example.a4_8_3_test_2.model.Contact;

import java.util.ArrayList;

public class Contact_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Contact> contact;
    ContactQolipBinding binding;
    SelektListener listener;
    FirstFragment fragmet;

    public Contact_Adapter(FirstFragment fragmet, ArrayList<Contact> contact){
        this.contact=contact;
        this.fragmet=fragmet;
        this.listener=listener;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ContactQolipBinding binding = ContactQolipBinding.inflate(layoutInflater);
        return new CustomViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact1=contact.get(position);

        if (holder instanceof CustomViewHolder){

            ImageView photo=((CustomViewHolder) holder).binding.ivPhoto;
            TextView name=((CustomViewHolder) holder).binding.tvName;


            photo.setImageResource(contact1.getPhoto());
            name.setText(contact1.getName());
            LinearLayout linearLayout=((CustomViewHolder) holder).binding.linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmet.openItemDetail(contact.get(position));
                }
            });
         }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private final ContactQolipBinding binding;

        public CustomViewHolder(ContactQolipBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @Override
    public int getItemCount() {
       return contact.size();
    }
}
