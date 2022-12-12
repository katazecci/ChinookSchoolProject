package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.JDBCAlbumDao;
import model.Album;

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet {

	private AlbumDao dao = new JDBCAlbumDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String artistId = req.getParameter("ArtistId");

		List<Album> albums = this.dao.getArtistsAllAlbums(artistId);

		req.setAttribute("albums", albums);
		req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);

	}

}
