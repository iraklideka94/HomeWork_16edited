package com.example.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paging.databinding.ListItemBinding
import com.example.paging.model.UserInfo

class UserAdapter: PagingDataAdapter<UserInfo.Data, UserAdapter.UserViewHolder>(UserItemCallBack) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    inner class UserViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(){
            val user = getItem(bindingAdapterPosition)
            binding.apply {
                tvName.text = user?.firstName
                tvLastname.text = user?.lastName
                tvEmail.text = user?.email
                Glide.with(binding.root)
                    .load(user?.avatar)
                    .into(binding.imageView)

            }
        }
    }
    private object UserItemCallBack: DiffUtil.ItemCallback<UserInfo.Data>(){
        override fun areItemsTheSame(oldItem: UserInfo.Data, newItem: UserInfo.Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserInfo.Data, newItem: UserInfo.Data): Boolean {
           return oldItem == newItem
        }

    }

}