package Jogo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tabuleiro {
    private char[][] estruturaTabuleiro;

    public Tabuleiro(String arquivo) {
        lerArquivo(arquivo);
    }

	private void lerArquivo(String arquivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			int linhas = 0;
			int colunas = 0;

			while ((linha = br.readLine()) != null) {
				linhas++;
				colunas = linha.length();
			}

			estruturaTabuleiro = new char[linhas][colunas];
			
			br.close();

			BufferedReader br1 = new BufferedReader(new FileReader(arquivo));

			int linhaAtual = 0;
			while ((linha = br1.readLine()) != null) {
				for (int i = 0; i < colunas; i++) {
					estruturaTabuleiro[linhaAtual][i] = linha.charAt(i);
				}
				linhaAtual++;
			}
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void desenhaTabuleiro(int posicaoX, int posicaoY) {
        char[][] tabuleiroComCobra = new char[estruturaTabuleiro.length][estruturaTabuleiro[0].length];

        
        for (int i = 0; i < estruturaTabuleiro.length; i++) {
            for (int j = 0; j < estruturaTabuleiro[i].length; j++) {
                tabuleiroComCobra[i][j] = estruturaTabuleiro[i][j];
            }
        }

        
        tabuleiroComCobra[posicaoY][posicaoX] = 'O';

       // DESENHA O TABULEIRO COM A COBRINHA
        for (char[] linha : tabuleiroComCobra) {
            for (char c : linha) {
                System.out.print(c);
            }
            System.out.println();
        }
        
    }

    public char[][] getEstruturaTabuleiro() {
        return estruturaTabuleiro;
    }
}