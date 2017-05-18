package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;

//删除指定的购物项
public class DeleteItemServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        BusinessService service = new BusinessService();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        service.deleteCartItem(id, cart);
        request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
    }
}
