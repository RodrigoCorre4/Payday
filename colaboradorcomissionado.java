// ColaboradorComissionado.java - Subclasse

public class colaboradorcomissionado extends colaborador {
    private double valorVendas;
    private double percentualComissao;

    public colaboradorcomissionado(String matricula, String nome, double salarioBase, double valorVendas, double percentualComissao) {
        super(matricula, nome, salarioBase);
        this.valorVendas = valorVendas >= 0 ? valorVendas : 0;
        this.percentualComissao = percentualComissao >= 0 ? percentualComissao : 0;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        if (valorVendas >= 0) {
            this.valorVendas = valorVendas;
        }
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        if (percentualComissao >= 0) {
            this.percentualComissao = percentualComissao;
        }
    }

    public double calcularComissao() {
        return (this.valorVendas * this.percentualComissao) / 100.0;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }

    @Override
    public void exibirDados() {
        System.out.println("\n=== COLABORADOR COMISSIONADO ===");
        super.exibirDados();
        System.out.printf("Valor em Vendas: R$ %.2f\n", this.valorVendas);
        System.out.printf("Comissão (%.1f%%): R$ %.2f\n", this.percentualComissao, calcularComissao());
    }
}
