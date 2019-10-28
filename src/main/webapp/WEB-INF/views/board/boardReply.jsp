<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">답글 등록</h1>
	</div>
</div>

<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">답글 등록</div>
		
		<div class="panel-body">
			<form role="form" action="/board/boardReply" method="post">
			<input type='hidden' name='groupNo' value='<c:out value="${boardReply.groupNo}"/>'>
			<input type='hidden' name='groupOrd' value='<c:out value="${boardReply.groupOrd}"/>'>
			<input type='hidden' name='depth' value='<c:out value="${boardReply.depth}"/>'>
				<div class="form-group">
					<label>Title</label>
					<input class="form-control" id="title" name="title">
				</div>
				
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" id="content" name="content"></textarea>
				</div>
				<div class="form-group">
              		<label>Writer</label>
                    <input class="form-control" id="writer" name="writer">
                </div>
                
                <button id="submit" type="submit" class="btn btn-default">Submit Button</button>
                <button type="reset" class="btn btn-default">Reset Button</button>
				<button type="button" class="btn btn-default" onclick="self.location='/board/list'">Cancle</button>
			</form>
		</div>
	</div>
</div>
<script>
</script>
<%@ include file="../includes/footer.jsp" %>

</body>
</html>