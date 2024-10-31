package javatest;

import java.util.Scanner;

public class SudokuGame {
    private Board board;
    private Difficulty difficulty;
    private Display display;
    private Timer timer;

    public SudokuGame() {
        board = new Board();
        difficulty = new Difficulty();
        display = new Display();
        timer = new Timer();
    }

    public void run(Scanner scanner) {
        while (true) {
            // 난이도 선택
            int difficultyLevel = difficulty.selectDifficulty(scanner);
            int filledCells = difficulty.getFilledCells(difficultyLevel);

            // 보드 초기화
            board.initializeBoard(filledCells);

            // 게임 시작
            timer.start();
            while (true) {
                display.printBoard(board.getBoard());
                System.out.print("종료 (0),가로 행 (1-9), 세로 열 (1-9), 숫자 (1-9): ");
                int row = scanner.nextInt() - 1;
                if (row == -1) {
                    display.printQuitMessage();
                    char quitChoice = scanner.next().toLowerCase().charAt(0);
                    if (quitChoice == 'y') {
                        System.out.print("답안을 보시겠습니까? (y/n): ");
                        char viewAnswer = scanner.next().toLowerCase().charAt(0);
                        if (viewAnswer == 'y') {
                            SudoukuSolver solver = new SudoukuSolver(board);
                            if (solver.solve()) {
                                System.out.println("스도쿠 해결:");
                                solver.printGrid();
                            } else {
                                System.out.println("해결할 수 없는 퍼즐입니다.");
                            }
                        }
                        System.out.println("게임 종료");
                        return; // 게임 종료
                    } else {
                        continue; // 계속 진행
                    }
                }
                int col = scanner.nextInt() - 1;
                int num = scanner.nextInt();

                // 숫자 변경 가능 여부 확인
                if (board.isFixedCell(row, col)) {
                    display.printFixedCellMessage();
                } else if (board.isValidMove(row, col, num)) {
                    board.setCell(row, col, num);
                } else {
                    display.printInvalidMoveMessage();
                }

                // 퍼즐 해결 확인
                if (board.isSolved()) {
                    timer.stop();
                    long timeTaken = timer.getTimeTaken();
                    display.printCompletionMessage(timeTaken);                                                
                    display.printRestartMessage();  // 새 게임 시작 여부 확인
                    char newGameChoice = scanner.next().toLowerCase().charAt(0);
                    if (newGameChoice != 'y') {
                        System.out.println("게임 종료");
                        return; // 게임 종료
                    }
                    break; // 새로운 게임 루프 시작
                }
            }
        }
    }
}
