package com.example.mini_proect.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_proect.DataBase.All_Devices_Entity
import com.example.mini_proect.DataBase.All_Devices_view_Model
import com.example.mini_proect.R


class all_devices : Fragment() {

    private lateinit var viewModel: All_Devices_view_Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_all_devices, container, false)
        intiData(view)

        return view
    }


    private fun intiData(view: View) {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
        ).get(All_Devices_view_Model::class.java)

        viewModel.getDeviceDetails(requireContext())!!.observe(requireActivity(), Observer {

            val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
            var recycle: RecyclerView = recycler
            var LLM: LinearLayoutManager = LinearLayoutManager(context)
            LLM.orientation = RecyclerView.VERTICAL
            recycle.layoutManager = LLM
            var adapter = context?.let { it1 -> Adapter(it1,it) }
            recycle.adapter = adapter


        })
    }


}