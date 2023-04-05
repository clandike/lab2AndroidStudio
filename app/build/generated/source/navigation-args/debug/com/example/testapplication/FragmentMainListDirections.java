package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class FragmentMainListDirections {
  private FragmentMainListDirections() {
  }

  @NonNull
  public static NavDirections mainToDescription() {
    return new ActionOnlyNavDirections(R.id.mainToDescription);
  }
}
