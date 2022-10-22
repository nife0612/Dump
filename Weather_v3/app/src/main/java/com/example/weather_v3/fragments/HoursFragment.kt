package com.example.weather_v3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.weather_v3.R
import com.example.weather_v3.adapters.WeatherAdapter
import com.example.weather_v3.adapters.WeatherModel
import com.example.weather_v3.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {

    private lateinit var binding : FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        val list = listOf(
            WeatherModel("","12:00","Sunny","25°C","","","",""),
            WeatherModel("","13:00","Sunny","23°C","","","",""),
            WeatherModel("","14:00","Sunny","28°C","","","","")
        )
        rcView.adapter = adapter

        adapter.submitList(list)
    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()

    }
}