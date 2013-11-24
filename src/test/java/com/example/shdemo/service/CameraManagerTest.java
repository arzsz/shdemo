package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Camera;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class CameraManagerTest {

	@Autowired
	CameraManager cameraManager;

	private final String NAME_1 = "GoPro";
	private final String MODEL_1 = "HD_Hero_3";
	
	private final String NAME_2 = "Pivothead";
	private final String MODEL_2 = "Durango";
	
	private final String NAME_3 = "GoPro";
	private final String MODEL_3 = "HD_Hero_2";
	
	private final String NAME_4 = "Pivothead";
	private final String MODEL_4 = "Cameleon";
	
	private final String NAME_5 = "Contour";
	private final String MODEL_5 = "+2";

	private final String NAME_6 = "Contour";
	private final String MODEL_6 = "ROAM2";
	
	@Before
	public void set(){
			
		Camera camera1 = new Camera();
		camera1.setName(NAME_1);
		camera1.setModel(MODEL_1);
		
		Camera camera2 = new Camera();
		camera2.setName(NAME_2);
		camera2.setModel(MODEL_2);
		
		Camera camera3 = new Camera();
		camera3.setName(NAME_3);
		camera3.setModel(MODEL_3);
		
		Camera camera4 = new Camera();
		camera4.setName(NAME_4);
		camera4.setModel(MODEL_4);
		
		Camera camera5 = new Camera();
		camera5.setName(NAME_5);
		camera5.setModel(MODEL_5);
		
		Camera camera6 = new Camera();
		camera6.setName(NAME_6);
		camera6.setModel(MODEL_6);
		
		int camera1IdCam = cameraManager.addNewCamera(camera1);
		int camera2IdCam = cameraManager.addNewCamera(camera2);
		int camera3IdCam = cameraManager.addNewCamera(camera3);
		int camera4IdCam = cameraManager.addNewCamera(camera4);
		int camera5IdCam = cameraManager.addNewCamera(camera5);
		int camera6IdCam = cameraManager.addNewCamera(camera6);
	}
	
	@Test
	public void addCameraCheck() {

		Camera camera5 = new Camera();
		camera5.setName(NAME_5);
		camera5.setModel(MODEL_5);

		int camera5IdCam = cameraManager.addNewCamera(camera5);

        Camera retrievedCamera = cameraManager.findCameraById(camera5IdCam);
        assertEquals(NAME_5, retrievedCamera.getName());
        assertEquals(MODEL_5, retrievedCamera.getModel());
		
	}
	
	@Test
	public void readAllCamera() {
        List<Camera> allCamera = cameraManager.getAllCamera();

        assertEquals(2, allCamera.size());
	}
	
	// read by id
    public void readCameraById() {
            int id = 2;

            Camera retrievedCamera = cameraManager.findCameraById(id);
            assertEquals(NAME_2, retrievedCamera.getName());
            assertEquals(MODEL_2, retrievedCamera.getModel());
    }

    @Test
    // delete
    public void delCamera() {
            Camera retrievedCamera = cameraManager.findCameraById(1);
            cameraManager.delCamera(retrievedCamera);

            assertEquals(null, cameraManager.findCameraById(1));
    }
    
    @Test
    // update
    public void upCamera() {
            int id = 3;
            Camera retrievedCamera = cameraManager.findCameraById(id);
            retrievedCamera.setName(NAME_2);
            retrievedCamera.setModel(MODEL_2);
            cameraManager.upCamera(retrievedCamera);
            retrievedCamera = cameraManager.findCameraById(id);

            assertEquals(NAME_2, retrievedCamera.getName());
            assertEquals(MODEL_2, retrievedCamera.getModel());
    }
	
}
