<%@page import="java.util.List"%>
<%@page import="com.ecstore.model.Produto" %>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>

<%
	//List<Produto> produtos = (List<Produto>)request.getAttribute("produtos"); 
%>
<main>
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
	            <tr>
	                <td>Produto</td>
	                <td>Quantidade</td>
	                <td>Preço Unitário</td>
	                <td>Subtotal</td>              
	            </tr>
            </tbody>
        </table>

        <div class="carrinho-total">
            <p><strong>Total:</strong> <span id="carrinho-total">R$ 0,00</span></p>
            <button class="btn-finalizar">Finalizar Compra</button>
            <button class="btn-cancelar">Cancelar Compra</button>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
