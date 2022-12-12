package database;

import java.util.List;

import model.Artist;

public interface ArtistDao {

	public List<Artist> getAllArtists();

	public Artist getArtist(long id);

	public boolean addArtist(Artist artist);

	public List<Artist> searchForAnArtist(String searchTitle);

}
