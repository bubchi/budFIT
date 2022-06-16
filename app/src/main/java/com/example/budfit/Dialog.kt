package com.example.budfit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/**
 * Fragment, ktory zobrazi graficky obrazok oznamujuci uzivatelovi
 * najbliziu planovaciu aktivitu
 */
class Dialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootView: View = inflater.inflate(R.layout.popup, container, false)
        return rootView
    }
}