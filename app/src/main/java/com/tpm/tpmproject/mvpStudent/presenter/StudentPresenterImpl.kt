package com.tpm.tpmproject.mvpStudent.presenter

import com.tpm.tpmproject.R
import com.tpm.tpmproject.model.Student
import com.tpm.tpmproject.mvpStudent.contract.StudentContract

class StudentPresenterImpl : StudentContract.StudentPresenter {


    private var studentView: StudentContract.StudentView? = null
    var student_1 = Student("Ye Lin Aung", "Android", R.drawable.yla, "Male")
    var student_2 = Student("Mya Mya Khaing", "Android", R.drawable.mmk, "Female")
    var student_3 = Student("Chit Myo Ko", "Android", R.drawable.cmk, "Male")
    var student_4 = Student("Pyae Pyae Win", "Android", R.drawable.ppw, "Female")
    var student_5 = Student("Ko Ko", "Java", R.drawable.cmk, "Male")
    var student_6 = Student("Ma Ma", "Java", R.drawable.ppw, "Female")
    var student_7 = Student("Ag Ag", "Php", R.drawable.cmk, "Male")
    var student_8 = Student("Mya Mya", "Php", R.drawable.ppw, "Female")
    private var studentArr = mutableListOf<Student>(student_1, student_2, student_3, student_4,student_5,student_6,student_7,student_8)
    private var errList = mutableListOf<Student>(student_3)
    private var studentFilterList: MutableList<Student> = arrayListOf()
    private var filterIndex = 0
    override fun attachView(view: StudentContract.StudentView) {
        this.studentView = view
    }

    override fun loadStudentList() {
        studentView?.showStudentList(studentArr)
    }
    override fun loadFilterStudentList(android: String, php: String, java: String, male: String, female: String) {

        if ((female.isNotEmpty() && male.isNotEmpty()) || (female.isEmpty() && male.isEmpty())) {
            //select all courses
            if(android.isNotEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                studentView?.showFilterStudentList(studentArr)
            }
            //select android and php courses
            else if(android.isNotEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidStudents())
                sList.addAll(PhpStudents())
                studentView?.showFilterStudentList(sList)
            }
            //select android and java courses
            else if(android.isNotEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidStudents())
                sList.addAll(JavaStudents())
                studentView?.showFilterStudentList(sList)
            }
            //select php and java courses
            else if(android.isEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(PhpStudents())
                sList.addAll(JavaStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android course
            else if(android.isNotEmpty() && php.isEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(AndroidStudents())
            }
            //select php course
            else if(android.isEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(PhpStudents())
            }
            //select java course
            else if(android.isEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                studentView?.showFilterStudentList(JavaStudents())
            }
            //select Male
        } else if (female.isEmpty() && male.isNotEmpty()) {

            //select all courses
            if(android.isNotEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidMaleStudents())
                sList.addAll(PhpMaleStudents())
                sList.addAll(JavaMaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android and php courses
            else if(android.isNotEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidMaleStudents())
                sList.addAll(PhpMaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android and java courses
            else if(android.isNotEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidMaleStudents())
                sList.addAll(JavaMaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select php and java courses
            else if(android.isEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(PhpMaleStudents())
                sList.addAll(JavaMaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android course
            else if(android.isNotEmpty() && php.isEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(AndroidMaleStudents())
            }
            //select php course
            else if(android.isEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(PhpMaleStudents())
            }
            //select java course
            else if(android.isEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                studentView?.showFilterStudentList(JavaMaleStudents())
            }
            //select Female
        } else if (female.isNotEmpty() && male.isEmpty()) {

            //select all courses
            if(android.isNotEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidFemaleStudents())
                sList.addAll(PhpFemaleStudents())
                sList.addAll(JavaFemaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android and php courses
            else if(android.isNotEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidFemaleStudents())
                sList.addAll(PhpFemaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android and java courses
            else if(android.isNotEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(AndroidFemaleStudents())
                sList.addAll(JavaFemaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select php and java courses
            else if(android.isEmpty() && php.isNotEmpty() && java.isNotEmpty())
            {
                var sList: MutableList<Student> = arrayListOf()
                sList.addAll(PhpFemaleStudents())
                sList.addAll(JavaFemaleStudents())
                studentView?.showFilterStudentList(sList)

            }
            //select android course
            else if(android.isNotEmpty() && php.isEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(AndroidFemaleStudents())
            }
            //select php course
            else if(android.isEmpty() && php.isNotEmpty() && java.isEmpty())
            {
                studentView?.showFilterStudentList(PhpFemaleStudents())
            }
            //select java course
            else if(android.isEmpty() && php.isEmpty() && java.isNotEmpty())
            {
                studentView?.showFilterStudentList(JavaFemaleStudents())
            }

        } else {
            studentView?.hideBottomSheet()
        }

       // studentView?.showFilterStudentList(PhpStudents())
    }
    fun AndroidStudents(): MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Android"))
            {
                studentFilterList.add(student)
            }
        }
        return studentFilterList
    }
    fun AndroidMaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Android") && student.gender.equals("Male"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }
    fun AndroidFemaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Android") && student.gender.equals("Female"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }
    fun JavaStudents(): MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Java"))
            {
                studentFilterList.add(student)
            }
        }
        return studentFilterList
    }
    fun JavaMaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Java") && student.gender.equals("Male"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }
    fun JavaFemaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Java") && student.gender.equals("Female"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }
    fun PhpStudents(): MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Php"))
            {
                studentFilterList.add(student)
            }
        }
        return studentFilterList
    }
    fun PhpMaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Php") && student.gender.equals("Male"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }
    fun PhpFemaleStudents():MutableList<Student>
    {
        studentFilterList.clear()
        for(student in studentArr)
        {
            if(student.profession.equals("Php") && student.gender.equals("Female"))
                studentFilterList.add(student)
        }
        return studentFilterList
    }

}