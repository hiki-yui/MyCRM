package com.zs.hiki.settings.dao;


import com.zs.hiki.settings.domain.Users;

import java.util.List;

public interface T_UsersDao {
    List<Users> selectAll();
}
