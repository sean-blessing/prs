<jsp:include page="/includes/header.jsp" />
<%@ page import="java.util.ArrayList,prs.business.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Products - All</h1>
<table>
<tr><th>Part #</th><th>Name</th><th>Price</th></tr>
<%
ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
System.out.println(products.size());
for (Product p:products) {
%>
<tr><td><%=p.getPartNumber()%></td><td><%=p.getName()%></td><td align="right" width='100'><%=p.getPriceFormatted()%></td></tr>
<%	
}
%>
</table>
</body>
</html>