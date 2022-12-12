package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class JDBCAlbumDao implements AlbumDao {

	private Database db = new Database();

	@Override
	public List<Album> getArtistsAllAlbums(String id) {
		String selectAll = "SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?;";
		List<Album> allAlbums = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setString(1, id);
			results = statement.executeQuery();

			while (results.next()) {
				long albumId = results.getLong("AlbumId");
				String albumName = results.getString("Title");
				Album a = new Album(albumId, albumName);
				allAlbums.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.closeAll(connection, statement, results);
		}
		return allAlbums;
	}
}
