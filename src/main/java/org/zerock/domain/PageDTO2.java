package org.zerock.domain;

import lombok.Data;

@Data
public class PageDTO2 {

	private int page_num; //현제 페이지수
	private int amount; //데이터 수
	
	public PageDTO2() {
		this.page_num=1;
		this.amount=10;
	}
	
	public PageDTO2(int page_num,int amount) {
		this.page_num = page_num;
		this.amount = amount;
	}
	
	
	
}//class end
