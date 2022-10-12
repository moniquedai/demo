package com.prog2.main;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectTest {
	FullTimeTeacher teacher1=new FullTimeTeacher(1021,"Joe","35 Road","(514)234-8765",'m',1001,"Mathematics",
            "math","Phd","2021-04-21","FullTime",20.0,"math",false);
	PartTimeTeacher teacher2=new PartTimeTeacher(1031,"Joan","78 Road","(514)456-8765",'f',1001,"Mathematics",
			"Computer Science","Master","2021-07-21","PartTime",10.5,"computer",false,32);
	Staff staff1=new Staff(1013,"Steve","135 Road Louis","(514)239-8456",'m',1001,"Mathematics","administration",35);


	@Test
	void ComputePayRollTest() {
		assertEquals(6092.80,teacher1.ComputePayRoll(),0.0);
	}

	@Test
	void ComputePayRollTest1() {
		assertEquals(3988.48,teacher2.ComputePayRoll(),0.0);
	}
	
	@Test
	void ComputePayRollTest2() {
		assertEquals(1680,staff1.ComputePayRoll(),0.0);
	}
}


