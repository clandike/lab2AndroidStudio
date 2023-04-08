package com.example.testapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FragmentMainListDirections {
  private FragmentMainListDirections() {
  }

  @NonNull
  public static MainToDescription mainToDescription(@NonNull String imageURL,
      @NonNull String textView) {
    return new MainToDescription(imageURL, textView);
  }

  public static class MainToDescription implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private MainToDescription(@NonNull String imageURL, @NonNull String textView) {
      if (imageURL == null) {
        throw new IllegalArgumentException("Argument \"imageURL\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("imageURL", imageURL);
      if (textView == null) {
        throw new IllegalArgumentException("Argument \"textView\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("textView", textView);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public MainToDescription setImageURL(@NonNull String imageURL) {
      if (imageURL == null) {
        throw new IllegalArgumentException("Argument \"imageURL\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("imageURL", imageURL);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public MainToDescription setTextView(@NonNull String textView) {
      if (textView == null) {
        throw new IllegalArgumentException("Argument \"textView\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("textView", textView);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("imageURL")) {
        String imageURL = (String) arguments.get("imageURL");
        __result.putString("imageURL", imageURL);
      }
      if (arguments.containsKey("textView")) {
        String textView = (String) arguments.get("textView");
        __result.putString("textView", textView);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.mainToDescription;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getImageURL() {
      return (String) arguments.get("imageURL");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getTextView() {
      return (String) arguments.get("textView");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      MainToDescription that = (MainToDescription) object;
      if (arguments.containsKey("imageURL") != that.arguments.containsKey("imageURL")) {
        return false;
      }
      if (getImageURL() != null ? !getImageURL().equals(that.getImageURL()) : that.getImageURL() != null) {
        return false;
      }
      if (arguments.containsKey("textView") != that.arguments.containsKey("textView")) {
        return false;
      }
      if (getTextView() != null ? !getTextView().equals(that.getTextView()) : that.getTextView() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getImageURL() != null ? getImageURL().hashCode() : 0);
      result = 31 * result + (getTextView() != null ? getTextView().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "MainToDescription(actionId=" + getActionId() + "){"
          + "imageURL=" + getImageURL()
          + ", textView=" + getTextView()
          + "}";
    }
  }
}
