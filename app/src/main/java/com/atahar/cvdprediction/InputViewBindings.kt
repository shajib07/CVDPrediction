package com.atahar.cvdprediction

import androidx.databinding.BindingAdapter

/*
class InputViewBindings {
}*/


@BindingAdapter("inputLabel")
fun UserInputItem.setInputLabel(inputLabel: String) {
    setInputLabelText(inputLabel)
}

/*@BindingAdapter("selectedSpinnerItem")
fun UserInputItem.selectSpinnerItem(item: Int) {
    setSelectedSpinnerItem(item)
}*/


@BindingAdapter("inputSelectionListener")
fun UserInputItem.setInputSelectionListener(inputSelectionListener: UserInputItem.InputSelectionListener) {
    setInputSelectionListener(inputSelectionListener)
}

@BindingAdapter("spinnerItems", "selectedItem")
fun UserInputItem.setSpinnerItems(items: ArrayList<String>, selectedItem: Int) = setSpinnerItems(items, selectedItem)

/*
* @BindingAdapter("pickerEnabled")
fun <T> DropdownInputView<T>.injectPickerEnabled(pickerEnabled: Boolean?) {
    this.isEnabled = pickerEnabled ?: true
}


* */