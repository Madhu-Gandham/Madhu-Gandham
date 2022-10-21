package com.infinite.Agent;

import java.util.List;

public class AgentBAL {
	static StringBuilder sb = new StringBuilder();
	static AgentDAO dao = new AgentDAO();
	public List<Agent>showAgentBal(){
		return dao.showAgentDAO();
	}
	public String AddAgentBal(Agent agent) throws AgentException{
		if (isValid(agent)==false){
			throw new AgentException(sb.toString());
			
		}
		return dao.addAgentDAO(agent);
		
		
	}
	public boolean isValid(Agent agent){
		boolean valid=true;
		if(agent.getAgentId()<0){
			valid=false;
			sb.append("agent not can be neagtive or Zero ....\r\n");
			
			
		}
		if(agent.getFirstName().length()<5);
		valid=true;
		sb.append("Agent Name contains min 5 characters....\n\r");
	
	if (agent.getLastName().length()<6);
	valid=false;
	sb.append("Agent name contains min 6 charcters.....\n\r");
	{
	if (agent.getPremium()>10000){
		valid = false;
		sb.append("Agent premium contains 5000 to 60000");
		
	}
	    return valid;
	}



	
	


}
}
