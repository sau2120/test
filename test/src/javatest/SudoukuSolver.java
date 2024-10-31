package javatest;

public class SudoukuSolver {
    private static final int SIZE = 9; // 스도쿠의 크기
    private int[][] grid; // 스도쿠 그리드

    // Board 객체를 인자로 받는 생성자
    public SudoukuSolver(Board board) {
        this.grid = board.getBoard(); // Board에서 그리드 배열 가져오기
    }

    // 그리드 출력
    public void printGrid() {
    	System.out.println("┌─────────┬─────────┬─────────┐");
        for (int i = 0; i < SIZE; i++) {
        	System.out.printf("│");
            for (int j = 0; j < SIZE; j++) {
            	
            	if(grid[i][j] == 0) {
            		System.out.println();
            	}
                if(grid[i][j] == 0) {
                	System.out.printf(" _ "+" ");
                }else {
                	System.out.printf("%2d ",grid[i][j]);
                }
                if((j+1)%3 == 0 && j !=SIZE -1) {
                	System.out.print("│");
                }
                
            
            
            }
            System.out.println("│");
            
            if(i == SIZE -1) {
            	System.out.println("└─────────┴─────────┴─────────┘");
            } else if(i%3 == 2) {
            	System.out.println("├─────────┼─────────┼─────────┤");
            }
            
        }
    }

    // 스도쿠 해결 함수
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) { // 빈 셀 찾기
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(row, col, num)) { // 숫자 배치 가능 여부 확인
                            grid[row][col] = num;
                       
                            if (solve()) {
                                return true;
                            }
                            grid[row][col] = 0; // 백트래킹
                        }
                    }
                    return false; // 해결할 수 없음
                }
            }
        }
        return true; // 해결 완료
    }

    // 숫자 배치 가능 여부 확인
    private boolean isSafe(int row, int col, int num) {
        // 행과 열 체크
        for (int x = 0; x < SIZE; x++) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }

        // 3x3 박스 체크
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
