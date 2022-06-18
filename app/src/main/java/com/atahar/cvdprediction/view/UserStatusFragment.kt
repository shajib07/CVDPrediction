package com.atahar.cvdprediction.view

import android.graphics.Color
import android.graphics.Color.red
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atahar.cvdprediction.R
import com.atahar.cvdprediction.databinding.FragmentUserStatusBinding
import com.atahar.cvdprediction.utils.AppConstants.CVD_STATUS
import com.atahar.cvdprediction.utils.AppConstants.SAMPLE_INPUT

class UserStatusFragment : Fragment() {

    private lateinit var binding: FragmentUserStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserStatusBinding.inflate(inflater)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        setStatusText(requireArguments().getInt(CVD_STATUS))

        binding.checkBtn.setOnClickListener {
            openUserInputFragment(false)
        }

        binding.sampleInputBtn.setOnClickListener {
            openUserInputFragment(true)
        }

        return binding.root
    }

    private fun openUserInputFragment(sampleInput: Boolean) {
        findNavController().navigate(
            R.id.action_userStatusFragment_to_userInputFragment,
            bundleOf(SAMPLE_INPUT to sampleInput)
        )
    }

    private fun setStatusText(status: Int) {
        when (status) {
            1 -> {
                binding.statusText.text = getString(R.string.cvd_risk_text)
                binding.statusText.setTextColor(Color.RED)
            }
            0 -> {
                binding.statusText.text = getString(R.string.cvd_no_risk_text)
                binding.statusText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.web_sfe)
                )
            }
            else -> {
                binding.statusText.text = getString(R.string.welcome_text)
                binding.statusText.setTextColor(
                    ContextCompat.getColor(requireContext(), androidx.constraintlayout.widget.R.color.primary_text_default_material_light)
                )
            }
        }
    }
}