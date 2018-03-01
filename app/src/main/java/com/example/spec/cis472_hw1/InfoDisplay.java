package com.example.spec.cis472_hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);

        //Extract the bundle from the intent to use variables
        Bundle bundle = getIntent().getExtras();
        //Extract each value from the bundle for usage
        String UIfname = bundle.getString("fname");
        String UIlname = bundle.getString("lname");
        String UIusername = bundle.getString("username");
        String UIpassword = bundle.getString("password");
        String UIphone = bundle.getString("phone");
        String UIemail = bundle.getString("email");
        String UIgender = bundle.getString("gender");
        String UIcountry = bundle.getString("country");

        //now display the information in our textviews
        TextView fn = (TextView)findViewById(R.id.EnteredFname);
        fn.setText(UIfname);

        TextView ln = (TextView)findViewById(R.id.EnteredLname);
        ln.setText(UIlname);

        TextView un = (TextView)findViewById(R.id.EnteredUsername);
        un.setText(UIusername);

        TextView em = (TextView)findViewById(R.id.EnteredEmail);
        em.setText(UIemail);

        TextView phone = (TextView)findViewById(R.id.EnteredPhone);
        phone.setText(UIphone);

        TextView pw = (TextView)findViewById(R.id.EnteredPassword);
        pw.setText(UIpassword);

        TextView gender = (TextView)findViewById(R.id.EnteredGender);
        gender.setText(UIgender);

        TextView country = (TextView)findViewById(R.id.EnteredCountry);
        country.setText(UIcountry);
    }//end onCreate


    public void returnButton(View V){
        //this button allows us to return to the form page
        Intent myIntent = new Intent();
        myIntent.setClass(getBaseContext(), Linear_Layout.class);
        startActivity(myIntent);
    }//end returnButton

}//end InfoDisplay
