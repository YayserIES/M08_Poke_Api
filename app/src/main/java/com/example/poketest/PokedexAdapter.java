package com.example.poketest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.example.poketest.models.Pokemon;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder>
{

    private ArrayList<Pokemon> data;
    private Context context;

    public PokedexAdapter(Context context)
    {
        this.context = context;
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.pokemon_in_pokedex, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Pokemon pokemon = data.get(position);
        holder.txtPoke.setText(pokemon.getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+ pokemon.getNumber()+".png")
                .into(holder.imgPoke);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public void addListPokemon(ArrayList<Pokemon> listaPokemon)
    {
        data.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imgPoke;
        private TextView txtPoke;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgPoke = (ImageView) itemView.findViewById(R.id.imagenPokemon);
            txtPoke = (TextView) itemView.findViewById(R.id.nombrePokemon);
        }
    }
}
