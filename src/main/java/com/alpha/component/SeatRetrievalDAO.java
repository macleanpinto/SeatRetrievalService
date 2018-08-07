package com.alpha.component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alpha.dto.BayRequestDTO;
import com.alpha.dto.BayResultDTO;
import com.alpha.dto.SeatsInfoDTO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Component("seatRetrievalDAO")
public class SeatRetrievalDAO {

	public static final Logger logger = LoggerFactory.getLogger(SeatRetrievalDAO.class);

	@Autowired
	@Qualifier("mongoClient")
	private MongoClient mongoClient;
	
	

	public BayResultDTO fetchBayLayout(BayRequestDTO requestDTO) {
		DB database =mongoClient.getDB("seat_allocation_web_app");
		DBCollection collection = database.getCollection("BAY_LAYOUT");
		DBObject query = new BasicDBObject();
		query.put("bayId", requestDTO.getBayId());
		query.put("wingId", requestDTO.getWingId());
		query.put("floorId", requestDTO.getFloorNumber());
		DBCursor results = collection.find(query);

		BayResultDTO bayResultDTO = new BayResultDTO();
		for (DBObject singleItem : results) {
			bayResultDTO.setBayId(String.valueOf(singleItem.get("bayId")));
			bayResultDTO.setFloorNumber((Long) singleItem.get("floorId"));
			bayResultDTO.setWingId(String.valueOf(singleItem.get("wingId")));
		}
		return bayResultDTO;

	}

	public Long fetchLayoutIds(BayRequestDTO requestDTO) {
		DB database =mongoClient.getDB("seat_allocation_web_app");
		DBCollection collection = database.getCollection("BAY");
		DBObject query = new BasicDBObject();
		query.put("bayId", requestDTO.getBayId());
		query.put("wingId", requestDTO.getWingId());
		query.put("floorId", requestDTO.getFloorNumber());
		DBObject results = collection.findOne(query);

		Long layoutId= (Long) results.get("layoutId");
		return layoutId;

	}

	public List<SeatsInfoDTO> fetchSeatsLayout(Long layoutId) {
		DB database =mongoClient.getDB("seat_allocation_web_app");

		DBCollection collection = database.getCollection("SEAT_LAYOUT");
		DBObject query = new BasicDBObject();
		query.put("layoutId", layoutId);
		DBCursor results = collection.find(query);
		results.sort(new BasicDBObject("seatRowNum",1).append("seatColummnNum",1));
		

		List<SeatsInfoDTO> seatInfoList = new ArrayList<>();
		try{
		for (DBObject singleItem : results) {
			SeatsInfoDTO seatDetails = new SeatsInfoDTO();
			seatDetails.setSeatColumn((Long) singleItem.get("seatColummnNum"));
			seatDetails.setSeatRowNum((Long) singleItem.get("seatRowNum"));
			seatDetails.setLayoutId((Long) singleItem.get("layoutId"));
			seatDetails.setSeatName(String.valueOf(singleItem.get("seatName")));
			seatDetails.setSeatOccupant(String.valueOf(singleItem.get("seatOccupant")));
			seatDetails.setSeatId(String.valueOf(singleItem.get("seatId")));
			seatInfoList.add(seatDetails);
		}
		}
		catch(Exception e) {
			logger.error("Exception Occured{}".concat(e.getMessage()));

		}	return seatInfoList;

	}

}
