<%@page import="com.ecstore.model.Usuario" %>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>


<main>
    <section class="login-container">
        <h2>Login</h2>

        <%
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if(usuario == null){
        %>
        <form id="login-form" method="post" action="login">
            <input type="text" id="login" name="login" placeholder="Digite seu usuário" required>
            
            <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>
            
            <input type="submit" class="btn-login" value="Entrar">
        </form>
        
        <div class="help-text">
            <a href="html/recuperar_senha.html">Esqueceu sua senha?</a>
        </div>
        
        <div class="cadastro-link">
            <h3>Ainda não possui cadastro?</h3>
            <a href="/ecommerce/ControllerCadastro" class="btn-cadastro">Criar Conta</a>
        </div>
        <%} else { %>
        <h3>Já está logado.</h3>
        <a href="/ecommerce/logout">Deslogar</a>
        <%} %>
    </section>
</main>
<script src="../js/validacao.js"></script>

<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
