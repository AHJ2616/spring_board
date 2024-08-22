<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- jstl format : 날짜 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 게시판 글 수정페이지 </h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="heading">Board modify
			</div>
			<!-- /.heading -->
			<div class="body">
			<div class="form-group">
				<input class="form-control" name="bno" readonly="readonly" value='<c:out value="${board.bno}"/>' />
			</div>
				<form role="form" action="/board/modify" method="post">
					<input type="hidden" name="bno" value="${board.bno}" />
			
					<div class="form-group">
						<label>제목</label>
						<input class="form-control" name="title" value='<c:out value="${board.title}"/>' />
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="4" cols="50" name="content" ><c:out value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" readonly="readonly" value='<c:out value="${board.writer}"/>' />
					</div>
				<%-- 	<div class="form-group">
						<label>작성일</label>
						<input class="form-control" name="regdate" readonly="readonly" value='<fmt:formatDate pattern="yyyy-MM-dd"  value="${board.regdate}"/>' />
					</div>
					<div class="form-group">
						<label>최종수정일</label>
						<input class="form-control" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy-MM-dd"  value="${board.updateDate}"/>' />
					</div> --%>
					<!-- submit이 여러개인 경우 java script를 이용해서 분기처리를 해줘야 한다 -->
					<button data-oper="modify" class="btn btn-primary">수정하기</button>&nbsp;
					<button data-oper="list" class="btn btn-info">뒤로가기</button>
					<!-- /.form-group -->
				</form>	
			</div>
			<!-- ./body -->
		</div>
		<!-- /.panel panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@ include file="../includes/footer.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){ /* 웹브라우저 전송 준비단계에서 실행해라 */
		var formObj = $("form"); /* form을 formObj에 넣는다 */
		$("button").on("click", function(e){
			e.preventDefault(); //버튼을 눌러도 form의 action으로 submit하지 않는다.
			
			var operation=$(this).data("oper"); // data-oper의 값을 operation에 넣는다
			 if(operation==="list"){
				self.location="/board/list";
				return;
			}
			else if(operation==="modify"){
				formObj.submit();
			}
		});
	});
</script>