package com.example.viewgroups_sharedpref_appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        String fotoMessage = String.valueOf(new Random().nextInt(100));

        TextView fotoText = findViewById(R.id.textView_foto);
        fotoText.setText(fotoMessage);

        findViewById(R.id.button_back).setOnClickListener(buttonsClickListener);
        findViewById(R.id.button_go).setOnClickListener(buttonsClickListener);

    }
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_back :
                    finish();
                    break;
                case R.id.button_go :
                    startNewActivity();
                    break;

            }
        }
    };

    private void startNewActivity(){
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
