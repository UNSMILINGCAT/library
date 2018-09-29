package com.library.mapper;

import com.library.data.UserTable;
import org.apache.ibatis.annotations.Param;

public interface UserTableMapper
{
    UserTable select(String username);

    UserTable select(@Param(value = "username") String username, @Param(value = "password") String password);

    int addUser(UserTable userTable);
}
