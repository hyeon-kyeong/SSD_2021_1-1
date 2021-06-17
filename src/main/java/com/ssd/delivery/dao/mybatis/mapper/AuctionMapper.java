/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


package com.ssd.delivery.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssd.delivery.domain.AuctionDTO;

/**
 * @author Eduardo Macarron
 */
@Mapper
public interface AuctionMapper {

	void insertAuction(AuctionDTO auction);
	void updateAuction(AuctionDTO auction);
	void deleteAuction(int auctionId);

	AuctionDTO getAuctionById(int auctionId);
	List<AuctionDTO> getAuctionByUsername(String username);
	List<AuctionDTO> getAuctionList();
}
