package com.example.mini_proect.Activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.mini_proect.DataBase.DBHelper
import com.example.mini_proect.R
import kotlinx.android.synthetic.main.activity_change_password.*
import java.net.PasswordAuthentication

class ChangePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val anim = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        password_main.startAnimation(anim)

        var helper = DBHelper(this)
        var db = helper.readableDatabase

        var password = CompanionObjectData.password
        var mail = CompanionObjectData.email
        var type = CompanionObjectData.type

        submit_button.setOnClickListener {

            var OldPass = old_password.text.toString()
            val NewPass = new_password.text.toString()
            val ConNew = admin_confirm_password.text.toString()

            if((OldPass==password) && (type.equals("Employee"))){
                oldpassword.isErrorEnabled = false
                if(checkDetails(NewPass,ConNew,OldPass)) {
                    if (OldPass!=NewPass) {
                        var cv = ContentValues()
                        cv.put("PASSWORD", NewPass)
                        db.update("ADD_EMPLOYEE", cv, "EMAIL=?", arrayOf(mail))

                        CompanionObjectData.loginDetails(mail,NewPass,"Employee")
                        Toast.makeText(this, "Password change successful", Toast.LENGTH_SHORT).show()

                        var i=Intent(this,HomeScreenEmployee::class.java)
                        i.putExtra("EmpSettings","Employee")
                        startActivity(i)
                        finishAffinity()
                    }
                }
            }

            else if((OldPass==password) && (type.equals("Admin"))){
                oldpassword.isErrorEnabled = false
                if(checkDetails(NewPass,ConNew,OldPass) ) {
                    if (!OldPass.equals(NewPass)) {
                        var cv = ContentValues()
                        cv.put("PASSWORD", NewPass)
                        db.update("ADD_ADMIN", cv, "EMAIL=?", arrayOf(mail))

                        CompanionObjectData.loginDetails(mail,NewPass,"Admin")

                        Toast.makeText(this, "Password change successful", Toast.LENGTH_SHORT).show()
                        var i=Intent(this,Home_screen_admin::class.java)
                        i.putExtra("AdminSettings","Admin")
                        startActivity(i)
                        finishAffinity()
                    }

                    else
                        Toast.makeText(this, "Old password and New password can't be same", Toast.LENGTH_SHORT).show()

                }

            }

            else{
                oldpassword.error = "Current password is incorrect"
                oldpassword.isErrorEnabled = true
            }



        }
    }

    private fun checkDetails(newPass:String,conPass:String,oldpass:String):Boolean {
        if(newPass.isEmpty()){
            New_password.error = "Enter password"
            New_password.isErrorEnabled = true
        }
        else if (!IsAlphaNumeric(newPass)) {
            New_password.error = "Password should be alphanumeric"
            New_password.isErrorEnabled = true
        } else if (!(newPass.length >= 8 && newPass.length <= 10)) {
            New_password.error = "Password should be in between 8 and 10 characters"
            New_password.isErrorEnabled = true
        } else if(oldpass.equals(newPass)){
            New_password.error = "old password and new password should not be same"
            New_password.isErrorEnabled = true
        }else if (!newPass.equals(conPass)) {
            New_password.isErrorEnabled=false
            confirm_new_layout.error = "New Password and Confirm Password are mis-matched"
            confirm_new_layout.isErrorEnabled = true

        }
        else {
            confirm_new_layout.isErrorEnabled = false
            New_password.isErrorEnabled=false
            return true
        }
        return false
    }

        private fun IsAlphaNumeric(id: String): Boolean {
            var x = false
            var y = false
            var z = true
            for (c in id) {
                if (c in 'a'..'z' || c in 'A'..'Z')
                    x = true
                else if (c in '0'..'9')
                    y = true
                else
                    z = false

            }
            if (x && y && z) {
                return true
            }
            return false
        }
    }




