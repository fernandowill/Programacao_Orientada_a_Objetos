public class Cliente {
    private String nome;
    private String CPF;
    private String numeroTel;

    public Cliente(String nome, String CPF,String numeroTel) {
        this.nome = nome;
        this.CPF = CPF;
        this.numeroTel = numeroTel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
}
