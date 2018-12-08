package com.incidents.web;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.LightsAllOut;
import com.incidents.entities.MyUser;
import com.incidents.entities.TreeTrims;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.services.Users;
import com.incidents.services.impl.LightsAllOutService;
import com.incidents.services.impl.TreeTrimsService;

@RestController
public class LightsAllOutEndpoint {

	  @Autowired
	  private Users userService;
	  
	  @Autowired
	  private LightsAllOutService service;
	  
	  @RequestMapping(value = "/lightsAllOutEndpoint/create", method = RequestMethod.POST, headers = "Accept=application/json")
	  public LightsAllOut create(Principal principal, String srn, String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, Date createdAt, Date completionDate) {
		  MyUser user;
		  
		    if (principal != null) {
		        try {
		          user = userService.findByUsername(principal.getName());
		        } catch (EntityNotFoundException e) {
		          return null;
		        }
		      } else {
		        return null;
		      }
		    
		    return service.create(srn, status, streetAddress, xCoordinate, yCoordinate, ward, policeDistrict, communityArea, latitude, longitude, location, createdAt, completionDate);
		    
	  }
	
}