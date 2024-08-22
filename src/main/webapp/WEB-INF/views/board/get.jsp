<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- jstl format : 날짜 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 게시판 글 상세보기 </h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="heading">Board get
			</div>
			<!-- /.heading -->
			<div class="body">
			<div class="form-group">
				<input class="form-control" name="bno" readonly="readonly" value='<c:out value="${board.bno}"/>' />
			</div>
				
					<div class="form-group">
						<label>제목</label>
						<input class="form-control" name="title" readonly="readonly" value='<c:out value="${board.title}"/>' />
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="4" cols="50" name="content" readonly="readonly"><c:out value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" readonly="readonly" value='<c:out value="${board.writer}"/>' />
					</div>
					<div class="form-group">
						<label>작성일</label>
						<input class="form-control" name="regdate" readonly="readonly" value='<fmt:formatDate pattern="yyyy-MM-dd"  value="${board.regdate}"/>' />
					</div>
					<div class="form-group">
						<label>최종수정일</label>
						<input class="form-control" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy-MM-dd"  value="${board.updateDate}"/>' />
					</div>
					<button type="button" onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'" class="btn btn-primary">수정</button>&nbsp;
					<button type="button" onclick="location.href='/board/remove?bno=<c:out value="${board.bno}"/>'" class="btn btn-danger">삭제</button>&nbsp;
					<button type="button"  class="btn btn-info">뒤로가기</button>
					<!-- /.form-group -->
				
			</div>
			<!-- ./body -->
		</div>
		<!-- /.panel panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@ include file="../includes/footer.jsp" %>