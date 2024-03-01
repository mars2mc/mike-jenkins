package com.mike;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
	
	private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outStream));
	}

	@Test
	public void testSayHello2() throws IOException {
		HelloWorld hw = new HelloWorld();
		hw.sayHello();

		outStream.flush();
        String printedOutPut = new String(outStream.toByteArray());
		String[] outputData = printedOutPut.split(System.getProperty("line.separator"));


		assertEquals("Hello World 123", outputData[0]);
	}

	@AfterEach
	public void cleanUp(){
		System.setOut(null);
	}

}
