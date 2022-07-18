package com.yz.service;

import com.yz.pojo.User;


import java.util.List;

public interface UserService{

/**
 * /user/selectUserPage?userName=z&userSex=男&page=null
 */
 List<User> selectUserPage(

         String userName,

         String userSex,

         int startRow);


    /**
     * /user/ deleteUserById?userId= 15968162087363060
     */

    int deleteUserById(String userId);

    /**
     * /user/createUser(参数见下面)
     */
    int createUser(User user);

    /**
     * /user/getRowCount?userName=z&userSex=男
     */
    int getRowCount(String userName, String userSex);

}
