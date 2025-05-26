public class PessoaFisica extends IdUnico {
    private String nome;
    private String anoNasc;
    private String cpf;
   
    public PessoaFisica(String nome, String anoNasc, String cpf){
        super();
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.cpf = cpf;
    }
    public String getNome(){
        return nome;
    }

    public String getAnoNasc(){
        return anoNasc;
    }

    public String getCpf(){
        return cpf;
    }

    /*
    public static void main(String[] args) {
        PessoaFisica p1 = new PessoaFisica("João", "1990", "111.111.111-11");
        PessoaFisica p2 = new PessoaFisica("Maria", "1985", "222.222.222-22");

        System.out.println("ID do João: " + p1.getId()); // 100
        System.out.println("ID da Maria: " + p2.getId()); // 101
    } */
}