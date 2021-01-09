package cat.copernic.finalsergiomejias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragmenta.*
import kotlinx.android.synthetic.main.fragmentb.*
import kotlinx.android.synthetic.main.fragmentc.*
import android.view.MenuItem
//import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.practica.practicafinal1.R

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicial)

        /*val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment? ?: return
        setSupportActionBar(toolbar)

        // Set up Action Bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)


        // You should also remove the old appBarConfiguration setup above
        val drawerLayout : DrawerLayout? = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmenta, R.id.fragmenta),
            drawerLayout)

        setupActionBar(navController, appBarConfiguration)

        setupNavigationMenu(navController)

        setupBottomNavMenu(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                Integer.toString(destination.id)
            }

            Toast.makeText(this@MainActivity, "Navigated to $dest",
                Toast.LENGTH_SHORT).show()
            Log.d("NavigationActivity", "Navigated to $dest")
        }*/

    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        val navigationView = findViewById<NavigationView>(androidx.navigation.ui.R.id.nav_view)
        // The NavigationView already has these same navigation items, so we only add
        // navigation items to the menu here if there isn't a NavigationView
        if (navigationView == null) {
            menuInflater.inflate(androidx.navigation.ui.R.menu.overflow_menu, menu)
            return true
        }*/


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.fragmenta))
                || super.onOptionsItemSelected(item)
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


    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.fragmenta)
        bottomNav?.setupWithNavController(navController)
    }

    private fun setupNavigationMenu(navController: NavController) {
//        // In split screen mode, you can drag this view out from the left
//        // This does NOT modify the actionbar
        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
        sideNavView?.setupWithNavController(navController)
    }

    private fun setupActionBar(navController: NavController,
                               appBarConfig : AppBarConfiguration) {
//        // This allows NavigationUI to decide what label to show in the action bar
//        // By using appBarConfig, it will also determine whether to
//        // show the up arrow or drawer menu icon
        setupActionBarWithNavController(navController, appBarConfig)
    }

}