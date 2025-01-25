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
    <header-component></header-component>

    <main>
        
        <h2>Produtos</h2>
        <div class="container-produtos">
           
            <div class="produto">
                <img src="https://media.istockphoto.com/id/482748813/pt/foto/vintage-velho-computador-arredondado-monitor-teclado-e-relan%C3%A7amento-dos-anos-80-fundo-branco.jpg?s=612x612&w=0&k=20&c=9-c6e7CZT87EUunBEtVEq0lignErekR0Eoz1y6-T6SA=" alt="Computador Antigo">
                <p><strong>Computador Antigo</strong></p>
                <p>R$ 199,90</p>
                <button>Adicionar ao Carrinho</button>
            </div>

           
            <div class="produto">
                <img src="https://media.istockphoto.com/id/496859509/pt/foto/monitor-de-computador.jpg?s=612x612&w=0&k=20&c=Wc3fzXa5d_b-QWpjwz_c8DzrWHICId0_B3kOOUFpTLk=" alt="Televisão Retrô" id="157">
                <p><strong>Monitor Retrô</strong></p>
                <p>R$ 299,90</p>
                <button>Adicionar ao Carrinho</button>
            </div>

            
            <div class="produto">
                <img src="https://media.istockphoto.com/id/471068599/pt/foto/vintage-de-m%C3%A1quina-de-escrever.jpg?s=612x612&w=0&k=20&c=UzBdhQ8abO7dk8FNd2dAdG9k3Vk_Qa1sWuALeFhbXng=" alt="Máquina de Escrever">
                <p><strong>Máquina de Escrever</strong></p>
                <p>R$ 159,90</p>
                <button>Adicionar ao Carrinho</button>
            </div>

            
            <div class="produto">
                <img src="https://www.creativefabrica.com/wp-content/uploads/2022/12/11/Vintage-Camera-Graphic-51649209-1.png" alt="Câmera Vintage">
                <p><strong>Câmera Vintage</strong></p>
                <p>R$ 249,90</p>
                <button>Adicionar ao Carrinho</button>
            </div>
        </div>

        <section class="categoria">
            <h2>Computadores</h2>

            <div class="container-produtos">
                <div class="produto">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxN3b8qxJdDlxNFM6DhV9DSmAHOk2tEJwTg&s" alt="Produto 1">
                    <p><strong>Computador Gamer</strong></p>
                    <p>R$ 1909,90</p>
                    <button>Adicionar ao Carrinho</button>
                </div>
                <!-- Mais produtos -->
            </div>
        </section>
        
        <section class="categoria">
            <h2>Eletrônicos</h2>
            <div class="container-produtos">
                <div class="produto">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjaWjp9l6huTeWkF-ZbrDpfluWfh8lBZcF3A&s">
                    <p><strong>Capacitores</strong></p>
                    <p>R$ 0,90</p>
                    <button>Adicionar ao Carrinho</button>
                </div>

                <div class="produto">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIEGgxZfbxHL5gU_TGdS4Te5cmviXEq-s3aw&s">
                    <p><strong>Indutor</strong></p>
                    <p>R$ 4,90</p>
                    <button>Adicionar ao Carrinho</button>
                </div>
                
            </div>
        </section>

        <section class="categoria">
            <h2>Periféricos</h2>
            <div clas="container-produtos">
                <div class="produto">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMNFSMAnnQyZGV-FWH3KrzpirF1ffCOrsIxA&s">
                    <p><strong>Teclado</strong></p>
                    <p>R$ 43,90</p>
                    <button>Adicionar ao Carrinho</button>
                </div>

            </div>  

        </section>

        <section class="categoria">
            <h2>Peças de hardware</h2>
            <div clas="container-produtos">
                <div class="produto">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSe_C80lNVzMJZKZZsmum7Cjqy4P0Yjiy70Lg&s">
                    <p><strong>RAM</strong></p>
                    <p>R$ 4,90</p>
                    <button>Adicionar ao Carrinho</button>
                </div>

            </div>  

        </section>
        
    </main>

    <footer-component></footer-component>
    
</body>
</html>