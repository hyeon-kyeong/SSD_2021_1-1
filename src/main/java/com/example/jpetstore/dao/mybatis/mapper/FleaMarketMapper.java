package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;


import com.example.jpetstore.domain.ItemDTO;

public interface FleaMarketMapper {
	
	void create(ItemDTO item);
	void update(ItemDTO item);
	void remove(ItemDTO item);

	ItemDTO getFleaMarketById(int itemId);
	List<ItemDTO> findFleaMarketByUsername(String username);
	List<ItemDTO> findFleaMarketList();

}
