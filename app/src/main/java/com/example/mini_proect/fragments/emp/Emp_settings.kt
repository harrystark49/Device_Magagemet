package com.example.mini_proect.fragments.emp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_proect.Activities.AdminDetails
import com.example.mini_proect.Activities.ChangePassword
import com.example.mini_proect.Activities.Register
import com.example.mini_proect.R
import com.example.mini_proect.finish_Activity
import kotlinx.android.synthetic.main.fragment_emp_settings.view.*


class emp_settings : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_emp_settings, container, false)

        view.emp_update_profile.setOnClickListener {
            val intent = Intent(context, Register::class.java)
            startActivity(intent)
            finish_Activity
        }
        view.emp_change_password.setOnClickListener {
            val intent = Intent(context, ChangePassword::class.java)
            startActivity(intent)
            finish_Activity
        }
        view.adminDetails.setOnClickListener {
            val intent = Intent(context, AdminDetails::class.java)
            startActivity(intent)
            finish_Activity
        }

        return view
    }


}