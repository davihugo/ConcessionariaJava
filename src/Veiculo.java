public abstract class Veiculo {
    private String cor;
    private String marca;
    private String modelo;
    private String ano;
    private double valor;

    private int quantidade;

    public Veiculo(String cor, String marca, String modelo, String ano, double valor, int quantidade) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.quantidade=quantidade;
    }

    public String getCor() {
        return cor;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }
    public void setQuantidade(int qtde) {
        this.quantidade = qtde;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}