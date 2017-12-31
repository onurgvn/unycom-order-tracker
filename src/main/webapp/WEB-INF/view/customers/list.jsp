<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
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
                <th>Name</th>
                <th>Location</th>
                <th>Registration Date</th>
                <th>Active</th>
                <th>Type</th>
                <th>VIP</th>
            </tr>
            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">
                <tr style="cursor: pointer"
                    onclick="location.href='${pageContext.request.contextPath}/orders/${tempCustomer.code}'">
                    <td>${tempCustomer.name}</td>
                    <td>${tempCustomer.location}</td>
                    <td>${tempCustomer.registrationDate}</td>
                    <td>${tempCustomer.active}</td>
                    <td>${tempCustomer.type}</td>
                    <td>
                        <c:if test="${tempCustomer.type == 'VIP'}">
                            <img src="${pageContext.request.contextPath}/resources/star.jpg" alt="VIP" height="15"
                                 width="15"/>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>