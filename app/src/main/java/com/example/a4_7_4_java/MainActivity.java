package com.example.a4_7_4_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;

import com.example.a4_7_4_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        initView();
    }
    void initView(){

        binding.edText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Matn o'zgarishidan oldin nima qilish kerakligini ko'rsatadi
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Matn o'zgarishi bo'lganda nima qilish kerakligini ko'rsatadi
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Matn o'zgarishidan so'ng nima qilish kerakligini ko'rsatadi
                // binding.tvText.setText(s.toString());

            }
        });

        binding.edText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction()==KeyEvent.ACTION_UP) {
                    // Enter tugmasi bosilganda nima qilish kerakligini ko'rsatadi
                    show_msg();
                    return true;
                }
                binding.tvText.setText("xayr");
                return false;
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_msg();
            }
        });

    }

    private void show_msg(){
        binding.tvText.setText(binding.edText.getText().toString());
    }
}