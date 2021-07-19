package MyAdapters

import Models.User
import Utils.MyDate.list
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.contact.R
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter(context: Context,val list: List<User>):ArrayAdapter<User>(context, R.layout.item_list,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        }else{
            itemView =convertView
        }

        itemView.contact_name.text = list[position].name
        itemView.contact_number.text = list[position].number
        return itemView
    }
}