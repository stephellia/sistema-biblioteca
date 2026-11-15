-- Exercicio 3: consultas da biblioteca

-- 1. Listar todos os itens do acervo.
SELECT codigo, titulo, tipo, disponivel
FROM item;

-- 2. Mostrar os emprestimos que ainda nao foram devolvidos.
SELECT usuario.nome, item.titulo, emprestimo.data_retirada, emprestimo.data_devolucao_prevista
FROM emprestimo
JOIN usuario ON emprestimo.usuario_id = usuario.id
JOIN item ON emprestimo.item_id = item.id
WHERE emprestimo.data_devolucao IS NULL;

-- 3. Somar as multas de cada usuario.
SELECT usuario.nome, COALESCE(SUM(emprestimo.valor_multa), 0) AS total_multas
FROM usuario
LEFT JOIN emprestimo ON usuario.id = emprestimo.usuario_id
GROUP BY usuario.id, usuario.nome;

-- 4. Listar os itens que nunca foram emprestados.
SELECT item.codigo, item.titulo
FROM item
LEFT JOIN emprestimo ON item.id = emprestimo.item_id
WHERE emprestimo.id IS NULL;
