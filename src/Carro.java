

public class Carro extends Veiculo implements Dados{
    private int numPortas;
    private int numPassageiros;
    public Carro(final String marca, final String cor, final int qtde, final String modelo, final String ano, final double valor, final int numPortas, final int numPassageiros) {
        super(cor, marca, modelo, ano, valor, qtde);
        this.numPortas=numPortas;
        this.numPassageiros=numPassageiros;
    }
    public void ExibirDados(){
        System.out.println("O carro é o seguinte: "+this.getMarca() + " "+ this.getModelo());
    }
    public int getNumPortas() {
        return numPortas;
    }
    public int getNumPassageiros() {
        return numPassageiros;
    }
    public void setNumPortas(final int numPortas) {
        this.numPortas = numPortas;
    }
    public void setNumPassageiros(final int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }


}
