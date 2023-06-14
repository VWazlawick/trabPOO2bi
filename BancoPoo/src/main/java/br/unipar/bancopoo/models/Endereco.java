package br.unipar.bancopoo.models;

public class Endereco extends AbstractBaseEntity{
    private String nmRua;
    private String nrCasa;
    private String nmBairro;
    private String cep;
    private String dsComplemente;
    private Cidade cidade;
    private Pessoa pessoa;

    public Endereco() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public String getNrCasa() {
        return nrCasa;
    }

    public void setNrCasa(String nrCasa) {
        this.nrCasa = nrCasa;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDsComplemente() {
        return dsComplemente;
    }

    public void setDsComplemente(String dsComplemente) {
        this.dsComplemente = dsComplemente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "nmRua=" + nmRua + ", nrCasa=" + nrCasa + ", nmBairro=" + nmBairro + ", cep=" + cep + ", dsComplemente=" + dsComplemente + ", cidade=" + cidade + ", pessoa=" + pessoa + '}';
    }

    
    

    
}
