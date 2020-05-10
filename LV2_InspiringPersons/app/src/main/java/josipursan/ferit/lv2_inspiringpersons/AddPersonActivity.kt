package josipursan.ferit.lv2_inspiringpersons

import android.app.Activity
import android.content.Intent
import android.content.pm.InstrumentationInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        setTitle("Add person")


        val buttonAddPerson_returnToMainActivity = findViewById<Button>(R.id.addPerson_button_activity2)
        buttonAddPerson_returnToMainActivity.setOnClickListener()
        {
            val editTextNameBirthDeath = findViewById<EditText>(R.id.editText_nameBirthDeath)
            val editTextShortDescription = findViewById<EditText>(R.id.editText_shortDescription)
            val editTextQuoteInput = findViewById<EditText>(R.id.editText_quoteInput)

            if(editTextShortDescription.getText().toString().equals("") || editTextNameBirthDeath.getText().toString().equals(""))
            {
                val warningToast = Toast.makeText(this, "Please enter values", Toast.LENGTH_LONG).show()
            }
            else
            {
                var editTextNameBirthDeath_value = editTextNameBirthDeath.text.toString()
                var editTextShortDescription_value = editTextShortDescription.getText().toString()
                var editTextQuoteInput_value = editTextQuoteInput.text.toString()

                val newPerson : Intent = Intent()
                newPerson.putExtra("NameBirthDeath", editTextNameBirthDeath_value)
                newPerson.putExtra("ShortDescription", editTextShortDescription_value)
                newPerson.putExtra("Quotes", editTextQuoteInput_value)
                setResult(Activity.RESULT_OK, newPerson)
                finish()
            }
        }
    }
}
