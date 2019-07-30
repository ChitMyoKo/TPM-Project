package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.tpm.tpmproject.adapter.TeacherAdapter
import com.tpm.tpmproject.model.Teacher
import com.tpm.tpmproject.R
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.activity_teacher.*
import kotlinx.android.synthetic.main.bottom_sheet_teacher.view.*

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

    private lateinit var filterBottomSheetBehavior : BottomSheetBehavior<LinearLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        teacherToolbar.setTitle(R.string.teacaherToolbar)
        setSupportActionBar(teacherToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val coordinatorLayout : CoordinatorLayout = teacherCoordiLy
        val bottomSheetLayout = coordinatorLayout.bottomSheetFilter
        filterBottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        filterBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.filter)
        {
            Log.d("Menu","do menu item")
            if (filterBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                filterBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
                Log.d("Menu show","do menu item")
            } else {
                filterBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                Log.d("Menu not show","do menu item")
            }
        }
        else if(item.itemId == android.R.id.home)
        {
            onBackPressed()
            true
        }
        else{
            Log.d("not Menu","do menu item")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickItem(teacher : Teacher)
    {
        startActivity(TeacherProfileActivity.newIntent(this,teacher.name,teacher.profile))
    }
}
