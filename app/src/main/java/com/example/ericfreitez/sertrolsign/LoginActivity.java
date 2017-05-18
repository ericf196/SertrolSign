package com.example.ericfreitez.sertrolsign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ericfreitez.sertrolsign.ApiRest.ApiClient;
import com.example.ericfreitez.sertrolsign.ApiRest.EmpresaClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ListaEmpresaClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ListaProyectoClient;
import com.example.ericfreitez.sertrolsign.ApiRest.ProyectoClient;
import com.example.ericfreitez.sertrolsign.models.Empresa;
import com.example.ericfreitez.sertrolsign.models.MensajeResponse;
import com.example.ericfreitez.sertrolsign.models.Proyecto;
import com.example.ericfreitez.sertrolsign.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    private static final String DUMMY_USER_ID = "00000000";
    private static final String DUMMY_PASSWORD = "00000000";
    public static final String ERROR_MESSAGE_RETROFIT = "Error onFailure Retrofit";
    public static final String ERROR_PASSWORD_USERNAME = "Error en Usuario o Password";
    public static final String ERROR_NO_ENCONTRADO = "Error encontrado";

    //private UserLoginTask mAuthTask = null;

    private Button mFormButton;
    private ImageView mLogoView;
    private EditText mUserIdView;
    private EditText mPasswordView;
    private TextInputLayout mFloatLabelUserId;
    private TextInputLayout mFloatLabelPassword;
    private View mProgressView;
    private View mLoginFormView;
    private ProgressDialog mProgressDialog;
    private List<Proyecto> proyectos= new ArrayList<>() ;
    private Bundle bundleProyectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogoView = (ImageView) findViewById(R.id.image_logo);
        mUserIdView = (EditText) findViewById(R.id.user_name); //*
        mPasswordView = (EditText) findViewById(R.id.password); //*
        mFloatLabelUserId = (TextInputLayout) findViewById(R.id.float_label_user_id);
        mFloatLabelPassword = (TextInputLayout) findViewById(R.id.float_label_password);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        mFormButton= (Button) findViewById(R.id.form_button);

        //mFormButton.setOnClickListener(this);



        // Setup
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {

                    if (!isOnline()) {
                        showLoginError(getString(R.string.error_network));
                        return false;
                    }
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isOnline()) {

                    return;
                }
                attemptLogin();
            }
        });

    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 3;
    }

    private void attemptLogin() {

        mFloatLabelUserId.setError(null);
        mFloatLabelPassword.setError(null);

        // Store values at the time of the login attempt.
        String userId = mUserIdView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mFloatLabelPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
        mFloatLabelPassword.setError(getString(R.string.error_invalid_password));
        focusView = mFloatLabelPassword;
        cancel = true;
    }

        // Verificar si el ID tiene contenido.
        if (TextUtils.isEmpty(userId)) {
            mFloatLabelUserId.setError(getString(R.string.error_field_required));
            focusView = mFloatLabelUserId;
            cancel = true;
        } else if (!isUserIdValid(userId)) {
            mFloatLabelUserId.setError(getString(R.string.error_field_required));
            focusView = mFloatLabelUserId;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            logining();
        }
    }

    /*private void showProgress(final boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        mLogoView.setVisibility(visibility);
        mLoginFormView.setVisibility(visibility);

    }*/


    private boolean isUserIdValid(String userId) {

        return userId.length() >5;
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }




    private void logining() {

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Cargando...");
        mProgressDialog.show();

        ProyectoClient service = ApiClient.getClient().create(ProyectoClient.class);

        Call<ListaProyectoClient> call= service.Login(mUserIdView.getText().toString(),mPasswordView.getText().toString());
        call.enqueue(new Callback<ListaProyectoClient>() {
            @Override
            public void onResponse(Call<ListaProyectoClient> call, Response<ListaProyectoClient> response) {

                Log.e("msg", "onResponse :" + response.message());

                ListaProyectoClient listaProyecto = response.body();
                if(listaProyecto.getEncontrado()==0){
                        Toast.makeText(getApplicationContext(), ERROR_PASSWORD_USERNAME , Toast.LENGTH_LONG).show();
                }else{

                    /*if (listaProyecto!=null){
                        Log.e("msg", "Bloque 3");
                        proyectos= listaProyecto.getProyectos();
                        for (int i=0; i <proyectos.size(); i++){
                            Log.i("msg",proyectos.get(i).getNombreProyecto());
                            Log.i("msg",proyectos.get(i).getNombreEmpresa());
                            Log.i("msg",proyectos.get(i).getDescripcionProyecto());
                            Log.i("msg",proyectos.get(i).getCodigoProyecto());
                            Log.i("msg","--------------------------------");
                        }

                    }*/

                    bundleProyectos =new Bundle();
                    bundleProyectos.putSerializable("userProyectos",listaProyecto);
                    bundleProyectos.putString("userName",mUserIdView.getText().toString());
                    Intent mainActivity= new Intent(getApplicationContext(), MainActivity.class);
                    mainActivity.putExtras(bundleProyectos);
                    startActivity(mainActivity);


                }

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }

                //Toast.makeText(getApplicationContext(), "AQUI" , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ListaProyectoClient> call, Throwable t) {
                Log.i("msg","" + t.getMessage());
                Toast.makeText(getApplicationContext(), ERROR_MESSAGE_RETROFIT , Toast.LENGTH_LONG).show();
            }
        });


    }

    /*public class UserLoginTask extends AsyncTask<Void, Void, Integer> {

        private final String mUserId;
        private final String mPassword;

        UserLoginTask(String userId, String password) {
            mUserId = userId;
            mPassword = password;
        }

        @Override
        protected Integer doInBackground(Void... params) {

            try {
                // Simulate network access.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return 4;
            }

            if (!mUserId.equals(DUMMY_USER_ID)) {
                return 2;
            }

            if (!mPassword.equals(DUMMY_PASSWORD)) {
                return 3;
            }

            return 1;
        }

        @Override
        protected void onPostExecute(final Integer success) {
            mAuthTask = null;
            showProgress(false);


            switch (success) {
                case 1:
                    showMainActivity();
                    break;
                case 2:
                case 3:
                    showLoginError("Número de identificación o contraseña inválidos");
                    break;
                case 4:
                    showLoginError(getString(R.string.error_server));
                    break;
            }


        }

        private void showMainActivity() {


            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }*/
}
