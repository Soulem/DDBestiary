package com.dynamicdevs.ddbestiary.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.databinding.FragmentSearchBinding
import com.dynamicdevs.ddbestiary.view.delegate.SearchMonsterDelegate
import com.google.android.material.internal.VisibilityAwareImageButton

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
//    private lateinit var databaseDelegate: DatabaseDelegate
    private lateinit var searchMonsterDelegate: SearchMonsterDelegate

//    interface DatabaseDelegate{
//        fun insertNewMonster(monster:DDMonsterResult)
//        fun removeMonster(monster:DDMonsterResult)
//    }
    fun setSearchMonsterDelegate(searchMonsterDelegate: SearchMonsterDelegate){
        this.searchMonsterDelegate = searchMonsterDelegate
    }

    fun showError(){
        binding.errorTextView.visibility = View.VISIBLE
        Thread(Runnable{
            Thread.sleep(3500)
            binding.errorTextView.visibility = View.INVISIBLE
        }).start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view:View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        binding.searchButton.setOnClickListener{
            val monsterName = binding.monsterNameEditText.text.toString().trim()

            searchMonsterDelegate.searchForMonster(monsterName);
        }

    }
}