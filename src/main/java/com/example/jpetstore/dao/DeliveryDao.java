package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.example.jpetstore.domain.DeliveryDTO;

public interface DeliveryDao {

	void create (DeliveryDTO delivery) throws DataAccessException;
	
	void update(DeliveryDTO delivery) throws DataAccessException;
	
	void remove(int deliveryId) throws DataAccessException;
	
	DeliveryDTO getDeliveryById(int deliveryId) throws DataAccessException;
	
	DeliveryDTO getDeliveryByUsername(String username) throws DataAccessException;
	
	List<DeliveryDTO> getDeliveryList() throws DataAccessException;
}
