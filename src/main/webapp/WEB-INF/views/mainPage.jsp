<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mainPage</title>
</head>
<body>

    <Header>
     <%@ include file="/WEB-INF/views/header/header.jsp" %> 
    </Header>
    
    <h1>
       MAINPAGE
    </h1>

    <c:choose>
        <c:when test="${fn:length(mainBoastList) > 0}">
          <c:forEach items="${mainBoastList}" var="list" varStatus="status">
            <tr>
                <td><img src="/img/boast/${list.getBImage()}" alt=""></td>
                <td>${list.getBTitle()}</td>
                <td>${list.getBWriter()}</td>
                <td>${list.getCount()}</td>
            </tr>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <tr>
            <td colspan="4">조회된 결과가 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>

  
</body>
</html>