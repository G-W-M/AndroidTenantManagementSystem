package com.mobile.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mobile.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null

    private val binding: FragmentViewTenantsBinding
        get() = _binding!!

    // Receive the argument declared in nav_graph.xml.
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val newTenant = args.newTenant

        // Supply the tenant to the Data Binding layout.
        binding.tenant = newTenant

        // Hide the "Just added" section if no tenant was passed.
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // Display all tenants stored in the repository.
        val tenants = TenantRepository.tenants

        binding.allTenantsTextView.text =
            if (tenants.isEmpty()) {
                "No tenants yet. Add one from the Dashboard."
            } else {
                tenants.joinToString("\n\n") { it.summary() }
            }

        // Open the dialer with the newly added tenant's phone number.
        binding.callButton.setOnClickListener {
            if (newTenant != null) {
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:${newTenant.phone}")
                )

                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}