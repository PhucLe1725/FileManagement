package com.example.informationform

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mssv: EditText
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var genderGroup: RadioGroup
    private lateinit var phuongXaSpinner: Spinner
    private lateinit var quanHuyenSpinner: Spinner
    private lateinit var tinhThanhSpinner: Spinner
    private lateinit var sportCheckBox: CheckBox
    private lateinit var movieCheckBox: CheckBox
    private lateinit var musicCheckBox: CheckBox
    private lateinit var termsCheckBox: CheckBox
    private lateinit var submitButton: Button
    private lateinit var calendarView: CalendarView
    private lateinit var showCalendarButton: Button
    private lateinit var selectedDateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phuongXaSpinner = findViewById(R.id.phuongXaSpinner)
        quanHuyenSpinner = findViewById(R.id.quanHuyenSpinner)
        tinhThanhSpinner = findViewById(R.id.tinhThanhSpinner)

        val phuongXaOptions = arrayOf("Phường 1", "Phường 2", "Phường 3")
        val quanHuyenOptions = arrayOf("Quận 1", "Quận 2", "Quận 3")
        val tinhThanhOptions = arrayOf("TPHCM", "Hà Nội", "Đà Nẵng")

        phuongXaSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, phuongXaOptions)
        quanHuyenSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, quanHuyenOptions)
        tinhThanhSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tinhThanhOptions)

        mssv = findViewById(R.id.MSSV)
        name = findViewById(R.id.Name)
        email = findViewById(R.id.Email)
        phoneNumber = findViewById(R.id.PhoneNumber)
        genderGroup = findViewById(R.id.genderGroup)
        calendarView = findViewById(R.id.calendarView)
        phuongXaSpinner = findViewById(R.id.phuongXaSpinner)
        quanHuyenSpinner = findViewById(R.id.quanHuyenSpinner)
        tinhThanhSpinner = findViewById(R.id.tinhThanhSpinner)
        sportCheckBox = findViewById(R.id.sportCheckBox)
        movieCheckBox = findViewById(R.id.movieCheckBox)
        musicCheckBox = findViewById(R.id.musicCheckBox)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        submitButton = findViewById(R.id.submitButton)

        calendarView = findViewById(R.id.calendarView)
        showCalendarButton = findViewById(R.id.showCalendarButton)
        selectedDateText = findViewById(R.id.selectedDateText)

        showCalendarButton.setOnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Thiết lập ngày đã chọn
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            selectedDateText.text = "Ngày sinh: $selectedDate"

            // Ẩn CalendarView sau khi chọn xong
            calendarView.visibility = View.GONE
        }

        submitButton.setOnClickListener {
            if (isFormValid()) {
                Toast.makeText(this, "Thông tin đã được gửi thành công!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isFormValid(): Boolean {
        if (mssv.text.isEmpty()) {
            mssv.error = "Vui lòng nhập MSSV"
            return false
        }
        if (name.text.isEmpty()) {
            name.error = "Vui lòng nhập họ tên"
            return false
        }
        if (email.text.isEmpty()) {
            email.error = "Vui lòng nhập email"
            return false
        }
        if (phoneNumber.text.isEmpty()) {
            phoneNumber.error = "Vui lòng nhập số điện thoại"
            return false
        }
        if (genderGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show()
            return false
        }
        if (selectedDateText.text === "Chưa chọn ngày sinh") {
            Toast.makeText(this, "Vui lòng chọn ngày sinh", Toast.LENGTH_SHORT).show()
            return false
        }
        if (phuongXaSpinner.selectedItem == null) {
            Toast.makeText(this, "Vui lòng chọn Phường/Xã", Toast.LENGTH_SHORT).show()
            return false
        }
        if (quanHuyenSpinner.selectedItem == null) {
            Toast.makeText(this, "Vui lòng chọn Quận/Huyện", Toast.LENGTH_SHORT).show()
            return false
        }
        if (tinhThanhSpinner.selectedItem == null) {
            Toast.makeText(this, "Vui lòng chọn Tỉnh/Thành", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!termsCheckBox.isChecked) {
            Toast.makeText(this, "Vui lòng đồng ý với các điều khoản", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
