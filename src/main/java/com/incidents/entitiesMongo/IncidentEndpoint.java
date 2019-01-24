package com.incidents.entitiesMongo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentEndpoint {

	@Autowired
	private IncidentDAO inDao;

	@RequestMapping(value = "/view", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public List<Incident> create(@RequestParam("d1") String d1, @RequestParam("d2") String d2) {
		System.out.println("d1: " + d1 + "\nd2 "+ d2);
		List<Incident> s = inDao.findLala(d1, d2);
		System.out.println(s.size());
		for (Incident incident : s) {
			System.out.println(s.toString());
		}
	
		return s;
		
	}
}
