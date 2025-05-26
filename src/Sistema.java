import java.util.ArrayList;
import java.util.Scanner;
public class Sistema {
    public static void main(String[] args) {
        
    Scanner entrada = new Scanner(System.in);
    ArrayList<IdUnico> lista = new ArrayList<>();

    boolean continuar = true;

    while(continuar){
    System.out.println("Digite\n1 - Pessoa Fisica\n2 - Pessoa Juridica\n0- Encerrar");
    int opcao = entrada.nextInt(); //opcao captura a opcao do usuario
    entrada.nextLine(); //Limpa o buffer 
    

    if(opcao == 1 ){
        System.out.println("Nome:");
        String nome = entrada.nextLine(); //limpa o buffer
        
        System.out.println("Ano de Nascimento:");
        String anoNasc = entrada.nextLine();

        System.out.println("CPF");
        String cpf = entrada.nextLine();

        PessoaFisica pf = new PessoaFisica(nome, anoNasc, cpf);
        lista.add(pf);

        System.out.println("Pessoa Fisica Cadastrada.");

    } else if(opcao == 2){
        System.out.println("Nome Razao Social:");
        String nomeRazaoSocial = entrada.nextLine();

        System.out.println("Ano fundacao:");
        int anoFundancao = Integer.parseInt(entrada.nextLine());

        System.out.println("CNPJ");
        String cnpj = entrada.nextLine();

        PessoaJuridica pj = new PessoaJuridica(nomeRazaoSocial, anoFundancao, cnpj);
        lista.add(pj);

        System.out.println("Pessoa Juridica Cadastrada");


    } else if(opcao == 0){
        continuar = false;
    } else{
        System.out.println("Opcao Invalida!\n");
    }
    }

    //Mostrando Lista
    System.out.println("\n Lista de Cadastrados");
    for(IdUnico pessoa : lista){ //for (Tipo item : lista)
        System.out.println("ID:" + pessoa.getId());
        if(pessoa instanceof PessoaFisica){
            PessoaFisica pf = (PessoaFisica) pessoa;

            System.out.println("Tipo: PF    | Nome:" + pf.getNome() +
                                          " | Ano Nascimento:" + pf.getAnoNasc()+
                                          " | CPF:" + pf.getCpf());
        }else if(pessoa instanceof PessoaJuridica){
            PessoaJuridica pj = (PessoaJuridica) pessoa;
            System.out.println("Tipo: PJ | Razao Social:" + pj.getNomeRazaoSocial()+
                                       " | Ano da Fundacao:" + pj.getAnoFundacao() +
                                       " | CNPJ:" + pj.getCnpj());
        } System.err.println();
    }
    entrada.close();

}

}