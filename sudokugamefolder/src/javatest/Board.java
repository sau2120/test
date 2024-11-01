package javatest;

import java.util.Random;

public class Board {

	 int[][] board = new int[9][9]; //비어 있는 보드 배열
	 boolean[][] fixedCells = new boolean[9][9]; //고정 셀 표시용 배열
	
	 
	 
	public void initializeBoard(int filledCells) {
		fillBoard(0,0);
		Random random = new Random(); //랜덤 숫자를 생성하기 위한 Random 객체 생성
		
		//주어진 개수 만큼 무작위로 셀 비우기
		
		for(int i=0; i<81-filledCells; i++) { //채워야 할 셀 수만큼 반복
			int row,col;
			do {
				row = random.nextInt(9); //0~8까지의 난수를 생성하고 행과 열을 선택
				col = random.nextInt(9); 
				
			}while(board[row][col] ==0); //
			                 
			board[row][col]=0; //
			fixedCells[row][col] = false; //해당 칸들은 0이고 그 숫자칸들은 변경이 가능함
		}		
		//고정 셀로 설정
		for(int row = 0; row<9; row++) { //각 행
			for(int col=0; col<9; col++) { //각 행의 열
				if(board[row][col] !=0) {
					fixedCells[row][col]=true; //해당 칸들이 0이 아니면 고정 칸으로 설정
				}
			}
		}
		
		
	}
			
	private boolean fillBoard(int row,int col) {
		if(row==9) return true; //만약 행이 9이라면 true로 반환
		if(col==9) return fillBoard(row+1,0); //만약 열이 9라면 보드의 다음 행으로 이동
		
		for(int num=1; num<=9; num++) { 
		if(isValidMove(row,col,num)) { //현재 위치에 숫자를 배치할 수 있는 경우
					
			board[row][col] = num; //1~9를 시도하면서 배치가능하면 배치
			if(fillBoard(row,col+1)) return true; //다음 열로 이동 및 true를 반환하면 보드가 성공적으로 채워졌다는 뜻
			board[row][col]=0; //false를 반환하면 현재 위치에 배치한 숫자를 다시 비움
		}
		}
		return false; //만약 모든 숫자를 시도했는데 유효한 숫자를 찾지 못했을 경우 false를 반환
	}	
	//주어진 위치에 숫자가 유효한지 확인하는 메서드
	public boolean isValidMove(int row, int col, int num) {		
		//행과 열을 체크
		for(int i=0; i<9; i++) {
			if(board[row][i]==num || board[i][col]==num) {
				return false;
			}
		}
		//3*3칸 박스에서 같은 숫자가 있는지 체크
	int boxRowStart = row - row%3; //박스의 시작 행
	int boxColStart = col - col%3; //박스의 시작 열
	
	for (int i = 0; i<3; i++) {
		for(int j=0; j<3; j++) {
			if(board[i+boxRowStart][j+boxColStart]==num) {
				return false; //같은 숫자가 있다면 false 반환
			}
		}
	}	
		return true;	
	}	
	public void setCell(int row,int col,int num) {
		board [row][col]=num;
		fixedCells[row][col]=false;
	}	
	public boolean isFixedCell(int row,int col) {
		return fixedCells[row][col];
	}
	public int[][] getBoard(){
		return board;
	}
	public boolean isSolved() { //해결 확인
	
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j]==0) {
					return false;
				}
			}
		}		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				int num = board[i][j];
				board[i][j]=0;
				
				if(!isValidMove(i,j,num)) {
					board[i][j]=num;
					return false;
				}
				board[i][j]=num;
			}
		}	
		return true;
	}
	
}

