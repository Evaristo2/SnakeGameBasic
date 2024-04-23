package Jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Cobra implements KeyListener, Runnable {
    private int posicaoX;
    private int posicaoY;
    private int direcao;
    private boolean rodando;
    private Tabuleiro tabuleiro;

    
    public Cobra(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicaoX = 3;
        posicaoY = 4;
        direcao = 2;
        rodando = true;
    }
    
    
    // RECONHECIMENTO DE TECLAS
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // MÉTODO DE IDENTIFICAÇÃO DE TECLA PRESSIONADA
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_UP && direcao != 1) {
            direcao = 0; // CIMA
        } else if (key == KeyEvent.VK_DOWN && direcao != 0) {
            direcao = 1; // BAIXO
        } else if (key == KeyEvent.VK_RIGHT && direcao != 3) {
            direcao = 2; // DIREITA
        } else if (key == KeyEvent.VK_LEFT && direcao != 2) {
            direcao = 3; // ESQUERDA
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void mover() {
        switch (direcao) {
            case 0: // CIMA
                posicaoY--;
                break;
            case 1: // BAIXO
                posicaoY++;
                break;
            case 2: // DIREITA
                posicaoX++;
                break;
            case 3: // ESQUERDA
                posicaoX--;
                break;
        }
    }
    
    
    // VERIFICA COLISÃO DA COBRINHA NO TABULEIRO PELO PRÓXIMO CARACTER
    public void verificarColisao() throws InterruptedException {
        char[][] estruturaTabuleiroColisao = tabuleiro.getEstruturaTabuleiro();

        int proximoX = posicaoX;
        int proximoY = posicaoY;

        switch (direcao) {
            case 0: // CIMA
                proximoY--;
                break;
            case 1: // BAIXO
                proximoY++;
                break;
            case 2: // DIREITA
                proximoX++;
                break;
            case 3: // ESQUERDA
                proximoX--;
                break;
        }

        // VERIFICA SE ENCOSTOU NOS CARACTERES OU NO LIMITE DO TABULEIRO
        if (proximoX < 0 || proximoX >= estruturaTabuleiroColisao[0].length ||
            proximoY < 0 || proximoY >= estruturaTabuleiroColisao.length ||
            estruturaTabuleiroColisao[proximoY][proximoX] != ' ') {
            rodando = false;
            FinalJogo.gameOver();
            return;
        }
    }

    
    // VERIFICA E EXECUTA O MÉTODO MOVER
    public void run() {
        while (rodando) {
            mover();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    // MUDA DIREÇÃO
    public void setDirecao(int novaDirecao) {
        if (novaDirecao >= 0 && novaDirecao <= 3) {
            direcao = novaDirecao;
        }
    }

    public int getDirecao() {
        return direcao;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }
}