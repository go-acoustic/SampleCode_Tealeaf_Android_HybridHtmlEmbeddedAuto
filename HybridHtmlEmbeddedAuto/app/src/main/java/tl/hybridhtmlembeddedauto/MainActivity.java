/********************************************************************************************
* Copyright (C) 2022 Acoustic, L.P. All rights reserved.
*
* NOTICE: This file contains material that is confidential and proprietary to
* Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
* industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
* Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
* prohibited.
********************************************************************************************/

package tl.hybridhtmlembeddedauto;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.tl.uic.Tealeaf;


public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createWebView(R.id.myWebView1, "file:///android_asset/mobile_domcap/embeddedGesturesMenu.html");
        createWebView(R.id.myWebView2, "file:///android_asset/mobile_domcap/embeddedGesturesMenu.html");

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        findViewById(R.id.button_dialog).setOnClickListener(view -> {
            // Diaglog contains a webview
            WebDialog noticeDialog = new WebDialog(MainActivity.this);
            noticeDialog.setUrl("file:///android_asset/mobile_domcap/embeddedGesturesMenu.html");
            noticeDialog.show();
        });

        findViewById(R.id.button1).setOnClickListener(view -> {
            finish();
            startActivity(getIntent());
        });

        findViewById(R.id.button2).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void createWebView(final int id, final String url) {
        final MyWebView myWebView = findViewById(id);
        myWebView.clearCache(true);

        WebView.setWebContentsDebuggingEnabled(true);

        // Remove the zuto zoom
        String s = myWebView.getSettings().getUserAgentString();
        myWebView.getSettings().setBuiltInZoomControls(true);
        // Use the API 11+ calls to disable the controls
        // Use a separate class to obtain 1.6 compatibility
        ((Runnable) () -> myWebView.getSettings().setDisplayZoomControls(false)).run();

        // Hook is required in order to setup hybrid bridge
        myWebView.loadUrl(url);
    }

    /* Add touch event to collect gestures for Tealeaf for native controls.
     *
     * (non-Javadoc)
     * @see android.app.Activity#dispatchTouchEvent(android.view.MotionEvent)
     */
    public boolean dispatchTouchEvent(MotionEvent e) {
//        Tealeaf.dispatchTouchEvent(this, e);
        return super.dispatchTouchEvent(e);
    }
}
