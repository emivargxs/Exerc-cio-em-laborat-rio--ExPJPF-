import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {    
        ArrayList<IdUnico> lista = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar PF");
            System.out.println("2 - Cadastrar PJ");
            System.out.println("3 - Buscar por Nome, CPF, CNPJ ou ano");
            System.out.println("4 - Listar todos os cadastrados");
            System.out.println("0 - Sair");
            System.out.print("Digite uma opção: ");
                    
            opcao = entrada.nextInt(); //recebendo os valores do usuario
            entrada.nextLine(); // limpa o buffer

            if (opcao == 1) { //se
                System.out.print("Nome: ");
                String nome = entrada.nextLine();

                System.out.print("Ano de Nascimento: ");
                String anoNasc = entrada.nextLine();

                System.out.print("CPF: ");
                String cpf = entrada.nextLine();

                //criar uma instancia de pessoa fisica com as caract atribuidas na entrada.
                PessoaFisica pf = new PessoaFisica(nome, anoNasc, cpf); 
                lista.add(pf); //adicionar a lista

                System.out.println("Pessoa Física cadastrada.");

            } else if (opcao == 2) { //se
                System.out.print("Nome ou Razão Social: ");
                String nomeRazaoSocial = entrada.nextLine();

                System.out.print("Ano de Fundação: ");
                int anoFundacao = Integer.parseInt(entrada.nextLine());

                System.out.print("CNPJ: ");
                String cnpj = entrada.nextLine();

                //criando uma instancia de pessoa juridica
                PessoaJuridica pj = new PessoaJuridica(nomeRazaoSocial, anoFundacao, cnpj);
                lista.add(pj); //adicionando a lista essa pessoa

                System.out.println("Pessoa Jurídica cadastrada.");

            } else if (opcao == 3) { //se
                //digito qual termo quero encontrar
                System.out.print("Digite termo para buscar (nome, CPF, CNPJ ou ano): ");
                String termo = entrada.nextLine();
                buscarPessoa(lista, termo);

            } else if (opcao == 4) {
                listarTodos(lista); //funcao que lista todos os valores da lista
            }

        } while (opcao != 0); //quando opcao for igual a 0:

        System.out.println("FIM");
        entrada.close();    
    }

    public static void buscarPessoa(ArrayList<IdUnico> lista, String termoBusca) {
        boolean encontrou = false;

        for (IdUnico pessoa : lista) {
            if (pessoa instanceof PessoaFisica) { //se a pessoa é uma instancia de pessoa fisica,verifica!!
                PessoaFisica pf = (PessoaFisica) pessoa; // faz a conversap de pessoa para Pessoa fisica 

                if (pf.getNome().contains(termoBusca) || 
                    pf.getCpf().contains(termoBusca) || 
                    pf.getAnoNasc().contains(termoBusca)) {
                    System.out.println("Pessoa Física encontrada:");
                    System.out.println("ID:" + pf.getId() + ", Nome: " + pf.getNome() + ", CPF: " + pf.getCpf() + ", Ano: " + pf.getAnoNasc());
                    encontrou = true;
                }

            } else if (pessoa instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) pessoa;

                if (pj.getNomeRazaoSocial().contains(termoBusca) || 
                    pj.getCnpj().contains(termoBusca) || 
                    String.valueOf(pj.getAnoFundacao()).contains(termoBusca)) {
                    System.out.println("Pessoa Jurídica encontrada:");
                    System.out.println("ID:" + pj.getId() +", Razão Social: " + pj.getNomeRazaoSocial() + ", CNPJ: " + pj.getCnpj() + ", Ano: " + pj.getAnoFundacao());
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma pessoa encontrada com esse termo.");
        }
    }

    public static void listarTodos(ArrayList<IdUnico> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        System.out.println("\n--- Lista de Pessoas Cadastradas ---");
        for (IdUnico pessoa : lista) {
            if (pessoa instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) pessoa;
                System.out.println("Pessoa Física |" + "ID: " + pf.getId() + ", Nome: " + pf.getNome() + ", CPF: " + pf.getCpf() + ", Ano: " + pf.getAnoNasc());
            } else if (pessoa instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) pessoa;
                System.out.println("Pessoa Jurídica |" + "ID: " + pj.getId() +", Razão Social: " + pj.getNomeRazaoSocial() + ", CNPJ: " + pj.getCnpj() + ", Ano: " + pj.getAnoFundacao());
            }
        }
    }
}
