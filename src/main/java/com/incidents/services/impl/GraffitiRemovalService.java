package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.GraffitiRemoval;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.GraffitiRemovalDAO;
import com.incidents.repositories.IncidentDAO;
import java.util.UUID;

@Service("GraffitiRemoval")
public class GraffitiRemovalService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	GraffitiRemovalDAO dao;
	
	@Transactional
	public GraffitiRemoval create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location, String typeOfSurface, String located, String ssa) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.GRAFFITI_REMOVAL);
		newIncident.setStatus(status);
		newIncident.setStreetAddress(streetAddress);
		newIncident.setZipCode(zipCode);
		newIncident.setxCoordinate(xCoordinate);
		newIncident.setyCoordinate(yCoordinate);
		newIncident.setWard(ward);
		newIncident.setPoliceDistrict(policeDistrict);
		newIncident.setCommunityArea(communityArea);
		newIncident.setLatitude(latitude);
		newIncident.setLongitude(longitude);
		newIncident.setLocation(location);
		newIncident.setSrn(UUID.randomUUID().toString());
		incidentDao.save(newIncident);
		
		
		GraffitiRemoval newGraffitiRemoval = new GraffitiRemoval();
		newGraffitiRemoval.setIncident(newIncident);
		newGraffitiRemoval.setTypeOfSurface(typeOfSurface);
		newGraffitiRemoval.setLocated(located);
		newGraffitiRemoval.setSsa(ssa);
		
		dao.save(newGraffitiRemoval);
		return newGraffitiRemoval;
	}
	
}
