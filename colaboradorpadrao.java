// ColaboradorPadrao.java - Subclasse

public class colaboradorpadrao extends colaborador {

    public colaboradorpadrao(String matricula, String nome, double salarioBase) {
        super(matricula, nome, salarioBase);
    }

    @Override
    public double calcularSalarioFinal() {
        return super.calcularSalarioFinal();
    }

    @Override
    public void exibirDados() {
        System.out.println("\n=== COLABORADOR PADRÃO ===");
        super.exibirDados();
    }
}
