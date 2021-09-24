package tl.hybridhtmlembeddedauto;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.NonNull;

public class WebDialog extends Dialog {

    private static final String TAG = WebDialog.class.getSimpleName();

    private WebView mWebnotiView;

    private String mUrl;

    private Context mContext;

    public WebDialog(@NonNull Context context) {
        super(context, R.style.FullscreenDialog);
        mContext = context;
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    @JavascriptInterface
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_web_notice);

        mWebnotiView = findViewById(R.id.web_view_dialog);
        Button dialogButton = (Button) findViewById(R.id.btnClose);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebDialog.this.dismiss();
            }
        });

        String path = mUrl;
        if (path != null) {
            loadUrl(path);
        }
    }

    private void loadUrl(String url) {
        if (mWebnotiView == null) {
            return;
        }

        mWebnotiView.post(() -> {
            if (mWebnotiView != null) {
                mWebnotiView.loadUrl(url);
            }
        });
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
