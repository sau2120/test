package javatest;

public class Display {

	//보드를 출력하는 메서드
	public void printBoard(int[][] board) {
		//세로줄 i=가로줄 j=세로줄
      	System.out.println("┌─────────┬─────────┬─────────┐");
          for (int i = 0; i < 9; i++) {
          	System.out.printf("│");
              for (int j = 0; j < 9; j++) {      	
              	 System.out.printf("%2d ",board[i][j]);
                   if(i==2 && j==8) {
                  	System.out.printf("│\n├─────────┼─────────┼─────────┤");
                  }else if(i==5 && j==8){
                  	System.out.printf("│\n├─────────┼─────────┼─────────┤");                	
                  }
                   
                 else if(j==2) {
                 	System.out.printf("│");
                }else if(j==5) {
                	System.out.printf("│");
                }else if(j==8) {
                	System.out.printf("│");
                }
                
            }
          
            System.out.println();
        }
        System.out.println("└─────────┴─────────┴─────────┘");
    }
	
	//게임 완료 메세지 출력
	public void printCompletionMessage(long timeTaken) {
		System.out.println("축하합니다! 당신은 클리어 하셨습니다!");
		System.out.printf("완성하는데 걸린 시간: %d 초\n",timeTaken);
	}
	public void printRestartMessage() {
		System.out.println("새 게임을 시작하려면 y를 눌러주세요.(y를 제외한 키를 입력하면 종료됩니다.)");
	}
	
	public void printInvalidMoveMessage() {
		System.out.println("다시 시도해주세요.");
	}
	public void printQuitMessage() {
		System.out.println("종료하시겠습니까? : y/n");
	}
	public void printFixedCellMessage() {
		System.out.println("이 칸의 숫자는 고정되어있습니다. 다른 칸을 선택해주세요.");
	}

	
}
