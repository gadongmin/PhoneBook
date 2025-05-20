package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// 프로그램 시작 안내 메세지 출력
		System.out.println("*************************************************");
		System.out.println("*             전화번호 관리 프로그램            *");
		System.out.println("*************************************************");

		// 리스트
		List<Person> lArray = new ArrayList<Person>();
		// 키보드
		Scanner sc = new Scanner(System.in);

		// 파일 가져오기
		FileReader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB1.txt");
		BufferedReader br = new BufferedReader(fr);

		// 파일 리스트화
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] info = str.split(","); // 쉼표로 구분
			String name = info[0]; // 이름 
			String hp = info[1]; // 핸드폰
			String cp = info[2]; // 회사

			Person p = new Person(name, hp, cp); // 객체생성(이름, 핸드폰, 회사)
			lArray.add(p); // 배열에 담기
		}
		br.close();

		while (true) {
			// 메뉴반복
			System.out.println("");
			System.out.println("1. 리스트   2. 등록   3. 삭제   4. 검색   5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴번호: ");
			int num = sc.nextInt(); // 메뉴번호 입력

			if (num == 5) {
				System.out.println("*************************************************");
				System.out.println("*                   감사합니다                  *");
				System.out.println("*************************************************");
				break;
			}

			switch (num) {
				case 1:
					System.out.println("<1. 리스트>");
					for (int i = 0; i < lArray.size(); i++) {
						System.out.print((i + 1) + ". ");
						lArray.get(i).showInfo();
					}
					break;
	
				case 2:
					System.out.println("<2. 등록>");
					sc.nextLine();
					System.out.print("> 이름: ");
					String name = sc.nextLine();
					System.out.print("> 휴대전화: ");
					String hp = sc.nextLine();
					System.out.print("> 회사전화: ");
					String cp = sc.nextLine();
	
					Person p = new Person(name, hp, cp);
					lArray.add(p);
	
					FileWriter fw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB1.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (Person pArr : lArray) {
						bw.write(pArr.getName() + "," + pArr.getHp() + "," + pArr.getCp());
						bw.newLine();
					}
					System.out.println("[등록되었습니다.]");
					bw.close();
					break;
	
				case 3:
					System.out.println("<3. 삭제>");
					sc.nextLine();
					System.out.print("> 번호: ");
					int dNum = sc.nextInt();
					lArray.remove(dNum - 1);
	
					FileWriter dfw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB1.txt");
					BufferedWriter dbw = new BufferedWriter(dfw);
					for (Person pArr : lArray) {
						dbw.write(pArr.getName() + "," + pArr.getHp() + "," + pArr.getCp());
						dbw.newLine();
					}
					System.out.println("[삭제되었습니다.]");
					dbw.close();
					break;
	
				case 4:
					System.out.println("<4. 검색>");
					sc.nextLine();
					System.out.print("> 이름: ");
					String sName = sc.nextLine();
	
					for (int i = 0; i < lArray.size(); i++) {
						Person pName = lArray.get(i);
						if (pName.getName().contains(sName)) {
							System.out.print((i + 1) + ". ");
							pName.showInfo();
						}
					}
					break;
	
				default:
					System.out.println("[다시 입력해 주세요.]");
			}
		}

		sc.close();
	}

}
