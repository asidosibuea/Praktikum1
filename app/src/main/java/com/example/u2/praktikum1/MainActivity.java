package com.example.u2.praktikum1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getHasil(View view){
        try {

        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);
        int idRb = rg.getCheckedRadioButtonId();
        RadioButton selectedRb = (RadioButton) findViewById(idRb);
        String gender = selectedRb.getText().toString();

        TextView tvHasil = (TextView) findViewById(R.id.tv_hasil);
        ImageView emot = (ImageView) findViewById(R.id.img);

        EditText edtBerat = (EditText) findViewById(R.id.et_berat);
        double bb = Double.parseDouble(edtBerat.getText().toString());

        EditText edtTinggi = (EditText) findViewById(R.id.et_tinggi);
        double tb = Double.parseDouble(edtTinggi.getText().toString())/100;

        double bmi = bb/(tb*tb);

        String hasilf = String.format("%.2f", bmi);

        String kategori="";
        if (gender.equals("Male")){
                if (bmi>27){
                    kategori = " dengan kategori obesitas";
                    emot.setBackgroundResource(R.drawable.img_crying);
                    tvHasil.setTextColor(Color.RED);

                } else if (bmi > 23){
                    kategori = " dengan kategori kegemukan";
                    emot.setBackgroundResource(R.drawable.img_crying);
                    tvHasil.setTextColor(Color.RED);
                } else if (bmi>= 17){
                    kategori = " dengan kategori normal";
                    emot.setBackgroundResource(R.drawable.img_ok);
                    tvHasil.setTextColor(Color.GREEN);
                } else {
                    kategori = " dengan kategori kurus";
                }
                emot.setBackgroundResource(R.drawable.img_crying);
                tvHasil.setTextColor(Color.RED);
            }
        else if (gender.equals("Female")){
            if (bmi>27){
                kategori = " dengan kategori obesitas";
                emot.setBackgroundResource(R.drawable.img_crying);
                tvHasil.setTextColor(Color.RED);
            } else if (bmi>= 25){
                kategori = " dengan kategori kegemukan";
                emot.setBackgroundResource(R.drawable.img_crying);
                tvHasil.setTextColor(Color.RED);
            } else if (bmi>= 18){
                kategori = " dengan kategori normal";
                emot.setBackgroundResource(R.drawable.img_ok);
                tvHasil.setTextColor(Color.GREEN);
            } else {
                kategori = " dengan kategori kurus";
                emot.setBackgroundResource(R.drawable.img_crying);
                tvHasil.setTextColor(Color.RED);
            }
        }
        tvHasil.setText("BMI : " +hasilf + kategori);

        InputMethodManager papantombol = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        papantombol.hideSoftInputFromWindow(view.getWindowToken(), 0);

        } catch (Exception e){
            Log.e("Error", String.valueOf(e));
            Toast.makeText(getApplicationContext(),"make sure all the field is not empty", Toast.LENGTH_LONG).show();
        }
    }
}
