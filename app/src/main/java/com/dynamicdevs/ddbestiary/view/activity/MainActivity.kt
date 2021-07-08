package com.dynamicdevs.ddbestiary.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.databinding.ActivityMainBinding
import com.dynamicdevs.ddbestiary.view.fragment.DisplayFragment
import com.dynamicdevs.ddbestiary.view.fragment.SearchFragment
import com.dynamicdevs.ddbestiary.viewmodel.ObjectViewModel

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    private lateinit var displayFragment : DisplayFragment
    private lateinit var searchFragment: SearchFragment
    private val viewModel : ObjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayFragment = supportFragmentManager.findFragmentById(R.id.display_frameLayout) as DisplayFragment

        viewModel.setDatabase(this)
        viewModel.getMonsters()
    }

}