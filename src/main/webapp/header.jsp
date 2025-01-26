<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Engenharia de Computação Store</title>
    
    <link rel="shortcut icon" href="img/EC_Store_icon.ico" type="image/x-icon">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/produtos.css">

    <script src="js/components/header.js"></script>
    <script src="js/components/footer.js"></script>
</head>
<body>
	<header>
	    <img src="img/logo.png" alt="ECStore logo">
	    <nav>
	        <ul class="menu">
	            <li><a href="/ecommerce/home">Início</a></li>
	            <li><a href="/ecommerce/CarrinhoController">Carrinho</a></li>
	            <li><a href="login.html">Login</a></li>
	            <li><a href="cadastro.html">Cadastro</a></li>
	        </ul>
	    </nav>
        <form id="pesquisa" action="busca.html">
            <input type="text" placeholder="Buscar produtos..." id="campo-pesquisa">
            <button type="submit" onclick="buscar()">Buscar</button>
        </form>
        
    </header>