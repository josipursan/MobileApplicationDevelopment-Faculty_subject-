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
    val Musk_quotes : String = "Really, the only thing that makes sense is to strive for greater collective enlightenment.|When something is important enough, you do it even if the odds are not in your favor.|If you get up in the morning and think the future is going to be better, it is a bright day. Otherwise, it's not."

    // Source : https://en.wikipedia.org/wiki/Elon_Musk

    val Ritchie_firsLine : String = "Dennis Ritchie (1941 - 2011)"
    val Ritchie_secondLine : String = "Dennis MacAlistair Ritchie was an American computer scientist. He created the C programming language, the Unix operating system and B programming language."
    val Ritchie_quotes : String = "C++ and Java, say, are presumably growing faster than plain C, but I bet C will still be around.|For infrastructure technology, C will be hard to displace.|UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity."
    // Source : https://en.wikipedia.org/wiki/Dennis_Ritchie

    val Shannon_firstLine : String = "Claude Shannon (1916 - 2001)"
    val Shannon_secondLine : String = "Claude Elwood Shannon was an American mathematician, electrical engineer, and cryptographer known as \"the father of information theory\"."
    val Shannon_quotes : String = "I have spent lots of time on totally useless problems.|My mind wanders around and I will conceive of different things day and night.|I think that dissatisfaction in present days is a key driving force in good scientists."
    // https://en.wikipedia.org/wiki/Claude_Shannon

    val list = ArrayList<InspiringPerson>()
    val testList = generateList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.adapter = PersonAdapter(testList, this)
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
                val inspiringPerson_creation = InspiringPerson(R.drawable.ic_person_black, data?.getStringExtra("NameBirthDeath") ?: "",
                    data?.getStringExtra("ShortDescription") ?: "", data?.getStringExtra("Quotes") ?: "")

                val current_list = addItemTolist(data?.getStringExtra("NameBirthDeath") ?: "", data?.getStringExtra("ShortDescription") ?: "", data?.getStringExtra("Quotes") ?: "")
                recyclerView.adapter = PersonAdapter(current_list, this)
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

    private fun addItemTolist(nameBirthDeath : String, description : String, quotes : String):List<InspiringPerson>
    {
        var current_list = ArrayList<InspiringPerson>()
        current_list.addAll(testList)

        val person = InspiringPerson(R.drawable.ic_person_black, nameBirthDeath, description, quotes)
        current_list.add(person)
        list += person
        return current_list
    }

    private fun generateList(): List<InspiringPerson> {

        var item = InspiringPerson(R.drawable.elon_musk_picture, Musk_firstLine, Musk_secondLine, Musk_quotes)
        list += item
        item = InspiringPerson(R.drawable.dennis_ritchie_picture, Ritchie_firsLine, Ritchie_secondLine, Ritchie_quotes)
        list += item
        item = InspiringPerson(R.drawable.claude_shannon_picture, Shannon_firstLine, Shannon_secondLine, Shannon_quotes)
        list += item

        return list
    }

}
