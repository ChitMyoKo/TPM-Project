package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import com.tpm.tpmproject.adapter.TeacherAdapter
import com.tpm.tpmproject.model.Teacher
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    lateinit var teachrArray : List<Teacher>
    private val teacherAdapter : TeacherAdapter by lazy { TeacherAdapter(teachrArray,this::onClickItem) }
    companion object{
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,TeacherActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        teacherToolbar.setTitle(R.string.teacaherToolbar)
        setSupportActionBar(teacherToolbar)

        var teacher_1 = Teacher("Thaw Zin Aung","Android",R.drawable.tza)
        var teacher_2 = Teacher("Kyaw Kyaw Khaing","Android",R.drawable.kkk)
        var teacher_3 = Teacher("Phone Lin Aung","Android",R.drawable.pla)
        var teacher_4 = Teacher("Myo Sat Paing","Android",R.drawable.msp)
        teachrArray = mutableListOf<Teacher>(teacher_1,teacher_2,teacher_3,teacher_4)

        rcTeacher.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = teacherAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.filter,menu)
        return true
    }

    private fun onClickItem(teacher : Teacher)
    {
        startActivity(TeacherProfileActivity.newIntent(this,teacher.name,teacher.profile))
    }
}
