
// https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Random.html
import java.util.Random;
import java.util.Scanner;


public class PedraPapelTesoura {

    static final int PEDRA = 0;
    static final int PAPEL = 1;
    static final int TESOURA = 2;
    static int pontuacaoJogador = 0;
    static int pontuacaoComputador = 0;
    static int empates;
    static boolean jogarNovamente = true;

    static public void main(String[] args){

            while (jogarNovamente) {
                System.out.println("Vamos jogar Pedra, Papel, Tesoura!");
                System.out.println("Faça sua jogada!");
                System.out.println("Digite 0 para PEDRA, 1 para PAPEL, e 2 para TESOURA:");
                int jogadaUsuario = recebeJogadaUsuario();
                int jogadaCpu = geraJogadaCpu();
                int resultado = executaJogada(jogadaUsuario, jogadaCpu);
                exibeResultado(jogadaUsuario, jogadaCpu, resultado);
                //System.out.println(jogadaUsuario);

                jogarNovamente = continuarJogando();
            }
    }

    static public int recebeJogadaUsuario(){
        Scanner entrada =  new Scanner(System.in);
        int jogada = 4;
        while (jogada < 0 || jogada > 2) {
            System.out.println("Digite sua jogada: ");
            jogada = entrada.nextInt();
        }
        //entrada.close();
        return jogada;
    }

    static public int geraJogadaCpu(){
        Random rnd = new Random();
        long semente = System.currentTimeMillis();
        rnd.setSeed(semente);
        return rnd.nextInt(3); // retorna aleatorio entre 0 e 2
    }

    static public int executaJogada(int jogadaUsuario, int jogadaCpu){
        if (jogadaUsuario == jogadaCpu) {
            return 0; //Resultado empate
        } else if ((jogadaUsuario == PEDRA && jogadaCpu == TESOURA) ||
                (jogadaUsuario == PAPEL && jogadaCpu == PEDRA) || (jogadaUsuario == TESOURA && jogadaCpu == PAPEL)){
            return 1; //Jogador venceu
        } else {
            return 2; //Cpu venceu
        }

    }

    static public void exibeResultado(int jogadaUsuario, int jogadaCpu, int resultado){
        String resultadoFinal;
        if (resultado == 0){
            resultadoFinal = "Empate";
            empates++;
        } else if (resultado == 1){
            resultadoFinal = "Parabéns, Você venceu!!!";
            pontuacaoJogador++;
        } else {
            resultadoFinal = "O computador venceu";
            pontuacaoComputador++;
        }


        String jogadaUsuarioStr = "";
        String jogadaCpuStr = "";
        switch (jogadaUsuario){
            case PEDRA:
                jogadaUsuarioStr = "Pedra";
                break;
            case PAPEL:
                jogadaUsuarioStr = "Papel";
                break;
            case TESOURA:
                jogadaUsuarioStr = "Tesoura";
                break;

        }

        switch (jogadaCpu) {
            case PEDRA:
                jogadaCpuStr = "Pedra";
                break;
            case PAPEL:
                jogadaCpuStr = "Papel";
                break;
            case TESOURA:
                jogadaCpuStr = "Tesoura";
                break;
        }

        System.out.printf("Sua Jogada foi %s \n", jogadaUsuarioStr);
        System.out.printf("A jogada do Computador foi %s \n", jogadaCpuStr);
        System.out.println(resultadoFinal);
        System.out.printf("Placar:\n Jogador: %d \n Computador: %d \n Empates: %d \n", pontuacaoJogador, pontuacaoComputador, empates);

        }

    static public boolean continuarJogando() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja jogar novamente? (sim/não)");
        String resposta = entrada.nextLine();
        while (!resposta.equalsIgnoreCase("sim") && !resposta.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Deseja jogar novamente? (sim/não)");
            resposta = entrada.nextLine();
        }
        //entrada.close();
        return resposta.equalsIgnoreCase("sim");
    }



}
