package com.example.quanlycongviec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTaCongViec: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTaCongViec = findViewById(R.id.edtMoTaCongViec)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            moManHinhChiTiet()
        }
    }

    private fun moManHinhChiTiet() {
        val congViec = CongViec(
            tenCongViec = edtTenCongViec.text.toString(),
            moTa = edtMoTaCongViec.text.toString()
        )
        val intent = Intent(this, ChiTietCongViecActivity::class.java)
        intent.putExtra(KHOA_CONG_VIEC, congViec)
        startActivity(intent)
    }

    companion object {
        const val KHOA_CONG_VIEC = "cong_viec"
    }
}