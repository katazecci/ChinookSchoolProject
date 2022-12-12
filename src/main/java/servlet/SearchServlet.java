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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private ArtistDao dao = new JDBCArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = req.getParameter("searchTitle");

		List<Artist> matchingArtists = this.dao.searchForAnArtist(input);

		req.setAttribute("artists", matchingArtists);
		req.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(req, resp);

	}

}
