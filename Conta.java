package contaBancaria;

import java.util.Scanner;

public class Conta {
    public int numConta;
    protected String tipoConta;
    private String titularConta;
    private double saldo;
    private boolean status;
    private double saque;
    private String resposta;

    public Conta(){
        this.setStatus(false);
        this.setSaldo(0);
    }

    public int getNumConta(){
        return this.numConta;
    }

    public void setNumConta(int numConta){
        this.numConta = numConta;
    }

    public String getTipoConta(){
        return this.tipoConta;
    }

    public void setTipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }

    public String getTitularConta(){
        return this.titularConta;
    }
    public void setTitularConta(String titularConta){
        this.titularConta = titularConta;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double s){
        this.saldo = s;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void checaConta(){
        Scanner sc = new Scanner(System.in);
        while (!tipoConta.equalsIgnoreCase("cc") && (!tipoConta.equalsIgnoreCase("cp"))) {
            System.out.println("Tipo de conta invalida, digite novamente:");
            this.tipoConta = sc.nextLine();
        }

    }
    public void abrirConta(){ //método abrir conta
        Scanner entrada = new Scanner(System.in);
        //Pegando dados da conta
        System.out.println("Qual o número da conta? ");
        this.numConta = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Qual o tipo de conta? (cc = conta corrente / cp = conta poupanca) ");
        this.tipoConta = entrada.nextLine();
        this.checaConta();
        System.out.println("Qual o nome do titular? ");
        this.titularConta = entrada.nextLine();
        this.status = true;

        //Saldo inicial da conta
        if (tipoConta.equalsIgnoreCase("cc")) {
            this.setSaldo(50);
        } else if (tipoConta.equalsIgnoreCase("cp")) {
            this.setSaldo(150);
        } else {
            this.setSaldo(0);
        }

    }

    public void fecharConta(){ //método fechar conta
        Scanner entrada = new Scanner(System.in);
        System.out.println("Você quer fechar a sua conta? ");
        resposta = entrada.nextLine();
        if (resposta.equalsIgnoreCase("sim")) {
            System.out.println("ESTÁ AÇÃO NÃO PODERÁ SER REVERTIDA, O(A) SENHOR(A) QUER CONTINUAR COM O FECHAMENTO DA SUA CONTA?");
            resposta = entrada.nextLine();
            if (resposta.equalsIgnoreCase("sim")){
                if (this.getSaldo() > 0 ) {
                    System.out.println("Conta ainda tem dinheiro! Não é possivel fechar a conta!");
                } else if(this.getSaldo() < 0) {
                    System.out.println("Conta em débito! Não é possível fechar a conta!");
                } else {
                    System.out.println("Conta fechada com sucesso!");
                    this.setStatus(false);
                }
            } else {
                System.out.println("O fechamento da conta foi cancelado! Obrigado!");
            }
        } else {
            System.out.println("O fechamento da conta foi cancelado! Obrigado!");
        }
    }

    public void depositar() { //método depositar
        Scanner entrada = new Scanner(System.in);
        if(this.getStatus() == true) {
            System.out.println("Saldo atual da conta R$" + this.getSaldo());
            System.out.println("Quanto você vai depositar?");
            this.saldo += entrada.nextDouble();
            System.out.println("Novo saldo R$" + this.getSaldo());
        } else{
            System.out.println("A conta não está ativa!");
        }
    }

    public void sacar(){ //método sacar
        Scanner entrada = new Scanner(System.in);
        System.out.println("Saldo Atual R$" + this.getSaldo());
        System.out.println("Quanto você quer sacar? ");
        saque = entrada.nextDouble();
        while ((saque <= 0) || (saque > this.getSaldo())){
            System.out.println("Valor de saque indisponíovel! Digite um novo valor de saque R$ ");
            saque = entrada.nextDouble();
        }
            System.out.println("Processando saque no valor de R$" + saque);
        this.saldo -= saque;
        System.out.println("Saldo Atual R$" + this.getSaldo());
    }

    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade...");
        if(this.getTipoConta().equalsIgnoreCase("cc")) {
            this.saldo -= 12;
        } else if (this.getTipoConta().equalsIgnoreCase("cp")){
            this.saldo -= 20;
        }
        System.out.println("Saldo atual R$" + this.getSaldo());

    }

    public void mostrarConta(){
        System.out.println("Informações da contaBancaria.Conta");
        System.out.println("Número da conta: " + this.getNumConta());
        System.out.println("Tipo de conta: " + this.getTipoConta());
        System.out.println("Titular da conta: " + this.getTitularConta());
        System.out.println("Saldo da conta R$" + this.getSaldo());
        System.out.println("Status da conta (true = aberta // false = fechada): " + this.getStatus());
    }
}
