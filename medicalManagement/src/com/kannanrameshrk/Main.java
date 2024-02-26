package com.kannanrameshrk;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		BaseView baseView = new BaseView();
		
		System.out.println("Medical Management");
		System.out.println("********************");
		boolean loop=true;
		
		do{
			System.out.println(" 1.Admin");
			System.out.println(" 2.User");
			System.out.println(" 3.Exit");
			System.out.println("Enter your choice:");
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:{
				System.out.println("\t\tAdmin Page:");
				System.out.println("\t\t***********");
				baseView.adminStart(input);
				break;
			}
			case 2:{
				System.out.println("\t\tUser Page");
				System.out.println("\t\t***********");
				baseView.userStart(input);
				break;
			}
			case 3:{
				loop=false;
				System.out.println("Exit Application..");
				break;
			}
			default:{
				System.out.println("Exit application...");
				break;
			}
			}
		}while(loop);
		
	}
}
