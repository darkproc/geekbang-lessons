package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService;

    @POST
    @Path("/register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        System.out.println(userService);
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phonenumber);
        System.out.println("user="+user);
        Boolean flag=userService.register(user);
        if(flag){
            request.setAttribute("status","恭喜，注册成功");
        }else{
            request.setAttribute("status","注册失败了");
        }
        return "result.jsp";
    }
}
