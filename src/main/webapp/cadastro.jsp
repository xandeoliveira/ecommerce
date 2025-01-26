<%@page import="com.ecstore.model.Usuario" %>
<jsp:include page="header.jsp">
	<jsp:param name="header" value="header.jsp" />
</jsp:include>

<main>
    <section class="cadastro-container">
        <h2>Cadastro de Novo Usuário</h2>
        
        <form id="cadastro-form" method="post" action="cadastro">
                <input type="text" id="nome" name="nome" placeholder="Digite seu nome completo" required>
                
                <input type="email" id="email" name="email" placeholder="Digite seu email" required>
                
                <input type="text" id="endereco" name="endereco" placeholder="Digite seu endereço" required>
                
                <input type="text" id="login" name="login" placeholder="Crie um login" required>
                
                <input type="password" id="senha" name="senha" placeholder="Crie uma senha 5 ou mais caracteres" required>
            </div>

            <input type="submit" class="btn-cadastrar" value="Cadastrar">
        </form>

        <div class="cadastro-link">
            <h3>Já tem uma conta?</h3>
            <a href="/ecommerce/login" class="btn-login">Entrar</a>
        </div>
    </section>
</main>
<script src="../js/validacao.js"></script>

<jsp:include page="footer.jsp">
	<jsp:param name="footer" value="footer.jsp" />
</jsp:include>
