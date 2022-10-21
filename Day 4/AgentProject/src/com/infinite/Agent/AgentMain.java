package com.infinite.Agent;

import java.awt.List;
import java.util.Scanner;

public class AgentMain {
	static Scanner sc = new Scanner(System.in);
	static AgentBAL bal = new AgentBAL();
	public static void main(String[] args) {
		int choice;
		do{
			System.out.println("O P T I O N S");
			System.out.println(".........");
			System.out.println("1.Add agent");
			System.out.println("2.showagent");
			System.out.println("6.Exit");
			System.out.println("Enter your chice");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				try {
					addAgentMain();
				} catch (AgentException e){
				System.out.println(e.getMessage());
				}
				break;
			case 2:
			     showAgentMain();
			     break;
			}while(choice!=6);
			
		
	}
	public static void  showAgentMain(){
		List<Agent>agentList = bal.showAgentBal();
		for ( Agent agent : agentList) {
			System.out.println(agent);
		}
			
		}
	}
	public static void addAgentMain() throws AgentException{
		Agent agent = new Agent();
		System.out.println();
		System.out.println("Enter Agent Number");
		agent.setAgentId(sc.nextInt());
		
		System.out.println("Enter paymode(YEARLY,HALFYEARLY,QUARTERLY    )");
	}
	
		
	}



