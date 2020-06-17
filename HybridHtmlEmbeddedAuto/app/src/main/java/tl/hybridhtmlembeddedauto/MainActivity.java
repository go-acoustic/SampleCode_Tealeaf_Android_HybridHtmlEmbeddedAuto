/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2016
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/

package tl.hybridhtmlembeddedauto;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;

import androidx.appcompat.app.AppCompatActivity;

import com.ibm.eo.util.LogInternal;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createWebView(R.id.myWebView1, "file:///android_asset/mobile_domcap/embeddedGesturesMenu.html");
        createWebView(R.id.myWebView2, "file:///android_asset/mobile_domcap/embeddedGesturesMenu.html");

        if (VERSION.SDK_INT >= VERSION_CODES.HONEYCOMB) {
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void createWebView(final int id, final String url) {
        final MyWebView myWebView = (MyWebView) findViewById(id);
        myWebView.clearCache(true);

        if (VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        // Remove the zuto zoom
        String s = myWebView.getSettings().getUserAgentString();
        myWebView.getSettings().setBuiltInZoomControls(true);
        if (VERSION.SDK_INT >= VERSION_CODES.HONEYCOMB) {
            // Use the API 11+ calls to disable the controls
            // Use a separate class to obtain 1.6 compatibility
            new Runnable() {
                public void run() {
                    myWebView.getSettings().setDisplayZoomControls(false);
                }
            }.run();
        } else {
            try {
                Method zoomMethod = myWebView.getClass().getMethod("getZoomButtonsController");
                if (zoomMethod != null) {
                    Object[] value = null;
                    final ZoomButtonsController zoom_controll = (ZoomButtonsController) zoomMethod.invoke(myWebView, value);
                    zoom_controll.getContainer().setVisibility(View.GONE);
                }
            } catch (Exception e) {
                LogInternal.logException("HybridHTMLEmbedded", e);
            }
        }

        // Hook is required by AspectJ in order to setup hybrid bridge
        myWebView.loadUrl(url);
    }

    /* Add touch event to collect gestures for Tealeaf.
     *
     * (non-Javadoc)
     * @see android.app.Activity#dispatchTouchEvent(android.view.MotionEvent)
     */
    public boolean dispatchTouchEvent(MotionEvent e) {
        return super.dispatchTouchEvent(e);
    }
}
