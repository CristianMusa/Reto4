package com.example.consumoservicio;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.consumoservicio.client.RetrofitClient;
import com.example.consumoservicio.entity.Estudiante;
import com.example.consumoservicio.service.RetrofitApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> info = new ArrayList<String>();
    private ListView tvResponse;
    private RetrofitApiService apiService;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
        initValues();
        getIdEstudiante();
        adapter();
    }

    private void initListView() {
        tvResponse = (ListView) findViewById(R.id.tvResponse);
    }

    private void initValues() {
        apiService = RetrofitClient.getApiService();
    }

    private void adapter(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, info);
        tvResponse.setAdapter(adapter);
    }

    private void getIdEstudiante(){
        initValues();
        Call<List<Estudiante>> call = apiService.getEstudiantes();
        call.enqueue(new Callback<List<Estudiante>>() {
            @Override
            public void onResponse(Call<List<Estudiante>> call, Response<List<Estudiante>> response) {
                muestraMensaje("--> Consulta Exitosa");
                if(response.isSuccessful()){
                    List<Estudiante> respuesta = response.body();

                    for(Estudiante estudiante: respuesta){
                        info.add(estudiante.getInstituacionEducativa() + ": " +  estudiante.getNombres() + " " +  estudiante.getApellidos());
                    }
                    adapter.notifyDataSetChanged();

                }else{
                    muestraMensaje("No se encontraron Registros");
                }
            }

            @Override
            public void onFailure(Call<List<Estudiante>> call, Throwable t) {
                muestraMensaje("--> Error:" + t.getMessage());

            }
        });
    }

    public void muestraMensaje(String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(msg);
        alert.show();
    }
}