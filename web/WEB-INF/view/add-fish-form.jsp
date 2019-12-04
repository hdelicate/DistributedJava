<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 12/4/2019
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Fish</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-donut-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>New Fish</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form:form action="save" modelAttribute="aFish" enctype="multipart/form-data">
            <form:hidden path="id" value="${aFish.id}"/>



            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="speciesName"/>
                        <form:errors path="speciesName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Summary</label></td>
                    <td><form:input path="summary"/>
                        <form:errors path="summary" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Spot</label></td>
                    <td>
                        <form:select path="spotList" items="${spots}" itemLabel="spotName" itemValue="id">
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>
    </div>
</div>
</body>
</html>