package com.dynamicdevs.ddbestiary.view.activity

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.dynamicdevs.ddbestiary.R
import com.dynamicdevs.ddbestiary.databinding.ActivityDetailedMonsterBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.*
import com.dynamicdevs.ddbestiary.viewmodel.ObjectViewModel
import java.util.*

class DetailedMonsterActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityDetailedMonsterBinding
    private lateinit var result: DDMonsterResult
    private lateinit var viewModel : ObjectViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailedMonsterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root)
            .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
            .load(R.drawable.paper_texture)
            .into(binding.backgroundDetailedIv)


        viewModel = ObjectViewModel.instance

        val emptyList : List<Any> = emptyList()
        val emptySense : Senses =  Senses("", "", 0)
        val emptySpeed : Speed = Speed("", "", "")
        var monster: DDMonsterResult = viewModel.monsterLiveData.value ?: DDMonsterResult(
            emptyList as List<Action>,
            "",
            0,
            0,
            0,
            emptyList,
            0,
            emptyList as List<String>,
            emptyList,
            emptyList,
            0,
            "",
            0,
            "",
            0,
            "",
            emptyList as List<LegendaryAction>,
            "",
            emptyList as List<Proficiency>,
            emptySense,
            "",
            emptyList as List<SpecialAbility>,
            emptySpeed,
            0,
            "",
            "",
            "",
            0,
            0
        )

        //Log.d("TAG_X", "monster gotten from search is $monster")


            binding.monsterNameTextView.text = "Name: ${monster.name?:""}"
            binding.monsterTypeTextView.text = "Type: ${monster.type?:""}"
            binding.monsterSubtypeTextView.text = "Subtype: ${monster.subtype?:""}"
            binding.monsterXpTextView.text = "XP: ${monster.xp?:""}"

            binding.strengthTextView.text = "STR: ${monster.strength?:""}"
            binding.dexterityTextView.text = "DEX: ${monster.dexterity?:""}"
            binding.constitutionTextView.text = "CON: ${monster.constitution?:""}"
            binding.intelligenceTextView.text = "INT: ${monster.intelligence?:""}"
            binding.wisdomTextView.text = "WIS: ${monster.wisdom?:""}"
            binding.charismaTextView.text = "CHA: ${monster.charisma?:""}"

            binding.monsterChallengeRatingTextView.text = "Challenge Rating: ${monster.challenge_rating?:""}"
            binding.monsterAcTextView.text = "AC: ${monster.armor_class?:""}"
            binding.monsterHpTextView.text = "HP: ${monster.hit_points?:""}"
            binding.monsterHitdiceTextView.text = "Hit Dice: ${monster.hit_dice?:""}"
            binding.monsterAlignmentTextView.text = "Alignment: ${monster.alignment?:""}"
            binding.monsterSizetTextView.text = "Size: ${monster.size?:""}"

            binding.languageResultsTextVeiw.text = monster.languages?:""
            binding.languageResultsTextVeiw.movementMethod = ScrollingMovementMethod()
            binding.senseResultsTextVeiw.text = monster.senses.toString()?:""
            binding.senseResultsTextVeiw.movementMethod = ScrollingMovementMethod()

            val abilitiesStringBuilder = StringBuilder()
            monster.special_abilities.forEach {
                abilitiesStringBuilder.append(it.toString()?:"").append("\n")
            }
            binding.abilitiesResultsTextView.text = abilitiesStringBuilder.toString()?:""
            binding.abilitiesResultsTextView.movementMethod = ScrollingMovementMethod()

            val proficienciesStringBuilder = StringBuilder()
            monster.proficiencies.forEach {
                proficienciesStringBuilder.append(it.toString()?:"").append("\n")
            }
            binding.proficienciesResultsTextView.text = proficienciesStringBuilder.toString()?:""
            binding.proficienciesResultsTextView.movementMethod = ScrollingMovementMethod()

            val actionsStringBuilder = StringBuilder()
            monster.actions.forEach {
                actionsStringBuilder.append(it.toString()?:"").append("\n")
            }
            /*monster.legendary_actions.forEach {
                actionsStringBuilder.append(it.toString()).append("\n")
            }*/
            binding.actionsResultsTextView.text = actionsStringBuilder.toString()?:""
            binding.actionsResultsTextView.movementMethod = ScrollingMovementMethod()

            val conditionsStringBuilder = StringBuilder()
            monster.condition_immunities.forEach {
                conditionsStringBuilder.append(it.toString()?:"").append("\n")
            }
            monster.damage_immunities.forEach {
                conditionsStringBuilder.append(it.toString()?:"").append("\n")
            }
            monster.damage_resistances.forEach {
                conditionsStringBuilder.append(it.toString()?:"").append("\n")
            }
            monster.damage_vulnerabilities.forEach {
                conditionsStringBuilder.append(it.toString()?:"").append("\n")
            }
            binding.conditionDamageResultsTextView.text = conditionsStringBuilder.toString()?:""
            binding.conditionDamageResultsTextView.movementMethod = ScrollingMovementMethod()

    }
}