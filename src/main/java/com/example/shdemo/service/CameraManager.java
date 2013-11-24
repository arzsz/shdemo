package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Camera;

public interface CameraManager {

	int addNewCamera(Camera camera);
	Camera findCameraById(int idCam);
	void upCamera(Camera camera);
	void delCamera(Camera camera);
	List<Camera> getAllCamera();

}