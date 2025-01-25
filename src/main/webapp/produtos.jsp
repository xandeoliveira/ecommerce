<%@page import="java.util.List"%>
<%@page import="com.ecstore.model.Produto" %>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>

<%
	List<Produto> produtos = (List<Produto>) request.getAttribute("produtos"); 
%>

<main>
    <h2>Produtos</h2>
    
    <%
    	for(Produto produto : produtos){
    %>
    <div class="produto">
	    <img src="" alt="<%=produto.getDescricao() %>">
	    <p><strong><%=produto.getDescricao() %></strong></p>
	    <p>R$ <%=produto.getPreco() %></p>
	    <button>Adicionar ao Carrinho</button>
	</div>
	<%} %>
    
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
