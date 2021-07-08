package com.dynamicdevs.ddbestiary.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.databinding.ActivityDetailedMonsterBinding
import com.dynamicdevs.ddbestiary.databinding.ActivityMainBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult
import com.dynamicdevs.ddbestiary.util.Constants.DND5eAPICONSTANTS.NAME_KEY
import com.dynamicdevs.ddbestiary.view.fragment.DisplayFragment
import com.dynamicdevs.ddbestiary.view.fragment.SearchFragment
import com.dynamicdevs.ddbestiary.viewmodel.ObjectViewModel

class DetailedMonsterActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityDetailedMonsterBinding
    private lateinit var result: DDMonsterResult
    private val viewModel : ObjectViewModel by viewModels()


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailedMonsterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val extras: Bundle? = Intent().extras
        val monster: String? = extras?.getString(NAME_KEY)

        monster?.let {
            viewModel.searchForMonster(it)
        }

        viewModel.monsterLiveData.observe(this, Observer {
            result = it[0]


            Glide.with(this)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.url)
                .into(binding.monsterImageView)

            binding.monsterNameTextView.text = "Name: ${result.name}"
            binding.monsterTypeTextView.text = "Type: ${result.type}"
            binding.monsterSubtypeTextView.text = "Subtype: ${result.subtype}"
            binding.monsterXpTextView.text = "XP: ${result.xp}"

            binding.strengthTextView.text = "STR: ${result.strength}"
            binding.dexterityTextView.text = "DEX: ${result.dexterity}"
            binding.constitutionTextView.text = "CON: ${result.constitution}"
            binding.intelligenceTextView.text = "INT: ${result.intelligence}"
            binding.wisdomTextView.text = "WIS: ${result.wisdom}"
            binding.charismaTextView.text = "CHA: ${result.charisma}"

            binding.monsterChallengeRatingTextView.text = "Challenge Rating: ${result.challenge_rating}"
            binding.monsterAcTextView.text = "AC: ${result.armor_class}"
            binding.monsterHpTextView.text = "HP: ${result.hit_points}"
            binding.monsterHitdiceTextView.text = "Hit Dice: ${result.hit_dice}"
            binding.monsterAlignmentTextView.text = "Alignment: ${result.alignment}"
            binding.monsterSizetTextView.text = "Size: ${result.size}"

            binding.languageResultsTextVeiw.text = result.languages
            binding.senseResultsTextVeiw.text = result.senses.toString()

            val abilitiesStringBuilder = StringBuilder()
            result.special_abilities.forEach {
                abilitiesStringBuilder.append(it.toString()).append("\n")
            }
            binding.abilitiesResultsTextView.text = abilitiesStringBuilder.toString()
            binding.abilitiesResultsTextView.movementMethod = ScrollingMovementMethod()

            val proficienciesStringBuilder = StringBuilder()
            result.proficiencies.forEach {
                proficienciesStringBuilder.append(it.toString()).append("\n")
            }
            binding.proficienciesResultsTextView.text = proficienciesStringBuilder.toString()
            binding.proficienciesResultsTextView.movementMethod = ScrollingMovementMethod()

            val actionsStringBuilder = StringBuilder()
            result.legendary_actions.forEach {
                actionsStringBuilder.append(it.toString()).append("\n")
            }
            result.actions.forEach {
                actionsStringBuilder.append(it.toString()).append("\n")
            }
            binding.actionsResultsTextView.text = actionsStringBuilder.toString()
            binding.actionsResultsTextView.movementMethod = ScrollingMovementMethod()

            val conditionsStringBuilder = StringBuilder()
            result.condition_immunities.forEach {
                conditionsStringBuilder.append(it.toString()).append("\n")
            }
            result.damage_immunities.forEach {
                conditionsStringBuilder.append(it.toString()).append("\n")
            }
            result.damage_resistances.forEach {
                conditionsStringBuilder.append(it.toString()).append("\n")
            }
            result.damage_vulnerabilities.forEach {
                conditionsStringBuilder.append(it.toString()).append("\n")
            }
            binding.conditionDamageResultsTextView.text = conditionsStringBuilder.toString()
            binding.conditionDamageResultsTextView.movementMethod = ScrollingMovementMethod()



        })

    }
}