package Jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PainelJogoCobrinha extends JPanel {
    private static final long serialVersionUID = 1L;

    private Cobra cobra;
    private boolean rodando;
    private Tabuleiro tabuleiro;
    private Thread threadJogo;


    public PainelJogoCobrinha(Tabuleiro tabuleiro, Cobra cobra) {
        this.tabuleiro = tabuleiro;
        this.cobra = cobra;
        this.rodando = false;
        
        setFocusable(true);
        
        // "OUVE" OS COMANDOS DO TECLADO
        addKeyListener(new Comandos());
    }

    public void iniciarJogo() {
        rodando = true;
        threadJogo = new Thread(() -> {
            while (rodando) {
                cobra.mover();
                tabuleiro.desenhaTabuleiro(cobra.getPosicaoX(), cobra.getPosicaoY());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cobra.verificarColisao();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                FinalJogo.gameOver(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadJogo.start();
    }
    
    // CLASSE PRIVADA PARA OS COMANDOS
    private class Comandos implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP && cobra.getDirecao() != 1) {
                cobra.setDirecao(0); // CIMA
            } else if (key == KeyEvent.VK_DOWN && cobra.getDirecao() != 0) {
                cobra.setDirecao(1); // BAIXO
            } else if (key == KeyEvent.VK_RIGHT && cobra.getDirecao() != 3) {
                cobra.setDirecao(2); // DIREITA
            } else if (key == KeyEvent.VK_LEFT && cobra.getDirecao() != 2) {
                cobra.setDirecao(3); // ESQUERDA
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }

}