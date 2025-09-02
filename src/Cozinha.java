import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cozinha{
    private Queue<Pedido> filaDePedidos = new LinkedList<>();
    private volatile boolean estaTrabalhando = false;
    Scanner scanner = new Scanner(System.in);


    public void run(Cardapio cardapio) {
        this.estaTrabalhando = true;
        int escolha;
            opcoesMain1();
            escolha = scanner.nextInt();
            scanner.nextLine();
            if(escolha == 1) {
                Cliente cliente1 = login();
                Pedido pedido1 = new Pedido(cliente1);
                filaDePedidos.add(pedido1);
                while (estaTrabalhando) {
                    opcoesMain2(cliente1);
                    escolha = scanner.nextInt();
                    switch (escolha) {
                        case 1:
                            opcoesCardapio();
                            escolha = scanner.nextInt();
                            switch (escolha) {
                                case 1:
                                    opcoesHamburguer(cardapio,pedido1);
                                    break;
                                case 2:
                                    opcoesBebidas(cardapio,pedido1);
                                    break;
                                case 3:
                                    opcoesCombos(cardapio,pedido1);
                                    break;
                                case 4:
                                    break;
                           }
                           break;
                        case 2:
                            pedido1.printarPedido();
                            break;
                        case 3:
                            fecharCozinha();
                            break;

                }
            }
        }
    }


    public void fecharCozinha() {
        estaTrabalhando = false;
        }

    public void novoPedido(Pedido pedido) {
        filaDePedidos.add(pedido);
        }
    public void opcoesMain1() {
        System.out.println("====== BEM-VINDO À LANCHONETE ======");
        System.out.println("Veja as opções abaixo e insira sua resposta");
        System.out.println("1: Logar");
        System.out.println("2: Fechar o site");
    }

    public void opcoesMain2(Cliente cliente) {
        System.out.println("Olá,"+cliente.getNome()+",O que deseja fazer");
        System.out.println("1: Ver cardapio");
        System.out.println("2: Ver pedido");
        System.out.println("3: Fechar o site");


    }

    public Cliente login(){
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String CPF = scanner.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = scanner.nextLine();
        return new Cliente(nome,CPF,telefone);
    }

    public void opcoesCardapio() {
        System.out.println("Selecione qual o produto desejado");
        System.out.println("1: Ver Hamburgueres");
        System.out.println("2: Ver Bebidas");
        System.out.println("3: Ver Combos");
        System.out.println("4: Voltar");


    }
    public void opcoesHamburguer(Cardapio cardapio, Pedido pedido) {
        cardapio.printarHamburgueres();
        System.out.println("5:Voltar ");
        System.out.println("Digite sua escolha: ");
        int escolha = scanner.nextInt();
        escolha--;
        if (escolha <= 3 && escolha >= 0) {
            pedido.adicionarItem(cardapio.getItensDisponiveis().get(escolha));
        }
        else if (escolha == 4) {
            return;
        }
    }

    public void opcoesBebidas(Cardapio cardapio, Pedido pedido) {
        cardapio.printarBebidas();
        System.out.println("4:Voltar ");
        System.out.println("Digite sua escolha: ");
        int escolha = scanner.nextInt();
        escolha += 3;
        if (escolha >= 4 && escolha <= 6) {
            pedido.adicionarItem(cardapio.getItensDisponiveis().get(escolha));
        }
        else if (escolha == 7) {
            return;
        }
    }

    public void opcoesCombos(Cardapio cardapio, Pedido pedido) {
        cardapio.printarCombos();
        System.out.println("3:Voltar ");
        System.out.println("Digite sua escolha: ");
        int escolha = scanner.nextInt();
        escolha += 6;
        System.out.println(escolha);
        if (escolha == 7 || escolha == 8) {
            pedido.adicionarItem(cardapio.getItensDisponiveis().get(escolha));
        }
        else if (escolha == 5) {
            return;
        }
        return;
    }



    }
