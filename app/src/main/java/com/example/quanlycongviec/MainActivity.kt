package com.example.quanlycongviec

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val edtTenCongViec = findViewById<EditText>(R.id.edtTenCongViec)
        val edtMoTaCongViec = findViewById<EditText>(R.id.edtMoTaCongViec)
        val btnTaoCongViec = findViewById<Button>(R.id.btnTaoCongViec)

        btnTaoCongViec.setOnClickListener {
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra(KHOA_TEN_CONG_VIEC, edtTenCongViec.text.toString())
            intent.putExtra(KHOA_MO_TA_CONG_VIEC, edtMoTaCongViec.text.toString())
            startActivity(intent)
        }
    }
    companion object {
        const val KHOA_TEN_CONG_VIEC = "ten_cong_viec"
        const val KHOA_MO_TA_CONG_VIEC = "mo_ta_cong_viec"
    }
}