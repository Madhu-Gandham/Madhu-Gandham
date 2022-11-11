package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;
import javax.naming.InitialContext;

import javax.naming.NamingException;

public class AddAgentMain {

	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Agent agent = new Agent();
		System.out.println("Enter AgentName  ");
		agent.setName(sc.next());
		System.out.println("Enter AgentId ");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter City  ");
		agent.setCity(sc.next());
		System.out.println("Enter Premium   ");
		agent.setPrimium(sc.nextDouble());
		AgentCrudBeanRemote service = null;
		    service = (AgentCrudBeanRemote)
		    		new InitialContext().lookup("AgentBean/remote");
		    System.out.println(service.addAgentBean(agent));
	}
}