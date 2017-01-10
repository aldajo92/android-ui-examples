package com.example.algomez.myuiexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.Locale;

public class PendulumActivity extends AppCompatActivity {

  private final String RUN_VARIABLE = "boolean.isRun";
  private final String TIME_VARIABLE = "float.time";

  @BindView(R.id.activity_main_button) Button mainButton;
  @BindView(R.id.touch_view) PendulumView pendulumView;
  @BindView(R.id.values_fields) TextView valuesField;

  private Runnable runnableCode;
  private Handler handler;

  private float g = 9.8f;
  private float ropeLong = 1f;
  private float frequency = (float) Math.sqrt(g / ropeLong);
  private float degree0 = 0.5f;
  private float time = 0;
  private float degree = 0;

  private boolean isRun = false;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pendulum);
    ButterKnife.bind(this);

    degree = degree0;
    handler = new Handler();
    runnableCode = this::pendulumTask;

    if (null != savedInstanceState) {
      isRun = savedInstanceState.getBoolean(RUN_VARIABLE);
      time = savedInstanceState.getFloat(TIME_VARIABLE);
      printValue(degree);
      pendulumView.setDegrees(degree);
      if (isRun) {
        handler.removeCallbacks(runnableCode);
        handler.post(runnableCode);
      }
    } else {
      pendulumView.setDegrees(degree0);
    }
    pendulumView.invalidate();
  }

  @Override public void onSaveInstanceState(Bundle savedInstanceState) {
    savedInstanceState.putBoolean(RUN_VARIABLE, isRun);
    savedInstanceState.putFloat(TIME_VARIABLE, time);

    super.onSaveInstanceState(savedInstanceState);
  }

  @OnClick(R.id.activity_main_button) public void clearAll() {
    if (!isRun) {
      handler.post(runnableCode);
    } else {
      handler.removeCallbacks(runnableCode);
    }
    isRun = !isRun;
  }

  public void printValue(float value) {
    String valueFormat = String.format(Locale.US, "%.3f", value);
    valuesField.setText(valueFormat);
  }

  public void pendulumTask() {
    time += 0.01;
    degree = (float) (degree0 * Math.cos(frequency * time));
    printValue(degree);
    pendulumView.updateMeasures(degree);
    handler.postDelayed(runnableCode, 10);
  }

  public static Intent getIntent(Context context){
    Intent intent = new Intent(context, PendulumActivity.class);
    return intent;
  }
}