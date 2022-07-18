package com.yz.controller;

import com.yz.pojo.User;
import com.yz.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

@CrossOrigin  //为了在服务器端支持跨域访问！！！
@RestController  //有了这个不用在下面的方法上面加@ResponseBody了！
@RequestMapping("/user")
public class UserController {

    public static final int PAGE_SIZE =5;



    //一定有业务逻辑层的对象
    UserService userService;

    /**
     * /user/selectUserPage?userName=z&userSex=男&page=null
     */

    @RequestMapping("/selectUserPage")
    //@ResponseBody
    public List<User> selectUserPage(String userName,String userSex,Integer page){
        int startRow=0;
        if(page != null){
            startRow = (page-1)*PAGE_SIZE;

        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    /**
     * /user/ deleteUserById?userId= 15968162087363060
     */
    @RequestMapping("/deleteUserById")
    //@ResponseBody
    public int deleteUserById(String userId){

        return userService.deleteUserById(userId);
    }

    /**
     * /user/createUser(参数见下面)
     */
    //@ResponseBody
    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis()+"";
        user.setUserId(userId);
        return userService.createUser(user);

    }

    /**
     * /user/getRowCount?userName=z&userSex=男
     */
   // @ResponseBody
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName ,String userSex){

        return userService.getRowCount(userName,userSex);
    }



}
