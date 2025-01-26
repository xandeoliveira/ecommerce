<%@page import="com.ecstore.model.Carrinho" %>
<%@page import="com.ecstore.model.Usuario" %>
<%@page import="com.ecstore.model.Produto" %>
<%@page import="com.ecstore.dao.ProdutoDAO" %>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>

<%
Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
List<Carrinho> itensCarrinho = (List<Carrinho>) session.getAttribute("itensCarrinho");
%>

<main>
    <h2>Carrinho</h2>
    
    <%
    if(usuario != null) {
    %>
    <h2>Seu Carrinho de Compras</h2>
    <div class="carrinho-container">
        <!-- Itens do carrinho -->
        <table>
            <thead>
                <tr>
                    <th>Produto</th>
                    <th>Quantidade</th>
                    <th>Preço Unitário</th>
                    <th>Subtotal</th>           
                </tr>
            </thead>
            <tbody id="carrinho-itens">
            <%
            if(itensCarrinho != null) {
            	for(Carrinho item : itensCarrinho) {
            		Produto produto = new ProdutoDAO().read(item.getProdutoId());
            %>
	            <tr>
	                <td><%=produto.getDescricao() %></td>
	                <td><%=item.getQuantidade() %></td>
	                <td><%=produto.getPreco() %></td>
	                <td><%=item.getSubtotal(produto.getPreco()) %></td>              
	            </tr>
	        <%	}
            } %>
            </tbody>
        </table>

        <div class="carrinho-total">
            <p><strong>Total:</strong> <span id="carrinho-total">R$ 0,00</span></p>
            <button class="btn-finalizar">Finalizar Compra</button>
            <button class="btn-cancelar">Cancelar Compra</button>
        </div>
    </div>
    <%} else{ %>
    	<h3>Ainda não fez login.</h3>
        <a href="login">Login</a>
	<%}%>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
