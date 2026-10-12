package com.example.quanlycongviec

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)
        val edtTenChinhSua = findViewById<EditText>(R.id.edtTenChinhSua)
        val edtMoTaChinhSua = findViewById<EditText>(R.id.edtMoTaChinhSua)

        edtTenChinhSua.setText(intent.getStringExtra(MainActivity.KHOA_TEN_CONG_VIEC).orEmpty())
        edtMoTaChinhSua.setText(intent.getStringExtra(MainActivity.KHOA_MO_TA_CONG_VIEC).orEmpty())
    }
}