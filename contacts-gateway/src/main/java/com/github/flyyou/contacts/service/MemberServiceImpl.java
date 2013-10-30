package com.github.flyyou.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.flyyou.contacts.base.BaseService;
import com.github.flyyou.contacts.dao.MemberDao;
import com.github.flyyou.contacts.domain.Member;
import com.github.flyyou.contacts.exception.AlreadyExistException;
import com.github.flyyou.contacts.exception.NotFoundException;

@Service
public class MemberServiceImpl extends BaseService implements MemberService {

	@Autowired
	private MemberDao memberDao;

	public void create(Member member) {
		Assert.notNull(member, "member can't be null");
		Assert.hasText(member.getId(), "member's id can't be null");

		Member oldMember = memberDao.get(member.getId());
		if (oldMember != null) {
			throw new AlreadyExistException("already exist member. id=" + member.getId());
		}

		memberDao.create(member);
	}

	public int update(Member member) {
		Assert.notNull(member, "member can't be null");
		Assert.hasText(member.getId(), "member's id can't be null");

		Member oldMember = memberDao.get(member.getId());
		if (oldMember == null) {
			throw new NotFoundException("not exist member. id=" + member.getId());
		}

		int result = memberDao.update(member);

		return result;
	}

	public int delete(String id) {
		Assert.hasText(id, "member's id can't be null");

		Member member = memberDao.get(id);
		if (member == null) {
			throw new NotFoundException("not exist member. id=" + id);
		}

		int result = memberDao.delete(id);

		return result;
	}

	public Member get(String id) {
		Assert.hasText(id, "member's id can't be null");

		Member member = memberDao.get(id);
		if (member == null) {
			throw new NotFoundException("not exist member. id=" + id);
		}

		return member;
	}

	public List<Member> getAllList() {
		List<Member> memberList = memberDao.getAllList();

		return memberList;
	}

}
