package com.dynamicdevs.ddbestiary.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dynamicdevs.ddbestiary.adapter.DisplayRecyclerViewAdapter
import com.dynamicdevs.ddbestiary.databinding.FragmentDisplayBinding
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonstersResult
import com.dynamicdevs.ddbestiary.model.data.dd.monster.Result
import com.dynamicdevs.ddbestiary.view.activity.MainActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayFragment : Fragment(), MainActivity.DisplayFragmentRecyclerInterface {
    private lateinit var binding: FragmentDisplayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayBinding.inflate(layoutInflater)
        return binding.root
    }

    private val adapter = DisplayRecyclerViewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.displayRecyclerView.adapter = adapter

    }

    private fun updateList(list: List<Result>) {
        adapter.apiList = list
    }

    override fun updateAdapter(monsters: DDMonstersResult) {
        //MAKE SURE WE SET THE LIST OF RESULTS TO THE LIST IN OUR ADAPTOR
        updateList(monsters.results)
    }


//----------------------------------------------------------------------------
//    private lateinit var binding: FragmentDisplayBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDisplayBinding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    private val adapter = DisplayRecyclerViewAdapter()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.displayRecyclerView.adapter = adapter
//    }
//
//    fun updateList(list: List<DDMonsterResult>) {
//        adapter.apiList = list
//    }



    //--------------------------------------------------------------------------------


//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_display, container, false)
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment DisplayFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            DisplayFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}