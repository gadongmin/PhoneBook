package com.javaex.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// 프로그램 시작 안내 메세지 출력
		System.out.println("*************************************************");
		System.out.println("*             전화번호 관리 프로그램            *");
		System.out.println("*************************************************");

		// 연락처를 저장할 리스트 생성
		List<PhoneList> lArr = new ArrayList<PhoneList>();
		// 입력을 위한 스케너 생성
		Scanner sc = new Scanner(System.in);

		// 파일에서 연락처를 한줄씩 읽어오기
		Reader fr = new FileReader("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String str = br.readLine(); // 한줄읽기
			if (str == null) { // 읽을 줄을 없을 시 반복 종료
				break;
			}
			String[] info = str.split(","); // 쉼표로 분리해서 배열에 저장
			String name = info[0];
			String phoneNum = info[1];
			String cpNum = info[2];

			PhoneList l = new PhoneList(name, phoneNum, cpNum); // 연락처 객체 생성
			lArr.add(l); // 리스트에 추가
			
		}
		br.close(); // 파일 닫기

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
					for (int i = 0; i < lArr.size(); i++) {
						System.out.print((i + 1) + ". ");
						lArr.get(i).showInfo(); // 리스트에 담은 정보 출력
					}
					break;
	
				case 2:
					System.out.println("<2. 등록>");
					sc.nextLine();
					System.out.print("> 이름: ");
					String name = sc.nextLine();
					System.out.print("> 휴대전화: ");
					String phoneNum = sc.nextLine();
					System.out.print("> 회사전화: ");
					String cpNum = sc.nextLine();
	
					// 새 연락처 객체 생성
					PhoneList pAdd = new PhoneList(name, phoneNum, cpNum);
					lArr.add(pAdd); // 리스트에 추가
	
					// 파일 원본에 연락처 추가
					Writer fw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (PhoneList p : lArr) {
						bw.write(p.getName() + "," + p.getPhoneNum() + "," + p.getCpNum());
						bw.newLine();
					}
					bw.close();
	
					System.out.println("[등록되었습니다.]");
					break;
	
				case 3:
					System.out.println("<3. 삭제>");
					System.out.print("> 번호: ");
					int dNum = sc.nextInt();
					lArr.remove(dNum - 1);
	
					Writer dfw = new FileWriter("C:\\javaStudy\\강의자료\\02.java_programming\\미니프로젝트\\PhoneDB.txt");
					BufferedWriter dbw = new BufferedWriter(dfw);
					for (PhoneList p : lArr) {
						dbw.write(p.getName() + "," + p.getPhoneNum() + "," + p.getCpNum());
						dbw.newLine();
					}
					dbw.close();
	
					System.out.println("[삭제되었습니다.]");
					break;
	
				case 4:
					System.out.println("<4. 검색>");
					sc.nextLine();
					System.out.print("> 이름: ");
					String sName = sc.nextLine();
	
					for (int i = 0; i < lArr.size(); i++) {
						PhoneList p = lArr.get(i);
	
						if (p.getName().contains(sName)) { // 이름에 입력한 글자가 있으면 출력
							System.out.print((i + 1) + ". ");
							p.showInfo();
						
						}else {
							System.out.println("[다시 입력해주세요.]");
						}
					}
					break;
	
				default:
					System.out.println("[다시 입력해주세요.]");
					break;
			}

		}

		sc.close();

	}

}
