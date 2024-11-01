package javatest;

import java.util.Scanner;

public class SudokuGameEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        SudokuGame game = new SudokuGame();
        
        game.run(scanner); // 게임 시작

        scanner.close(); // 스캐너 종료
    }
}
