package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.OrderInfor;

public interface OrderInforService {

	int saveOrderInforAndReturnId(OrderInfor OrderInfor);

	int updateOrderInfor(OrderInfor OrderInfor);

	OrderInfor findOneByOutTradeNo(String out_trade_no);

	List<OrderInfor> findSellerOrderListByUserId(Integer userId);

	List<OrderInfor> findBuyerOrderListByUserId(Integer userId);

	int deleteSellerOrderInforById(Integer orderId);

	int deleteBuyerOrderInforById(Integer orderId);
	
	List<OrderInfor> findDeletedSellerOrderListByUserId(Integer userId);
	
	List<OrderInfor> findDeletedBuyerOrderListByUserId(Integer userId);

	int deleteOrderInforByIdAndType(Integer orderId, String orderType);

	List<OrderInfor> findDeletedOrderListByUserIdAndType(Integer userId, String orderType);
	
}
