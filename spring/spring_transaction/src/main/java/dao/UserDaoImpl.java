package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ktrol
 * @Date: 2023/07/11/9:37
 */

@Repository
public class UserDaoImpl implements UserDao{



    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void reduce() {
        String sql="update account set value =value -? where account=? ";
        jdbcTemplate.update(sql,200,"alive");
    }

    @Override
    public void add() {

        String sql="update account set value=value+? where account=? ";
        jdbcTemplate.update(sql,200,"bob");
    }
}
