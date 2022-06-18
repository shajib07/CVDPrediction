package com.atahar.cvdprediction.model

enum class CVDStatus(val cvdStatus: Int) {
    NO_RISK(0),
    RISK(1),
    INVALID(-1)
}