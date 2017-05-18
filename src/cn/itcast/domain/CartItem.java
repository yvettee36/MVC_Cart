package cn.itcast.domain;

//代表某个商品，以及商品出现的次数（购物项）
//这样设计不会出现重复商品的问题（比如买了一本javaweb，再次买就是数量+1）
public class CartItem {
    private Book book;
    private int quantity;
    private double price;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        price = book.getPrice() * quantity;
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
