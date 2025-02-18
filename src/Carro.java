public class Carro extends Veiculo implements Dados{
    private int numPortas;
    private int numPassageiros;
    public Carro(String marca, String modelo, int ano, double preco, int numPortas) {
        super(marca, modelo, ano, preco);
        this.numPortas = numPortas;
        this.numPassageiros = 0;
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
