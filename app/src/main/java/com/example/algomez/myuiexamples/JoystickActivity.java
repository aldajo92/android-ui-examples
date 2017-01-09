package com.example.algomez.myuiexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by algomez on 1/8/17.
 */

public class JoystickActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joystick);
    ButterKnife.bind(this);
  }

  public static Intent getIntent(Context context){
    Intent intent = new Intent(context, JoystickActivity.class);
    return intent;
  }
}
