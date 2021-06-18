package com.ssd.delivery.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.AuctionDTO;
import com.ssd.delivery.domain.Order;

public interface AuctionDao {
		  
	  void insertAuction(AuctionDTO auction) throws DataAccessException;
	  void updateAuction(AuctionDTO auction) throws DataAccessException;
	  void deleteAuction(int auctionId) throws DataAccessException;
	  
	  AuctionDTO getAuctionById(int auctionId) throws DataAccessException;
	  List<AuctionDTO> getAuctionByUsername(String username) throws DataAccessException;
	  List<AuctionDTO> getAuctionList() throws DataAccessException;

}
