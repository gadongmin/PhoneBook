package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) throws IOException {
		// 프로그램 시작 안내 메세지 출력
		System.out.println("*************************************************");
		System.out.println("*             전화번호 관리 프로그램            *");
		System.out.println("*************************************************");

		// 리스트
		List<Person> personArray = new ArrayList<Person>();
		// 키보드
		Scanner sc = new Scanner(System.in);

		// 파일읽기
		FileReader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB3.txt");
		BufferedReader br = new BufferedReader(fr);

		// 리스트 출력
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			String[] contactInfo = line.split(",");
			String name = contactInfo[0];
			String hp = contactInfo[1];
			String cp = contactInfo[2];

			Person personList = new Person(name, hp, cp);
			personArray.add(personList);
		}
		br.close();

		while (true) {
			// 메뉴반복
			System.out.println("");
			System.out.println("1. 리스트   2. 등록   3. 삭제   4. 검색   5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴번호: ");
			int menuNumber = sc.nextInt(); // 메뉴번호 입력

			if (menuNumber == 5) {
				System.out.println("*************************************************");
				System.out.println("*                   감사합니다                  *");
				System.out.println("*************************************************");
				break;
			}

			switch (menuNumber) {
				case 1:
					System.out.println("<1. 리스트>");
					for (int i = 0; i < personArray.size(); i++) {
						System.out.print((i + 1) + ". ");
						personArray.get(i).showInfo();
					}
					break;
	
				case 2:
					sc.nextLine();
					System.out.println("<2. 등록>");
					System.out.print("> 이름: ");
					String name = sc.nextLine();
					System.out.print("> 휴대전화: ");
					String hp = sc.nextLine();
					System.out.print("> 회사전화: ");
					String cp = sc.nextLine();
	
					Person newPerson = new Person(name, hp, cp);
					personArray.add(newPerson);
	
					// 파일저장
					FileWriter fwAdd = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB3.txt");
					BufferedWriter bwAdd = new BufferedWriter(fwAdd);
					for (Person newPer : personArray) {
						bwAdd.write(newPer.getName() + "," + newPer.getHp() + "," + newPer.getCp());
						bwAdd.newLine();
					}
					System.out.println("[등록되었습니다.]");
					bwAdd.close();
					break;
	
				case 3:
					sc.nextLine();
					System.out.println("<3. 삭제>");
					System.out.print("> 번호: ");
					int deleteIndex = sc.nextInt();
					personArray.remove(deleteIndex - 1);
	
					// 파일저장
					FileWriter fwRe = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB3.txt");
					BufferedWriter bwRe = new BufferedWriter(fwRe);
					for (Person newPer : personArray) {
						bwRe.write(newPer.getName() + "," + newPer.getHp() + "," + newPer.getCp());
						bwRe.newLine();
					}
					System.out.println("[삭제되었습니다.]");
					bwRe.close();
					break;
	
				case 4:
					sc.nextLine();
					System.out.println("<4. 검색>");
					System.out.print("> 이름: ");
					String searchkey = sc.nextLine();
	
					for (int i = 0; i < personArray.size(); i++) {
						Person searchName = personArray.get(i);
	
						if (searchName.getName().contains(searchkey)) {
							System.out.print((i + 1) + ". ");
							searchName.showInfo();
						}
					}
					break;
	
				default:
					System.out.println("[다시 입력해 주세요.]");
					
					break;
			}
		}

		sc.close();
	}

}
