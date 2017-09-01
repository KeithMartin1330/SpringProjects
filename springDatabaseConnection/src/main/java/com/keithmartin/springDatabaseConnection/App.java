package com.keithmartin.springDatabaseConnection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.keithmartin.dao.PlayerDAO;
import com.keithmartin.rest.RetriveTeamFromAPI;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		RetriveTeamFromAPI team = new RetriveTeamFromAPI();
		//insert squad example must configure database connection
		//ArrayList<Player> players =team.getLatestSquad();
		//playerDAO.insertTeam(players);

		ApplicationContext context =
				new ClassPathXmlApplicationContext("Spring-Module.xml");

		PlayerDAO playerDAO = (PlayerDAO) context.getBean("playerDAO");
		System.out.println(playerDAO.getSquad());



	}
}
