package Java8.TheOptional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl("迪丽热巴");
        Optional<Girl> girl1 = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl("迪丽热巴");
        girl =null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    //报空指针异常，没有实例Girl
    @Test
    public void test3(){
        Boy boy = new Boy();
        String  girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化方法，增加判定条件
    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null)
                return girl.getName();
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String  girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的优化方法
    public String getGirlName2(Boy boy){
        //将boy包装到Optional容器里
        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        //orElse方法可以在boy1为空的时候默认返回参数设定的值，避免了空指针
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();

        //避免girl为空，用ofNullable
        Optional<Girl> girlOptional = Optional.ofNullable(girl);

        //此时的girl1一定非空，这里也用了orElse
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        //最后一定可以成功返回一个name值，因为girl1不可能为空了
        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy = null;
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }

    @Test
    public void test6(){
        Boy boy= new Boy();
        String girlName2 = getGirlName2(boy);
        System.out.println(girlName2);
    }

}
