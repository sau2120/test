package javatest;

import java.util.Scanner;

public class Difficulty {

	//난이도 선택 메서드
	public int selectDifficulty(Scanner scanner) {
		System.out.println("난이도를 선택 : 1.쉬움, 2.보통, 3.어려움");
		int difficulty = scanner.nextInt();
		
		while(difficulty<1 ||difficulty>3) {
			System.out.println("유효하지 않은 입력입니다. 다시 선택하세요: ");
			difficulty = scanner.nextInt();
		}
		return difficulty;
		
	}
	
	
	
	
	
	
	//난이도에 따른 미리 채워진 셀 개수 반환
	public int getFilledCells(int difficulty) {
		switch(difficulty) {
		case 1: return 80;
		case 2: return 30;
		case 3: return 22;
		default : return 0;
		}
	}
	
}
