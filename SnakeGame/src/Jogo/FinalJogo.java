package Jogo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinalJogo {
	
    public static void gameOver() throws InterruptedException {
        try (BufferedReader br = new BufferedReader(
                new FileReader("/dev/workspace/eclipse/Jogo0.SnakeGame/src/Jogo/GAMEOVER"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
        
        Thread.sleep(2000);

        try (BufferedReader br = new BufferedReader(
                new FileReader("/dev/workspace/eclipse/Jogo0.SnakeGame/src/Jogo/GAMEOVERcomInstrucoes"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
        System.exit(0);
    }
    
}