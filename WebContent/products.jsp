<jsp:include page="/includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Products - All</h1>
<table>
<tr><th>Part #</th><th>Name</th><th>Price</th></tr>
<c:forEach var="p" items="${products}">
<tr><td>${p.partNumber}</td>
	<td>${p.name}</td>
	<td align="right" width='100'>${p.priceFormatted}</td></tr>
</c:forEach>
</table>
</body>
</html>