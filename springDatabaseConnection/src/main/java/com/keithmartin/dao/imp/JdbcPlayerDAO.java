package com.keithmartin.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.keithmartin.Model.Player;
import com.keithmartin.dao.PlayerDAO;

public class JdbcPlayerDAO implements PlayerDAO{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// insert a player manually to database
	public void insertSinglePlayer(Player player){

		String sql = "INSERT INTO dbo.Players " +
				"(Name, DateOfBirth, Position) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, player.getName());
			ps.setString(2, player.getDateOfBirth());
			ps.setString(3, player.getPosition());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	// insert an arraylist containg a whole team
	public void insertTeam(ArrayList<Player> playerList){

		String sql = "INSERT INTO dbo.Players " +
				"(Name, DateOfBirth, Position) VALUES (?, ?, ?)";
		Connection conn = null;

		for(Player a:playerList) {

			try {

				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, a.getName());
				ps.setString(2, a.getDateOfBirth());
				ps.setString(3, a.getPosition());
				ps.executeUpdate();
				ps.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);

			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {}
				}
			}
		}
	}
	//
	public ArrayList<Player> getSquad() {

		String sql = "SELECT * FROM dbo.Players";
		Connection conn = null;
		Player p = null;
		ArrayList<Player> list = new ArrayList<Player>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				p= new Player(rs.getString("Name"),rs.getString("DateOfBirth"),rs.getString("Position"));
				list.add(p);
			}
			return list;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}

}

