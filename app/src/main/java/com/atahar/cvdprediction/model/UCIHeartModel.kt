package com.atahar.cvdprediction.model

data class UCIHeartModel(
    val age: Int,
    val sex: Int,
    val cp: Int,
    val restBP: Int,
    val cholesterol: Int,
    val fbs: Int,
    val ecg: Int,
    val thalach: Int,
    val exang: Int,
    val oldpeak: Int,
    val slope: Int,
    val ca: Int,
    val thal: Int
)