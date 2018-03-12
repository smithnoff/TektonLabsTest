package com.smithnoff.cesarsmith.tektonlabstest.ui.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import kotlinx.android.synthetic.main.item_suscribers.view.*

/**
 * Created by jesusflores on 12-03-18.
 */
class SuscribersAdapter(val context: Context, var listSuscribers: MutableList<User>) : RecyclerView.Adapter<SuscribersAdapter.SuscribersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SuscribersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_suscribers, parent, false)
        return SuscribersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSuscribers.size
    }

    override fun onBindViewHolder(holder: SuscribersViewHolder?, position: Int) {
        holder!!.bindView(listSuscribers[position])
    }

    class SuscribersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


        fun bindView(user: User) {

            itemView.suscriber_name.text=user.username

        }

    }
}