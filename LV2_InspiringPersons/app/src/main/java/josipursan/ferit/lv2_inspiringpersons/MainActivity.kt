package josipursan.ferit.lv2_inspiringpersons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val Musk_firstLine : String = "Elon Musk (1971 - )"
    val Musk_secondLine : String = "Elon Reeve Musk is an engineer, industrial designer, technology entrepreneur, and philanthropist."
    // Source : https://en.wikipedia.org/wiki/Elon_Musk

    val Ritchie_firsLine : String = "Dennis Ritchie (1941 - 2011)"
    val Ritchie_secondLine : String = "Dennis MacAlistair Ritchie was an American computer scientist. He created the C programming language, the Unix operating system and B programming language."
    // Source : https://en.wikipedia.org/wiki/Dennis_Ritchie

    val Shannon_firstLine : String = "Claude Shannon (1916 - 2001)"
    val Shannon_secondLine : String = "Claude Elwood Shannon was an American mathematician, electrical engineer, and cryptographer known as \"the father of information theory\"."
    // https://en.wikipedia.org/wiki/Claude_Shannon

    val requestCode_ID_startActivityForResult = 720

    val list = ArrayList<InspiringPerson>()
    val testList = generateList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.adapter = PersonAdapter(testList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val button_openActivity2 = findViewById<Button>(R.id.openActivity2);
        button_openActivity2.setOnClickListener()
        {
            openActivity2_addPerson()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                //val nameBirthDeath : String = data!!.getStringExtra("result_nameBirthDeath")
                val inspiringPerson_creation = InspiringPerson(R.drawable.ic_person_black, data?.getStringExtra("NameBirthDeath") ?: "",
                    data?.getStringExtra("ShortDescription") ?: "")
                val testToast = Toast.makeText(this, data?.getStringExtra("ShortDescription") ?: "", Toast.LENGTH_LONG).show()

                val current_list = addItemTolist(data?.getStringExtra("NameBirthDeath") ?: "", data?.getStringExtra("ShortDescription") ?: "")
                recyclerView.adapter = PersonAdapter(current_list)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.setHasFixedSize(true)
            }
        }
    }

    public fun openActivity2_addPerson()
    {
        val intent:Intent = Intent(this, AddPersonActivity::class.java)
        startActivityForResult(intent, 1)
    }

    private fun addItemTolist(nameBirthDeath : String, description : String):List<InspiringPerson>
    {
        var current_list = ArrayList<InspiringPerson>()
        current_list.addAll(testList)

        val person = InspiringPerson(R.drawable.ic_person_black, nameBirthDeath, description)
        current_list.add(person)
        list += person
        return current_list
    }

    private fun generateList(): List<InspiringPerson> {

        var item = InspiringPerson(R.drawable.elon_musk_picture, Musk_firstLine, Musk_secondLine)
        list += item
        item = InspiringPerson(R.drawable.dennis_ritchie_picture, Ritchie_firsLine, Ritchie_secondLine)
        list += item
        item = InspiringPerson(R.drawable.claude_shannon_picture, Shannon_firstLine, Shannon_secondLine)
        list += item

        return list
    }
}
