// Colaborador.java - Classe Base (Superclasse)

public class colaborador {
    // Atributos privados (Encapsulamento)
    private String matricula;
    private String nome;
    private double salarioBase;

    // Construtor
    public colaborador(String matricula, String nome, double salarioBase) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase >= 0 ? salarioBase : 0;
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        } else {
            System.out.println("O salário base não pode ser negativo!");
        }
    }

    // Método para calcular salário final
    public double calcularSalarioFinal() {
        return this.salarioBase;
    }

    // Método para exibir dados do colaborador
    public void exibirDados() {
        System.out.println("----------------------------------------");
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Nome: " + this.nome);
        System.out.printf("Salário Base: R$ %.2f\n", this.salarioBase);
        System.out.printf("Salário Final: R$ %.2f\n", this.calcularSalarioFinal());
    }
}
