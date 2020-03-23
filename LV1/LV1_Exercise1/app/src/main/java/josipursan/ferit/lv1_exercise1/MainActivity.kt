package josipursan.ferit.lv1_exercise1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ///////////////////////////////////////////////////////////////////////////////////////////

        fun buildAlertDialog(message : String = "Bad input value")
        {
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)

            alertDialogBuilder.setTitle("Error")
            alertDialogBuilder.setMessage("$message")

            alertDialogBuilder.setNeutralButton("Close"){_,_ ->}

            val alertDialog : AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

        fun setVisibilityTrue_BMItxtViewsAndImgView()
        {
            txtView_showBMInumerically.visibility = View.VISIBLE
            txtView_BMIword.visibility = View.VISIBLE
            txtView_BMIdescription.visibility = View.VISIBLE
            imgView_BMIimage.visibility = View.VISIBLE
        }

        fun setVisbilityFalse_BMItxtViewsAndImgView()
        {
            txtView_showBMInumerically.visibility = View.INVISIBLE
            txtView_BMIword.visibility = View.INVISIBLE
            txtView_BMIdescription.visibility = View.INVISIBLE
            imgView_BMIimage.visibility = View.INVISIBLE
        }

        //////////////////////////////////////////////////////////////////////////////////////////

        btnCalculate.setOnClickListener{
            if(editTxt_EnterHeight.text.toString().length > 0 && editTxt_EnterWeight.text.toString().length > 0)
            {
                if(editTxt_EnterHeight.text.toString().toDouble() < 2.5 && editTxt_EnterHeight.text.toString().toDouble() > 0 &&
                    editTxt_EnterWeight.text.toString().toInt() < 350 && editTxt_EnterWeight.text.toString().toInt() > 0)
                {
                    var BMI : Float = editTxt_EnterWeight.text.toString().toInt()/(editTxt_EnterHeight.text.toString().toFloat().pow(2))
                    if(BMI < 18.5)
                    {
                        txtView_showBMInumerically.text = BMI.toString()
                        txtView_BMIword.text = getString(R.string.malnourishedString)
                        txtView_BMIdescription.text = getString(R.string.malnourishedDescription)
                        imgView_BMIimage.setImageResource(R.drawable.malnourished)

                        setVisibilityTrue_BMItxtViewsAndImgView()
                    }
                    else if(BMI >= 18.5 &&  BMI < 24.9)
                    {
                        txtView_showBMInumerically.text = BMI.toString()
                        txtView_BMIword.text = getString(R.string.healthyString)
                        txtView_BMIdescription.text = getString(R.string.healthyDescription)
                        imgView_BMIimage.setImageResource(R.drawable.normal)

                        setVisibilityTrue_BMItxtViewsAndImgView()
                    }
                    else if(BMI >= 25 && BMI < 29.9)
                    {
                        txtView_showBMInumerically.text = BMI.toString()
                        txtView_BMIword.text = getString(R.string.overweightString)
                        txtView_BMIdescription.text = getString(R.string.overweightDescription)
                        imgView_BMIimage.setImageResource(R.drawable.overweight)

                        setVisibilityTrue_BMItxtViewsAndImgView()
                    }
                    else if(BMI >= 30)
                    {
                        txtView_showBMInumerically.text = BMI.toString()
                        txtView_BMIword.text = getString(R.string.obeseString)
                        txtView_BMIdescription.text = getString(R.string.obeseDescription)
                        imgView_BMIimage.setImageResource(R.drawable.obese)

                        setVisibilityTrue_BMItxtViewsAndImgView()
                    }
                }
                else if(editTxt_EnterHeight.text.toString().toDouble() > 2.5 || editTxt_EnterHeight.text.toString().toDouble() < 0 ||
                    editTxt_EnterWeight.text.toString().toInt() > 350 || editTxt_EnterWeight.text.toString().toInt() < 0)
                {
                    buildAlertDialog("Bad input value(s)")
                    setVisbilityFalse_BMItxtViewsAndImgView()
                }
            }
            else
            {
                buildAlertDialog("Please enter values")
                setVisbilityFalse_BMItxtViewsAndImgView()
            }
        }
    }
}
