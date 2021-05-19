package ec.edu.ups.appcongreso

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import ec.edu.ups.appcongreso.databinding.FragmentLoginBinding
import ec.edu.ups.appcongreso.databinding.FragmentRegistrarBinding


class RegistrarFragment : Fragment() {

    private lateinit var binding: FragmentRegistrarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rw = ReadWrite(this.requireContext())

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registrar, container, false)

        var nombre = binding.nombre.text

        var apellido = binding.apellido.text

        var usuario = binding.ususario.text

        var contra = binding.contrasena.text


        var res = ReadWrite(this.requireContext())

        val operationList = rw.readHistory()

        val adapter = Adapter(this.requireContext(), operationList)

        binding.registrar.setOnClickListener { view: View ->

            //view.findNavController().navigate(R.id.action_homeFragment_to_dataFragment)

            var enviar = nombre.toString() + "," + apellido.toString() + "," + usuario.toString() + "," + contra.toString()

            operationList.add(enviar)

            rw.writeHistory(operationList)


            view.findNavController().navigate(R.id.action_registrarFragment_to_homeFragment)


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