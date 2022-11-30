<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

 <div class="card card-body">
		<form method="post" 
		      action="/news/update/${news.aid}" 
		      enctype="multipart/form-data">
		      
			<label class="form-label">제목</label>
			<input name="title" value='${news.title}'>
			<label class="form-label">이미지</label>
			<input type="file" name="file" class="form-control" value="${news.img}">
			<label class="form-label">기사내용</label>
			<textarea cols="50" rows="5" name="content" class="form-control">${news.content}</textarea>
			
			
			<button type="submit" class="btn btn-success mt-3">저장</button>
		</form>
	  </div>


</body>
</html>