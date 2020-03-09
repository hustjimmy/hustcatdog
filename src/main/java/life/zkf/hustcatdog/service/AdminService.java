package life.zkf.hustcatdog.service;

import life.zkf.hustcatdog.pojo.Admin;

public interface AdminService {

    Admin checkAdmin(String username, String password);

}
