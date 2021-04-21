package com.example.greeting_card.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.greeting_card.R
import com.example.greeting_card.databinding.FragmentMainBinding
import com.example.greeting_card.ui.card.CardFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: InformationViewModel
    private var position: Int = 0
    private val arrayImageSwitcher = arrayOf(
        R.drawable.fjb1,
        R.drawable.fjb2,
        R.drawable.fjb3,
        R.drawable.fjb4
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(InformationViewModel::class.java)
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainScreenButtonLaunch.setOnClickListener { verificationEditText() }
        switchImage()
    }

    private fun verificationEditText() {
        if (binding.mainScreenInputName.text.toString() == "" || binding.mainScreenTitle.text.toString() == "" || binding.mainScreenText.text.toString() == "") {
            Toast.makeText(context, "Не все поля заполнины ", Toast.LENGTH_SHORT).show()
        } else {
            val bundle = bundleOf(
                CardFragment.BUNDLE_NAME to binding.mainScreenInputName.text.toString(),
                CardFragment.BUNDLE_TITLE to binding.mainScreenTitle.text.toString(),
                CardFragment.BUNDLE_TEXT to binding.mainScreenText.text.toString()
            )
            binding.mainScreenButtonLaunch.setOnClickListener {
                findNavController().navigate(R.id.action_mainScreen_to_card, bundle)
            }
        }
    }

    private fun switchImage() {
        val imageSwitcher = binding.mainScreenImageSwitcher

        when {

            R.id.buttonNext.equals(setPositionNext()) -> imageSwitcher.setImageResource(
                arrayImageSwitcher[position]
            )
            R.id.buttonBack.equals(setPositionBack()) -> imageSwitcher.setImageResource(
                arrayImageSwitcher[position]
            )
        }
    }

    private fun setPositionNext() {
        position++
        if (position > arrayImageSwitcher.size - 1) {
            position = 0
        }
    }

    private fun setPositionBack() {
        position--
        if (position < 0) {
            position = arrayImageSwitcher.size - 1
        }
    }
}

