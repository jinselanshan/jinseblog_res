package com.jinse.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jinse.blog.config.AlipayConfig;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.OrderInfor;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.OrderInforService;
import com.jinse.blog.utils.SpringUtil;

@Controller
public class AlipayController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private OrderInforService orderInforService;

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/order/view")
	public void photoInfor(Model model, HttpServletRequest request, HttpServletResponse response,Blog blog, OrderInfor orderInfor)
			throws Exception {
		logger.info("获取article详情页");
		
		Blog blogRes = blogService.findBlogByBlogId(blog.getBlogId());
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		orderInfor.setOrderState("0");
		orderInfor.setBuyerId(userId);
		orderInfor.setBlogId(blogRes.getBlogId());
		orderInfor.setSellerId(blogRes.getUserId());
		orderInfor.setPictureId(blogRes.getPicture().getPictureId());
		orderInforService.saveOrderInforAndReturnId(orderInfor);

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		String out_trade_no = orderInfor.getOutTradeNo();
		// 付款金额，必填
		String total_amount = String.valueOf(orderInfor.getTotalAmount());
		// 订单名称，必填
		String title = orderInfor.getTitle();

		String message = "message";

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + title + "\"," + "\"body\":\"" + message + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		/*
		 * alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," +
		 * "\"total_amount\":\"" + total_amount + "\"," + "\"subject\":\"" + title
		 * +"\"," + "\"seller_id\":\"2088102175251970\"," +
		 * "\"product_code\":\"QUICK_WAP_PAY\"" + "}");
		 */
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		/*
		 * PrintWriter out = response.getWriter(); out.println(result);
		 */
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(result);// 直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
		// 请求
		//
		/*
		 * AlipayTradePagePayModel alimodel=new AlipayTradePagePayModel();
		 * alimodel.setOutTradeNo(out_trade_no); alimodel.setSubject(title);
		 * alimodel.setTotalAmount(total_amount);
		 * alimodel.setProductCode("FAST_INSTANT_TRADE_PAY"); alimodel.setBody(message);
		 * alipayRequest.setBizModel(alimodel); String form =
		 * alipayClient.pageExecute(alipayRequest).getBody();
		 * form=form.substring(0,form.indexOf("script")-1); map.put("result",form);
		 * return "alipay/alipay";
		 */

		/*
		 * response.setContentType("text/html;charset=" + AlipayConfig.charset);
		 * response.getWriter().write(result);// 直接将完整的表单html输出到页面
		 * response.getWriter().flush(); response.getWriter().close();
		 */
	}

	@RequestMapping("/return_url/view")
	public String returnUrl(Model model, HttpServletRequest request, HttpServletResponse response)
			throws AlipayApiException, UnsupportedEncodingException {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		// 切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
		// boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String
		// publicKey, String charset, String sign_type)
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type);
		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

			request.setAttribute("out_trade_no", out_trade_no);
			request.setAttribute("trade_no", trade_no);
			request.setAttribute("total_amount", total_amount);

			logger.info("订单处理：系统订单号" + out_trade_no + "支付宝交易号：" + trade_no);
			// 系统处理根据支付宝回调更改订单状态或者其他关联表的数据
			OrderInfor orderInfor = orderInforService.findOneByOutTradeNo(out_trade_no);
			if (orderInfor == null) {
				signVerified = false;
				request.setAttribute("signVerified", signVerified);
				request.setAttribute("reason", "商户订单号不存在");
				logger.error("系统订单：" + out_trade_no + "不存在。");
			} else {
				if (orderInfor.getTotalAmount() != null
						&& !orderInfor.getTotalAmount().toString().equals(total_amount)) {
					signVerified = false;
					request.setAttribute("signVerified", signVerified);
					request.setAttribute("reason", "付款金额不对");
					return "notify_url";
				}

				if (orderInfor.getTotalAmount() != null && orderInfor.getOrderState().equals("1")) {// 判断当前订单是否已处理，避免重复处理
					logger.info("系统订单：" + out_trade_no + "无需重复处理。");
				} else {
					orderInfor.setOrderState("1");// 修改订单状态为已支付
					Date payedAt = new Date();
					orderInfor.setTradeNo(trade_no);
					orderInfor.setPayedAt(payedAt);
					orderInfor.setSellerDeleted("N");
					orderInfor.setBuyerDeleted("N");
					orderInforService.updateOrderInfor(orderInfor);
					model.addAttribute("orderInfor", orderInfor);
					logger.info("系统订单：" + out_trade_no + "成功支付。");
				}

			}
		} else {
			request.setAttribute("reason", "验签失败");
		}
		request.setAttribute("signVerified", signVerified);
		return "alipay/return_url";
	}

	@RequestMapping("notify_url/view")
	public void notifyUrl(HttpServletRequest request, HttpServletResponse response)
			throws AlipayApiException, IOException {

		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		PrintWriter out = response.getWriter();

		// ——请在这里编写您的程序（以下代码仅作参考）——

		/*
		 * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）， 3、校验通知中的seller_id（或者seller_email)
		 * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		 * 4、验证app_id是否为该商户本身。
		 */
		if (signVerified) {// 验证成功
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
			}

			out.println("success");

		} else {// 验证失败
			out.println("fail");

			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);
		}
	}
}