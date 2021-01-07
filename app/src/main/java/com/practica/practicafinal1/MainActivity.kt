package com.practica.practicafinal1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragmenta.*
import kotlinx.android.synthetic.main.fragmentb.*
import kotlinx.android.synthetic.main.fragmentc.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicial)
    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }*/



    /*class HomeFragmentDirections private constructor() {
        private data class NextAction(val flowStepNumber: Int = 1) : NavDirections {
            override fun getActionId(): Int = R.id.next_action

            override fun getArguments(): Bundle {
                val result = Bundle()
                result.putInt("flowStepNumber", this.flowStepNumber)
                return result
            }
        }

        companion object {
            fun nextAction(flowStepNumber: Int = 1): NavDirections = NextAction(flowStepNumber)
        }
    }*/

    class FragmentA : Fragment() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragmenta, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            atob.setOnClickListener{
                findNavController().navigate(R.id.action_fragmenta_to_fragmentb)
            }
            atoc.setOnClickListener{
                findNavController().navigate(R.id.action_fragmenta_to_fragmentc)
            }

           /* val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            view.findViewById<Button>(R.id.atob)?.setOnClickListener {
                findNavController().navigate(R.id.fragmenta, null, options)
            }

            //view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
            //        Navigation.createNavigateOnClickListener(R.id.next_action, null)
            //)

            view.findViewById<Button>(R.id.atob)?.setOnClickListener {
                val flowStepNumberArg = 1
                val action = HomeFragmentDirections.nextAction(flowStepNumberArg)
                findNavController().navigate(action)
            }*/
        }


    }


    class FragmentB : Fragment() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragmentb, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            btoa.setOnClickListener{
                findNavController().navigate(R.id.action_fragmentb_to_fragmenta)
            }
            btoc.setOnClickListener{
                findNavController().navigate(R.id.action_fragmentb_to_fragmentc)
            }
        }



    }

    class FragmentC : Fragment() {




        override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragmentc, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            ctoa.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentc_to_fragmenta)
            }
            ctob.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentc_to_fragmentb)
            }
        }
    }




}