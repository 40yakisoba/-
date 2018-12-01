import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Hit{
	public static void main(String[] args){
		System.out.println("------------------------------"+"ヒットアンドブロー"+"-----------------------");
		System.out.println("数字と場所が一致していればヒット、　数字が一致していて場所が違うとブロー");
		System.out.println("");
		System.out.println("                 "+"送信回数が10回以下のうちに３ヒットでクリア！");
		System.out.println("                 "+"3つの数字を入力してEnterで送信！");
		System.out.println("                 "+"数字以外を入力すると終了できます。");

		try{
		//答え・・・３つの重複しない数字
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			list.add(i);
		}
		Collections.shuffle(list);//コレクションクラスのシャッフルメソッド
		
		List<Integer> answer = list.subList(0,3);//リスト.subList(開始位置,終了位置)で切り取り
			//System.out.println(answer + " " + scanner);
			
		int count = 0;
			while(true){
				int scanner = new Scanner(System.in).nextInt();//入力された数字
				int[] input = new int[3];
			
				input[0] = (int) scanner / 100;
				input[1] = (int) (scanner - ( input[0] * 100)) / 10;
				input[2] = scanner - ((input[0] * 100) + (input[1] * 10));//分けて配列にして入れておく
				if(scanner < 10 || scanner > 999){
					System.out.println("３つの数字を入力してください。");
						continue;
				
				}else if(input[0] == input[1] || input[1] == input[2] || input[2] == input[0]){
					System.out.println("入力する数字が重複してはいけません。");
						continue;
				}
				
				if(count == 10){
				System.out.println("失敗です、答えは" + answer);
				break;
				}
				
				int hit = 0;
				int blow = 0;
				for(int i = 0; i < answer.size();i++){
					for(int j = 0; j < input.length; j++){
						if(i == j && input[i] == answer.get(j)){
							hit++;
						}else if(input[i] == answer.get(j)){
							blow++;
						}
					}
				}//for
				
				count++;
				System.out.println("-----------------------------"+count+"回目"+"------------------------------------");
				System.out.println("          "+"["+input[0]+" "+input[1]+" "+input[2]+"]"+"は"+hit+"ヒット"+blow+"ブロー");
					
				
				
				if(hit == 3){
					System.out.println("おめでとう！" + count + "回目でクリア");
					break;					
				}
				
			}//while

		}catch(InputMismatchException e){
			System.out.println("数値以外が入力されました。");
		}finally{}
		
	}
}
