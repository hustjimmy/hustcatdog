package life.zkf.hustcatdog.mapper;

import life.zkf.hustcatdog.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    // 通过username查询管理员
    Admin queryAdminByUsernameAndPassword(String username, String password);

}
