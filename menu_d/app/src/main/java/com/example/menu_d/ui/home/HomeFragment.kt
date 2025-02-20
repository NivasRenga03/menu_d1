package com.example.menu_d.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menu_d.R
import com.example.menu_d.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inflate the layout using the ViewBinding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Bind your views from the layout
        val craftImage: ImageView = binding.craftImage
        val craftTitle: TextView = binding.craftTitle
        val craftDescription: TextView = binding.craftDescription
        val materialsTitle: TextView = binding.materialsTitle
        val materialsList: TextView = binding.materialsList
        val instructionsTitle: TextView = binding.instructionsTitle
        val instructionsList: TextView = binding.instructionsList
        val startCraftButton: Button = binding.startCraftButton

        // Observe the LiveData from the ViewModel
        homeViewModel.text.observe(viewLifecycleOwner) {
            // Example of updating the TextViews with data
            craftTitle.text = it
            // Add other data bindings as needed
        }

        // Example: Set some static data or use ViewModel data for other views
        craftDescription.text = getString(R.string.craft_description)
        materialsList.text = getString(R.string.materials_list)
        instructionsList.text = getString(R.string.instructions_list)

        // Set up the button click listener
        startCraftButton.setOnClickListener {
            // Handle button click here (e.g., navigate to another fragment or activity)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
