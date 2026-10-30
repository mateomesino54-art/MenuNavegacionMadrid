package com.example.menunavegacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        TextView tvUsuarioLogueado = view.findViewById(R.id.tvUsuarioLogueado);
        Button btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);

        if (getArguments() != null) {
            String usuario = getArguments().getString("CLAVE_USUARIO", "Invitado");
            tvUsuarioLogueado.setText("Usuario logueado:\n" + usuario.toUpperCase());
        }

        // Botón para cerrar sesión y regresar al Login
        btnCerrarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        return view;
    }
}