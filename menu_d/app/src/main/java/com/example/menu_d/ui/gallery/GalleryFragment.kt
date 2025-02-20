package com.example.menu_d.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menu_d.R
import com.example.menu_d.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    // Declare UI elements
    private lateinit var inputMaterials: EditText
    private lateinit var suggestButton: Button
    private lateinit var suggestionResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize UI elements
        inputMaterials = binding.root.findViewById(R.id.input_materials)
        suggestButton = binding.root.findViewById(R.id.btn_suggest)
        suggestionResult = binding.root.findViewById(R.id.suggestion_result)

        // Set up onClickListener for the Suggest button
        suggestButton.setOnClickListener {
            val materials = inputMaterials.text.toString()

            if (materials.isNotEmpty()) {
                // Call a function to suggest based on materials input (for now, just show the input)
                val suggestion = "Suggestions for your materials: $materials"
                suggestionResult.text = suggestion
            } else {
                suggestionResult.text = "Please enter some materials."
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
