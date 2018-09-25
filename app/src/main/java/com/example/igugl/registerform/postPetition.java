package com.example.igugl.registerform;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.example.igugl.registerform.Cliente.add;
import static java.security.AccessController.getContext;


public class postPetition extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miperfil);

       final String requestBody;

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("firstName");
        String lname = datos.getString("lastName");
        String email = datos.getString("email");
        String password = datos.getString("password");
        String auxId;

        final TextView nombre1 = findViewById(R.id.number);
        Cliente cliente = new Cliente(nombre, lname, email, password);

         requestBody = cliente.add(cliente.toString());


      //  try {

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            String URL = "http://billig.ru/aid/k33f3c8db70d437ce41cfbd1bbde0f413/run/users";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("add", response);
                    nombre1.setText(response);

                   // nombre1.setText(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {



                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
                };

        requestQueue.add(stringRequest);

        }
}

