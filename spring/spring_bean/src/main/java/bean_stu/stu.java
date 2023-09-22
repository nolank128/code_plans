package bean_stu;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/21:12
 */
public class stu {

    //四种类型属性
    private String[] courses;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;

    //学生所学多门课程
    private List<course> courseList;
    public void setCourseList(List<course> courseList) {
        this.courseList = courseList;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }




}
