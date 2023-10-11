/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


  EditText username;
  EditText password;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    username=(EditText)findViewById(R.id.username_editText);
    password=(EditText)findViewById(R.id.password_editText);



    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

  public void signUp(View view) {

      if(username.getText().toString().matches("")||password.getText().toString().matches("")){
               System.out.println("email required ");
               Toast.makeText(this,"Email and password required",Toast.LENGTH_LONG).show();
      }else {

        ParseUser user=new ParseUser();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());

        username.setText("");
        password.setText("");

        user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
          if (e == null) {
            Log.i("Parse Result", "Successful!");
          } else {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
          }

        }
      });


    }
  }

  @Override
  public void onClick(View view) {

  }
}