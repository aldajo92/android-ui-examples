package com.example.algomez.myuiexamples;

import android.content.Intent;

/**
 * Created by algomez on 1/9/17.
 */
public class ActivityItems {
  private String name;
  private String description;
  private Intent intent;

  public ActivityItems(String name, String description, Intent intent) {
    this.name = name;
    this.description = description;
    this.intent = intent;
  }

  public Intent getIntent() {
    return intent;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
