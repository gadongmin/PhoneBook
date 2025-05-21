package com.javaex.ex04;

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
		List<Person> PersonArray = new ArrayList<Person>();
		// 키보드
		Scanner sc = new Scanner(System.in);

		// 파일읽기
		FileReader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB4.txt");
		BufferedReader br = new BufferedReader(fr);

		// 주소록 출력
		while (true) {
			String flieRead = br.readLine();
			if (flieRead == null) {
				break;
			}
			String[] PersonInfo = flieRead.split(",");
			String name = PersonInfo[0];
			String hp = PersonInfo[1];
			String cp = PersonInfo[2];

			Person PersonSet = new Person(name, hp, cp);
			PersonArray.add(PersonSet);
		}
		br.close();

		while (true) {
			System.out.println("");
			System.out.println("1. 리스트   2. 등록   3. 삭제   4. 검색   5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴번호: ");
			int menuNumber = sc.nextInt();

			if (menuNumber == 5) {
				System.out.println("*************************************************");
				System.out.println("*                   감사합니다                  *");
				System.out.println("*************************************************");
				break;
			}

			switch (menuNumber) {
				case 1:
					System.out.println("<1. 리스트>");
					for (int i = 0; i < PersonArray.size(); i++) {
						System.out.print((i + 1) + ". ");
						PersonArray.get(i).showInfo();
					}
					break;
	
				case 2:
					sc.nextLine();
					System.out.println("<2. 등록>");
					sc.nextLine();
					System.out.print("> 이름: ");
					String name = sc.nextLine();
					System.out.print("> 휴대전화: ");
					String hp = sc.nextLine();
					System.out.print("> 회사전화: ");
					String cp = sc.nextLine();
	
					Person newPerson = new Person(name, hp, cp);
					PersonArray.add(newPerson);
	
					// 파일 저장
					FileWriter fwAdd = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB4.txt");
					BufferedWriter bwAdd = new BufferedWriter(fwAdd);
	
					for (Person personAdd : PersonArray) {
						bwAdd.write(personAdd.getName() + "," + personAdd.getHp() + "," + personAdd.getCp());
						bwAdd.newLine();
					}
					bwAdd.close();
					System.out.println("[등록되었습니다.]");
					break;
	
				case 3:
					sc.nextLine();
					System.out.println("<3. 삭제>");
					sc.nextLine();
					System.out.print("> 번호: ");
					int deleteNumber = sc.nextInt();
	
					PersonArray.remove(deleteNumber);
	
					// 파일 저장
					FileWriter fwRe = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB4.txt");
					BufferedWriter bwRe = new BufferedWriter(fwRe);
	
					for (Person personRe : PersonArray) {
						bwRe.write(personRe.getName() + "," + personRe.getHp() + "," + personRe.getCp());
						bwRe.newLine();
					}
					bwRe.close();
					System.out.println("[삭제되었습니다.]");
					break;
	
				case 4:
					sc.nextLine();
					System.out.println("<4. 검색>");
					System.out.print("> 이름: ");
					String searchName = sc.nextLine();
	
					int index = 0;
					for (Person searchPerson : PersonArray) {
	
						if (searchPerson.getName().contains(searchName)) {
							System.out.println((index + 1) + ". ");
							searchPerson.showInfo();
							index++;
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
