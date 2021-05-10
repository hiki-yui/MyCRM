package com.zs.hiki.settings.service;

import com.zs.hiki.settings.domain.Member;

import java.util.List;
import java.util.Map;

public interface MService {
    Map<String,Object> select(Integer page, Integer size, Member member);

}
