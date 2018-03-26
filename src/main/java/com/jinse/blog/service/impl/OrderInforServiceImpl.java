package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.OrderInforMapper;
import com.jinse.blog.pojo.OrderInfor;
import com.jinse.blog.pojo.OrderInforExample;
import com.jinse.blog.pojo.OrderInforExample.Criteria;
import com.jinse.blog.service.OrderInforService;

public class OrderInforServiceImpl implements OrderInforService {

	@Autowired
	OrderInforMapper orderInforMapper;
	
	@Override
	public int saveOrderInforAndReturnId(OrderInfor orderInfor) {
		return orderInforMapper.saveOrderInforAndReturnId(orderInfor);
	}

	@Override
	public OrderInfor findOneByOutTradeNo(String out_trade_no) {
		// TODO Auto-generated method stub
		OrderInforExample orderInforExample = new OrderInforExample();
		Criteria criteria = orderInforExample.createCriteria();
		criteria.andOutTradeNoEqualTo(out_trade_no);

		List<OrderInfor> orderInforList= orderInforMapper.selectByExample(orderInforExample);

		return orderInforList.get(0);
	}

	@Override
	public int updateOrderInfor(OrderInfor orderInfor) {
		OrderInforExample orderInforExample = new OrderInforExample();
		Criteria criteria = orderInforExample.createCriteria();
		criteria.andTradeNoEqualTo(orderInfor.getTradeNo());
		return orderInforMapper.updateByExample(orderInfor, orderInforExample);
	}

}
