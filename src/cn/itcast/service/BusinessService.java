package cn.itcast.service;

import java.util.Map;

import cn.itcast.domain.Book;
import cn.itcast.dao.BookDao;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;

//业务层，统一对web层提供所有服务
public class BusinessService {
    private BookDao dao = new BookDao();

    public Map getAll() {
        return dao.getAll();
    }

    public Book findBook(String id) {
        return (Book) dao.getAll().get(id);
    }

    //删除购物车中的购物项
    public void deleteCartItem(String id, Cart cart) {
        cart.getMap().remove(id);
    }

    //清空购物车
    public void clearCart(Cart cart) {
        cart.getMap().clear();
    }


    //改变购物数量
    public void changeItemQuantity(String id, String quantity, Cart cart) {
        CartItem item = cart.getMap().get(id);
        item.setQuantity(Integer.parseInt(quantity));

    }
}
