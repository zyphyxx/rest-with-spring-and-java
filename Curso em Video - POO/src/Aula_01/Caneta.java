package Aula_01;

public class Caneta {

    String modelo;
    String cor;
    int carga;

    double ponta;
    boolean tampada;
    void status(){
        System.out.println("Uma caneta: " + this.cor);
        System.out.println("esta tampada? "+ this.tampada);
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Ponta: "+ ponta);

    }
    void rabisca() {
        if (tampada == true){
            System.out.println("ERRO: nao posso rabiscar");
        }
        else {
            System.out.println("RABISCANDO");

        }

    }
    void tampar(){
        if (tampada == false){
            this.tampada = true;
            System.out.println("Sua caneta esta Tampada");
        }
    }
    void destampar(){
        if (tampada == true){
            this.tampada = false;
            System.out.println("Sua caneta esta Destampada");
        }

    }
}
