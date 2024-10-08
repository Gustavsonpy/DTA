package Customer;

public class Customer {

    private String cpf;
    private String nome;
    private String endereco1;
    private String endereco2;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int idade;
    private boolean primeira_compra;
    private String data_nascimento;

    public String getCpf() {return cpf;}

    public String getNome() {return nome;}

    public String getEndereco1() {return endereco1;}

    public String getEndereco2() {return endereco2;}

    public String getBairro() {return bairro;}

    public String getCidade() {return cidade;}

    public String getEstado() {return estado;}

    public String getCep() {return cep;}

    public int getIdade() {return idade;}

    public boolean getPrimeira_compra(){return primeira_compra;}

    public String getData_nascimento() {return data_nascimento;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public void setNome(String nome) {this.nome = nome;}

    public void setEndereco1(String endereco1) {this.endereco1 = endereco1;}

    public void setEndereco2(String endereco2) {this.endereco2 = endereco2;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public void setEstado(String estado) {this.estado = estado;}

    public void setCep(String cep) {this.cep = cep;}

    public void setIdade(int idade) {this.idade = idade;}

    public void setPrimeira_compra(boolean primeira_compra) {this.primeira_compra = primeira_compra;}

    public void setData_nascimento(String data_nascimento) {this.data_nascimento = data_nascimento;}
}
