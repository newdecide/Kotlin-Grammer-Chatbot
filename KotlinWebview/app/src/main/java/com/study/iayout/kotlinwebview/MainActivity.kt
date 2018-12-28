package com.study.iayout.kotlinwebview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.naver.com")

        btnnaver.setOnClickListener {
            webView.loadUrl("https://www.naver.com")
        }
        btndaum.setOnClickListener {
            webView.loadUrl("https://www.daum.net")
        }
        btngoogle.setOnClickListener {
            webView.loadUrl("https://www.google.com")
        }

    }
}
