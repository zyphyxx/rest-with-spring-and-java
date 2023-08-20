package Aula_01;

public class objCaneta {
    public static void main(String[] args) {

        Caneta caneta = new Caneta();
        Caneta caneta2 = new Caneta();

        caneta.modelo = "Bic";
        caneta.cor = "Azul";
        caneta.ponta = 0.5f;
        caneta.tampada = false;

        caneta2.tampada = true;

        caneta.status();
        caneta.rabisca();

        //caneta2.status();
        caneta2.rabisca();

        caneta2.destampar();
        caneta2.rabisca();



    }
}
