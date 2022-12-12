package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ArtistDao;
import database.JDBCArtistDao;
import model.Artist;

@WebServlet("/")
public class ArtistListServlet extends HttpServlet {

	private ArtistDao dao = new JDBCArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = this.dao.getAllArtists();

		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String artistTitle = req.getParameter("title");
		Artist newArtist = new Artist(artistTitle);
		boolean success = this.dao.addArtist(newArtist);

		if (success) {
			resp.sendRedirect("/");
		} else {
			resp.getWriter().println("Could not add item " + artistTitle);
		}

	}

}
