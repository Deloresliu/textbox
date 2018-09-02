package com.patient_doctor.textbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        private int MAX_LENGTH = 200; // MAX NUMBER = 200
        private int Rest_Length = MAX_LENGTH;
        private EditText mEdt_view;
        private TextView mTv_num;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mEdt_view = (EditText) findViewById(R.id.edt);
            mTv_num = (TextView) findViewById(R.id.edt_tv_num);
            mEdt_view.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
            setListener();
        }

        private void setListener() {
            mEdt_view.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    // TODO Auto-generated method stub
                    if (Rest_Length > 0) {
                        Rest_Length = MAX_LENGTH - mEdt_view.getText().length();
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    mTv_num.setText(Rest_Length + "/200");
                }

                @Override
                public void afterTextChanged(Editable s) {
                    mTv_num.setText(Rest_Length + "/200");
                }
            });
        }
}
