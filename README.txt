The Chinook database was created by Luis Rocha and is licensed as open source under the MIT license.

*****************************

Welcome to my first school project! This project is about creating a web application that uses
Chinook-database to display some artists. The styling is very simple on purpose, this project
is just to demonstrate my knowledge in creating some small functionalities in a 
web application that uses a small database.

List of Servlets included in the project (src/main/java/servlet):

- AlbumListServlet.java -- this Servlet is for listing albums of a chosen artist
- ArtistListServlet.java -- this Servlet is for listing all artists in the Chinook database
- SearchServlet.java -- this Servlet is for searching and listing all search results

List of DAO-classes included in the project (src/main/java/database):

- JDBCAlbumDao.java (interface AlbumDao) -- this class contains the methods for searching albums in the database
- JDBCArtistDao.java (interface ArtistDao) -- this class contains methods for searching and listing artists in the database

List of JSP-pages included in the project (src/main/java/webapp/WEB-INF):

- albumList.jsp -- this is the page where all the albums are listed
- artistList.jsp -- this is the (front) page where all artists are listed and where you can add or search for an artist
- searchResults.jsp -- this is the page where all search results are listed

*****************************
