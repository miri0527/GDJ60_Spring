package com.iu.s1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//�������� Test�� ����� ���ؼ� ���븦 ����ִ� �θ� ����
@RunWith(SpringJUnit4ClassRunner.class)
//Test�� ���� ��� �״�� �ۼ�
//** -> spring�ؿ� �Ǵٸ� ������ �־ �ǰ� ����Ǵ� ��
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyTestCase {
	
}
