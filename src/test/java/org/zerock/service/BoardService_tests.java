package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO2;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)  // 메서드별 테스트용 JUnit4
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 파일
@Log4j2 
public class BoardService_tests {

	@Setter(onMethod_= @Autowired) //@autowired - 스프링 의존성주입
	private BoardService service; //서비스 인터페이스 인스턴스 생성
	//setService(BoardSerivce)
	
	@Test //객체 생성 유무 판단용 테스트
	public void testExist() {
		log.info(service); 
		assertNotNull(service);
		//인터페이스를 파라미터로 사용할때 @Service로 등록된 class중 
		//해당 인터페이스를 implemens 한 class가 있다면 그 class가 적용된다.
	}
	
	@Test
	public void test_register() {
		BoardVO board = new BoardVO();
		board.setTitle("제목테스트");
		board.setContent("내용테스트");
		board.setWriter("작성자테스트");
		service.register(board);
		log.info("등록된 게시물의 번호 : " + board.getBno());
	}
	
	@Test
	public void test_get() {
		log.info(service.get(1L)); //long 타입이어서 L 붙임
		
	}
	
	@Test
	public void test_getlist() {
		service.getlist(new PageDTO2(2,2)).forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		if(board==null) {
			log.info("찾는 객체없음");
			return;
		}
		board.setTitle("서비스에서 수정한 제목");
		log.info("서비스에서 수정메서드 결과 : "+service.modify(board));
	}
	
	@Test
	public void testDelete() {
		log.info("삭제된 결과 : "+service.remove(2L));
	}
	
}//class end
