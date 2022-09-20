package com.example.devendra.fieldez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.devendra.fieldez.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        addStyleToTermsText();
    }

    private void addStyleToTermsText() {
        mBinding.textViewTerms.setText(Html.fromHtml("App usage policy will be as per FieldEZ's <b><font color='#FF9800'>Terms of Services</font></b>"));
    }


    public void doLogin(View view) {
        if (validateFields()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }

    private boolean validateFields() {
        if (TextUtils.isEmpty(mBinding.editTextUserName.getText().toString().trim())) {
            showMessage("Please enter user name");
            return false;
        }
        if (!mBinding.editTextUserName.getText().toString().trim().equals("fzuser")) {
            showMessage("Please enter correct user name");
            return false;
        }
        if (TextUtils.isEmpty(mBinding.editTextPassword.getText().toString().trim())) {
            showMessage("Please enter password");
            return false;
        }
        if (!mBinding.editTextPassword.getText().toString().trim().equals("test123")) {
            showMessage("Please enter correct password");
            return false;
        }
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}