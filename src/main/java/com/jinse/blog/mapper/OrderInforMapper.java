package com.jinse.blog.mapper;

import com.jinse.blog.pojo.OrderInfor;
import com.jinse.blog.pojo.OrderInforExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInforMapper {
    int countByExample(OrderInforExample example);

    int deleteByExample(OrderInforExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInfor record);

    int insertSelective(OrderInfor record);

    List<OrderInfor> selectByExample(OrderInforExample example);

    OrderInfor selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderInfor record, @Param("example") OrderInforExample example);

    int updateByExample(@Param("record") OrderInfor record, @Param("example") OrderInforExample example);

    int updateByPrimaryKeySelective(OrderInfor record);

    int updateByPrimaryKey(OrderInfor record);

	int saveOrderInforAndReturnId(OrderInfor orderInfor);
}