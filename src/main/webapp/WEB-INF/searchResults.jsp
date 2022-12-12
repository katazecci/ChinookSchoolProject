<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8" %>
<html>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<head>
</head>
<body>
	<h1>👀 Search results</h1>
		<ol>
			<c:forEach items="${ artists }" var="artist">
			<li><a href="/albums?ArtistId=${ artist.getId() }"><c:out value="${ artist.getName() }"/></a></li>
			</c:forEach>
		</ol>
</body>
</html>