package life.zkf.hustcatdog.service;

import life.zkf.hustcatdog.mapper.AdminMapper;
import life.zkf.hustcatdog.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin checkAdmin(String username, String password) {

        return adminMapper.queryAdminByUsernameAndPassword(username, password);

    }
}
