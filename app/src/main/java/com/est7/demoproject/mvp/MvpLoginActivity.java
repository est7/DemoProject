package com.est7.demoproject.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.est7.demoproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MvpLoginActivity extends AppCompatActivity implements LoginContract.ILoginView {

    @BindView(R.id.email)
    AutoCompleteTextView mEmail;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @BindView(R.id.clear)
    Button mClear;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    private LoginPresenterCompl mLoginPresenterCompl;

    /* @Inject
     LoginPresenterCompl loginPresenter;
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_login);
        ButterKnife.bind(this);
        //initDI();
        mLoginPresenterCompl = new LoginPresenterCompl(this);
    }

    private void initDI() {
        // DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);

    }


    @OnClick(R.id.email_sign_in_button)
    @Override
    public void doLogin() {
        mLoginPresenterCompl.doLogin(mEmail.getText().toString(), mPassword.getText().toString());

        mLoginPresenterCompl.setProgressBarVisiblity(VISIBLE);

    }

    @OnClick(R.id.clear)
    @Override
    public void onClearText() {
        mEmail.setText("");
        mPassword.setText("");
        mLoginPresenterCompl.clear();
    }


    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mProgressBar.setVisibility(visibility);
    }

    @Override
    public void showLoginSuccessToast(String userInfo) {
        mLoginPresenterCompl.setProgressBarVisiblity(INVISIBLE);

        Toast.makeText(this, userInfo, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailed() {
        mLoginPresenterCompl.setProgressBarVisiblity(INVISIBLE);

        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }
}

