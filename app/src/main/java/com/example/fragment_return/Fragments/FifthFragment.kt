package com.example.fragment_return.Fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragment_return.R
import com.google.android.material.snackbar.Snackbar

class FifthFragment : Fragment() {
    private var myView:View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_fragment1,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.itCopy-> Toast.makeText(context, "Has copiado esto", Toast.LENGTH_SHORT).show()
            R.id.itCut-> Snackbar.make(myView!!, "Has cortado esto", Snackbar.LENGTH_SHORT).show()
            R.id.itPaste-> Snackbar.make(myView!!, "Has pegado esto", Snackbar.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_first, container, false)
        return myView
    }

}