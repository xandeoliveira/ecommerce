<%@page import="java.util.List"%>
<%@page import="com.ecstore.model.Produto" %>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>

<%
	List<Produto> produtos = (List<Produto>)request.getAttribute("produtos"); 
%>

<main>
    <h2>Produtos</h2>
    
    <%
    if(produtos != null){
    	for(Produto produto : produtos){
    %>
    <div class="produto">
	    <img src="img/no_image.jpg" alt="<%=produto.getDescricao() %>">
	    <p><strong><%=produto.getDescricao() %></strong></p>
	    <p>R$ <%=produto.getPreco() %></p>
	    <p>Restam <%=produto.getQuantidade() %></p>
	    <button>Adicionar ao Carrinho</button>
	</div>
	<%}}else{%>
		<h3>Sem produtos para listar.</h3>
	<%} %>
    
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
