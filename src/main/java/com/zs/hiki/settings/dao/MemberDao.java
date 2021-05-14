package com.zs.hiki.settings.dao;

import com.zs.hiki.settings.domain.Member;

import java.util.List;
import java.util.Map;

public interface MemberDao {
    void append(Member member);

    void upDate(Member member);

    List<Member> select(Member member);

    Integer count();

    Member login(Member member);

    Integer reg(Member member);

    List<Member> selectNotInLike(Member member);

    Integer deleteMember(String[] id);
}
