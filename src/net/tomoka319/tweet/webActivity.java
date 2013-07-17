package net.tomoka319.tweet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class webActivity extends Activity {

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		//レイアウトで指定したWebViewのIDを指定する。
		WebView  myWebView = (WebView)findViewById(R.id.webView1);		
        //SNSのセッションを保つのに必要だったりします。
        myWebView.getSettings().setDomStorageEnabled(true);
		//リンクをタップしたときに標準ブラウザを起動させない
		myWebView.setWebViewClient(new WebViewClient());
		//JavaScriptを有効化
		myWebView.getSettings().setJavaScriptEnabled(true);
		//スクロールバー
		myWebView.setVerticalScrollbarOverlay(true);
		//Flash
		myWebView.getSettings().setPluginsEnabled( true );
		//サイズ合わせ
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
		//ズーム
		myWebView.getSettings().setBuiltInZoomControls(true);

        myWebView.setWebChromeClient(new WebChromeClient());
		//UA変更
		myWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36 OPR/15.0.1147.141" );	
		//ホームページ
		myWebView.loadUrl("http://www.google.com");}
	@Override
	public boolean onKeyDown( int keyCode, KeyEvent event ) {
		WebView webview = (WebView)findViewById(R.id.webView1);
        if(keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
	}
}