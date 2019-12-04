<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fish List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Fish Reviews</h2>

        <button class="add-button" onclick="window.location.href='showAddDonutForm';return false;">
            Add Fish
        </button>

    </div>
</div>

<form:form method="GET" action="search">
    Search Fish <input type="search" name="searchTerm">
    <input type="submit" value="Search" class="add-button">
</form:form>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th></th>
                <th>Spot</th>
                <th>Fish Name</th>
                <th>Summary</th>

            </tr>

            <c:forEach var="tempFish" items="${fish}">
                <c:url var="updateLink" value="/fish/showUpdateFishForm">
                    <c:param name="fishId" value="${tempFish.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/fish/delete">
                    <c:param name="fishId" value="${tempFish.id}"/>
                </c:url>

                <tr>

                    <td>${tempFish.spotList.spotName}</td>
                    <td>${tempFish.speciesName}</td>
                    <td>${tempFish.summary}</td>

                    <td>
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
                        <a href="${deleteLink}"
                           onclick="if(!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>
