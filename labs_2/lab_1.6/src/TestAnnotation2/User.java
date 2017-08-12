package TestAnnotation2;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 12.08.2017.
 */
public class User {
    private String name;
    private List<PermissionAction> permissions;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<PermissionAction> getPermissions() {
        return permissions;
    }

    public void addPermission(PermissionAction permissionAction){
        this.permissions.add(permissionAction);
    }
    public void setPermissions(List<PermissionAction> permissions) {
        this.permissions = permissions;
    }
}
