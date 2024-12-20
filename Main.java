
package domino_actualizado;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] Adilson_Carvalho) {
        
             Scanner in = new Scanner(System.in);
        
        int opcao = 0;
        int op = 0;
        String nomeVencedor = "";
        String msg = "";
        
        Domino d = new Domino();
        
        do {
            d.limparSaida();
            
            System.out.print(msg + "DOMINÓ \n\n(0) - Sair\n(1) - Cadastrar Jogador\n(2) - Iniciar Jogo\n\n>>> ");
            opcao = in.nextInt();
        
            switch (opcao) {
                case 0:
                    System.out.println("\nEncerrando a aplicação...\n");
                    break;

                case 1:
                    System.out.print("\nNome do Jogador: ");
                    String nome = in.next();
                    
                    if (d.adicionarJogador(new Jogador(nome))) {
                        msg = "Jogador " + nome + " cadastrado com sucesso.\n\n";
                    } else {
                        msg = "Número máximo de jogadores atingido.\n\n";
                    }
                    
                    break;

                case 2:
                    if (d.getJogadores().size() > 1) {
                        
                        d.limparSaida();
                        
                        d.iniciaJogo();
                        
                        String njDobrada = d.buscaJogador(d.getDobradaMaior()).getNome();
                        Peca pDobrada = d.getDobradaMaior();
                        
                      
                        
                        d.buscaJogador(pDobrada).getPecas().remove(pDobrada);
                        
                        int indexJogadorAtual = d.buscaIndexJogador(njDobrada) + 1;
                        boolean vencedor = false;
                        
                        do {
                            System.out.println(d);
                            
                            if (indexJogadorAtual == d.getJogadores().size()) {
                                indexJogadorAtual = 0;
                            }
                            
                            Jogador jogadorAtual = d.getJogadores().get(indexJogadorAtual);
                            
                            System.out.print("Jogador Atual: " + jogadorAtual.getNome() + ", escolha uma opção \n\n(1) - Jogar\n(2) - Comprar peça\n\n>>> ");
                            op = in.nextInt();

                            if (op == 1) {
                                System.out.print("\nEscolha uma peça válida\n\n>>> ");
                                int indexPeca = in.nextInt();
                                
                                Peca p = d.buscaPecaPeloIndex(jogadorAtual, indexPeca);
                                
                                if (d.jogada(jogadorAtual, p)) {
                                    
                                    d.limparSaida();
                                
                                    if (jogadorAtual.getPecas().isEmpty()) {
                                        vencedor = true;
                                        
                                        d.limparSaida();
                                        
                                        nomeVencedor = jogadorAtual.getNome();
                                        
                                        System.out.println("PARABÉNS " + nomeVencedor + ", VOCÊ VENCEU!!!\n\n");
                                        System.out.println(d.winner(jogadorAtual) + "\n");
                                        
                                        opcao = 0;
                                    } else if (d.isEmpate()) {
                                        msg = "DEU EMPATE!!!";
                                    } else {
                                        indexJogadorAtual++;
                                    }
                                } else {
                                    d.limparSaida();
                                    System.out.println("Peça Inválida...");
                                }
                            } else if (op == 2) {
                                d.comprar(jogadorAtual);
                                
                                indexJogadorAtual++;
                                
                                d.limparSaida();
                            } else {
                                d.limparSaida();
                                System.out.println("Opção Inválida...");
                            }
                        } while (!vencedor);
                    } else {
                        msg = "Número mínimo de jogadores não atingido...\n\n";
                    }
                    break;

                default:
                    msg = "Opção Inválida...\n\n";
                    break;
            }
        } while (opcao != 0);
      
    }
    
}
