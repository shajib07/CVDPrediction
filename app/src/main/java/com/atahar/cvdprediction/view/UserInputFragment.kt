package com.atahar.cvdprediction.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.atahar.cvdprediction.R
import com.atahar.cvdprediction.UserInputViewModel
import com.atahar.cvdprediction.databinding.FragmentUserInputBinding
import com.atahar.cvdprediction.utils.AppConstants.CVD_STATUS
import com.atahar.cvdprediction.utils.AppConstants.SAMPLE_INPUT
import com.atahar.cvdprediction.utils.CVDHelper
import com.atahar.cvdprediction.utils.HelperFunction

class UserInputFragment : Fragment() {

    private val inputViewModel: UserInputViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserInputBinding.inflate(inflater)
        binding.viewModel = inputViewModel

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (requireArguments().getBoolean(SAMPLE_INPUT)) {
            inputViewModel.setSampleInput()
        }

        binding.submitBtn.setOnClickListener {
            if (inputViewModel.inputComplete.value == true) {
                openUserStatusFragment()
            } else {
                HelperFunction.showErrorMessage(binding.root, getString(R.string.select_all_values))
            }
        }

        return binding.root
    }

    private fun openUserStatusFragment() {
        val heartRiskStatus =
            CVDHelper.buildUCIModel(requireContext(), inputViewModel.getUciHeartModel())

        findNavController().navigate(
            R.id.action_userInputFragment_to_userStatusFragment,
            bundleOf(CVD_STATUS to heartRiskStatus)
        )
    }
}