package com.usermanage.usercrud.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usermanage.usercrud.R
import com.usermanage.usercrud.databinding.FragmentUserBinding
import com.usermanage.usercrud.ui.adapters.UserAdapter
import com.usermanage.usercrud.ui.viewmodels.UserViewModel
import com.usermanage.usercrud.utils.Constants.BUNDLE_KEY_FROM_EDIT_USER
import com.usermanage.usercrud.utils.Constants.BUNDLE_KEY_FROM_WHERE
import com.usermanage.usercrud.utils.Injector
import com.usermanage.usercrud.utils.enums.Action
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

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getAllUsers().observe(requireActivity()) {
                adapter.updateUsers(it)
            }
        }

        //insert user
        binding.addFab.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY_FROM_WHERE, FromWhereEnum.ADD.name)
            findNavController().navigate(R.id.action_userFragment_to_editUserFragment, bundle)


        }


    }

    private fun initRecyclerview() {

        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        adapter = UserAdapter { user, action ->
            when (action) {
                Action.EDIT -> {

                    val bundle = Bundle()
                    bundle.putString(BUNDLE_KEY_FROM_WHERE, FromWhereEnum.EDIT.name)
                    bundle.putParcelable(BUNDLE_KEY_FROM_EDIT_USER, user)
                    findNavController().navigate(
                        R.id.action_userFragment_to_editUserFragment,
                        bundle
                    )


                }

                Action.DELETE -> {
                    //  CoroutineScope(Dispatchers.Main).launch {
                    viewModel.deleteUser(user)
                    // }


                }
            }
        }
        binding.rvUser.adapter = adapter
    }


}