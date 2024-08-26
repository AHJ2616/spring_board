package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO2;

//비지니스 로직을 처리한다
//메서드 명을 mapper와 일치하게 해도 된다.
//url명, method명 등 프론트와 관련있는 객체의 명명은 클라이언트(조장)의 요구에 따른다.

public interface BoardService { //interface를 이용하여 느슨한 결합

	//BoardVO를 이용하여 등록(insert into)
	public void register(BoardVO board);
	
	//BoardVO에 1개의 게시글 select
	public BoardVO get(Long bno);
	
	//BoardVO로 수정하고 boolean return
	public boolean modify(BoardVO board);
	
	//bno와 맞는 게시글 삭제후 boolean return
	public boolean remove(Long bno);
	
	//게시글 전체를 List로 select
	public List<BoardVO> getlist(PageDTO2 page);
	
	/* public List<BoardVO> getlist2(); */
	
	public int get_total(PageDTO2 page);
	
	
}//class end
