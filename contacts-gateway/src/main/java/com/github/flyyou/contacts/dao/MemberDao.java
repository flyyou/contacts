package com.github.flyyou.contacts.dao;

import java.util.List;

import com.github.flyyou.contacts.domain.Member;

public interface MemberDao {

	public void create(Member member);

	public int update(Member member);

	public int delete(String id);

	public Member get(String id);

	public List<Member> getAllList();

}
