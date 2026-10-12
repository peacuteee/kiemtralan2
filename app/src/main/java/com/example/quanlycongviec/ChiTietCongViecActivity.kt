package com.example.quanlycongviec

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chi_tiet_cong_viec)
        val tvTenCongViec = findViewById<TextView>(R.id.tvTenCongViec)
        val tvMoTaCongViec = findViewById<TextView>(R.id.tvMoTaCongViec)

        tvTenCongViec.text = intent.getStringExtra(MainActivity.KHOA_TEN_CONG_VIEC).orEmpty()
        tvMoTaCongViec.text = intent.getStringExtra(MainActivity.KHOA_MO_TA_CONG_VIEC).orEmpty()
    }
}