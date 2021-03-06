<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">글 등록</h1>
	</div>
</div>

<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">글 등록</div>
		
		<div class="panel-body">
			<form role="form" action="/board/register" method="post">
				<div class="form-group">
					<div class="checkbox">
						<label>
							<input type="checkbox" name ="fix" value="1">공지사항체크
						</label>
					</div>
				</div>
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
<%--var boardTitle = $("#title").val();
var boardContent = $("#content").val();
var boardWriter = $("#writer").val();

$("#submit").on("click", function(){
	if(boardTitle == ""){
		alert("제목을 입력하세요.");
		return;
	}
});--%>
</script>
<%@ include file="../includes/footer.jsp" %>
