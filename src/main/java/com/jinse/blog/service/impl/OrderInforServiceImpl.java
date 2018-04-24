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
		criteria.andOutTradeNoEqualTo(orderInfor.getOutTradeNo());
		return orderInforMapper.updateByExample(orderInfor, orderInforExample);
	}

	@Override
	public List<OrderInfor> findSellerOrderListByUserId(Integer userId) {
		return orderInforMapper.findSellerOrderListByUserId(userId);
	}

	@Override
	public List<OrderInfor> findBuyerOrderListByUserId(Integer userId) {
		return orderInforMapper.findBuyerOrderListByUserId(userId);
	}


	@Override
	public int deleteSellerOrderInforById(Integer orderId) {
		return orderInforMapper.deleteSellerOrderInforById(orderId);
	}
	
	@Override
	public int deleteBuyerOrderInforById(Integer orderId) {
		return orderInforMapper.deleteBuyerOrderInforById(orderId);
	}

	@Override
	public List<OrderInfor> findDeletedSellerOrderListByUserId(Integer userId) {
		return orderInforMapper.findDeletedSellerOrderListByUserId(userId);
	}
	
	@Override
	public List<OrderInfor> findDeletedBuyerOrderListByUserId(Integer userId) {
		return orderInforMapper.findDeletedBuyerOrderListByUserId(userId);
	}

	@Override
	public int deleteOrderInforByIdAndType(Integer orderId, String orderType) {
		if(orderType.equals("seller")) {
			return orderInforMapper.deleteSellerOrderInforById(orderId);
		}else{
			return orderInforMapper.deleteBuyerOrderInforById(orderId);
		}
	}

	@Override
	public List<OrderInfor> findDeletedOrderListByUserIdAndType(Integer userId, String orderType) {
		if(orderType.equals("seller")) {
			return orderInforMapper.findDeletedSellerOrderListByUserId(userId);
		}else{
			return orderInforMapper.findDeletedBuyerOrderListByUserId(userId);
		}
	}


}
