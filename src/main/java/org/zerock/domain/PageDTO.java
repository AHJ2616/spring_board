package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int start_page; //시작 페이지
	private int end_page; //끝 페이지
	private boolean prev , next;
	private int total; //총 레코드 수
	
	private PageDTO2 pagedto2; //PageDTO2
	
	//생성자
	public PageDTO(PageDTO2 pagedto2, int total) { 
		//pagedto2의 값(page_num : 페이지 번호 / amount : 한 페이지에 표시할 레코드 수) 와 total(전체 레코드 수)을 받아서 모든 필드값이 정해진다.
		this.pagedto2 = pagedto2;
		this.total=total;
		this.end_page = (int) (Math.ceil(pagedto2.getPage_num()/10.0)) * 10; //page_num에 따라 end_page가 설정된다.
		this.start_page = this.end_page - 9; //end_page에따라 start_page값이 설정 된다.
		int real_end = (int) (Math.ceil(total*1.0) / pagedto2.getAmount()); //전체 레코드 수에서 1페이지당 레코드 수를 나눈 값(최종 페이지수)
		
		//현재 end_page가 최종페이지 보다 크다면 최종페이지는 end_page가 된다
		if(real_end < this.end_page) {
			this.end_page = real_end;
		}
		
		this.prev = this.start_page>1; //이전페이지 체크 : start_page가 1이 아니라면 true
		this.next = this.end_page < real_end; //다음페이지 체크 : end_page가 real_end가 아니라면 true
		
	}
	
}//class end
