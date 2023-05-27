package com.sp.rest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sp.model.UserDB;
import com.sp.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserRestControlleur.class)
public class UserRestCrtTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService uService;

	UserDB mockUser=new UserDB("jdoe", "strong");
	
	@Test
	public void retrieveUser() throws Exception {
		Mockito.when(
				uService.getUser(Mockito.anyInt())
				).thenReturn(mockUser);
				

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/User/50").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		String expectedResult="{\"id\":1,\"name\":\"jdoe\",\"superPowerName\":\"strong\",\"superPowerValue\":100,\"imgUrl\":\"https//url.com\"}";


		JSONAssert.assertEquals(expectedResult, result.getResponse()
				.getContentAsString(), false);
	}

}
