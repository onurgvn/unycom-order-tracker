<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Orders</title>
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>UNYCOM - Order Tracker</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <!--  add our html table here -->
        <h2>Orders of the Customer </h2>
        <table>
            <tr>
                <th>Order Date</th>
                <th>Status</th>
            </tr>
            <!-- loop over and print our orders -->
            <c:forEach var="tempOrder" items="${orders}">
                <tr style="cursor: pointer"
                    onclick="location.href='${pageContext.request.contextPath}/orders/orderdetails/${tempOrder.id}'">
                    <td>${tempOrder.orderDate}</td>
                    <td>${tempOrder.status}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="Back to Customers"
               onclick="location.href='${pageContext.request.contextPath}/customers'"
               class="add-button"/>
    </div>
</div>
</body>
</html>