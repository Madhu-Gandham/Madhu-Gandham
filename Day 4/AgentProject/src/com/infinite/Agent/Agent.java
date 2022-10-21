package com.infinite.Agent;

public class Agent {
	private String FirstName;
	public Agent(String firstName, String lastName, double premium, int agentId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Premium = premium;
		AgentId = agentId;
	}
	@Override
	public String toString() {
		return "Agent [FirstName=" + FirstName + ", LastName=" + LastName + ", Premium=" + Premium + ", AgentId="
				+ AgentId + "]";
	}
	private String LastName;
	private double Premium;
	private int AgentId;
	public Object getFirstName;
	public Agent() {
		
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getPremium() {
		return Premium;
	}
	public void setPremium(double premium) {
		Premium = premium;
	}
	public int getAgentId() {
		return AgentId;
	}
	public void setAgentId(int agentId) {
		AgentId = agentId;
	}
	

}
