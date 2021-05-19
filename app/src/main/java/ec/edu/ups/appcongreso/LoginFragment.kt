package ec.edu.ups.appcongreso

import android.R.string
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import ec.edu.ups.appcongreso.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        var rw = ReadWrite(this.requireContext())

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        var user = binding.user.text.toString()

        var pass = binding.password.text.toString()

        print("1")

        binding.login.setOnClickListener { view: View ->

            val operationList = rw.readHistory()

            for (item in operationList) {
                //val stringArray: Array<String> = item.split(",")
            }


            //val adapter = Adapter(this.requireContext(), operationList)

            //binding.historial.adapter = adapter


            view.findNavController().navigate(R.id.action_loginFragment_to_loggedFragment)


        }




        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.about, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

}