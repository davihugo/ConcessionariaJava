public class Moto extends Veiculo implements Dados {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double preco, int cilindradas) {
        super(marca, modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void ExibirDados(){
        System.out.println("A moto é a seguinte: "+this.getMarca() + " "+ this.getModelo() + " "+ getCilindradas());
    }
}