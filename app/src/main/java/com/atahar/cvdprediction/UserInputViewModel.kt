package com.atahar.cvdprediction

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atahar.cvdprediction.model.CVDInputType
import com.atahar.cvdprediction.model.UCIHeartModel
import com.atahar.cvdprediction.utils.CVDHelper

class UserInputViewModel : ViewModel() {

    private var _inputComplete = MutableLiveData<Boolean>(false)
    val inputComplete: LiveData<Boolean>
        get() = _inputComplete

    val ageList = CVDHelper.AGE_LIST
    val sexList = CVDHelper.SEX_LIST
    val cpList = CVDHelper.CP_LIST
    val restBPList = CVDHelper.REST_BP_LIST
    val cholList = CVDHelper.CHOL_LIST
    val fbsList = CVDHelper.FBS_LIST
    val ecgList = CVDHelper.ECG_LIST
    val thalachList = CVDHelper.THALACH_LIST
    val exangList = CVDHelper.EXANG_LIST
    val oldpeakList = CVDHelper.OLDPEAK_LIST
    val slopeList = CVDHelper.SLOPE_LIST
    val caList = CVDHelper.CA_LIST
    val thalList = CVDHelper.THAL_LIST

    var selectedAge = -1
    var selectedSex = -1
    var selectedCp = -1
    var selectedRestBP = -1
    var selectedChol = -1
    var selectedFbs = -1
    var selectedEcg = -1
    var selectedThalach = -1
    var selectedExang = -1
    var selectedOldpeak = -1
    var selectedSlope = -1
    var selectedCa = -1
    var selectedThal = -1

    var ageSelectedItem = 0
    var sexSelectedItem = 0
    var cpSelectedItem = 0
    var restBPSelectedItem = 0
    var cholSelectedItem = 0
    var fbsSelectedItem = 0
    var ecgSelectedItem = 0
    var thalachSelectedItem = 0
    var exangSelectedItem = 0
    var oldpeakSelectedItem = 0
    var slopeSelectedItem = 0
    var caSelectedItem = 0
    var thalSelectedItem = 0


    fun setSampleInput() {
        val model = CVDHelper.getSampleUCIHeartModel()
        ageSelectedItem = ageList.indexOf(model.age.toString())
        sexSelectedItem = sexList.indexOf(model.sex.toString())
        cpSelectedItem = cpList.indexOf(model.cp.toString())
        restBPSelectedItem = restBPList.indexOf(model.restBP.toString())
        cholSelectedItem = cholList.indexOf(model.cholesterol.toString())
        fbsSelectedItem = fbsList.indexOf(model.fbs.toString())
        ecgSelectedItem = ecgList.indexOf(model.ecg.toString())
        thalachSelectedItem = thalachList.indexOf(model.thalach.toString())
        exangSelectedItem = exangList.indexOf(model.exang.toString())
        oldpeakSelectedItem = oldpeakList.indexOf(model.oldpeak.toString())
        caSelectedItem = caList.indexOf(model.ca.toString())
        slopeSelectedItem = slopeList.indexOf(model.slope.toString())
        thalSelectedItem = thalList.indexOf(model.thal.toString())
    }

    fun onItemSelected(selectedValueStr: String, typeCVD: CVDInputType) {

        if (selectedValueStr == "Select") return
        val selectedValue = selectedValueStr.toFloat().toInt()
        when (typeCVD) {
            CVDInputType.AGE -> selectedAge = selectedValue
            CVDInputType.SEX -> selectedSex = selectedValue
            CVDInputType.CP -> selectedCp = selectedValue
            CVDInputType.REST_BP -> selectedRestBP = selectedValue
            CVDInputType.CHOLESTEROL -> selectedChol = selectedValue
            CVDInputType.FBS -> selectedFbs = selectedValue
            CVDInputType.ECG -> selectedEcg = selectedValue
            CVDInputType.THALACH -> selectedThalach = selectedValue
            CVDInputType.EXANG -> selectedExang = selectedValue
            CVDInputType.OLDPEAK -> selectedOldpeak = selectedValue
            CVDInputType.SLOPE -> selectedSlope = selectedValue
            CVDInputType.CA -> selectedCa = selectedValue
            CVDInputType.THAL -> selectedThal = selectedValue
        }

        checkInputs()
    }

    private fun checkInputs() {
        if (selectedAge == -1
                || selectedSex == -1
                || selectedCp == -1
                || selectedRestBP == -1
                || selectedChol == -1
                || selectedFbs == -1
                || selectedEcg == -1
                || selectedThalach == -1
                || selectedExang == -1
                || selectedOldpeak == -1
                || selectedSlope == -1
                || selectedCa == -1
                || selectedThal == -1)
            _inputComplete.value = false
        else {
            getUciHeartModel()
            _inputComplete.value = true
        }
    }

    fun getUciHeartModel() = UCIHeartModel(
        selectedAge,
        selectedSex,
        selectedCp,
        selectedRestBP,
        selectedChol,
        selectedFbs,
        selectedEcg,
        selectedThalach,
        selectedExang,
        selectedOldpeak,
        selectedSlope,
        selectedCa,
        selectedThal
    )

}