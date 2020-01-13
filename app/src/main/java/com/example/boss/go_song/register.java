package com.example.boss.go_song;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.boss.go_song.API.BaseApp;
import com.example.boss.go_song.API.Helper;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends BaseApp {
    private EditText email, pass, pass2;
    private TextView btn_login;
    private ImageButton btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);
        setupView();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(BtnAnimasi);
                startActivity(new Intent(context, login.class));
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        email.setError(null);
        pass.setError(null);
        pass2.setError(null);
        /*check keberadaan teks*/
        if (Helper.isEmpty(email)) {
            email.setError("Email masih kosong");
            email.requestFocus();
        } else if (Helper.isEmailValid(email)) {
            email.setError("Format email salah");
            email.requestFocus();
        } else if (Helper.isEmpty(pass)) {
            pass.setError("Password masih kosong");
            pass.requestFocus();
        } else if (Helper.isEmpty(pass2)) {
            pass2.setError("Konfirmasi password masih kosong");
            pass2.requestFocus();
            /*check kesamaan password*/
        } else if (Helper.isCompare(pass, pass2)) {
            pass2.setError("Password tidak cocok");
            pass2.requestFocus();
        } else{
            /*kirim data ke server*/

            /*alamat url http://192.168.154.2/app_pesantren/register.php*/
            String URL = Helper.BASE_URL + "register.php";

            /*menampung nilai*/
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
            pd.setMessage("Sedang menambah data");
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

                                /*jika result adalah benar, maka pindah ke activity login dan menampilkan pesan dari server,
                                serta mematikan activity*/
                                if (result.equalsIgnoreCase("true")) {
                                    startActivity(new Intent(context, login.class));
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
        pass2 = (EditText) findViewById(R.id.pass2);
        btn_reg = (ImageButton) findViewById(R.id.btn_reg);
        btn_login = (TextView) findViewById(R.id.btn_login);
    }
}
