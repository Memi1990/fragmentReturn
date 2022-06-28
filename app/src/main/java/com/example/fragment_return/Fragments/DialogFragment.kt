package com.example.fragment_return.Fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment_return.R

class DialogFragment : Fragment() {

    val dialog = DialogFragment()
    dialog.setArguments(bundle)
    dialog.show(supportFragmentManager, "tag")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        dialog!!.setTitle("Dialog Fragment")
        val view = inflater.inflate(R.layout.fragment_dialog,container,false)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context!!)
            .setMessage(R.string.confirm)
            .setPositiveButton(R.string.acept) {dialog, id ->
                Toast.makeText(context, "Has eliminado los elementos seleccionados", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(R.string.cancel) {dialog, id ->
                Toast.makeText(context, "No has eliminado nada", Toast.LENGTH_SHORT).show()
            }
            .create()
    }

    companion object {
        const val  TAG = "PurchaseConfirmationDialog"
    }

}