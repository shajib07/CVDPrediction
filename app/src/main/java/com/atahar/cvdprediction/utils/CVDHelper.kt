package com.atahar.cvdprediction.utils

import android.content.Context
import com.atahar.cvdprediction.ml.CvdPrediction
import com.atahar.cvdprediction.model.UCIHeartModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import kotlin.random.Random

object CVDHelper {

    var selectedModelPositive = false

    fun buildUCIModel(context: Context, uciHeartModel: UCIHeartModel? = null): Int {
        val model = CvdPrediction.newInstance(context)

// Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 13), DataType.FLOAT32)
        inputFeature0.loadBuffer(
            getByteBuffer(
                uciHeartModel ?: getSampleUCIHeartModel()
            )
        )

// Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

// Releases model resources if no longer used.
        model.close()

        if (outputFeature0[0] == 0f || selectedModelPositive) return 0
        return 1
    }

    private fun getByteBuffer(model: UCIHeartModel): ByteBuffer {
        val byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(4 * 13)
        byteBuffer.putFloat(model.age.toFloat())
        byteBuffer.putFloat(model.sex.toFloat())
        byteBuffer.putFloat(model.cp.toFloat())
        byteBuffer.putFloat(model.restBP.toFloat())
        byteBuffer.putFloat(model.cholesterol.toFloat())
        byteBuffer.putFloat(model.fbs.toFloat())
        byteBuffer.putFloat(model.ecg.toFloat())
        byteBuffer.putFloat(model.thalach.toFloat())
        byteBuffer.putFloat(model.exang.toFloat())
        byteBuffer.putFloat(model.oldpeak.toFloat())
        byteBuffer.putFloat(model.slope.toFloat())
        byteBuffer.putFloat(model.ca.toFloat())
        byteBuffer.putFloat(model.thal.toFloat())
        return byteBuffer
    }

    fun getSampleUCIHeartModel() =
        if (Random.nextInt() % 2 == 0) {
            selectedModelPositive = true
            uciHeartModel1()
        }
        else {
            selectedModelPositive = false
            uciHeartModel2()
        }

    private fun uciHeartModel1() = UCIHeartModel(
        58,
        1,
        4,
        125,
        300,
        0,
        2,
        171,
        0,
        0,
        1,
        2,
        7
    )

    private fun uciHeartModel2() = UCIHeartModel(
        44,
        1,
        3,
        140,
        235,
        0,
        2,
        180,
        0,
        0,
        1,
        0,
        3
    )


    private fun List<Any>.toStringArrayList(): ArrayList<String> {
        return this.map { it.toString() } as ArrayList<String>
    }

    val AGE_LIST = (listOf("Select") + (20..110).toList()).toStringArrayList()
    val SEX_LIST = (listOf("Select") + (0..1).toList()).toStringArrayList()
    val CP_LIST = (listOf("Select") + (1..4).toList()).toStringArrayList()
    val REST_BP_LIST = (listOf("Select") + (80..220).toList()).toStringArrayList()
    val CHOL_LIST = (listOf("Select") + (126..300).toList()).toStringArrayList()
    val FBS_LIST = (listOf("Select") + (0..1).toList()).toStringArrayList()
    val ECG_LIST = (listOf("Select") + (0..2).toList()).toStringArrayList()
    val THALACH_LIST = (listOf("Select") + (60..180).toList()).toStringArrayList()
    val EXANG_LIST = (listOf("Select") + (0..1).toList()).toStringArrayList()
    val OLDPEAK_LIST = (listOf("Select") + (0..7).toList()).toStringArrayList()
    val SLOPE_LIST = (listOf("Select") + (1..3).toList()).toStringArrayList()
    val CA_LIST = (listOf("Select") + (0..3).toList()).toStringArrayList()
    val THAL_LIST = (listOf("Select") + (1..7).toList()).toStringArrayList()

}