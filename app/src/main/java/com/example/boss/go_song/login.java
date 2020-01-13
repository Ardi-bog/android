package com.example.boss.go_song;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.boss.go_song.API.BaseApp;
import com.example.boss.go_song.API.Helper;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends BaseApp {
    private EditText email, pass;
    private TextView btn_reg;
    private ImageButton btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupView();
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(BtnAnimasi);
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        email.setError(null);
        pass.setError(null);
        /*check kebaradan teks*/
        if (Helper.isEmpty(email)) {
            email.setError("Email masih kosong");
            email.requestFocus();
        } else if (Helper.isEmpty(pass)) {
            pass.setError("Password masih kosong");
            pass.requestFocus();
        }else{
            String URL = Helper.BASE_URL + "login.php";
            Map<String, String> param = new HashMap<>();
            param.put("email", email.getText().toString());
            param.put("password", pass.getText().toString());

            /*menampilkan progressbar saat mengirim data*/
            ProgressDialog pd = new ProgressDialog(context);
            pd.setIndeterminate(true);
            pd.setCancelable(false);
            pd.setInverseBackgroundForced(false);
            pd.setCanceledOnTouchOutside(false);
            pd.setTitle("Info");
            pd.setMessage("Login");
            pd.show();

            try {
                /*format ambil data*/
                aQuery.progress(pd).ajax(URL, param, String.class, new AjaxCallback<String>() {
                    @Override
                    public void callback(String url, String object, AjaxStatus status) {
                        /*jika objek tidak kosong*/
                        if (object != null) {
                            try {
                                JSONObject jsonObject = new JSONObject(object);
                                String result = jsonObject.getString("result");
                                String msg = jsonObject.getString("msg");
                                if (result.equalsIgnoreCase("true")) {
                                    startActivity(new Intent(context, MainActivity.class));
                                    Helper.pesan(context, msg);
                                    finish();
                                } else {
                                    Helper.pesan(context, msg);
                                }
                            } catch (JSONException e) {
                                Helper.pesan(context, "Error convert data json");
                            }
                        }
                    }
                });
            } catch (Exception e) {
                Helper.pesan(context, "Gagal mengambil data");
            }
        }
    }
    private void setupView() {
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        btn_login = (ImageButton) findViewById(R.id.btn_login);
        btn_reg = (TextView) findViewById(R.id.btn_reg);
    }
}
