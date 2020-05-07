package josipursan.ferit.lv3_birdcounting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedpreferencesHandler = SharedPreferences_Handler(this)

        val textView_counterDisplay = findViewById<TextView>(R.id.textview_counter)

        val blueBirdButton = findViewById<Button>(R.id.button_blueBird)
        val yellowBirdButton = findViewById<Button>(R.id.button_yellowBird)
        val greenBirdButton = findViewById<Button>(R.id.button_greenBird)
        val redBirdButton = findViewById<Button>(R.id.button_redBird)

        val resetButton = findViewById<Button>(R.id.resetButton)

        textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()

        blueBirdButton.setOnClickListener()
        {
            sharedpreferencesHandler.incrementBirdCount()
            textView_counterDisplay.setTextColor(ContextCompat.getColor(this, R.color.white))
            textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()
            textView_counterDisplay.setBackgroundResource(R.color.blue)
        }

        yellowBirdButton.setOnClickListener()
        {
            sharedpreferencesHandler.incrementBirdCount()
            textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()
            textView_counterDisplay.setTextColor(ContextCompat.getColor(this, R.color.black))
            textView_counterDisplay.setBackgroundResource(R.color.yellow)
        }

        greenBirdButton.setOnClickListener()
        {
            sharedpreferencesHandler.incrementBirdCount()
            textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()
            textView_counterDisplay.setTextColor(ContextCompat.getColor(this, R.color.black))
            textView_counterDisplay.setBackgroundResource(R.color.green)
        }

        redBirdButton.setOnClickListener()
        {
            sharedpreferencesHandler.incrementBirdCount()
            textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()
            textView_counterDisplay.setTextColor(ContextCompat.getColor(this, R.color.black))
            textView_counterDisplay.setBackgroundResource(R.color.red)
        }

        resetButton.setOnClickListener()
        {
            sharedpreferencesHandler.resetBirdCount()
            textView_counterDisplay.setTextColor(ContextCompat.getColor(this, R.color.black))
            textView_counterDisplay.setBackgroundResource(R.color.white)
            textView_counterDisplay.text = sharedpreferencesHandler.getBirdCount().toString()
        }


    }
}
