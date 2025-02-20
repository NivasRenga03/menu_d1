package com.example.menu_d.explore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menu_d.R
import com.example.menu_d.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ExploreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        val imageList = listOf(
            ExploreItem(R.drawable.img_1, "Stony Toy"),
            ExploreItem(R.drawable.img_3, "Glass Lamp"),
            ExploreItem(R.drawable.img_4, "Flower Decor"),
            ExploreItem(R.drawable.img_5, "Beaded Frame")
        )

        adapter = ExploreAdapter(requireContext(), imageList)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}
