package com.springboot.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.main.SpringBootDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootDemoApplication.class})
public class DemoApplicationTests {

	private String OPENSHIFT_URL = 
		"http://spring-boot-route-test-openship.44fs.preview.openshiftapps.com/springboot/hello";
	
	private String LOCALHOST_URL =
		"http://localhost:8080/springboot";
	
	private TestRestTemplate rest;
	
	@Before
	public void setup () {
		rest = new TestRestTemplate();
	}
	
	@After
	public void cleanup () {
		rest = null;
	}
	
	@Test
	public void contextLoads() {
		String response = rest.getForObject(LOCALHOST_URL, String.class);
		
		assertEquals("default mapping!", response);
		
	}
	
	@Test
	public void testOpenshift () {
		String response = rest.getForObject(OPENSHIFT_URL, String.class);
		assertNotNull(response);
		assertEquals("Hola Toño from RestController!", response);
	}

}
