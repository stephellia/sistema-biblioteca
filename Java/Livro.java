public class Livro extends ItemBiblioteca {
    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    public int prazoEmprestimo() {
        return 14;
    }

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }
        return diasAtraso * 0.50;
    }
}
