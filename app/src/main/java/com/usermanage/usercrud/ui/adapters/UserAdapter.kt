package com.usermanage.usercrud.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.usermanage.usercrud.data.model.User
import com.usermanage.usercrud.databinding.ItemUserBinding
import com.usermanage.usercrud.utils.enums.ActionEnum

class UserAdapter(private val onActionClick: (User, ActionEnum) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUsers(newUsers: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(users, newUsers))
        users = newUsers
        diffResult.dispatchUpdatesTo(this)
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user

            binding.editButton.setOnClickListener {
                onActionClick(user, ActionEnum.EDIT)
            }
            binding.deleteButton.setOnClickListener {
                onActionClick(user, ActionEnum.DELETE)
            }

            binding.executePendingBindings()
        }
    }

    class UserDiffCallback(private val oldList: List<User>, private val newList: List<User>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
