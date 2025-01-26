-- Tabelas
-- Tabela Usuário
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    endereco TEXT,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(25) NOT NULL
);

-- Tabela Produto
CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    categoria VARCHAR(50),
    quantidade INTEGER NOT NULL,
    preco NUMERIC(5, 2) NOT NULL,
    descricao TEXT,
    foto BYTEA -- Campo ajustado para armazenar a imagem
);

-- Tabela Compra
CREATE TABLE Compra (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuario_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    valor NUMERIC(5, 2) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario (id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto (id) ON DELETE CASCADE
);

-- Tabela Carrinho (associação entre Compra e Produto)
CREATE TABLE Carrinho (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Compra (id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto (id) ON DELETE CASCADE
);

-- Inserção de dados na tabela Usuario
INSERT INTO Usuario (email, nome, endereco, login, senha) VALUES
('maria.alencar@example.com', 'Maria Alencar', 'Avenida Central', 'maria', 'senha');

-- Inserção de dados na tabela Produto
INSERT INTO Produto (categoria, quantidade, preco, descricao, foto) VALUES
('Eletrônicos', 10, 91.89, 'Fone de ouvido Bluetooth', NULL),
('Eletrônicos', 10, 9100.89, 'MacBook Air', NULL),
('Eletrônicos', 10, 2890, 'Dell Inspiron', NULL),
('Eletrônicos', 10, 2849, 'Galaxy Book4', NULL),
('Eletrônicos', 10, 4100.89, 'Acer Nitro V15', NULL),
('Moda', 50, 59.90, 'Camiseta: Engenharia de Computação', NULL),
('Moda', 50, 29.90, 'Boné: Engenharia de Computação', NULL),
('Livros', 30, 239.90, 'Aprendendo SQL', NULL),
('Livros', 30, 289.90, 'SGBD', NULL),
('Livros', 30, 189.90, 'Física 2', NULL),
('Livros', 30, 559.90, 'Matemática Discreta', NULL);
