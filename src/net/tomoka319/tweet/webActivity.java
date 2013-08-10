package net.tomoka319.tweet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class webActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.web, menu);
      return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_timeline:
            	Intent intent = new Intent (this, MainActivity.class);
            	startActivity(intent);
            	return true;
            case R.id.menu_tweet:
                Intent intent1 = new Intent(this, TweetActivity.class);
                startActivity(intent1);
                return true;
            case R.id.menu_timeline1:
            	Intent intent2 = new Intent (this, MainActivity.class);
            	startActivity(intent2);
            	return true;
            case R.id.menu_tweet1:
            	Intent intent3 = new Intent(this, TweetActivity.class);
            	startActivity(intent3);
            	return true;
        }
        return super.onOptionsItemSelected(item);
    }
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