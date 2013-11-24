package com.example.shdemo.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Camera;

@Component
@Transactional
public abstract class CameraMangerHibernateImpl implements CameraManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//dodanie nowej kam
	@Override
	public int addNewCamera(Camera camera) {
		return (Integer) sessionFactory.getCurrentSession().save(camera);	
	}
	
	//znajezienie kam po id
	public Camera fingCamerabyId(int idCam){
		return (Camera) sessionFactory.getCurrentSession().get(Camera.class, idCam);
	}
	
	//update kam
	public void upCamera(Camera camera){
		sessionFactory.getCurrentSession().update(camera);
	}
	
	//delete kam
	public void delCamera(Camera camera){
		sessionFactory.getCurrentSession().delete(camera);
	}
	
	//wyswietlanie wszystkich kam
	@SuppressWarnings("unchecked")
	public List<Camera> getAllCamera(){
		return sessionFactory.getCurrentSession().getNamedQuery("camera.all").list();
		
	}
}