package com.example.algomez.myuiexamples.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import com.example.algomez.myuiexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DelayedViewActivity extends AppCompatActivity{

    @BindView(R.id.button_delayed_view)
    Button buttonDelayed;

    @BindView(R.id.stub_import)
    ViewStub stubImport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_view);
        ButterKnife.bind(this);

        stubImport.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                System.out.println(inflated);
            }
        });
        new Handler().postDelayed(() -> {
            stubImport.inflate();
        }, 2000);
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, DelayedViewActivity.class);
        return intent;
    }
}
