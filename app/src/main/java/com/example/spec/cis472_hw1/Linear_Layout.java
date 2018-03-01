package com.example.spec.cis472_hw1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.text.InputType;
import android.widget.Toast;
import android.view.View;

import java.util.Arrays;

public class Linear_Layout extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
    }

    //Button to clear all fields. Resets spinner to USA
    public void clearButton(View V){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        Toast.makeText(this, "Fields are cleared",
                Toast.LENGTH_LONG).show();

        clearForm((ViewGroup) findViewById(R.id.base));
        radioGroup.clearCheck();
        spinner.setSelection(0);
    }

    //button to submit, checks various info and sends us to InfoDisplay
    public void submitButton(View V){

        //first get various information
        EditText ETemail   = (EditText)findViewById(R.id.et_email);
        EditText ETemail2   = (EditText)findViewById(R.id.et_email2);

        String email = ETemail.getText().toString();
        String email2 = ETemail2.getText().toString();

        EditText ETpassword = (EditText)findViewById(R.id.et_password);
        EditText ETpassword2 = (EditText)findViewById(R.id.et_password2);

        String password = ETpassword.getText().toString();
        String password2 = ETpassword2.getText().toString();

        EditText ETusername = (EditText)findViewById(R.id.et_username);

        String username = ETusername.getText().toString();

        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);

        //get the list of usernames taken
        String usernamesArray[] =getResources().getStringArray(R.array.usernames);

        //check information
        if (!email.equals(email2)){
            Toast.makeText(this, "Emails don't match, try again!",
                    Toast.LENGTH_LONG).show();
        }
        else if (!password.equals(password2)){
            Toast.makeText(this, "Passwords don't match, try again!",
                    Toast.LENGTH_LONG).show();
        }
        else if(Arrays.asList(usernamesArray).contains(username)) {
            Toast.makeText(this, "Username is taken, try again!",
                    Toast.LENGTH_LONG).show();
        }
        else if (rg.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Please select a gender. 'Other' can be used for 'n/a'.",
                    Toast.LENGTH_LONG).show();
        }
        else {//finally send the info if everything is okay
            Toast.makeText(this, "Input submitted",
                    Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle(); //create a bundle to put info in

            //put info we currently have in the bundle:
            bundle.putString("email", email);
            bundle.putString("password", password);
            bundle.putString("username", username);

            //fetch other info to put in bundle:
            EditText ETfname   = (EditText)findViewById(R.id.et_first_name);
            String fname = ETfname.getText().toString();
            bundle.putString("fname", fname);

            EditText ETlname   = (EditText)findViewById(R.id.et_last_name);
            String lname = ETlname.getText().toString();
            bundle.putString("lname", lname);

            EditText ETphone   = (EditText)findViewById(R.id.et_phone);
            String phone = ETphone.getText().toString();
            bundle.putString("phone", phone);

            String gender = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            bundle.putString("gender", gender);

            Spinner mySpinner=(Spinner) findViewById(R.id.spinner2);
            String country = mySpinner.getSelectedItem().toString();
            bundle.putString("country", country);

            //now send the bundle to the new activity and start that activity
            Intent myIntent = new Intent();
            myIntent.setClass(getBaseContext(), InfoDisplay.class);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }

    //buttons to change view linear/relative
    public void toLinear(View v){
        setContentView(R.layout.linear);
    }

    public void toRelative(View v){
        setContentView(R.layout.relative);
    }

    //function used to help clear everything
    private void clearForm(ViewGroup group)
    {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }

}
