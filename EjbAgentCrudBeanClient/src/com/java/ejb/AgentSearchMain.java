package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class    AgentSearchMain {
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		int agentid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AgentId  ");
		agentid = sc.nextInt();
		   AgentCrudBeanRemote service = null;
		    service = (   AgentCrudBeanRemote)
		    		new InitialContext().lookup("AgentBean/remote");
		Agent agent = service.searchAgentBean(agentid);
		if (agent!=null) {
			System.out.println(agent);
		}
		else {
			System.out.println("Not Found");
		}

	}
}