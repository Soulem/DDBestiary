package com.dynamicdevs.ddbestiary.view.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dynamicdevs.ddbestiary.databinding.CardDisplayItemBinding
import com.dynamicdevs.ddbestiary.util.Constants.Companion.NAME_KEY
import com.dynamicdevs.ddbestiary.view.activity.DetailedMonsterActivity

class CardDisplayItem : AppCompatActivity() {
    private lateinit var binding: CardDisplayItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CardDisplayItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cardClick(view: View){
        var intent = Intent(this, DetailedMonsterActivity::class.java)
        intent.putExtra(NAME_KEY, binding.nameTextView.text)
    }
}