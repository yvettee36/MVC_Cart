package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;
//把购物车中的书修改为指定数量
public class ChangeQuantityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String quantity=request.getParameter("quantity");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		BusinessService service=new BusinessService();
		service.changeItemQuantity(id,quantity,cart);
		request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
	}
}
