<%@page import="java.util.List"%>
<%@page import="com.ecstore.model.Usuario"%>
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
	    String categoria = produtos.get(0).getCategoria();
    %>
        <section class="categoria">
        <h2><%=categoria %></h2>
        <div class="container-produtos">
    <%
    	for(Produto produto : produtos){
    		if(categoria.equals(produto.getCategoria())){
    %>
		    <div class="produto">
			    <img src="img/no_image.jpg" alt="<%=produto.getDescricao() %>">
			    <p><strong><%=produto.getDescricao() %></strong></p>
			    <p>R$<%=String.format("%.2f", produto.getPreco()) %></p>
			    <p>Restam <%=produto.getQuantidade() %></p>
			    <form action="carrinho" method="post">
					<input type="hidden" name="produto_id" value="<%=produto.getId() %>" />
					<input type="hidden" name="quantidade" value="1" />
				    <button type="submit">Adicionar ao Carrinho</button>
			    </form>
			</div>
	<%	
	    	} else {
	    		categoria = produto.getCategoria();
	    	%>
	    	</div>
	    	</section>
	    	<section class="categoria container-produtos">
        	<h2><%=categoria %></h2>
        	<div class="container-produtos">
	    	<%
	    	}
    	}
    %>
    		</div>
	    	</section>
    <%
   	}else{%>
		<h3>Sem produtos para listar.</h3>
	<%} %>
    
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
