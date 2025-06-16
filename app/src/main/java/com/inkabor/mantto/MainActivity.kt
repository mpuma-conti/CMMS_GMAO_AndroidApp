package com.inkabor.mantto;

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.inkabor.mantto.R
import android.os.Build
import android.view.View
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Animación de entrada
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        setContentView(R.layout.activity_main)

        // Oculta la barra de estado (notificaciones)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(android.view.WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }



        val webView = findViewById<WebView>(R.id.webview)
        // Configuraciones necesarias
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.allowContentAccess = true
        webSettings.allowFileAccess = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.setSupportZoom(true)

        // Esto evita que los enlaces se abran fuera del WebView
        webView.webViewClient = WebViewClient()

// Cargar URL
        webView.loadUrl("https://save-boxing-disciplines-apparently.trycloudflare.com")
    }

    override fun finish() {
        super.finish()
        // Animación de salida
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    }
}