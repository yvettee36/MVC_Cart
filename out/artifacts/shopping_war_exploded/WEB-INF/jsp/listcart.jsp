<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>购物车列表</title>
    <script type="text/javascript">
        function deleteitem(id) {
            var b = window.confirm("真的删除吗?");
            if (b) {
                window.location = "${pageContext.request.contextPath }/servlet/DeleteItemServlet?id=" + id;
            }
        }
        function clearcart() {
            var b = window.confirm("真的清空吗?");
            if (b) {
                window.location = "${pageContext.request.contextPath }/servlet/ClearCartServlet";
            }
        }
        function changeQuantity(input, id, oldvalue) {
            //alert(input.value);
            //检查数量是不是一个数字，且是正整数
            var quantity = input.value;
            if (quantity < 0 || quantity != parseInt(quantity)) {
                alert("请输入正整数");
                input.value = oldvalue;
                return;
            }
            var b = window.confirm("确定修改吗?");
            if (b) {
                window.location = "${pageContext.request.contextPath }/servlet/ChangeQuantityServlet?id=" + id + "&quantity=" + quantity;
            }
        }
    </script>
</head>

<body style="text-align:center">
<h1>购物车列表</h1>
<c:if test="${empty(cart.map)}">
    你没有购买任何商品
</c:if>
<c:if test="${!empty(cart.map)}">
    <table width="70%" border="1" align="center">
        <tr>
            <td>书名</td>
            <td>作者</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
            <td>操作</td>
        </tr>
        <c:forEach var="entry" items="${cart.map}">
            <tr>
                <td>${entry.value.book.name }</td>
                <td>${entry.value.book.author }</td>
                <td>${entry.value.book.price }</td>
                <td>
                    <input type="text" name="quantity" value="${entry.value.quantity }"
                           onchange="changeQuantity(this,${entry.key},${entry.value.quantity })"/>
                </td>
                <td>${entry.value.price }</td>
                <td><a href="javascript:void(0);" target="_blank"
                       onclick="deleteitem(${entry.key});return false;">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3">总价计</td>
            <td colspan="2">${cart.price }元</td>
            <td colspan="1"><a href="javascript:void(0);" target="_blank" onclick="clearcart();return false;">清空购物车</a>
            </td>
        </tr>
    </table>
</c:if>
</body>
</html>
