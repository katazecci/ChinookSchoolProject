<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8" %>
<html>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<head>
</head>
<body>
	<h1>✨Project Chinook✨</h1>
	<h3>✔️ Add an artist </h3>
	<form method="post">
    <input name="title" type="text" required placeholder="type here to add an artist..." autofocus /> 
    <input type="submit" value="Add to list" />
</form>
	<h3>👀 Search for an artist</h3>
 	<form action="/search" method="get">
            <input name="searchTitle" type="text" required placeholder="type here to search..." />
            <input type="submit" value="Search">
    </form>
		<ol>
			<c:forEach items="${ artists }" var="artist">
			<li><a href="/albums?ArtistId=${ artist.getId() }"><c:out value="${ artist.getName() }"/></a></li>
			<!--  yllä oleva takaa että sisältö tulkitaan tekstinä, ei koodina-->
			</c:forEach>
		</ol>
</body>
</html>