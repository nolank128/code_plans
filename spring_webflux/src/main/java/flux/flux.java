package flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/12/16:59
 */
public class flux {
    public static void main(String[] args){

        //flux 返回多个元素
        //mono 返回0或1个元素
        Flux.just(1,2,3,4).subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);

        Integer[] arr={1,2,3};
        Flux.fromArray(arr);

        List<Integer> list= Arrays.asList(arr);
        Flux.fromIterable(list);

        Stream<Integer> stream=list.stream();
        Flux.fromStream(stream);


    }
}
