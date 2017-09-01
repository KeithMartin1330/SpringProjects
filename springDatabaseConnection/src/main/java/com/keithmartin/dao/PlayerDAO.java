package com.keithmartin.dao;

import java.util.ArrayList;

import com.keithmartin.Model.Player;

public interface PlayerDAO {
	public void insertSinglePlayer(Player player);
	public void insertTeam(ArrayList<Player> playerList);
	public ArrayList<Player> getSquad();
	

}
