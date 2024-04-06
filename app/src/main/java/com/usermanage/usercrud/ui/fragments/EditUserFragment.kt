package com.usermanage.usercrud.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.usermanage.usercrud.R
import com.usermanage.usercrud.data.model.User
import com.usermanage.usercrud.databinding.FragmentEditUserBinding
import com.usermanage.usercrud.ui.viewmodels.UserViewModel
import com.usermanage.usercrud.utils.Constants
import com.usermanage.usercrud.utils.Injector
import com.usermanage.usercrud.utils.enums.FromWhereEnum


class EditUserFragment : Fragment() {

    private lateinit var binding: FragmentEditUserBinding

    private val viewModel: UserViewModel by viewModels {
        Injector.getViewModelFactory(requireContext())
    }

    var userModelFromEdit: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentEditUserBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val action = bundle?.getString(Constants.BUNDLE_KEY_FROM_WHERE)

        if (action == FromWhereEnum.EDIT.name) {
            userModelFromEdit = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(Constants.BUNDLE_KEY_FROM_EDIT_USER, User::class.java)
            } else {
                bundle.getParcelable(Constants.BUNDLE_KEY_FROM_EDIT_USER)
            }

            // Fill EditText fields with current user data
            binding.etName.setText(userModelFromEdit?.name)
            binding.etEmail.setText(userModelFromEdit?.email)
            binding.etAge.setText(userModelFromEdit?.age.toString())

        }

        onBackButtonClick()

        binding.btSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val age = binding.etAge.text.toString()

            if (validateFields()) {
                val user = User(name = name, email = email, age = age.toInt())

                if (action == FromWhereEnum.EDIT.name) {
                    // Update user
                    user.id = userModelFromEdit!!.id
                    viewModel.updateUser(user)
                } else {
                    // Insert new user
                    viewModel.insertUser(user)
                }


                findNavController().navigate(R.id.action_editUserFragment_to_userFragment)

            }


        }
    }

    private fun onBackButtonClick() {

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_editUserFragment_to_userFragment)
        }

    }


    fun isValidAge(age: String): Boolean {
        return try {
            val ageInt = age.toInt()
            ageInt in 1..120 // Example: Age should be between 1 and 120
        } catch (e: NumberFormatException) {
            false // Invalid integer format
        }
    }

    fun isValidName(name: String): Boolean {
        return name.isNotBlank() && name.matches(Regex("^[a-zA-Z\\s]+\$"))
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    private fun validateFields(): Boolean {
        val name = binding.etName.text.toString().trim()
        val age = binding.etAge.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()

        if (!isValidName(name)) {
            binding.etName.error = "Invalid name"
            return false
        }

        if (!isValidAge(age)) {
            binding.etAge.error = "Invalid age"
            return false
        }

        if (!isValidEmail(email)) {
            binding.etEmail.error = "Invalid email"
            return false
        }

        return true
    }


}