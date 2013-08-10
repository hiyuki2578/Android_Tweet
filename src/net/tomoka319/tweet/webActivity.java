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
		//���C�A�E�g�Ŏw�肵��WebView��ID���w�肷��B
		WebView  myWebView = (WebView)findViewById(R.id.webView1);		
        	//SNS�̃Z�b�V������ۂ̂ɕK�v�������肵�܂��B
	        myWebView.getSettings().setDomStorageEnabled(true);
		//�����N���^�b�v�����Ƃ��ɕW���u���E�U���N�������Ȃ�
		myWebView.setWebViewClient(new WebViewClient());
		//JavaScript��L����
		myWebView.getSettings().setJavaScriptEnabled(true);
		//�X�N���[���o�[
		myWebView.setVerticalScrollbarOverlay(true);
		//Flash
		myWebView.getSettings().setPluginsEnabled( true );
		//�T�C�Y���킹
        	myWebView.getSettings().setLoadWithOverviewMode(true);
        	myWebView.getSettings().setUseWideViewPort(true);
		//�Y�[��
		myWebView.getSettings().setBuiltInZoomControls(true);
		//�z�[���y�[�W
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