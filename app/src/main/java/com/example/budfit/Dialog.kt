package com.example.budfit

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment

class Dialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var rootView: View = inflater.inflate(R.layout.popup, container, false)

        //rootView.button
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("popup")
        rootView.setOnClickListener() {
            dismiss()
        }
        return rootView
    }
    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater : LayoutInflater = activity.layoutInflater
        val view : View =inflater.inflate(R.layout.popup, null)

        builder.setView(view).setTitle("Pop up").setNeutralButton("OK", DialogInterface.OnClickListener { dialog, which ->  })


        return builder.create()
    }*/


}