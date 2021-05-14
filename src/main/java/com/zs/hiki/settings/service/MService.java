package com.zs.hiki.settings.service;

import com.zs.hiki.settings.domain.Member;

import java.util.List;
import java.util.Map;

public interface MService {
    Map<String,Object> select(Integer page, Integer size, Member member);

    void appendMember(Member member);

    void editMember(Member member);

    Member login(Member member);

    Member reg(Member member);

    Member selectLoginName(Member member);

    Member selectMemberName(Member member);

    void deleteMember(String[] Id);
}
