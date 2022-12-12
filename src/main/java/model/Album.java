package model;

public class Album {

	private long id;
	private String name;

	public Album(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getAlbumsName() {
		return this.name;
	}

	public long getAlbumsId() {
		return this.id;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Album && ((Album) other).id == this.id;
	}

}
