package com.example.viewgroups_sharedpref_appbar;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.InputType;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initViews();
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageTypePayment = "";
                if (mBankCardChkBx.isChecked())
                    messageTypePayment = mBankCardChkBx.getText().toString();
                if (mMobilePhoneChkBx.isChecked())
                    messageTypePayment = mMobilePhoneChkBx.getText().toString();
                if (mCashAddressChkBx.isChecked())
                    messageTypePayment = mCashAddressChkBx.getText().toString();


                String messageToShow = "Произведена оплата: " + mInputMoney.getText().toString()
                        + " " + messageTypePayment + " "
                        + mInputInfo.getText().toString();
                Toast.makeText(PaymentActivity.this, messageToShow, Toast.LENGTH_LONG).show();

            }
        });
    }


    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

    }

    private void resetCheckBoxes() {
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }


    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        String typePayment = mBankCardChkBx.getText().toString();
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        typePayment = mMobilePhoneChkBx.getText().toString();
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mCashAddressChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        typePayment = mCashAddressChkBx.getText().toString();
                        break;
                    default:
                }
            }
        }
    };


}