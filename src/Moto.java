public class Moto extends Veiculo implements Dados {
    private int Cilindrada;

    public Moto(String cor, String marca, String modelo, String ano, double valor, int Cilindrada, int qtde) {
        super(cor, marca, modelo, ano, valor,qtde);
        this.Cilindrada = Cilindrada;
    }

    public int getCilindrada() {
        return Cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        Cilindrada = cilindrada;
    }
    public void ExibirDados(){
        System.out.println("A moto é a seguinte: "+this.getMarca() + " "+ this.getModelo() + " "+ getCilindrada());
    }

}