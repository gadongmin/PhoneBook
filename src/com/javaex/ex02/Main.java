package com.javaex.ex02;

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
		List<Person> pArr = new ArrayList<Person>();
		// 키보드
		Scanner sc = new Scanner(System.in);

		// 파일읽기
		FileReader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB2.txt");
		BufferedReader br = new BufferedReader(fr);

		// 리스트 출력
		while (true) {
			String str = br.readLine(); // 한줄씩 읽기
			if (str == null) { // 출력내용이 없을때 종료
				break;
			}
			String[] info = str.split(","); // 쉼표로 구분
			String name = info[0];
			String hp = info[1];
			String cp = info[2];

			Person p = new Person(name, hp, cp); // 객체생성
			pArr.add(p); // 담기
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
					for (int i = 0; i < pArr.size(); i++) {
						System.out.print((i + 1) + ". ");
						pArr.get(i).showInfo();
					}
					break;
	
				case 2:
					System.out.println("<2. 등록>");
					sc.nextLine();
					System.out.print("이름: ");
					String name = sc.nextLine();
					System.out.print("휴대전화: ");
					String hp = sc.nextLine();
					System.out.print("회사전화: ");
					String cp = sc.nextLine();
	
					Person p = new Person(name, hp, cp);
					pArr.add(p);
	
					// 파일에 저장
					FileWriter fw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB2.txt");
					BufferedWriter bw = new BufferedWriter(fw);
	
					for (Person person : pArr) {
						bw.write(person.getName() + "," + person.getHp() + "," + person.getCp());
						bw.newLine();
					}
					System.out.println("[등록되었습니다.]");
					bw.close();
					break;
	
				case 3:
					System.out.println("<3. 삭제>");
					sc.nextLine();
					System.out.print("번호: ");
					int dNum = sc.nextInt();
					pArr.remove(dNum - 1);
	
					// 파일에 저장
					FileWriter dfw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB2.txt");
					BufferedWriter dbw = new BufferedWriter(dfw);
	
					for (Person person : pArr) {
						dbw.write(person.getName() + "," + person.getHp() + "," + person.getCp());
						dbw.newLine();
					}
					System.out.println("[삭제되었습니다.]");
					dbw.close();
					break;
	
				case 4:
					System.out.println("<4. 검색>");
					sc.nextLine();
					System.out.print("이름: ");
					String sName = sc.nextLine();
	
					for (int i = 0; i < pArr.size(); i++) {
						Person pName = pArr.get(i);
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
