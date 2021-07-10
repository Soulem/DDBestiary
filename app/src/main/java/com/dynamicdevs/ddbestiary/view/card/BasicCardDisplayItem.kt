package com.dynamicdevs.ddbestiary.view.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dynamicdevs.ddbestiary.databinding.BasicCardDisplayItemBinding
import com.dynamicdevs.ddbestiary.util.Constants.Companion.NAME_KEY
import com.dynamicdevs.ddbestiary.view.activity.DetailedMonsterActivity

class BasicCardDisplayItem : AppCompatActivity() {
    private lateinit var binding: BasicCardDisplayItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BasicCardDisplayItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cardClick(view: View){
        var intent = Intent(this, DetailedMonsterActivity::class.java)
        intent.putExtra(NAME_KEY, binding.monsterNameTextViewBasic.text)
    }
}