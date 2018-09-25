package com.example.igugl.registerform;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

public class Validate{

         public final static boolean isValidEmail(CharSequence target) {
             if (TextUtils.isEmpty(target)) {
                 return false;
             } else {
                 return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
             }
         }
}
