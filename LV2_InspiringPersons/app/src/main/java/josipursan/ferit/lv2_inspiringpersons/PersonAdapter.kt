package josipursan.ferit.lv2_inspiringpersons

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.inspiring_person.view.*

class PersonAdapter(private val personList : List<InspiringPerson>, val context : Context) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.inspiring_person,
            parent, false)

        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentItem = personList[position]

        holder.imageView.setImageResource(currentItem.ImageReource)
        holder.textView1.text = currentItem.textFirstRow
        holder.textView2.text = currentItem.textSecondRow

        holder.imageView.setOnClickListener()
        {
            var quotesArray : Array<String> = currentItem.quotes.split("|").toTypedArray()
            var randomQuote = quotesArray.random()

            val testToast = Toast.makeText(context, randomQuote, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount() = personList.size

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView : ImageView = itemView.imageView
        val textView1 : TextView = itemView.textView_1
        val textView2 : TextView = itemView.textView_2
    }

}