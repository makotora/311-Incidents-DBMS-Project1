package com.incidents.entitiesMongo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.demo.Incident;

public interface IncidentDAO extends MongoRepository<Incident, Integer>{

	
	@Query("{ 'ZIP' : 60629 }")
	List<Incident> findByBy();
	
	List<Incident> findByCommunityArea(Integer communityArea);
	
	@Query("{'CREATION DATE' : { '$gte' : { '$date' : '?0' }, '$lte' : { '$date' : '?1' } }}")
	List<Incident> findLala(String d1, String d2);
	
//	@Query("{'CREATION DATE' : { '$gte' : ISODate('2008-01-01T00:00:00.000+0000'), '$lte' : ISODate('2009-04-01T00:00:00.000+0000')}")
	

	
}
