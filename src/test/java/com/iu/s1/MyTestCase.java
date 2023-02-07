package com.iu.s1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//여러개의 Test를 만들기 위해서 뼈대를 잡아주는 부모 역할
@RunWith(SpringJUnit4ClassRunner.class)
//Test할 때는 경로 그대로 작성
//** -> spring밑에 또다른 폴더가 있어도 되고 없어도되는 것
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyTestCase {
	
}
