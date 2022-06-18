package com.atahar.cvdprediction.model

enum class CVDInputType(val label: String) {
    AGE("Age"),
    SEX("Sex"),
    CP("Chest Pain"),
    REST_BP("Resting BP"),
    CHOLESTEROL("Cholesterol"),
    FBS("Fasting BP"),
    ECG("ECG"),
    THALACH("Thalach"),
    EXANG("Exang"),
    OLDPEAK("Oldpeak"),
    SLOPE("slope"),
    CA("Number of vessels"),
    THAL("Thalassemia")
}
