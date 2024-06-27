package com.example.clicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clicker.databinding.FragmentClickerBinding

class ClickerFragment : Fragment() {

    lateinit var binding: FragmentClickerBinding
    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnPlusOne.setOnClickListener {
            count++
            tvResult.text = count.toString()
            if (tvResult.text.toString() == "10") {
                val bundle = Bundle()
                val secondFragment = SecondFragment()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.conteiner, secondFragment).addToBackStack(null).commit()
            }


        }
        btnMinosOne.setOnClickListener {
            count--

            tvResult.text = count.toString()
        }
    }

}