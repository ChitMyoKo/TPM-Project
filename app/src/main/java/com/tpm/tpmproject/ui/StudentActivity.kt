package com.tpm.tpmproject.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.tpm.tpmproject.adapter.StudentAdapter
import com.tpm.tpmproject.model.Student
import com.tpm.tpmproject.R
import com.tpm.tpmproject.mvpStudent.contract.StudentContract
import com.tpm.tpmproject.mvpStudent.presenter.StudentPresenterImpl
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.activity_student.view.*
import kotlinx.android.synthetic.main.bottom_sheet_student.*
import kotlinx.android.synthetic.main.bottom_sheet_student.view.*
import kotlinx.android.synthetic.main.bottom_sheet_student.view.btnDoneStudent

class StudentActivity : AppCompatActivity(),StudentContract.StudentView {

    companion object{
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context,StudentActivity::class.java)
            return  intent
        }
    }

    private lateinit var studentArr : MutableList<Student>
    private lateinit var filterBottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private val studentAdapter  : StudentAdapter by lazy { StudentAdapter(this::onItemClick) }
    private val studentPresenter : StudentContract.StudentPresenter by lazy { StudentPresenterImpl() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        studentPresenter.attachView(this)
        studentPresenter.loadStudentList()
        studentToolbar.setTitle(R.string.studentToolbar)
        setSupportActionBar(studentToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val coordinatorLayout : CoordinatorLayout = studentCoordiLy
        val bottomSheetLayout = coordinatorLayout.bottomSheetFilter
        filterBottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        filterBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        btnDoneStudent.setOnClickListener {
            var android : String =""
            var java : String = ""
            var php : String = ""
            var male : String = ""
            var femal : String = ""
            if(chbAndroidStudent.isChecked)
                android = "android"
            if(chbJavaStudent.isChecked)
                java= "java"
            if(chbPhpStudent.isChecked)
                php = "php"
            if(chbMaleStudent.isChecked)
                male = "male"
            if(chbFemaleStudent.isChecked)
                femal = "female"
            studentPresenter.loadFilterStudentList(android,php,java,male,femal)
            filterBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            chbAndroidStudent.isChecked = false
            chbJavaStudent.isChecked = false
            chbPhpStudent.isChecked = false
            chbMaleStudent.isChecked = false
            chbFemaleStudent.isChecked = false
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

    private fun onItemClick(student : Student)
    {
        startActivity(StudentProfileActivity.newIntent(this,student.name,student.profession,student.profile))
    }
    override fun showStudentList(studentList: MutableList<Student>) {
        studentArr = studentList
        studentAdapter.setStudentList(studentArr)
        loadRecycler()
    }

    override fun showFilterStudentList(studentFilterList: MutableList<Student>) {
        studentArr = studentFilterList
        for(stu in studentArr.indices)
        {
            Log.d("student :", studentArr[stu].profession)
        }
        Log.d("dd","dd")
        studentAdapter.setStudentList(studentArr)
        Log.d("do","do filter")
        loadRecycler()
    }
    override fun hideBottomSheet() {
        filterBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }
    fun loadRecycler()
    {
        rcStudent.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = studentAdapter
        }

    }
    override fun onResume() {
        super.onResume()
        studentAdapter.setStudentList(studentArr)
    }
}
