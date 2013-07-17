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

        myWebView.setWebChromeClient(new WebChromeClient());
		//UA�ύX
		myWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36 OPR/15.0.1147.141" );	
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