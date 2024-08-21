package org.zerock.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)  // 메서드별 테스트용 JUnit4
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) // 참고할 파일
@Log4j2
@WebAppConfiguration // 프론트 테스트
//Mock을 활용해서 get,post방식으로 param을 보낸뒤 controller에서 처리되는지 테스트한다
public class controller_tests {

	@Setter(onMethod_= @Autowired)
	private WebApplicationContext ctx; // 톰켓 대신해서 사용한다.
	
	private MockMvc mockMvc; // 크롬 대신해서 사용한다.
	
	@org.junit.Before // 구동전에 선행되는 코드
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}//method end
	
	@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) //테스트 타겟 url
				.andReturn()												 //결과 얻기
				.getModelAndView()											 //결과를 모델과 뷰에 담기
				.getModelMap()												 //select결과 얻기
				);
		
	}
	
	@Test
	public void testRegister() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","컨트롤러 테스트 제목")
				.param("content","컨트롤러 테스트 내용")
				.param("writer","컨트롤러 테스트 사용자") //테스트용으로 보낸 값
				).andReturn()							  //결과 얻기
				.getModelAndView()						  //결과를 모델과 뷰에 저장
				.getViewName();							  //결과를 String 처리한다
		log.info("결과 url : "+result);					  //result =  redirect:/board/list
	}
	
	
	@Test
	public void testGet() throws Exception{ 
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno","3") //숫자여도 value는 항상 String(""에 감싸서 보내기)
				).andReturn()
				.getModelAndView()
				.getModelMap() //select결과 얻기
				);
		
	}
	
	@Test
	public void testModify() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno","3")
				.param("title","컨트롤러 테스트 제목2")
				.param("content","컨트롤러 테스트 내용2")
				.param("writer","컨트롤러 테스트 사용자2") //테스트용으로 보낸 값
				).andReturn()							  //결과 얻기
				.getModelAndView()						  //결과를 모델과 뷰에 저장
				.getViewName();							  //결과를 String 처리한다
		log.info("결과 url : "+result);					  //result =  redirect:/board/list
		
	}
	
	@Test
	public void testRemove() throws Exception{
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno","5") //테스트용으로 보낸 값
				).andReturn()							  //결과 얻기
				.getModelAndView()						  //결과를 모델과 뷰에 저장
				.getViewName();							  //결과를 String 처리한다
		log.info("결과 url : "+result);					  //result =  redirect:/board/list
		
	}//method end
	
}//class end
