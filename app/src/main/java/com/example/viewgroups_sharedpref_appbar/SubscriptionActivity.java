package com.example.viewgroups_sharedpref_appbar;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class SubscriptionActivity extends AppCompatActivity {

    private EditText nameEdite;
    private EditText emailEdite;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        nameEdite = findViewById(R.id.edit_name);
        emailEdite = findViewById(R.id.edit_email);
        resultText = findViewById(R.id.text_result);

        findViewById(R.id.button_ok).setOnClickListener(okClickListener);
        findViewById(R.id.button_clear).setOnClickListener(clearClickListener);

    }

    private View.OnClickListener okClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = String.valueOf(nameEdite.getText());
            String password = String.valueOf(emailEdite.getText());

            String message = getString(R.string.message_confirmation, name, password);
            resultText.setText(message);

        }


    };
    private View.OnClickListener clearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (emailEdite.getText().length() != 0 || nameEdite.getText().length() != 0) {
                emailEdite.getText().clear();
                nameEdite.getText().clear();
                resultText.setText("");

            }


        }

    };
}
