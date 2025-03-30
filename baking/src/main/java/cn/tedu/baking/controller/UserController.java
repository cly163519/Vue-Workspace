package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserRegDTO;
import cn.tedu.baking.pojo.vo.UserVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    IUserService userService;
    @PostMapping("/reg")
    public JsonResult reg(UserRegDTO userRegDTO){
        System.out.println("userRegDTO = " + userRegDTO);
        userService.reg(userRegDTO);
        return JsonResult.ok();
    }

    //Login function
    @PostMapping("login")
    public JsonResult login(UserLoginDTO userLoginDTO){
        UserVO userVO = userService.login(userLoginDTO);
        System.out.println("userLoginDTO = " + userLoginDTO);
        return JsonResult.ok(userVO);
    }

}
