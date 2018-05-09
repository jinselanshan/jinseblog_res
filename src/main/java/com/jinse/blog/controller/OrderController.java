package com.jinse.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.OrderInfor;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.OrderInforService;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.utils.BlogUtil;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.vos.BlogVO;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private OrderInforService orderInforService;

	// 找到卖出的order_infor列表
	@RequestMapping(value = "/order/seller/picture")
	public String sellerIndex(Model model, HttpServletRequest request) throws Exception {
		logger.info("进入卖出的order_info界面");
		// order_info 列表，与博客一对一
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		List<OrderInfor> orderInforList = orderInforService.findSellerOrderListByUserId(userId);
		model.addAttribute("orderInforList", orderInforList);
		model.addAttribute("type", "seller");
		return "buy/sellerIndex";
	}

	// 找到买到的order_info列表
	@RequestMapping(value = "/order/buyer/picture")
	public String buyerIndex(Model model, HttpServletRequest request) throws Exception {
		logger.info("进入买到的order_info界面");
		// order_info 列表，与博客一对一
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		List<OrderInfor> orderInforList = orderInforService.findBuyerOrderListByUserId(userId);
		model.addAttribute("orderInforList", orderInforList);
		model.addAttribute("type", "buyer");
		return "buy/sellerIndex";
	}

	// 找到回收站Seller order_info列表
	@RequestMapping(value = "/order/recycle/picture/{orderType}")
	public String recycleSellerIndex(@PathVariable("orderType") String orderType, Model model,
			HttpServletRequest request) throws Exception {
		logger.info("进入回收站order_info界面");
		// order_info 列表，与博客一对一
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		List<OrderInfor> orderInforList = orderInforService.findDeletedOrderListByUserIdAndType(userId, orderType);
		model.addAttribute("orderInforList", orderInforList);
		return "buy/sellerIndex";
	}

	// 删除order
	@RequestMapping(value = "/order/deleteOrderInfor/{orderType}/{orderId}")
	@ResponseBody
	public int deleteSellerOrderInfor(@PathVariable("orderId") Integer orderId,
			@PathVariable("orderType") String orderType, Model model, HttpServletRequest request) {
		logger.info("删除order");
		int count = orderInforService.deleteOrderInforByIdAndType(orderId, orderType);
		return count == 1 ? 1 : 0;
	}

	// 判断当前图片能否购买
	@RequestMapping(value = "/picture/ifCanBuy/{blogId}")
	@ResponseBody
	public int buySpan(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request) {
		logger.info("删除order");
		Blog blog = blogService.findBlogByBlogId(blogId);
		if (blog != null && blog.getPicture() != null && blog.getPicture().getBuy() != null
				&& !"Y".equals(blog.getPicture().getBuy())) {
			return 1;
		}
		return 0;
	}
}