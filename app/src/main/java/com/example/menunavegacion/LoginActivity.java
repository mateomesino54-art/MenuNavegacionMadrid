package com.example.menunavegacion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private Button btnLogin;

    // CREDENCIALES VÁLIDAS - ¡IMPORTANTE CAMBIAR "MAURICIO" POR TU NOMBRE!
    private final String USUARIO_VALIDO = "mateo";
    private final String PASSWORD_VALIDO = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etUsuario.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            // Validación de campos vacíos
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validación de credenciales
            if (user.equals(USUARIO_VALIDO) && pass.equals(PASSWORD_VALIDO)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USUARIO_LOGUEADO", user);
                startActivity(intent);
                finish(); // Cerramos el login para que no se pueda volver
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });
    }
}