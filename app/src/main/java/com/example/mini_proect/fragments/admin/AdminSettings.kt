package com.example.mini_proect.fragments.admin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mini_proect.Activities.ChangePassword
import com.example.mini_proect.Activities.Register
import com.example.mini_proect.R
import com.example.mini_proect.finish_Activity
import kotlinx.android.synthetic.main.fragment_admin_settings.view.*

class AdminSettings : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_admin_settings, container, false)

        view.update_profile.setOnClickListener {
            
            val i = Intent(context,Register::class.java)
            startActivity(i)
            finish_Activity
        }
        view.change_password.setOnClickListener {

            val intent = Intent(context, ChangePassword::class.java)
            startActivity(intent)
            finish_Activity
        }
        return view
    }
}