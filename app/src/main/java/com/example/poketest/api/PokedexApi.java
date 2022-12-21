package com.example.poketest.api;

import com.example.poketest.models.PokemonRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokedexApi
{
     @GET("pokemon")
     Call<PokemonRespuesta> obtenerListaPokemon(@Query("offset") int offset, @Query("limit") int limit);
}
