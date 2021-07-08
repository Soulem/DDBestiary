package com.dynamicdevs.ddbestiary.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.adapter.DisplayRecyclerViewAdapter
import com.dynamicdevs.ddbestiary.databinding.ActivityMainBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonstersResult
import com.dynamicdevs.ddbestiary.view.fragment.DisplayFragment
import com.dynamicdevs.ddbestiary.view.fragment.SearchFragment
import com.dynamicdevs.ddbestiary.viewmodel.ObjectViewModel

class MainActivity : AppCompatActivity()  {
    interface DisplayFragmentRecyclerInterface{
        fun updateAdapter(monsters : DDMonstersResult)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var displayFragment : DisplayFragment
    private lateinit var searchFragment: SearchFragment
    private val viewModel : ObjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //grabed the display fragment
        displayFragment = supportFragmentManager.findFragmentById(R.id.display_frameLayout) as DisplayFragment
        // the displayFragment is a DisplayFragmentRecyclerInterface
        // so we store the displayFragment in that interface variable
        val displayFragRecyclerView : DisplayFragmentRecyclerInterface = displayFragment

        //set up the viewModel
        viewModel.setDatabase(this)
        //make the call to get ALL MONSTERS
        viewModel.getMonsters()
        //observe the data for when it changes.
        viewModel.monstersLiveData.observe(this, Observer{
            //now, in our display model, we update our addapter, pasing in our result
            displayFragRecyclerView.updateAdapter(it)

        })
    }

}