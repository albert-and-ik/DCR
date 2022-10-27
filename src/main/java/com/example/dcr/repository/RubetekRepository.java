package com.example.dcr.repository;

import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.ResponseBodyDto;
import com.example.dcr.model.dto.RoomCameraDataDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;


public interface RubetekRepository {
    @GET("doors")
    Call<ResponseBodyDto<List<DoorDto>>> doors();

    @GET("cameras")
    Call<ResponseBodyDto<RoomCameraDataDto>> cameras();
}
