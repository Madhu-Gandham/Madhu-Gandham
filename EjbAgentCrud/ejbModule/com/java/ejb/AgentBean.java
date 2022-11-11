package com.java.ejb;


import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployCrudBean
 */
@Stateless
@Remote(AgentCrudBeanRemote.class)
public class AgentBean implements AgentCrudBeanRemote {

	static AgentDAO adao;
	
	static {
		adao = new AgentDAO();
	}
    /**
     * Default constructor. 
     */
    public AgentBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Agent> showAgentBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Agent searchAgentBean(int agentid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addAgentBean(Agent agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteAgentBean(int agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateAgentBean(Agent agent) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}