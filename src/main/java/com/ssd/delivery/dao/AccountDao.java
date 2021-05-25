package com.ssd.delivery.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.delivery.domain.Account;

public interface AccountDao {
	void insert(Account account) throws DataAccessException;
	
	void update(Account account) throws DataAccessException;
	
	void delete(String username) throws DataAccessException;
	
	List<Account> getUserListByAuctionId(String auctionId) throws DataAccessException;
	
	List<Account> getUserListByCPId(String CPId) throws DataAccessException;
	
	boolean existingUser(String username) throws DataAccessException;
	
	List<Account> getFavoriteUserList(String username) throws DataAccessException;
	
	Account findUser(String username) throws DataAccessException;

}
