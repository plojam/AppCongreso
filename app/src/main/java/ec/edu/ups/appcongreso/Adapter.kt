package ec.edu.ups.appcongreso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val mContext: Context, private val operationList: MutableList<String>): ArrayAdapter<String>(mContext, 0, operationList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false)

        val operation = operationList[position]

        layout.datos.text = operation

        return layout
    }
}