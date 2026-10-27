// Principal.java - Classe Principal do Sistema

import java.util.ArrayList;
import java.util.Scanner;

public class principal {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<colaborador> listaColaboradores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarColaboradorPadrao();
                    break;
                case 2:
                    cadastrarColaboradorComissionado();
                    break;
                case 3:
                    cadastrarColaboradorProducao();
                    break;
                case 4:
                    listarColaboradores();
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE GESTÃO DE COLABORADORES   ");
        System.out.println("========================================");
        System.out.println("1. Cadastrar Colaborador Padrão");
        System.out.println("2. Cadastrar Colaborador Comissionado");
        System.out.println("3. Cadastrar Colaborador de Produção");
        System.out.println("4. Listar Todos os Colaboradores");
        System.out.println("0. Sair do Sistema");
        System.out.println("========================================");
    }

    private static double lerDoublePositivo(String mensagem) {
        double valor = -1;
        while (valor < 0) {
            System.out.print(mensagem);
            try {
                String entrada = scanner.nextLine().replace(',', '.');
                valor = Double.parseDouble(entrada);
                if (valor < 0) {
                    System.out.println("❌ Entrada inválida! Digite um valor maior ou igual a zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite um número válido.");
            }
        }
        return valor;
    }

    private static int lerIntPositivo(String mensagem) {
        int valor = -1;
        while (valor < 0) {
            System.out.print(mensagem);
            try {
                String entrada = scanner.nextLine();
                valor = Integer.parseInt(entrada);
                if (valor < 0) {
                    System.out.println("❌ Entrada inválida! Digite um valor inteiro maior ou igual a zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite um número inteiro válido.");
            }
        }
        return valor;
    }

    private static void cadastrarColaboradorPadrao() {
        System.out.println("\n--- Cadastro de Colaborador Padrão ---");
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite o nome completo: ");
        String nome = scanner.nextLine();
        double salarioBase = lerDoublePositivo("Digite o salário base (R$): ");

        colaboradorpadrao colab = new colaboradorpadrao(matricula, nome, salarioBase);
        listaColaboradores.add(colab);
        System.out.println("✅ Colaborador Padrão cadastrado com sucesso!");
    }

    private static void cadastrarColaboradorComissionado() {
        System.out.println("\n--- Cadastro de Colaborador Comissionado ---");
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite o nome completo: ");
        String nome = scanner.nextLine();
        double salarioBase = lerDoublePositivo("Digite o salário base (R$): ");
        double valorVendas = lerDoublePositivo("Digite o valor total das vendas (R$): ");
        double percentualComissao = lerDoublePositivo("Digite o percentual da comissão (%): ");

        colaboradorcomissionado colab = new colaboradorcomissionado(matricula, nome, salarioBase, valorVendas, percentualComissao);
        listaColaboradores.add(colab);
        System.out.println("✅ Colaborador Comissionado cadastrado com sucesso!");
    }

    private static void cadastrarColaboradorProducao() {
        System.out.println("\n--- Cadastro de Colaborador de Produção ---");
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite o nome completo: ");
        String nome = scanner.nextLine();
        double salarioBase = lerDoublePositivo("Digite o salário base (R$): ");
        int quantidadePecas = lerIntPositivo("Digite a quantidade de peças produzidas: ");
        double valorPorPeca = lerDoublePositivo("Digite o valor por peça (R$): ");

        colaboradorproducao colab = new colaboradorproducao(matricula, nome, salarioBase, quantidadePecas, valorPorPeca);
        listaColaboradores.add(colab);
        System.out.println("✅ Colaborador de Produção cadastrado com sucesso!");
    }

    private static void listarColaboradores() {
        System.out.println("\n========================================");
        System.out.println("        RELATÓRIO DE COLABORADORES       ");
        System.out.println("========================================");

        if (listaColaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado até o momento.");
        } else {
            for (colaborador c : listaColaboradores) {
                c.exibirDados();
            }
            System.out.println("\nTotal de colaboradores registrados: " + listaColaboradores.size());
        }
    }
}
