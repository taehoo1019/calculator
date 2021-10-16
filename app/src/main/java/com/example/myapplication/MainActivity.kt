package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var nm = mutableListOf<String>()
    var nm3 = mutableListOf<String>()
    var nm2 = mutableListOf<String>()
    var n = mutableListOf<Int>(0)
    var 결과1 =0
    var s = -1

    var g = 0
    var show = " "
    var save1 = 0
    var save2 = 0
    var save3 = 0
    fun zz(a:Int):Unit {
        for (i in 0 until nm2.size) {
            show = show + nm2[i]
        }
        t1.text = show
        show= ""
    }

    fun kimTaeHoo(a: String, b: Int, c: String): Unit {
        if(결과1 == 1){
            결과1 = 0
            save1 = 0
            save2 = 0
            save3 = 0
            s = -1
            g = 0
            show = ""
            for (i in 0 until  nm.size) {
                nm[i] = ""
            }
            for (i in 0 until  nm2.size) {
                nm2[i] = ""
            }
            for (i in 0 until  nm3.size) {
                nm3[i] = ""
            }
            for (i in 0 until  n.size) {
                n[i] = 0
            }
            zz(0)
        }


        s++

        if (a == "n") {

            nm[s] = "n"
            n[s] = b
            nm2[s] = "${b}"
            nm3[s] = "${b}"
            if (s != 0 && nm[s-1] == "n" && nm[s] == "n") {
                nm.removeAt(s)
                n[save3] = n[save3] * 10 + n[s]
                n.removeAt(s)
                nm2[save3] = nm2[save3] + nm2[s]
                nm2.removeAt(s)
                nm3.removeAt(s)
                s--
            }
            save3 = s

        }
        else {
            when (c) {
                "(" -> {
                    if (g == 0) {
                        g = 1
                        nm[s] = "m"
                        nm2[s] = "("
                        nm3[s] = "("
                        save1 = s
                    } else {
                        g = 0
                        nm[s] = "m"
                        nm2[s] = ")"
                        nm3[s] = ")"
                        save2 = s
                    }
                }
                "×", "÷" -> {
                    nm[s] = "m"
                    nm2[s] = c
                    nm3[s] = c

                }
                else -> {
                    nm[s] = "m"
                    nm2[s] = c
                    nm3[s] = c

                }
            }


        }

        println(nm3)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 0..100) {
            nm.add("")
            nm2.add("")
            nm3.add("")
            n.add(0)
        }



        b1.setOnClickListener {
            kimTaeHoo("n", 1, "")
            zz(0)
        }
        b2.setOnClickListener {
            kimTaeHoo("n", 2, "")
            zz(0)
        }
        b3.setOnClickListener {
            kimTaeHoo("n", 3, "")
            zz(0)
        }
        b4.setOnClickListener {
            kimTaeHoo("n", 4, "")
            zz(0)
        }
        b5.setOnClickListener {
            kimTaeHoo("n", 5, "")
            zz(0)
        }
        b6.setOnClickListener {
            kimTaeHoo("n", 6, "")
            zz(0)
        }
        b7.setOnClickListener {
            kimTaeHoo("n", 7, "")
            zz(0)
        }
        b8.setOnClickListener {
            kimTaeHoo("n", 8, "")
            zz(0)
        }
        b9.setOnClickListener {
            kimTaeHoo("n", 9, "")
            zz(0)
        }
        b0.setOnClickListener {
            kimTaeHoo("n", 0, "")
            zz(0)
        }


        더하기.setOnClickListener {
            kimTaeHoo("m", 0, "+")
            zz(0)
        }
        빼기.setOnClickListener {
            kimTaeHoo("m", 0, "-")
            zz(0)
        }
        나누기.setOnClickListener {
            kimTaeHoo("m", 0, "÷")
            zz(0)
        }
        곱하기.setOnClickListener {
            kimTaeHoo("m", 0, "×")
            zz(0)
        }

        괄호.setOnClickListener {
            kimTaeHoo("m", 0, "(")
            zz(0)
        }


        결과.setOnClickListener {
            if (save2 != 0) {
                var j = save1 + 1
                while (j < save2) {

                    if (nm3[j] == "×") {
                        n[j - 1] = n[j - 1] * n[j + 1]
                        n.removeAt(j)
                        n.removeAt(j )
                        nm3.removeAt(j)
                        nm3.removeAt(j )
                        j--
                        println(nm3)

                    }
                    if (nm3[j] == "÷") {
                        n[j - 1] = n[j - 1] / n[j + 1]
                        n.removeAt(j)
                        n.removeAt(j)
                        nm3.removeAt(j)
                        nm3.removeAt(j)
                        j--
                        println(nm3)
                    }
                    j++
                }
                j =save1 + 1
                for (i in 0 until nm3.size) {
                    if (nm3[i] == ")") {
                        save2 = i
                    }
                }
                while (j < save2) {

                    if (nm3[j] == "+") {
                        n[j - 1] = n[j - 1] + n[j + 1]
                        n.removeAt(j)
                        n.removeAt(j)
                        nm3.removeAt(j)
                        nm3.removeAt(j)
                        j--
                        println(nm3)

                    }
                    if (nm3[j] == "-") {
                        n[j - 1] = n[j - 1] - n[j + 1]
                        n.removeAt(j)
                        n.removeAt(j)
                        nm3.removeAt(j)
                        nm3.removeAt(j)
                        j--
                        println(nm3)
                    }
                    j++
                }
                n[save1] =n[save1 + 1]
                n.removeAt(save1 + 1)
                n.removeAt(save1 + 1)
                nm[save1] =nm[save1 + 1]
                nm.removeAt(save1 + 1)
                nm.removeAt(save1 + 1)
            }
            var j = 0
            while (j < nm3.size) {

                if (nm3[j] == "×") {
                    println(" mul ")
                    n[j - 1] = n[j - 1] * n[j + 1]
                    n.removeAt(j)
                    n.removeAt(j )
                    nm3.removeAt(j)
                    nm3.removeAt(j )
                    j--

                    println(nm3)

                }
                if (nm3[j] == "÷"){
                    n[j - 1] = n[j - 1] / n[j + 1]
                    n.removeAt(j)
                    n.removeAt(j)
                    nm3.removeAt(j)
                    nm3.removeAt(j)
                    j--

                    println(nm3)
                }
                j++
            }
            println("hello1")
            j =0
            while (j < nm3.size) {

                if (nm3[j] == "+") {
                    n[j - 1] = n[j - 1] + n[j + 1]
                    n.removeAt(j)
                    n.removeAt(j )
                    nm3.removeAt(j)
                    nm3.removeAt(j )
                    j--

                    println(nm3)

                }
                if (nm3[j] == "-") {
                    n[j - 1] = n[j - 1] - n[j + 1]
                    n.removeAt(j)
                    n.removeAt(j )
                    nm3.removeAt(j)
                    nm3.removeAt(j)
                    j--

                    println(nm3)
                }
                j++
            }
            println("hello")
            t1.text =" ${n[0]}"
            결과1 = 1

        }




        삭제.setOnClickListener {


            save1 = 0
            save2 = 0
            save3 = 0
            s = -1
            g = 0
            show = ""
            for (i in 0 until  nm.size) {
                nm[i] = ""
            }
            for (i in 0 until  nm2.size) {
                nm2[i] = ""
            }
            for (i in 0 until  nm3.size) {
                nm3[i] = ""
            }
            for (i in 0 until  n.size) {
                n[i] = 0
            }
            zz(0)
        }





        /*
        b1.setOnTouchListener(object :View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when(event?.action){
                    MotionEvent.ACTION_DOWN ->{
                        // 버튼 클릭
                    }
                    MotionEvent.ACTION_UP ->{
                        // 버튼 릴리즈
                    }
                }
                return true
            }
        })
        */ /*

        var toast = Toast.makeText(applicationContext,"너무 높은 수", Toast.LENGTH_SHORT)
        t1.text=""

        toast.show()


            when(b){
                "+" -> {

                }
                "-" -> {

                }
                "/" -> {

                }
                "*" -> {

                }
                "(" -> {

                }

            }
        */

    }
}
