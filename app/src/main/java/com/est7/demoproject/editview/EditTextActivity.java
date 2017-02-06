package com.est7.demoproject.editview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.est7.demoproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditTextActivity extends AppCompatActivity {

    @BindView(R.id.et_editview)
    EditText mEtEditview;
    @BindView(R.id.activity_edit_text)
    RelativeLayout mActivityEditText;
    private InputMethodManager mInputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        mInputMethodManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        mEtEditview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocus) {
                if (!isFocus) {
                    mEtEditview.setHint("mEtEditview");
                } else {
                    mInputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                }
            }
        });
    }

    @OnClick(R.id.et_editview)
    public void onClick() {


    }
}
