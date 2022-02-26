package dadm.quixada.ufc.cartao_visita.data;

public class BusinessCard {
    private String id;
    private String nome;
    private String empresa;
    private String telefone;
    private String email;
    private String fundoPersonalizado;

    public BusinessCard(String id, String nome, String empresa, String telefone, String email, String fundoPersonalizado) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.telefone = telefone;
        this.email = email;
        this.fundoPersonalizado = fundoPersonalizado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFundoPersonalizado() {
        return fundoPersonalizado;
    }

    public void setFundoPersonalizado(String fundoPersonalizado) {
        this.fundoPersonalizado = fundoPersonalizado;
    }
}
