package service;

import entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/17:51
 */
public interface UserService {

    //根据id查询用户
    Mono<User> getUserById(int id);
    //查询all用户
    Flux<User> getAllUser();
    //add用户

    Mono<Void> saveUserInfo(Mono<User> user);
}
