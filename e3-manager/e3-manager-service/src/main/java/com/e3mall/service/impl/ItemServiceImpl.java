package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem findItemById(long itemId) {
		// return tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
