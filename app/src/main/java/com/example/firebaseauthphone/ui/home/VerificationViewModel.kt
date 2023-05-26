package com.example.firebaseauthphone.ui.home
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.firebaseauthphone.base.BaseViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class VerificationViewModel:BaseViewModel<verificationNavigator>(){

    lateinit var verification_Id:String
    val verify_code= ObservableField<String>();
    private lateinit var auth: FirebaseAuth



    fun startPhoneAuth(phone:String){
        val callBack = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                //showLoading?.value=false
                messageLiveData?.value="Successful verification"
                signInWithPhoneAuthCredential(credential) }

            override fun onVerificationFailed(e: FirebaseException) {
                //Log.w("failed", "onVerificationFailed", e)
                showLoading?.value=true
                messageLiveData?.value="Verification Failed" }

            override fun onCodeSent(verificationId: String,
                                    token: PhoneAuthProvider.ForceResendingToken) {
                Log.d(TAG, "onCodeSent:$verificationId")
                verification_Id=verificationId

                // Save verification ID and resending token so we can use them later
//            storedVerificationId = verificationId
//            resendToken = token
            }
        }
    val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(phone) // Phone number to verify
        .setTimeout(120L, TimeUnit.SECONDS) // Timeout and unit
        .setActivity()
        .setCallbacks(callBack) // OnVerificationStateChangedCallbacks
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options) }

    fun verifyCode() {
        val credential:PhoneAuthCredential = PhoneAuthProvider.getCredential(verification_Id,verify_code.toString())
        if (verify_code == null)
            Toast.makeText(VerificationActivity(),"please inter Validation number",Toast.LENGTH_LONG)
                .show()
            //messageLiveData?.value = "Please Enter Verify Code"
        else if (verify_code.toString().length !=6)
           // messageLiveData?.value = "Verify Code Must Be 6 Numbers Only"
               Toast.makeText(VerificationActivity(),"please inter Validation number",Toast.LENGTH_LONG)
               .show()
        else
            messageLiveData?.value = "Verify Code Must Be 6 Numbers Only"
        signInWithPhoneAuthCredential(credential)
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                //showLoading?.value=false
                navigator?.openmainHomeScreen()
            } else {
                //showLoading?.value=true
                messageLiveData?.value = "Wrong Verification Code"
            } }
    }}