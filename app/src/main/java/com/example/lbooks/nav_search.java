package com.example.lbooks;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class nav_search extends Fragment {
    EditText searchbox;
    TextView title,name,phone;
    Button searchbtn;
    ImageView result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nav_search, container, false);
        searchbox=view.findViewById(R.id.bookname);
        searchbtn=view.findViewById(R.id.searchbtn);
        title=view.findViewById(R.id.titletext);
        name=view.findViewById(R.id.found);
        phone=view.findViewById(R.id.phone);
        result=view.findViewById(R.id.resultview);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String book=searchbox.getText().toString();

                if(book.equals("class11")){
                    result.setImageResource(R.drawable.mathsbook1);
                    title.setText("Class 11 Maths");
                    name.setText("Einstein");
                    phone.setText("9442487451");
                }
                else if(book.equals("class7")){
                    result.setImageResource(R.drawable.mathsbook2);
                    title.setText("Class 7 Maths");
                    name.setText("Ramnuja");
                    phone.setText("9552487451");

                }
                else
                {
                    result.setVisibility(View.INVISIBLE);
                    name.setVisibility(view.INVISIBLE);
                    phone.setVisibility(view.INVISIBLE);
                    title.setText("No book found");
                }

            }
        });
        return view;
    }
}