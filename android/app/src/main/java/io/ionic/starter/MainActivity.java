package io.ionic.starter;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Logger;

public class MainActivity extends BridgeActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.hideBars();
  }
  @Override
  public void onResume(){
    super.onResume();
    this.hideBars();
  }
  @Override
  public void onPause(){
    super.onPause();
    this.hideBars();
  }
  @Override
  public void onWindowFocusChanged(boolean hasFocus)
  {
    super.onWindowFocusChanged(hasFocus);
    this.hideBars();
  }

  private void hideBars() {
    Logger.warn("Version: " + Build.VERSION.SDK_INT + " | " + Build.VERSION_CODES.R);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      getWindow().setDecorFitsSystemWindows(false);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      // On older versions of android setDecorFitsSystemWindows doesn't exist yet, but it can
      // be emulated with flags.
      // It still must be P or greater, as that is the min version for getting the insets
      // through the native plugin.

      getWindow().getDecorView().setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
          View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
          View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
      setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
    } else if (Build.VERSION.SDK_INT >= 19) {
      getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    } else if (Build.VERSION.SDK_INT >= 21) {
      setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
      getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
  }
  private void setWindowFlag(final int bits, boolean on) {
    Window win = getWindow();
    WindowManager.LayoutParams winParams = win.getAttributes();
    if (on) {
      winParams.flags |= bits;
    } else {
      winParams.flags &= ~bits;
    }
    win.setAttributes(winParams);
  }
}
