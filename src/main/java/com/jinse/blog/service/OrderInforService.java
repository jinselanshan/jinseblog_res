package com.jinse.blog.service;

import com.jinse.blog.pojo.OrderInfor;

public interface OrderInforService {

	int saveOrderInforAndReturnId(OrderInfor OrderInfor);

	int updateOrderInfor(OrderInfor OrderInfor);

	OrderInfor findOneByOutTradeNo(String out_trade_no);

}
