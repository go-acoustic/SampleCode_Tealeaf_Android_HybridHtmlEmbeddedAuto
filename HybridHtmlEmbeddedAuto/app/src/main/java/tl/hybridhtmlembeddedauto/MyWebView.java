/********************************************************************************************
# Copyright (C) 2017 Acoustic, L.P. All rights reserved.
# 
# NOTICE: This file contains material that is confidential and proprietary to
# Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
# industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
# Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
# prohibited.
********************************************************************************************/
package tl.hybridhtmlembeddedauto;

import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import tl.hybridhtmlembeddedauto.MyWebChromeClient;

/**
 * @author ohernandezltmac
 *
 */
public class MyWebView extends WebView {
    /**
     * @param context
     */
    public MyWebView(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("NewApi")
    @Override
    public void loadUrl(final String url) {
        loadUrl(url, null);
    }

    /**
     * {@inheritDoc}
     */
    public final void loadUrl(final String url, final Map<String, String> extraHeaders) {
        super.loadUrl(url, extraHeaders);
    }

    /**
     * Initializes WebView.
     */
    private void init() {
    	this.setWebChromeClient(new MyWebChromeClient());
    }

}
