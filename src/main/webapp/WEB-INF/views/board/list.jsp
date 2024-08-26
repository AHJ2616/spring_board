<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jstl format : 날짜 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판 리스트</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				board.controller list
				<button id="regBtn" type="button" class="btn btn-xs pull-right">새
					게시물 등록</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<!-- for each문 -->
						<c:forEach items="${list}" var="boardlist">
							<tr>
								<!-- 번호 -->
								<td><c:out value="${boardlist.bno}" /></td>
								<!-- 제목 -->
								<td>
									<a href="/board/get?bno=<c:out value='${boardlist.bno}'/>"  >
									<c:out value="${boardlist.title}" />
									</a>
								</td>
								<!-- 작성자 -->
								<td><c:out value="${boardlist.writer}" /></td>
								<!-- 작성일 -->
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${boardlist.regdate}" /></td>
								<!-- 수정일 -->
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${boardlist.updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${ page_maker.prev }">
							<li class="paginate_button previous">
								<a href="${page_maker.start_page - 1}">Previous</a>
							</li>
						</c:if>
						<c:forEach var="num" begin="${page_maker.start_page}" end="${ page_maker.end_page }">
							<li class="paginate_button">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						<c:if test="${ page_maker.next }">
							<li class="paginate_button next">
								<a href="${pageMaker.endPage +1 }">Next</a>
							</li>
						</c:if>
					</ul>
				</div>
				<!-- /.pull-right -->
				
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="page_num" value='${page_maker.page.page_num}' />
					<input type="hidden" name="amount" value='${page_maker.page.amount}' />
				</form>
				
				<!-- Modal : alert대신에 사용하는 Modal 경고창 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">글 작성 완료</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
</div>
<!-- /.row -->

<!-- 준비단계의 익명의 함수(익명의 함수는 뒤에 ;을 붙여야 된다) -->
<script type="text/javascript">
	$(document).ready(function() { /* 웹브라우저 전송 준비단계에서 실행해라 */
		
		/* controller에서 flashAttribute를 통해 1회용으로 넘어오는 result=bno */
		var result = "<c:out value="${result}"/>";
		
		/* check_modal function 실행 */
		check_modal(result);
		
		/* modal function 생성 */
		function check_modal(result){
			if(result===""| history.state){ /* result가 null이거나 history.state=true 이면 동작 x */
				return;
			}
			if(parseInt(result)>0){
				
				$(".modal-body").html("게시글 "+result+"번이 등록되었습니다");
			}
			$("#myModal").modal("show");
		}
		$("#regBtn").on("click", function() { /* id가 regBtn인 동작 */
			self.location = "/board/register";

		});
		var actionForm = $("#actionForm");
		$(".paginate_button a").on(
				"click",
				function(e) {

					e.preventDefault();

					console.log('click');

					actionForm.find("input[name='pageNum']")
							.val($(this).attr("href"));
					actionForm.submit();
				});
</script>

<%@ include file="../includes/footer.jsp"%>
