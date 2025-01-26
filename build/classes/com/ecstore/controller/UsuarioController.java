package com.ecstore.controller;

import com.ecstore.dao.UsuarioDAO;
import com.ecstore.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        // Inicializa a conexão com o banco de dados e a classe DAO
        Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
        usuarioDAO = new UsuarioDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("cadastrar".equals(action)) {
                cadastrarUsuario(req, resp);
            } else if ("autenticar".equals(action)) {
                autenticarUsuario(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro no processamento: " + e.getMessage());
        }
    }

    private void cadastrarUsuario(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        // Recebe os dados do formulário
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        // Cria um novo objeto Usuario
        Usuario usuario = new Usuario(0, email, nome, endereco, login, senha);

        // Salva o usuário no banco de dados
        usuarioDAO.create(usuario);

        // Redireciona para uma página de sucesso
        resp.sendRedirect("cadastroSucesso.jsp");
    }

    private void autenticarUsuario(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        // Recebe os dados do formulário
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        // Busca o usuário pelo login
        Usuario usuario = usuarioDAO.listAll()
            .stream()
            .filter(u -> u.getLogin().equals(login))
            .findFirst()
            .orElse(null);

        // Verifica se o usuário foi encontrado e se a senha é válida
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Armazena o usuário na sessão
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);

            // Redireciona para a página inicial
            resp.sendRedirect("home.jsp");
        } else {
            // Redireciona para a página de login com erro
            resp.sendRedirect("login.jsp?erro=true");
        }
    }
}
