package Jogo;

import javax.swing.JFrame;

public class JogoCobrinha {
    public static void main(String[] args) throws InterruptedException {
        Tabuleiro tabuleiro = new Tabuleiro("/dev/workspace/eclipse/Jogo0.SnakeGame/src/Jogo/tabuleiroteste");
        Cobra cobra = new Cobra(tabuleiro);
        PainelJogoCobrinha painelJogo = new PainelJogoCobrinha(tabuleiro, cobra);
        JFrame janela = new JFrame();

        // ESTRUTURA JFRAME
        // ENCERRA O JOGO SE FECHAR A JANELA
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        janela.add(painelJogo);
        janela.pack();
        janela.setLocation(550, 0);
        janela.setVisible(true);
        painelJogo.iniciarJogo();
    }
}