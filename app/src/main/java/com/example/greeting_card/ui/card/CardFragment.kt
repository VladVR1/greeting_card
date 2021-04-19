package com.example.greeting_card.ui.card


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greeting_card.databinding.FragmentCardBinding

class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString(BUNDLE_NAME)
        val text = arguments?.getString(BUNDLE_TEXT)
        val title = arguments?.getString(BUNDLE_TITLE)
        binding.cardName.text = name
        binding.cardText.text = text
        binding.cardTitle.text = title
    }

    companion object {
        const val BUNDLE_TITLE = "title"
        const val BUNDLE_TEXT = "text"
        const val BUNDLE_NAME = "name"

    }
}