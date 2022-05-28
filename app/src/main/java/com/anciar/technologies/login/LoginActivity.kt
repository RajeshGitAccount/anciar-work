package com.anciar.technologies.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.anciar.technologies.databinding.ActivityLoginBinding
import com.anciar.technologies.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private  val TAG = "LoginActivity"

    private val viewModel by viewModels<LoginViewModel>()

    private lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.model = viewModel
        binding.lifecycleOwner = this
        enableClickListeners()
        observeViewModel()
    }

    private fun enableClickListeners() {
        binding.submit.setOnClickListener {
//            onLoginButtonClick()
            viewModel.onSubmitClick()
        }
    }


    private fun observeViewModel() {
        viewModel.errorValidations.observe(this, Observer {
            when (it) {
                InValidErrors.EMAILINCORRECT -> {
                    showErrorDialog("In valid Email")
                }
                InValidErrors.PASSWORDINCORRECT -> {
                    showErrorDialog("in valid password")
                }
                InValidErrors.INCORRECTCREDENTIALS -> {
                    showErrorDialog("in Correct Credentials")
                }
            }
        })

        viewModel.succesResult.observe(this, Observer {
            if(it) {
                navigateToMainActivity()
            }
        })
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this,MainActivity::class.java))

    }

    private fun showErrorDialog(message: String) {
        val alertDialog: AlertDialog? = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK") { _, _ ->
                    setCancelable(true)
                }
                setMessage(message)
            }
            builder.create()
        }
        alertDialog?.show()
    }


}