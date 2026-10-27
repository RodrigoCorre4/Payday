// ColaboradorProducao.java - Subclasse

public class colaboradorproducao extends colaborador {
    private int quantidadePecas;
    private double valorPorPeca;

    public colaboradorproducao(String matricula, String nome, double salarioBase, int quantidadePecas, double valorPorPeca) {
        super(matricula, nome, salarioBase);
        this.quantidadePecas = quantidadePecas >= 0 ? quantidadePecas : 0;
        this.valorPorPeca = valorPorPeca >= 0 ? valorPorPeca : 0;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        if (quantidadePecas >= 0) {
            this.quantidadePecas = quantidadePecas;
        }
    }

    public double getValorPorPeca() {
        return valorPorPeca;
    }

    public void setValorPorPeca(double valorPorPeca) {
        if (valorPorPeca >= 0) {
            this.valorPorPeca = valorPorPeca;
        }
    }

    public double calcularProdutividade() {
        return this.quantidadePecas * this.valorPorPeca;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularProdutividade();
    }

    @Override
    public void exibirDados() {
        System.out.println("\n=== COLABORADOR PRODUÇÃO ===");
        super.exibirDados();
        System.out.println("Quantidade de Peças: " + this.quantidadePecas);
        System.out.printf("Valor por Peça: R$ %.2f\n", this.valorPorPeca);
        System.out.printf("Adicional de Produtividade: R$ %.2f\n", calcularProdutividade());
    }
}
