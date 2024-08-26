package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO2;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // spring에 bean 등록(Service) -> root-context.xml에 scan 추가시키기
@Log4j2
@AllArgsConstructor // 모든 필드명을 파라미터로 갖는 생성자 생성
public class BoardService_impl implements BoardService {
	//impl = implements의 줄임말
	
	private BoardMapper mapper; // BoardMapper 인스턴스 생성(query 인터페이스)
	//@AllArgsConstructor 에 넣기위하여 필드에 인스턴스 생성
	
	@Override
	public void register(BoardVO board) {
		// TODO BoardVO를 이용하여 등록(insert into)
		log.info("BoardService_impl.register() 실행");
		mapper.insertSelectKey(board); //자동으로 번호를 생성하고 insert문 실행
		
		
		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO BoardVO에 1개의 게시글 select
		log.info("BoardService_impl.get() 실행");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO BoardVO로 수정하고 boolean return
		return mapper.update(board)==1;//result가 true면 1이 나오니까
	}

	@Override
	public boolean remove(Long bno) {
		// TODO bno와 맞는 게시글 삭제후 boolean return
		return mapper.delete(bno)==1;//result가 true면 1이 나오니까
	}

	@Override
	public List<BoardVO> getlist(PageDTO2 page) {
		// TODO 게시글 전체를 List로 select
		log.info("BoardService_impl.getlist() 실행");
		return mapper.getList(page);
	}
	
	public List<BoardVO> getlist2() {
		// TODO 게시글 전체를 List로 select
		log.info("BoardService_impl.getlist() 실행");
		return mapper.getList2();
	}

	@Override
	public int get_total(PageDTO2 page) {
		// TODO 게시글의 전체갯수 파악하기
		return mapper.getTotal_count(page);
	}

}
