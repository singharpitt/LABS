package com.example.sharedpreference_comp_201b049;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    String[]winnerArray={"Ankur","srivastava","Rocks"};
    public  void storepreference(View view)
    {
        sharedPreferences.edit().putString("players",new Gson().toJson(winnerArray)).apply();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        sharedPreferences=this.getSharedPreferences("com.example.sharedpreference_comp_201b049", Context.MODE_PRIVATE);
        String[] temp=new Gson().fromJson(sharedPreferences.getString("players",null),winnerArray.getClass());
        textView.setText(Arrays.toString(temp));
    }
}