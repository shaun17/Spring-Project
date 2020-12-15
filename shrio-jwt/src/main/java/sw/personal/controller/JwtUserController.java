package sw.personal.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sw.personal.po.User;
import sw.personal.service.UserService;
import sw.personal.shrio.jwt.JwtUtil;

import java.util.List;

public class JwtUserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;


    @RequestMapping(value = "/jwt/login", method = RequestMethod.GET)
    public Object insertRedis(String username, String password) {

        logger.info("==========" + username + password);
        JwtUtil jwtUtil = new JwtUtil();
        String encode = jwtUtil.encode(username, 100000, null);
        List<User> users = userService.queryByUserName(username);
        logger.info(JSONObject.toJSONString(users));
        Subject subject = SecurityUtils.getSubject();
//        JwtToken jwtToken = new JwtToken(encode);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        token.setRememberMe(rememberMe);
        try {
//            subject.login(jwtToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            return "{\"Msg\":\"您的账号或密码输入错误\",\"state\":\"failed\"}";
        }
        return encode;
    }

    @RequestMapping("/jwt/")
    @ResponseBody
    public String index() {
        return "no permission";
    }

    @RequiresPermissions("permission1")
    @RequestMapping("/permission1")
    public String permission1(){
        return "had permission1 ";
    }

    @RequiresPermissions("permission5")
    @RequestMapping("/permission5")
    public String permission5(){
        return "had permission1 ";
    }

    @RequiresRoles("role1")
    @RequestMapping("/rolt1")
    public String rolt1(){
        return "had role1 ";
    }

    @RequestMapping("/role2")
    @RequiresRoles("role2")
    public String rolt2(){
        return "had role1 ";
    }
}
