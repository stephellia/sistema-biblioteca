public class Revista extends ItemBiblioteca {
    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    public int prazoEmprestimo() {
        return 7;
    }

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }
        return diasAtraso * 1.00;
    }
}
