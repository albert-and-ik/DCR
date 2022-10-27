package com.example.dcr.config;

import com.example.dcr.repository.RubetekRepository;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RubetekRepositoryConfig {

    @Value("${app.rubetek.sync-baseUrl}")
    String uri;

    Retrofit retrofitClient;
    RubetekRepository rubetekRepository;
    OkHttpClient okHttpClient;

    private Retrofit getClient() {
        if(retrofitClient == null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(uri)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofitClient;
    }

    private OkHttpClient getOkHttpClient(){
        if(okHttpClient==null)
            new OkHttpClient()
                    .newBuilder()
                    .build();

        return okHttpClient;
    }


    @Bean
    public RubetekRepository getRubetekService() {
        if(rubetekRepository == null)
            rubetekRepository = getClient().create(RubetekRepository.class);


        return rubetekRepository;
    }
}
