package josipursan.ferit.lv3_birdcounting

import android.content.Context
import android.widget.EditText

class SharedPreferences_Handler(context:Context)
{
    val PREFERENCE_MARKER = "BirdCount_preference"
    val PREFERENCE_BIRD_COUNT = "BirdCount"

    val preference = context.getSharedPreferences(PREFERENCE_MARKER, Context.MODE_PRIVATE)

    fun getBirdCount():Int
    {
        return preference.getInt(PREFERENCE_BIRD_COUNT, 0)
    }

    fun incrementBirdCount()
    {
        val editor = preference.edit()
        var newCountState = getBirdCount() + 1
        editor.putInt(PREFERENCE_BIRD_COUNT, newCountState)
        editor.apply()
    }

    fun resetBirdCount()
    {
        val editor = preference.edit()
        editor.putInt(PREFERENCE_BIRD_COUNT, 0)
        editor.apply()
    }
}