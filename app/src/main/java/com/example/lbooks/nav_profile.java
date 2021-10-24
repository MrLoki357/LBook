package com.example.lbooks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class nav_profile extends Fragment {
    LinearLayout callus,smscare;
    Button logout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_profile, container, false);
        callus=view.findViewById(R.id.sendphone);
        smscare=view.findViewById(R.id.smscare);
        logout=view.findViewById(R.id.logout);
        callus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9445633122"));
                startActivity(intent);
            }
        });
        smscare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:9445633122"));
                intent.putExtra("sms_body","Customer has requested a call");
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}