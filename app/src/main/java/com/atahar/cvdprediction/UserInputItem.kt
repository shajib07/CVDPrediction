package com.atahar.cvdprediction

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import com.atahar.cvdprediction.databinding.LayoutUserInputItemBinding
import kotlin.collections.indexOf as indexOf1

class UserInputItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var inputLabelText: AppCompatTextView
    private var inputSpinner: AppCompatSpinner
    private var spinnerItems: ArrayList<String> = ArrayList()

    private lateinit var inputSelectionListener: InputSelectionListener

    private var binding: LayoutUserInputItemBinding =
        LayoutUserInputItemBinding.inflate(LayoutInflater.from(context), this)

    init {
        inputLabelText = binding.inputLabelText
        inputSpinner = binding.spinner
    }

    fun setSpinnerItems(items: ArrayList<String>, selectedItem: Int) {
        spinnerItems.addAll(items)
        inputSpinner.adapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerItems)

        inputSpinner.setSelection(selectedItem)

        inputSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                inputSelectionListener.onInputSelection(items[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun setSelectedSpinnerItem(item: Int) {
        this.inputSpinner.setSelection(spinnerItems.indexOf(item.toString()))
    }

    fun setInputSelectionListener(listener: InputSelectionListener) {
        this.inputSelectionListener = listener
    }

    fun setInputLabelText(label: String) {
        inputLabelText.text = label
    }

    interface InputSelectionListener {
        fun onInputSelection(input: String)
    }


}
