package com.example.menunavegacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel("Celebración Épica", "Un jugador del Real Madrid celebrando un gol en el Bernabéu.", R.drawable.madrid_celebracion));
        items.add(new ItemModel("Estadio Bernabéu", "Una vista nocturna del legendario estadio del Real Madrid.", R.drawable.madrid_estadio));
        items.add(new ItemModel("Escudo Dorado", "El escudo oficial en color dorado rodeado de laurel.", R.drawable.madrid_escudo));
        items.add(new ItemModel("Fuente de Cibeles", "Lugar tradicional de celebración de los títulos merengues.", R.drawable.madrid_cibeles));
        items.add(new ItemModel("Camiseta Legendaria", "La histórica elástica blanca con detalles dorados.", R.drawable.madrid_camiseta));
        items.add(new ItemModel("Bota de Goleador", "Calzado de alta gama utilizado por las grandes estrellas.", R.drawable.madrid_bota));

        ItemAdapter adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}