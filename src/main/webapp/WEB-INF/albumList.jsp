<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8" %>
<html>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<head>
</head>
<body>
	<h1>🎵 All albums of a chosen artist</h1>
		<ol>
			<c:forEach items="${ albums }" var="album">
			<li><c:out value="${ album.getAlbumsName() }"/></li>
			</c:forEach>
		</ol>
</body>
</html>