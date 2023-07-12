package service.impl;

import entity.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/17:55
 */

@Repository
public class UserServiceImpl implements UserService {

    //创建map集合存储数据
    private  final Map<Integer,User> users=new HashMap<>();

    public UserServiceImpl(){
        this.users.put(1,new User("alice","boy",21));
        this.users.put(1,new User("bob","boy",21));

    }


    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person->{
            //map中添加值
            int id=users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
