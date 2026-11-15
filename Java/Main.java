public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Aluno aluno = new Aluno("Ana");
        Professor professor = new Professor("Carlos");

        Livro livro1 = new Livro(1, "Dom Casmurro");
        Livro livro2 = new Livro(2, "O Cortico");
        Livro livro3 = new Livro(3, "Iracema");
        Revista revista1 = new Revista(4, "Ciencia Hoje");
        Revista revista2 = new Revista(5, "Historia");

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        biblioteca.listarAcervo();
        System.out.println("\nTESTANDO EMPRESTIMOS");
        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(revista1, aluno);
        biblioteca.emprestar(livro3, aluno); // Recusado: aluno ja tem 3 itens.
        biblioteca.emprestar(livro3, professor);

        biblioteca.listarAcervo();
        System.out.println("\nTESTANDO DEVOLUCAO");
        biblioteca.devolver(revista1, aluno, 2);
        biblioteca.listarAcervo();
    }
}
