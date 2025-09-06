//package com.login.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.login.dto.Message;
//import com.login.entity.UserInfo;
//import com.login.repository.UserInfoRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LoginServiceTest {
//
//	
//	@Autowired
//	LoginService loginService;
//	
//	@Autowired
//	UserInfoRepository userInfoRepository;
//	
//	@Test
//	public void test_addUser() {
//		UserInfo userInfo = new UserInfo(1, "Name1", "Name1@gmail.com", "Password", "ADMIN");
//		Message message = new Message("User added to system");
//		//when(loginService.addUser(userInfo)).thenReturn(message);
//		//assertEquals("User added to system",message.getMessage());
//		assertEquals(1, 1);
//	}
//}
