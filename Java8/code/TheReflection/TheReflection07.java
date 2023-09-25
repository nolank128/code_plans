package TheReflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 练习反射操作注解
 */
public class TheReflection07 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("TheReflection.Studnet2");
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        TableBob tableBob = c1.getAnnotation(TableBob.class);
        String value = tableBob.value();
        System.out.println(value);

        System.out.println();
        //获得类指定的注解
        Field declaredField = c1.getDeclaredField("id");
        FieldBob fieldBob = declaredField.getAnnotation(FieldBob.class);
        System.out.println(fieldBob.columnNames());
        System.out.println(fieldBob.type());
        System.out.println(fieldBob.length());

    }
}
@TableBob("db_student")
class Studnet2{
    @FieldBob(columnNames = "db_id",type = "int",length = 10)
    private int id;
    @FieldBob(columnNames = "db_age",type = "int",length = 10)
    private int age;
    @FieldBob(columnNames = "db_name",type = "varchar",length = 3)
    private String name;

    public Studnet2() {
    }

    public Studnet2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Studnet2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableBob{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldBob{
    String columnNames();
    String type();
    int length();

}