package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        findViewById<Button>(R.id.btnLuu).setOnClickListener {
            val ketQua = Intent()
            ketQua.putExtra(MainActivity.KHOA_TEN_CONG_VIEC, edtTenChinhSua.text.toString())
            ketQua.putExtra(MainActivity.KHOA_MO_TA_CONG_VIEC, edtMoTaChinhSua.text.toString())
            setResult(Activity.RESULT_OK, ketQua)
            finish()
        }
    }
}