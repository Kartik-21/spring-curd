package com.kartik.curd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class CurdApplicationTests {

	//integrate another dependency
	//@InjectMocks

	@Mock
	List list;

	@Test
	void contextLoads() {
	}

	@Test
	public void getInt(){
		when(list.get(0)).thenReturn(24);
		Assertions.assertSame(24,list.get(0));
	}

}
