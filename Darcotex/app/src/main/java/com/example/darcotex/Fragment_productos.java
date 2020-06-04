package com.example.darcotex;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Fragment_productos extends Fragment {
    View view;
    Button edit_boton_items, edit_boton_stock, edit_boton_categorias ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_productos, container, false);
        edit_boton_items = (Button) view.findViewById(R.id.Items_button);
        edit_boton_stock = (Button) view.findViewById(R.id.Stock_button);
        edit_boton_categorias = (Button) view.findViewById(R.id.Categorias_button);


        if(savedInstanceState == null){//ESto es para que inicialmente se inicie la pestaña Items
            edit_boton_items.setBackgroundResource(R.drawable.button_presionado);
            getFragmentManager().beginTransaction().replace(R.id.frag_container_productos, new Fragment_Items()).commit();
        }

        edit_boton_items.setOnClickListener(new View.OnClickListener() { //por si se aapreta el boton Items
            Drawable backgroud = edit_boton_items.getBackground();
            @Override
            public void onClick(View v) {
                edit_boton_items.setBackgroundResource(R.drawable.button_presionado);
                edit_boton_stock.setBackgroundResource(R.color.colorPrimary2);//desactivar boton stock
                edit_boton_categorias.setBackgroundResource(R.color.colorPrimary2);//desactivar boton categorias
                getFragmentManager().beginTransaction().replace(R.id.frag_container_productos, new Fragment_Items()).commit();
            }
        });

        edit_boton_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //por si se aapreta el boton STOCK
                edit_boton_items.setBackgroundResource(R.color.colorPrimary2);//desactivar boton items
                edit_boton_stock.setBackgroundResource(R.drawable.button_presionado);
                edit_boton_categorias.setBackgroundResource(R.color.colorPrimary2);//desactivar boton categorias
                getFragmentManager().beginTransaction().replace(R.id.frag_container_productos, new Fragment_Stock()).commit();
            }
        });

        edit_boton_categorias.setOnClickListener(new View.OnClickListener() { //por si se aapreta el boton CATEGORIAS
            @Override
            public void onClick(View v) {
                edit_boton_items.setBackgroundResource(R.color.colorPrimary2);//desactivar boton items
                edit_boton_stock.setBackgroundResource(R.color.colorPrimary2);//desactivar boton stock
                edit_boton_categorias.setBackgroundResource(R.drawable.button_presionado);
                getFragmentManager().beginTransaction().replace(R.id.frag_container_productos, new Fragment_Categorias()).commit();
            }
        });
        return view;

    }
}
