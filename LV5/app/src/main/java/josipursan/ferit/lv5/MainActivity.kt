package josipursan.ferit.lv5

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSoundPool: SoundPool
    private var mLoaded : Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setUpUI()
        this.loadSounds()
    }

    private fun setUpUI() {
        this.f1Button.setOnClickListener(this)
        this.iceCubesButton.setOnClickListener(this)
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
        this.mSoundMap[R.raw.f1] = this.mSoundPool.load(this, R.raw.f1, 1)
        this.mSoundMap[R.raw.icecubes] = this.mSoundPool.load(this, R.raw.icecubes, 1)
    }

    override fun onClick(v: View?) {
        if(this.mLoaded == false) return
        when (v?.getId())
        {
            R.id.f1Button -> playSound(R.raw.f1)
            R.id.iceCubesButton -> playSound(R.raw.icecubes)
        }
    }

    private fun playSound(selectedSound: Int)
    {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }
}
