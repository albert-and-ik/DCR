package com.example.dcr.schedule.task;


import com.example.dcr.service.CameraService;
import com.example.dcr.service.DoorService;
import com.example.dcr.service.RoomService;
import com.example.dcr.service.RubetekService;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class TaskSyncWithRubetek implements Runnable{

    final DoorService doorService;
    final RoomService roomService;
    final CameraService cameraService;
    final RubetekService rubetekService;



    @Override
    public void run(){
        try {
            doorService.updateOrCreate(rubetekService.getDoors());

            cameraService.updateOrCreate(rubetekService.getCameras());

            roomService.updateOrCreate(rubetekService.getRooms());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
