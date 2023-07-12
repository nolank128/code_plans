package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.UserService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/18:03
 */

@RestController
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    //id查询用户
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }

    //查询all用户

    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    //添加用户
    @PostMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody User user){
        Mono<User> userMono=Mono.just(user);
        return  userService.saveUserInfo(userMono);
    }
}
