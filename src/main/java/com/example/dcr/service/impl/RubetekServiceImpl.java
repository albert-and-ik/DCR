package com.example.dcr.service.impl;

import com.example.dcr.model.dto.CameraDto;
import com.example.dcr.model.dto.DoorDto;
import com.example.dcr.model.dto.ResponseBodyDto;
import com.example.dcr.model.dto.RoomCameraDataDto;
import com.example.dcr.repository.RubetekRepository;
import com.example.dcr.service.RubetekService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class RubetekServiceImpl implements RubetekService {

    final RubetekRepository rubetekRepository;
    private static <T> @Nullable T getData(Call<ResponseBodyDto<T>> call) throws IOException, NullPointerException {
        try {
            Response<ResponseBodyDto<T>> response = call.execute();

            if(response.isSuccessful()
                    && response.body() != null
                    && response.body().isSuccess()) {

                return response.body().getData();
            }
        } catch (RuntimeException e) {
            throw new IOException("Request failed");
        }

        return null;
    }

    @Override
    public List<DoorDto> getDoors() throws IOException {

        return getData(rubetekRepository.doors());
    }

    @Override
    public List<String> getRooms() throws IOException, NullPointerException {
        Set<String> rooms = new HashSet<>();

        RoomCameraDataDto roomCameraDataDto = getData(rubetekRepository.cameras());

        rooms.addAll(roomCameraDataDto.getRoom());

        rooms.addAll(
                roomCameraDataDto
                        .getCameras()
                        .stream()
                        .map(CameraDto::getRoom)
                        .toList()
        );

        rooms.addAll(
                getDoors()
                        .stream()
                        .map(DoorDto::getRoom)
                        .toList()
        );

        rooms.remove(null);


        return rooms.stream().toList();
    }

    @Override
    public List<CameraDto> getCameras() throws IOException, NullPointerException {
            return getData(rubetekRepository.cameras()).getCameras();
    }

}
