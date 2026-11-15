-- Exercicio 2: tabelas da biblioteca
-- As duas primeiras tabelas precisam existir antes de emprestimo.

CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao VARCHAR(30),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(15) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INTEGER NOT NULL CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL REFERENCES item(id),
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0
);

-- Dados para testar
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L001', 'Dom Casmurro', 'livro', 'Machado de Assis', '1', FALSE),
('L002', 'O Cortico', 'livro', 'Aluisio Azevedo', '2', TRUE),
('R001', 'Ciencia Hoje', 'revista', 'Editora Ciencia Hoje', '10', TRUE),
('L003', 'Iracema', 'livro', 'Jose de Alencar', '1', TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Ana', 'aluno', 3),
('Carlos', 'professor', 5);

-- Primeiro emprestimo ainda esta em aberto.
INSERT INTO emprestimo
(item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES
(1, 1, '2026-11-01', '2026-11-15', NULL, 0.00),
(3, 2, '2026-10-20', '2026-10-27', '2026-10-29', 2.00);
