package com.dd.test.Presenter;

import com.dd.test.Model.User;
import com.dd.test.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSuccess = user.isValidData();

        if(isLoginSuccess){
            loginView.onLoginResult("Login Success");
        }
        else
            loginView.onLoginResult("Login error");
    }
}
