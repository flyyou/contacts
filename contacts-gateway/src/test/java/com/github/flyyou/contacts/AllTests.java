package com.github.flyyou.contacts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.flyyou.contacts.controller.MemberControllerTest;
import com.github.flyyou.contacts.dao.MemberDaoTest;
import com.github.flyyou.contacts.service.MemberServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	AbstractTest.class, 
	MemberDaoTest.class, 
	MemberServiceTest.class, 
	MemberControllerTest.class, 
})
public class AllTests {

}
