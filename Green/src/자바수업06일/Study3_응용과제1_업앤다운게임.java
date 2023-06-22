package 자바수업06일;

import java.util.Scanner;

public class Study3_응용과제1_업앤다운게임 {
	public static void main(String[] args) {
		GameUpDown game = new GameUpDown();
	}
}
class GameUpDown 
{
	Scanner sc = new Scanner(System.in);
	static int totCnt=0,winCnt=0, lossCnt=0;
	
	int comNumber;
	int gameCount=5;	
	CountDown cd = new CountDown();
	Thread th = new Thread(cd);
	GameUpDown()
	{
		th.start();
		while(true)
		{
			int sel;
			System.out.println("1.게임시작");
			System.out.println("2.결과");
			System.out.println("3.종료");
			System.out.print("선택:"); sel = sc.nextInt();
			if( sel == 1)      { gameStart();}
			else if( sel == 2) { history();}
			else if( sel == 3) {System.out.println("프로그램종료.");break;}
			
		}
	}
	void gameStart()
	{		
		//comNumber = (int)(Math.random()*50+1);//컴퓨터 숫자생성..
		comNumber =1;
		CountDown.check = true;//카운트다운시작.
		System.out.print("답:"); int myNumber = sc.nextInt();
		
		if(comNumber == myNumber)
		{
			if(gameCount>0)
			{
				System.out.println("정답입니다! 승리!");
				CountDown.check=false;
				CountDown.secondCheck=3;
				winCnt++;
				totCnt++;
			}
			else
			{
				System.out.println("틀렸습니다! 패배!");
				CountDown.check=false;
				CountDown.secondCheck=3;
				totCnt++;
				lossCnt++;
			}
		}		
	}	
	void history()
	{
		System.out.println("총시도횟수 : "+totCnt+" 회");
		System.out.println("승리(5회이내정답): "+winCnt+"회");
		System.out.println("패배(5회초과시): "+lossCnt+"회");
	}	
}

class CountDown implements Runnable{
	static boolean check = false;
	static int secondCheck=3;	
	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(100);				
				//System.out.println("check:" + check);
			} catch (InterruptedException e) {			
			}
			
			
			if(check == true)
			{
				try {
					System.out.println("\n3...:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;					
					if(check==false){secondCheck=3;continue;}
					
					System.out.println("2..:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;
					if(check==false){secondCheck=3;continue;}
					
					System.out.println("1.:"+secondCheck);
					Thread.sleep(1000);
					secondCheck--;				
					if(check==false){secondCheck=3;continue;}
					
					if(secondCheck==0)
					{
						check=false;
						System.out.println("시간초과..패배!");
						GameUpDown.totCnt++;
						GameUpDown.lossCnt++;
						secondCheck=3;//시칸체크 초기화
					}
				} catch (InterruptedException e) {			
				}
			}
		}
		
	}
}
