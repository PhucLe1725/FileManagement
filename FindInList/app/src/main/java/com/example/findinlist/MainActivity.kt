package com.example.findinlist
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: List<Student>
    private lateinit var searchEditText: EditText
    private lateinit var studentRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        studentRecyclerView = findViewById(R.id.studentRecyclerView)

        studentList = listOf(
            Student("Nguyen Van An", "20129834"),
            Student("Le Thi Binh", "20237429"),
            Student("Tran Van Cuong", "20342389"),
            Student("Pham Minh Duy", "20451278"),
            Student("Nguyen Thi Huong", "20223765"),
            Student("Le Hoang Kim", "20316492"),
            Student("Dang Van Long", "20429387"),
            Student("Phan Minh Quan", "20337921"),
            Student("Tran Thi Thuy", "20245833"),
            Student("Nguyen Van Tai", "20356987"),
            Student("Le Thi Mai", "20468849"),
            Student("Hoang Van Phu", "20272914"),
            Student("Nguyen Thi Phuong", "20189327"),
            Student("Vo Van Quy", "20391756"),
            Student("Nguyen Thi Hang", "20201864"),
            Student("Tran Minh Tuan", "20412793"),
            Student("Nguyen Van Binh", "20323741"),
            Student("Le Van Cuong", "20234785"),
            Student("Vu Minh Hoang", "20147892"),
            Student("Tran Thi Thanh", "20356143")
        )

        studentAdapter = StudentAdapter(studentList)

        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerView.adapter = studentAdapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString().trim()
                if (keyword.length > 2) {
                    // Tìm kiếm nếu từ khóa > 2 ký tự
                    val filteredList = studentList.filter {
                        it.name.contains(keyword, ignoreCase = true) || it.mssv.contains(keyword)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    // Hiển thị toàn bộ danh sách nếu từ khóa <= 2 ký tự
                    studentAdapter.updateList(studentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}

