package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTaCongViec: TextView
    private lateinit var tvThongTinCongViec: TextView
    private lateinit var btnChinhSua: Button

    private lateinit var congViec: CongViec

    private val trinhMoChinhSua: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { ketQua ->
            if (ketQua.resultCode == Activity.RESULT_OK) {
                val congViecMoi = ketQua.data?.let {
                    IntentCompat.getParcelableExtra(it, MainActivity.KHOA_CONG_VIEC, CongViec::class.java)
                }
                if (congViecMoi != null) {
                    congViec = congViecMoi
                    hienThiCongViec()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTaCongViec = findViewById(R.id.tvMoTaCongViec)
        tvThongTinCongViec = findViewById(R.id.tvThongTinCongViec)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        congViec = IntentCompat.getParcelableExtra(intent, MainActivity.KHOA_CONG_VIEC, CongViec::class.java)
            ?: CongViec("", "")
        hienThiCongViec()

        btnChinhSua.setOnClickListener {
            val intentChinhSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentChinhSua.putExtra(MainActivity.KHOA_CONG_VIEC, congViec)
            trinhMoChinhSua.launch(intentChinhSua)
        }
    }

    private fun hienThiCongViec() {
        tvTenCongViec.text = congViec.tenCongViec
        tvMoTaCongViec.text = congViec.moTa
        tvThongTinCongViec.text = congViec.layThongTin()
    }
}