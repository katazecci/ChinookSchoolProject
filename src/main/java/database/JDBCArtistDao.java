package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class JDBCArtistDao implements ArtistDao {

	private Database db = new Database();

	public List<Artist> searchForAnArtist(String searchTitle) {

		String sql = "SELECT ArtistId, Name FROM Artist WHERE Name LIKE ? ORDER BY Name ASC;";
		List<Artist> matchingArtists = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + searchTitle + "%");
			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				Artist a = new Artist(id, name);
				matchingArtists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.closeAll(connection, statement, results);
		}
		return matchingArtists;
	}

	public List<Artist> getAllArtists() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";
		List<Artist> allArtists = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				Artist a = new Artist(id, name);
				allArtists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.closeAll(connection, statement, results);
		}
		return allArtists;
	}

	@Override
	public Artist getArtist(long id) {

		List<Artist> artists = this.getAllArtists();

		for (Artist artist : artists) {
			if (id == artist.getId()) {
				return artist;
			}
		}
		return null;
	}

	public boolean addArtist(Artist artist) {
		String sql = "INSERT INTO Artist (Name) VALUES (?)";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet ids = null;

		String artistName = artist.getName();

		try {
			connection = this.db.connect();
			statement = connection.prepareStatement(sql);

			PreparedStatement insertQuery = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			insertQuery.setString(1, artistName);
			int rows = insertQuery.executeUpdate();

			if (rows == 1) {
				ids = insertQuery.getGeneratedKeys();
				ids.next();
				long generatedId = ids.getLong(1);
				artist.setId(generatedId);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.closeAll(connection, statement, ids);
		}
		return false;
	}

}
