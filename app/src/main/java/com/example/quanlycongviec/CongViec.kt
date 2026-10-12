package com.example.quanlycongviec

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Parcelable
{
    fun layTenTrangThai(): String {
        return if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
    }

    fun layThongTin(): String {
        return "Tên công việc: $tenCongViec\n" +
                "Mô tả: $moTa\n" +
                "Trạng thái: ${layTenTrangThai()}"
    }
}