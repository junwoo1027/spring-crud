<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	게시글 목록
                            	<button id='regBtn' type="button" class="btn btn-xs pull-right">새 글 작성</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>#번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>수정일</th>
                                        </tr>
                                    </thead>
     								
     								<c:forEach items="${list}" var="board">

     									<tr>    									
     										<c:if test="${board.fix == 0}">
     										<td class='fix'><c:out value="${board.bno}"/></td>
     										
     										
     										<td>
     										<c:if test="${board.depth > 0}">
     											<c:forEach begin="1" end="${board.depth}">
     												&nbsp;&nbsp;&nbsp;
     											</c:forEach>
     											Re:
     										</c:if>
     										<a class='move' href='<c:out value="${board.bno}"/>'>
     										<c:out value="${board.title}"/></a>
											<c:if test="${board.replyCnt > 0}">
     										<b>[<c:out value="${board.replyCnt}"/>]</b>
     										</c:if>
     											<c:forEach items="${replyList}" var="replies">
 <%--   												<c:forEach items="${replies.value}" var ="rep">
    													<c:if test="${board.bno == replies.key}">			
														<br>
														<div class="fa fa-comments fa-fw"></div>
														<p>작성자 : ${rep.getReply()}
														내용 : ${rep.getReplyer()}</p>
													</c:if>
													</c:forEach>--%>
    											</c:forEach>
     										</td>
     										

     										
     										<td><c:out value="${board.writer}"/></td>
     										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
     										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
     										</c:if>
     										
     										
     										<c:if test="${board.fix == 1}">
     										<td class='fix' bgcolor="yellow"><c:out value="공지"/></td>
     										<td bgcolor="yellow"><a class='move' href='<c:out value="${board.bno}"/>'>
     										<c:out value="${board.title}"/></a>
     										<c:if test="${board.replyCnt > 0}">
     										<b>[<c:out value="${board.replyCnt}"/>]</b>
     										</c:if>
     									    	<c:forEach items="${replyList}" var="replies">
   <%--  												<c:forEach items="${replies.value}" var ="rep">
    													<c:if test="${board.bno == replies.key}">			
														<br>
														<div class="fa fa-comments fa-fw"></div>
														<p>작성자 : ${rep.getReply()}
														내용 : ${rep.getReplyer()}</p>
														</c:if>
													</c:forEach> --%>
    											</c:forEach>
     										</td>
     										<td bgcolor="yellow"><c:out value="${board.writer}"/></td>
     										<td bgcolor="yellow"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
     										<td bgcolor="yellow"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
     										</c:if>
     									</tr>
     								</c:forEach>
                                </table>
                                
                                <div class='pull-right'>
                                	<ul class="pagination">
                                		<c:if test="${pageMaker.prev}">
                                			<li class="paginate_button previous"><a href="${pageMaker.startPage -1}">Previous</a></li>
                                		</c:if>
                                		
                                		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                                			<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
                                		</c:forEach>
                                		
                                		<c:if test="${pageMaker.next}">
                                			<li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>
                                		</c:if>
                                	</ul>
                                </div>
                                <form id="actionForm" action="/board/list" method="get">
                                	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
                                	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
                                </form>
                                
				            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
											처리완료됬습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<%@ include file="../includes/footer.jsp" %>

<script type="text/javascript">

//modal 이벤트
$(document).ready(function(){
	var result= '<c:out value="${result}"/>';
	var fix= '<c:out value="${fix}"/>';
	
	checkModal(result);
	
	//글등록후 모달창 뜨고 뒤로가기하고 앞으로 가기해도 다시 모달창안뜸
	history.replaceState({}, null, null);
	
	function checkModal(result){
		if(result === '' || history.state){
			return;
		}
		
		if(parseInt(result) > 0){
//			$(".modal-body").html("게시글 "  + parseInt(result)  + "번이 등록되었습니다.");
			$(".modal-body").html("게시글이 등록되었습니다.");
		}
		$("#myModal").modal("show");
	}
	
	//게시글 등록 이벤트
	$("#regBtn").on("click", function(){
		self.location = "/board/register";
	});
	
	//페이징버튼
	var actionForm = $("#actionForm");
	
	$(".paginate_button a").on("click", function(e){
		e.preventDefault();//a태그 클릭해도 이동 없도록 처리
		console.log('click');
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	//게시물 조회시 페이지 관련 값 전달 이벤트
	$(".move").on("click", function(e){
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
		actionForm.attr("action","/board/get");
		actionForm.submit();
	});
});
</script>