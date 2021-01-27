package com.app.revisionandroidapp.ui.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import com.app.revisionandroidapp.R
import java.lang.Exception

class CustomModalFragment : AppCompatDialogFragment() {

    private val string1: String = ""
    private val string2: String = ""

    private var listener: ExampleDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val view = layoutInflater.inflate(R.layout.custom_dialog_fragment, null, false)

        builder.setView(view)

        val editText1 = view.findViewById<EditText>(R.id.name_edit_text)
        val editText2 = view.findViewById<EditText>(R.id.text_edit_text)
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            listener?.applyTexts(editText1.text.toString(), editText2.text.toString())
        }

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as ExampleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement ExampleDialogListener")
        }
    }

    interface ExampleDialogListener {
        fun applyTexts(string1: String, string2: String)
    }
}