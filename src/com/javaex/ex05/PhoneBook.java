package com.javaex.ex05;

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
		System.out.println("***********************************##*************");
		System.out.println("*             전화번호 관리 프로그램            *");
		System.out.println("*************************************************");

		// 리스트
		List<Person> personArray = new ArrayList<Person>();
		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 파일읽기
		FileReader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB5.txt");
		BufferedReader br = new BufferedReader(fr);

		// 주소록 출력
		while (true) {
			String personList = br.readLine();
			if (personList == null) {
				break;
			}
			String[] personInfo = personList.split(",");
			String name = personInfo[0];
			String hp = personInfo[1];
			String cp = personInfo[2];

			Person person = new Person(name, hp, cp);
			personArray.add(person);
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
					sc.nextLine();
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
					String newName = sc.nextLine();
					System.out.print("> 휴대전화: ");
					String newHp = sc.nextLine();
					System.out.print("> 회사전화: ");
					String newCp = sc.nextLine();
	
					Person newPerson = new Person(newName, newHp, newCp);
					personArray.add(newPerson);
	
					// 파일 저장
					FileWriter fwAdd = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB5.txt");
					BufferedWriter bwAdd = new BufferedWriter(fwAdd);
	
					for (Person newPersonList : personArray) {
						bwAdd.write(newPersonList.getName() + "," + newPersonList.getHp() + "," + newPersonList.getCp());
						bwAdd.newLine();
					}
					bwAdd.close();
					System.out.println("[등록되었습니다.]");
					break;
	
				case 3:
					sc.nextLine();
					System.out.println("<3. 삭제>");
					System.out.print("> 번호: ");
					int deleteNumber = sc.nextInt();
	
					personArray.remove(deleteNumber);
	
					// 파일저장
					FileWriter fwRe = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB5.txt");
					BufferedWriter bwRe = new BufferedWriter(fwRe);
	
					for (Person newPersonList : personArray) {
						bwRe.write(newPersonList.getName() + "," + newPersonList.getHp() + "," + newPersonList.getCp());
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
	
					for (int i = 0; i < personArray.size(); i++) {
						Person searchPerson = personArray.get(i);
	
						if (searchPerson.getName().contains(searchName)) {
							System.out.print((i + 1) + ". ");
							searchPerson.showInfo();
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
