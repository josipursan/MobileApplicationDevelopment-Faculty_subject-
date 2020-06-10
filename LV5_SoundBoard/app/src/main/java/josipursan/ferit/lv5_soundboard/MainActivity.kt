package josipursan.ferit.lv5_soundboard

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setUpUI()
        this.loadSounds()
    }

    private fun setUpUI() {
        this.quigonjinnImageButton.setOnClickListener(this)
        this.anakinImageButton.setOnClickListener(this)
        this.obiwankenobiImageButton.setOnClickListener(this)
    }

    private fun loadSounds() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        }
        else
        {
            this.mSoundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
        }

        this.mSoundPool.setOnLoadCompleteListener{_,_,_ -> mLoaded = true}
        this.mSoundMap[R.raw.lightsaber] = this.mSoundPool.load(this, R.raw.lightsaber, 1)
        this.mSoundMap[R.raw.bananaslip] = this.mSoundPool.load(this, R.raw.bananaslip, 1)
        this.mSoundMap[R.raw.lightsaberon] = this.mSoundPool.load(this, R.raw.lightsaberon, 1)
    }


    override fun onClick(v: View?) {
        if(this.mLoaded == false) return
        when(v?.getId())
        {
            R.id.quigonjinnImageButton -> playSound(R.raw.lightsaber)
            R.id.anakinImageButton -> playSound(R.raw.bananaslip)
            R.id.obiwankenobiImageButton -> playSound(R.raw.lightsaberon)
        }
    }

    fun playSound(selectedSound: Int)
    {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }

}
