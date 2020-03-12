package dog.snow.androidrecruittest.ui

import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.ui.adapter.ListAdapter
import dog.snow.androidrecruittest.ui.model.ListItem
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.android.synthetic.main.list_fragment.view.*
import kotlinx.android.synthetic.main.list_item.*
import org.w3c.dom.Text

class ListFragment : Fragment(R.layout.list_fragment){

    private lateinit var listTitle: List<ListItem>
    private lateinit var recyclerView: RecyclerView
    private lateinit var listAdapter: ListAdapter
    private lateinit var textView: TextView
    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
         ): View? {
            v = inflater.inflate(R.layout.list_fragment,container,false)
            listTitle = listOf(ListItem(1,"Test","Test","https://via.placeholder.com/150/18a3"))
            recyclerView = v.findViewById(R.id.rv_items)
            listAdapter = ListAdapter({item,position,view ->})
            listAdapter.submitList(listTitle)
            return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(activity)
            visibility = View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}