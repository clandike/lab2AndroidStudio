package com.example.testapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView

class FragmentMainList : Fragment() {

    val args: Fragment by navArgs()

    lateinit var adapter: AdapterForMainList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AdapterForMainList{myCar, position ->
            Toast.makeText(requireContext(),"Click btn №$position",Toast.LENGTH_LONG).show()
            findNavController().navigate(FragmentMainListDirections.mainToDescription())
        }
        adapter.setNewData(createCars())
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.adapter = adapter
    }

    fun createCars(): List<MyCar> {
        return listOf(
            MyCar("BMW M4 Competition", "BMW", "This is BMW", "Beautiful car"),
            MyCar("Mercedes CLS", "Mercedes", "This is Mercedes", "Beautiful car"),
            MyCar("BMW X5", "BMW", "This is BMW", "Beautiful car")
        )
    }
}