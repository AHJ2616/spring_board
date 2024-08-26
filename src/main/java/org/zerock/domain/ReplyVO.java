package org.zerock.domain;

import java.util.Date;

public class ReplyVO {
	
	private Long rno; //pk
	private Long bno;
	
	private String reply; //댓글
	private String replyer; //작성자
	private Date replydate; //작성일
	private Date update_date; //수정일

}
