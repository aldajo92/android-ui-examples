package com.example.algomez.myuiexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jmedeisis.bugstick.Joystick;
import com.jmedeisis.bugstick.JoystickListener;
import java.util.Locale;

/**
 * Created by algomez on 1/8/17.
 */

public class JoystickActivity extends AppCompatActivity {

  @BindView(R.id.joystick) Joystick joystick;
  @BindView(R.id.degree_text_view) TextView degreeTextView;
  @BindView(R.id.offset_text_view) TextView offsetTextView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joystick);
    ButterKnife.bind(this);

    joystick.setJoystickListener(new JoystickListener() {
      @Override public void onDown() {

      }

      @Override public void onDrag(float degrees, float offset) {
        setOffsetText(offset);
        setDegreeText(degrees);
      }

      @Override public void onUp() {
        setOffsetText(0);
        setDegreeText(0);
      }
    });
  }

  public void setOffsetText(float offsetText){
    String valueFormat = String.format(Locale.US, "%.3f", offsetText);
    offsetTextView.setText(valueFormat);
  }

  public void setDegreeText(float degreeText){
    String valueFormat = String.format(Locale.US, "%.3f", degreeText);
    degreeTextView.setText(valueFormat);
  }

  public static Intent getIntent(Context context){
    Intent intent = new Intent(context, JoystickActivity.class);
    return intent;
  }
}
