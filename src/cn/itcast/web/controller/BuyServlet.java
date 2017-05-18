package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;

public class BuyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        BusinessService service = new BusinessService();
        Book book = service.findBook(id);
        //得到用户的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //把书加到用户的购物车中
        cart.add(book);
        //用请求转发可以直接跳转到jsp，现在重新用servlet转到jsp多一个步骤，
        // 是因为服务器可以直接访问WEB-INF，外界访问不了WEB-INF目录
        response.sendRedirect(request.getContextPath() + "/servlet/ListcartUIServlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
