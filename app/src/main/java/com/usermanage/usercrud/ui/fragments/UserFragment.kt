package com.usermanage.usercrud.ui.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usermanage.usercrud.R
import com.usermanage.usercrud.databinding.FragmentUserBinding
import com.usermanage.usercrud.ui.adapters.UserAdapter
import com.usermanage.usercrud.ui.viewmodels.UserViewModel
import com.usermanage.usercrud.utils.Constants.BUNDLE_KEY_FROM_EDIT_USER
import com.usermanage.usercrud.utils.Constants.BUNDLE_KEY_FROM_WHERE
import com.usermanage.usercrud.utils.Injector
import com.usermanage.usercrud.utils.enums.ActionEnum
import com.usermanage.usercrud.utils.enums.FromWhereEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private lateinit var adapter: UserAdapter
    private val viewModel: UserViewModel by viewModels {
        Injector.getViewModelFactory(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val fragmentBinding = FragmentUserBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerview()

        binding.idLoadingPB.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {

            viewModel.getAllUsers().observe(requireActivity()) {

                binding.idLoadingPB.visibility = View.GONE

                if (it.isNullOrEmpty()) {
                    binding.apply {
                        rvUser.visibility = View.GONE
                        llSearch.visibility = View.GONE
                        emptyLayout.visibility = View.VISIBLE

                    }

                } else {
                    binding.apply {
                        rvUser.visibility = View.VISIBLE
                        llSearch.visibility = View.VISIBLE
                        emptyLayout.visibility = View.GONE

                    }
                    adapter.updateUsers(it)
                }

            }
        }


        //insert user
        binding.addFab.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY_FROM_WHERE, FromWhereEnum.ADD.name)
            findNavController().navigate(R.id.action_userFragment_to_editUserFragment, bundle)


        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                viewModel.searchUsersByName(s.toString()).observe(requireActivity(), Observer {
                    it?.let {
                        adapter.updateUsers(it)
                    }
                })

            }

        })

    }

    private fun initRecyclerview() {

        binding.rvUser.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter = UserAdapter { user, action ->
            when (action) {
                ActionEnum.EDIT -> {

                    val bundle = Bundle()
                    bundle.putString(BUNDLE_KEY_FROM_WHERE, FromWhereEnum.EDIT.name)
                    bundle.putParcelable(BUNDLE_KEY_FROM_EDIT_USER, user)
                    findNavController().navigate(
                        R.id.action_userFragment_to_editUserFragment,
                        bundle
                    )


                }

                ActionEnum.DELETE -> {
                    viewModel.deleteUser(user)


                }
            }
        }
        binding.rvUser.adapter = adapter


    }


}