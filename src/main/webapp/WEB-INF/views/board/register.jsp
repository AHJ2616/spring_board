<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- jstl format : 날짜 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header"> 게시판 글 등록 페이지 </h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="heading">Board Register
			</div>
			<!-- /.heading -->
			<div class="body">
				<form role="form" action="/board/register" method="post">
					<div class="form-group">
						<label>제목</label>
						<input class="form-control" name="title" />
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name="content" ></textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" />
					</div>
					<button class="btn btn-default">작성완료</button>&nbsp;
					<button type="reset" class="btn btn-default">작성취소</button>
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