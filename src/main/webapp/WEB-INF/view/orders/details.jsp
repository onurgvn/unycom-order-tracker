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
        <table>
            <tr>
                <th>Order Date</th>
                <th>Confirmation Date</th>
                <th>Completion Date</th>
                <th>Product</th>
                <th>Original Price</th>
                <th>Final Price</th>
                <th>Status</th>
            </tr>
            <!-- loop over and print our orders -->
            <c:forEach var="tempOrder" items="${orders}">
                <tr>
                    <td>${tempOrder.orderDate}</td>
                    <td>${tempOrder.confirmationDate}</td>
                    <td>${tempOrder.completionDate}</td>
                    <td>${tempOrder.product}</td>
                    <td>${tempOrder.originalPrice}</td>
                    <td>${tempOrder.lastPrice}</td>
                    <td>${tempOrder.status}</td>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="Back to Orders"
               onclick="location.href='${pageContext.request.contextPath}/orders/${orders[0].customer.code}'"
               class="add-button"/>
    </div>
</div>
</body>
</html>