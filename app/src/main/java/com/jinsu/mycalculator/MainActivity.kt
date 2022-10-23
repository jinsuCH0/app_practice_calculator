package com.jinsu.mycalculator

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jinsu.mycalculator.databinding.ActivityMainBinding

private val OPERATOR_LIST = arrayListOf("+", "-", "×", "÷", "%", "=", ".")

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Main Activity : onCreate() called!")

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        addListener()
    }

    private fun addListener() {
        with(binding) {
            btn0.setOnClickListener {
                Log.d(TAG, "Main Activity : 0 Clicked!")
                numberFunc(0)
            }
            btn1.setOnClickListener {
                Log.d(TAG, "Main Activity : 1 Clicked!")
                numberFunc(1)
            }
            btn2.setOnClickListener {
                Log.d(TAG, "Main Activity : 2 Clicked!")
                numberFunc(2)
            }
            btn3.setOnClickListener {
                Log.d(TAG, "Main Activity : 3 Clicked!")
                numberFunc(3)
            }
            btn4.setOnClickListener {
                Log.d(TAG, "Main Activity : 4 Clicked!")
                numberFunc(4)
            }
            btn5.setOnClickListener {
                Log.d(TAG, "Main Activity : 5 Clicked!")
                numberFunc(5)
            }
            btn6.setOnClickListener {
                Log.d(TAG, "Main Activity : 6 Clicked!")
                numberFunc(6)
            }
            btn7.setOnClickListener {
                Log.d(TAG, "Main Activity : 7 Clicked!")
                numberFunc(7)
            }
            btn8.setOnClickListener {
                Log.d(TAG, "Main Activity : 8 Clicked!")
                numberFunc(8)
            }
            btn9.setOnClickListener {
                Log.d(TAG, "Main Activity : 9 Clicked!")
                numberFunc(9)
            }
        }
        with(binding) {
            btnDiv.setOnClickListener {
                Log.d(TAG, "Main Activity : Div Clicked!")
                operatorFunc( "÷")
            }
            btnMul.setOnClickListener {
                Log.d(TAG, "Main Activity : Mul Clicked!")
                operatorFunc("×")
            }
            btnMinus.setOnClickListener {
                Log.d(TAG, "Main Activity : Minus Clicked!")
                operatorFunc("-")
            }
            btnPlus.setOnClickListener {
                Log.d(TAG, "Main Activity : Plus Clicked!")
                operatorFunc("+")
            }
            btnPercent.setOnClickListener {
                Log.d(TAG, "Main Activity : % Clicked!")
                operatorFunc("%")
            }
            btnPoint.setOnClickListener {
                Log.d(TAG, "Main Activity : . Clicked!")
                operatorFunc(".")
            }
            btnCE.setOnClickListener {
                Log.d(TAG, "Main Activity : CE Clicked!")
                Toast.makeText(this@MainActivity, "기능 준비 중 입니다.", Toast.LENGTH_SHORT).show()
            }
            btnC.setOnClickListener {
                Log.d(TAG, "Main Activity : C Clicked!")
                list.clear()
                binding.txtInputMain.setText("")
                Log.d(TAG, "list : $list")
            }
            btnCalculate.setOnClickListener {
                Log.d(TAG, "Main Activity : = Clicked!")
                operatorFunc("=")
            }
        }
    }

    private fun numberFunc(number : Int) {
        try {
            binding.txtInputMain.append(number.toString())

        } catch (e: NumberFormatException) {
            with(binding.txtInputMain) {
                textSize = 32F
                setText("입력 가능 범위를 초과하였습니다.")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun operatorFunc(operator : String) {
        var result = 0
        var inputNumber = with(binding.txtInputMain.text) {
            if((this.toString().toInt() == 0) or (this == null)) 0.0
            else this.toString().toDouble()
        }

        when (operator) {
            "+", "-" -> {
                // TODO: 연산
            }
            "%" -> {
                inputNumber /= 100
                binding.txtInputMain.setText(inputNumber.toString())
            }
            "." -> {

            }
            "=" -> {
                // TODO: 연산 
            }
            else -> Toast.makeText(this, "입력 오류입니다.", Toast.LENGTH_SHORT).show()
        }
    }
}








/*
Log.d(TAG, "inputNumber : $inputNumber")
Log.d(TAG, "operator : $operator")
Log.d(TAG, "list : $list")
Log.d(TAG, "list : ${list.size}")

*/
/*fun arithmetic(listNumber: Int, operator: String, inputNumber: Int): Int {
    when (operator) {
        "+" -> {
            result = inputNumber + listNumber
        }
        "-" -> {
            result = inputNumber - listNumber
        }
        "×" -> {
            result = inputNumber * listNumber
        }
        "÷" -> {
            result = inputNumber / listNumber
        }
    }

    return result
}*//*


if (list.size != 0) {
    Log.d(TAG, "list is empty !!")
    list.add(inputNumber.toString())
    list.add(operator)
    Log.d(TAG, "list : $list")
} else {
    Log.d(TAG, "list is not empty !!")
//            if (list[list.size-1] !in OPERATOR_LIST) { // 리스트 마지막 숫자면
//                result = arithmetic(list[list.size-1].toInt(), operator, inputNumber)
//                list.removeAt(list.size)
//                list.add(result.toString())
//                binding.txtInputMain.setText(result.toString())
//                // TODO: 마지막거 꺼내서 result = inputNumber () list[list.size]
//                // TODO: removeAt(list.size) -> list.add(result)
//            } else {
//                // 연산자면 숫자 들어올때까지 대기
//            }
}*/
