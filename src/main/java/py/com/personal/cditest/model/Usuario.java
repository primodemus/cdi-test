package py.com.personal.cditest.model;


import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String username;
    private String password;
    private List<String> permissions = new ArrayList<String>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}
