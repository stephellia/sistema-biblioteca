public class Biblioteca {
    private ItemBiblioteca[] itens = new ItemBiblioteca[10];
    private Usuario[] quemPegou = new Usuario[10];
    private int totalItens = 0;

    public void cadastrarItem(ItemBiblioteca item) {
        if (totalItens < itens.length) {
            itens[totalItens] = item;
            totalItens++;
        } else {
            System.out.println("Nao tem mais espaco para cadastrar itens.");
        }
    }

    public void emprestar(ItemBiblioteca item, Usuario usuario) {
        int posicao = -1;
        for (int i = 0; i < totalItens; i++) {
            if (itens[i] == item) {
                posicao = i;
                break;
            }
        }

        if (posicao == -1) {
            System.out.println("Item nao cadastrado.");
        } else if (!item.isDisponivel()) {
            System.out.println("O item ja esta emprestado.");
        } else if (usuario.getQuantidadeEmprestada() >= usuario.limiteItens()) {
            System.out.println("Emprestimo recusado: " + usuario.getNome() + " atingiu o limite.");
        } else {
            item.emprestarItem();
            usuario.pegarItem();
            quemPegou[posicao] = usuario;
            System.out.println("Emprestimo realizado: " + item.getTitulo() + " para " + usuario.getNome());
            System.out.println("Prazo: " + item.prazoEmprestimo() + " dias.");
        }
    }

    public void devolver(ItemBiblioteca item, Usuario usuario, int diasAtraso) {
        int posicao = -1;
        for (int i = 0; i < totalItens; i++) {
            if (itens[i] == item) {
                posicao = i;
                break;
            }
        }

        if (posicao == -1 || item.isDisponivel()) {
            System.out.println("Esse item nao esta emprestado.");
        } else if (quemPegou[posicao] != usuario) {
            System.out.println("Esse item foi emprestado para outra pessoa.");
        } else {
            item.devolverItem();
            usuario.entregarItem();
            quemPegou[posicao] = null;
            System.out.println("Devolucao realizada: " + item.getTitulo());
            System.out.printf("Multa: R$ %.2f%n", item.calcularMulta(diasAtraso));
        }
    }

    public void listarAcervo() {
        System.out.println("\nACERVO DA BIBLIOTECA");
        for (int i = 0; i < totalItens; i++) {
            System.out.println(itens[i].getCodigo() + " - " + itens[i].getTitulo()
                    + " | Disponivel: " + itens[i].isDisponivel()
                    + " | Prazo: " + itens[i].prazoEmprestimo() + " dias");
        }
    }
}
