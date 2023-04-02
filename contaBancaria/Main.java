package contaBancaria;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta();

        conta1.abrirConta();
        conta1.mostrarConta();
        conta1.depositar();
        conta1.sacar();
        conta1.pagarMensalidade();
        conta1.fecharConta();
        conta1.mostrarConta();

    }
}