package com.maven.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {
	
	@Test
	public void initialTest() {
		Assert.assertEquals("test", "test");
	}

}
