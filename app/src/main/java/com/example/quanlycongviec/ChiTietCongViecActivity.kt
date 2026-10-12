package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChiTietCongViecActivity : AppCompatActivity() {
    private val trinhMoChinhSua =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { ketQua ->
            // xử lý kết quả ở ý 3d
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        findViewById<Button>(R.id.btnChinhSua).setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra(MainActivity.KHOA_TEN_CONG_VIEC, tvTenCongViec.text.toString())
            intentChinhSua.putExtra(MainActivity.KHOA_MO_TA_CONG_VIEC, tvMoTaCongViec.text.toString())
            trinhMoChinhSua.launch(intentChinhSua)
        }
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chi_tiet_cong_viec)
        val tvTenCongViec = findViewById<TextView>(R.id.tvTenCongViec)
        val tvMoTaCongViec = findViewById<TextView>(R.id.tvMoTaCongViec)

        tvTenCongViec.text = intent.getStringExtra(MainActivity.KHOA_TEN_CONG_VIEC).orEmpty()
        tvMoTaCongViec.text = intent.getStringExtra(MainActivity.KHOA_MO_TA_CONG_VIEC).orEmpty()
    }
}