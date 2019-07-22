package com.example.ui_unit_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author DexMP
 * @version 1.0
 * @see {@link First}
 */
public class Registration extends AppCompatActivity {

    EditText password, email;
    TextView strong_weak;
    FrameLayout mainFrame;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Регистрация");
        //init
        initData();
        password.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable s) {
                strong_weak.setVisibility(View.VISIBLE);
                if (isStrongPassword(password.getText().toString())){
                    strong_weak.setText("Сильный пароль");
                } else if (password.getText().toString() == null){
                    strong_weak.setText("");
                } else {
                    strong_weak.setText("Слабый пароль");
                }

                if (strong_weak.getText().equals("Сильный пароль")){
                    btnNext.setVisibility(View.VISIBLE);
                } else {
                    btnNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
    public static boolean isStrongPassword(String value){
        if (value.length() < 6) return false;
        if (!value.matches(".*[A-Z].*")) return false;
        if (!value.matches(".*[0-9].*")) return false;
        if (!value.matches(".*[a-z].*")) return false;
        if (value.matches(".*[ ].*")) return false;

        return true;
    }

    private void initData() {
        password = findViewById(R.id.password);
        strong_weak = findViewById(R.id.strong_weak);
        mainFrame = findViewById(R.id.mainFrame);
        btnNext = findViewById(R.id.btnNext);
        email = findViewById(R.id.email);
    }
}
