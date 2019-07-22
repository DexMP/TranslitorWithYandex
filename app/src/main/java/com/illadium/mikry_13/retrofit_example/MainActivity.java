package com.illadium.mikry_13.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    Button translateBt;
    Call<YaTranslate> translation;
    YandexTranslateInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        translateBt = findViewById(R.id.translateBt);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(YandexTranslateInterface.class);


        translateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");

                String NewText = et.getText().toString();
                if (NewText.contains("a")||NewText.contains("b")||NewText.contains("c")||NewText.contains("d")||NewText.contains("e")||NewText.contains("f")
                        ||NewText.contains("g")||NewText.contains("h")||NewText.contains("i")||NewText.contains("j")||NewText.contains("k")||NewText.contains("l")
                        ||NewText.contains("m")||NewText.contains("n")||NewText.contains("o") ||NewText.contains("p")||NewText.contains("q")||NewText.contains("r")
                        ||NewText.contains("s")||NewText.contains("t")||NewText.contains("u") ||NewText.contains("v")||NewText.contains("w")||NewText.contains("x")
                        ||NewText.contains("y")||NewText.contains("z")){
                    if (NewText != null)
                        setTranslation(et.getText().toString(), "en-ru");
                    else
                        Toast.makeText(MainActivity.this, "Нечего переводить :( ", Toast.LENGTH_LONG).show();
                }

                if (NewText.contains("а")||NewText.contains("б")||NewText.contains("в")||NewText.contains("г")||NewText.contains("д")||NewText.contains("е")
                        ||NewText.contains("ё")||NewText.contains("ж")||NewText.contains("з")||NewText.contains("и")||NewText.contains("й")||NewText.contains("к")
                        ||NewText.contains("л")||NewText.contains("м")||NewText.contains("н")||NewText.contains("о")||NewText.contains("п")||NewText.contains("р")
                        ||NewText.contains("с")||NewText.contains("т")||NewText.contains("у")||NewText.contains("ф")||NewText.contains("х")||NewText.contains("ц")
                        ||NewText.contains("ч")||NewText.contains("ш")||NewText.contains("щ")||NewText.contains("ъ")||NewText.contains("ы")||NewText.contains("ь")
                        ||NewText.contains("э")||NewText.contains("ю")||NewText.contains("я")){
                    if (NewText != null)
                        setTranslation(et.getText().toString(), "ru-en");
                    else
                        Toast.makeText(MainActivity.this, "Нечего переводить :( ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void setTranslation(String TextToTranslate, String TranslateDirection)
    {

        translation = service.translation(TextToTranslate, TranslateDirection);

        translation.enqueue(new Callback<YaTranslate>() {
            @Override
            public void onResponse(Call<YaTranslate> call, Response<YaTranslate> response) {
                YaTranslate translation_ = response.body();

                try {
                    for (String tr : translation_.getText())
                        tv.append(tr);
                }catch (NullPointerException e)
                {
                    tv.setText("Something went wrong, sorry");
                }
            }

            @Override
            public void onFailure(Call<YaTranslate> call, Throwable t) {

            }
        });
    }

}