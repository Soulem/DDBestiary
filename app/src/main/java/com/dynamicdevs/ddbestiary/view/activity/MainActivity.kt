package com.dynamicdevs.ddbestiary.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.databinding.ActivityMainBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonstersResult
import com.dynamicdevs.ddbestiary.util.Constants
import com.dynamicdevs.ddbestiary.view.delegate.SearchMonsterDelegate
import com.dynamicdevs.ddbestiary.view.fragment.DisplayFragment
import com.dynamicdevs.ddbestiary.view.fragment.SearchFragment
import com.dynamicdevs.ddbestiary.viewmodel.ObjectViewModel

class MainActivity : AppCompatActivity(), SearchMonsterDelegate {
    interface DisplayFragmentRecyclerInterface{
        fun updateAdapter(monsters : DDMonstersResult)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var displayFragment : DisplayFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var viewModel : ObjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root)
            .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
            .load(R.drawable.paper_texture)
            .into(binding.backgroundMainIv)


        //grabed the display fragment
        displayFragment = supportFragmentManager.findFragmentById(R.id.display_frameLayout) as DisplayFragment
        searchFragment = supportFragmentManager.findFragmentById(R.id.search_frameLayout) as SearchFragment
        displayFragment.setAdapterSerchMonsterDelegate(this)
        searchFragment.setSearchMonsterDelegate(this)
        viewModel = ObjectViewModel.instance
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

    override fun searchForMonster(monsterName: String) {
        var hasChanged : Boolean = false
        viewModel.searchForMonster(monsterName.lowercase())
        viewModel.monsterLiveData.observe(this, Observer{ monsterResult ->
            var intent = Intent(this, DetailedMonsterActivity::class.java)
            //intent.putExtra(Constants.NAME_KEY, monsterResult)
            Log.d("TAG_X", "searched for $monsterName")
            startActivity(intent)
        })

        /*if (!hasChanged){
            searchFragment = supportFragmentManager.findFragmentById(R.id.search_frameLayout) as SearchFragment
            searchFragment.showError()
            /*val tempToast = Toast.makeText(this, "That monster does not exist, please search for a different monster.", Toast.LENGTH_LONG)
            tempToast.setGravity(Gravity.TOP,0, 0 )
            tempToast.show()*/
        }*/
    }

}