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

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTaCongViec: TextView

    // Đặt ở đây: trong class, trước onCreate
    private val trinhMoChinhSua =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { ketQua ->
            if (ketQua.resultCode == Activity.RESULT_OK) {
                val duLieu = ketQua.data
                tvTenCongViec.text = duLieu?.getStringExtra(MainActivity.KHOA_TEN_CONG_VIEC).orEmpty()
                tvMoTaCongViec.text = duLieu?.getStringExtra(MainActivity.KHOA_MO_TA_CONG_VIEC).orEmpty()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTaCongViec = findViewById(R.id.tvMoTaCongViec)

        findViewById<Button>(R.id.btnChinhSua).setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra(MainActivity.KHOA_TEN_CONG_VIEC, tvTenCongViec.text.toString())
            intentChinhSua.putExtra(MainActivity.KHOA_MO_TA_CONG_VIEC, tvMoTaCongViec.text.toString())
            trinhMoChinhSua.launch(intentChinhSua) // dùng ở đây để mở màn hình chỉnh sửa
        }
    }
}