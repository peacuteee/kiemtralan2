package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTenChinhSua: EditText
    private lateinit var edtMoTaChinhSua: EditText
    private lateinit var btnLuu: Button

    private lateinit var congViec: CongViec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTenChinhSua = findViewById(R.id.edtTenChinhSua)
        edtMoTaChinhSua = findViewById(R.id.edtMoTaChinhSua)
        btnLuu = findViewById(R.id.btnLuu)

        congViec = IntentCompat.getParcelableExtra(intent, MainActivity.KHOA_CONG_VIEC, CongViec::class.java)
            ?: CongViec("", "")

        edtTenChinhSua.setText(congViec.tenCongViec)
        edtMoTaChinhSua.setText(congViec.moTa)

        btnLuu.setOnClickListener {
            luuVaTraKetQua()
        }
    }

    private fun luuVaTraKetQua() {
        congViec.tenCongViec = edtTenChinhSua.text.toString()
        congViec.moTa = edtMoTaChinhSua.text.toString()

        val ketQua = Intent()
        ketQua.putExtra(MainActivity.KHOA_CONG_VIEC, congViec)
        setResult(Activity.RESULT_OK, ketQua)
        finish()
    }
}