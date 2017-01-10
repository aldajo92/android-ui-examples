package com.example.algomez.myuiexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jmedeisis.bugstick.Joystick;
import com.jmedeisis.bugstick.JoystickListener;
import java.util.Locale;

/**
 * Created by algomez on 1/8/17.
 */

public class JoystickActivity extends AppCompatActivity {

  @BindView(R.id.joystick_left) Joystick joystickLeft;
  @BindView(R.id.joystick_right) Joystick joystickRight;
  @BindView(R.id.degree_left_text_view) TextView degreeLeftTextView;
  @BindView(R.id.offset_left_text_view) TextView offsetLeftTextView;
  @BindView(R.id.degree_right_text_view) TextView degreeRightTextView;
  @BindView(R.id.offset_right_text_view) TextView offsetRightTextView;

  @BindString(R.string.degree_text) String degreeTextFormat;
  @BindString(R.string.offset_text) String offsetTextFormat;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joystick);
    ButterKnife.bind(this);

    setOffsetLeftText(0);
    setDegreeLeftText(0);
    joystickLeft.setJoystickListener(new JoystickListener() {
      @Override public void onDown() {

      }

      @Override public void onDrag(float degrees, float offset) {
        setOffsetLeftText(offset);
        setDegreeLeftText(degrees);
      }

      @Override public void onUp() {
        setOffsetLeftText(0);
        setDegreeLeftText(0);
      }
    });

    setOffsetRighttText(0);
    setDegreeRightText(0);
    joystickRight.setJoystickListener(new JoystickListener() {
      @Override public void onDown() {

      }

      @Override public void onDrag(float degrees, float offset) {
        setOffsetRighttText(offset);
        setDegreeRightText(degrees);
      }

      @Override public void onUp() {
        setOffsetRighttText(0);
        setDegreeRightText(0);
      }
    });
  }

  public void setOffsetLeftText(float offsetText){
    String valueFormat = String.format(Locale.US, offsetTextFormat, offsetText);
    offsetLeftTextView.setText(valueFormat);
  }

  public void setDegreeLeftText(float degreeText){
    String valueFormat = String.format(Locale.US, degreeTextFormat, degreeText);
    degreeLeftTextView.setText(valueFormat);
  }

  public void setOffsetRighttText(float offsetText){
    String valueFormat = String.format(Locale.US, offsetTextFormat, offsetText);
    offsetRightTextView.setText(valueFormat);
  }

  public void setDegreeRightText(float degreeText){
    String valueFormat = String.format(Locale.US, degreeTextFormat, degreeText);
    degreeRightTextView.setText(valueFormat);
  }

  public static Intent getIntent(Context context){
    Intent intent = new Intent(context, JoystickActivity.class);
    return intent;
  }
}
