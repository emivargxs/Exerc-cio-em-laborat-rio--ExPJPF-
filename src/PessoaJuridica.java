public class  PessoaJuridica extends IdUnico {
    private String nomeRazaoSocial;
    private int anoFundacao;
    private String cnpj;

    public PessoaJuridica(String nomeRazaoSocial, int anoFundacao, String cnpj){
        super();
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.anoFundacao = anoFundacao;
        this.cnpj = cnpj;
    }

    public String getNomeRazaoSocial(){
        return nomeRazaoSocial;
    }

    public int getAnoFundacao(){
        return anoFundacao;
    }

    public String getCnpj(){
        return cnpj;
    }

}
