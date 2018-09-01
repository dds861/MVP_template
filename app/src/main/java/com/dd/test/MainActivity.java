package com.dd.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.test.Presenter.ILoginPresenter;
import com.dd.test.Presenter.LoginPresenter;
import com.dd.test.View.ILoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private EditText mEmailEdt;
    private EditText mPasswordEdt;
    private Button mLoginBtn;
    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEmailEdt = (EditText) findViewById(R.id.edt_email);
        mPasswordEdt = (EditText) findViewById(R.id.edt_password);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mLoginBtn.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // TODO 18/09/01
                loginPresenter.onLogin(mEmailEdt.getText().toString(),mPasswordEdt.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}