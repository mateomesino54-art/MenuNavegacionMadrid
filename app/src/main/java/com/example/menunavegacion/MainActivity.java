package com.example.menunavegacion;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private String usuarioRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioRecibido = getIntent().getStringExtra("USUARIO_LOGUEADO");
        if (usuarioRecibido == null) {
            usuarioRecibido = "Invitado";
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            cargarFragment(new HomeFragment());
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragmentSeleccionado = null;
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                fragmentSeleccionado = new HomeFragment();
            } else if (id == R.id.nav_user) {
                fragmentSeleccionado = new SettingFragment();
                Bundle args = new Bundle();
                args.putString("CLAVE_USUARIO", usuarioRecibido);
                fragmentSeleccionado.setArguments(args);
            }

            if (fragmentSeleccionado != null) {
                cargarFragment(fragmentSeleccionado);
                return true;
            }
            return false;
        });
    }

    private void cargarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
