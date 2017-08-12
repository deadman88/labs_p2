package TestAnnotation2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 12.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        User user_1 = new User("Stas");
        User user_2 = new User("Oleg");
        User user_3 = new User("Holga");

        Action action_1 = new Action();

        List<PermissionAction> permissionActions_1 = new ArrayList<>();
        List<PermissionAction> permissionActions_2 = new ArrayList<>();
        List<PermissionAction> permissionActions_3 = new ArrayList<>();

        user_1.setPermissions(permissionActions_1);
        user_1.addPermission(PermissionAction.USER_READ);
        user_1.addPermission(PermissionAction.USER_WRITE);

        user_2.setPermissions(permissionActions_2);
        user_2.addPermission(PermissionAction.USER_READ);

        user_3.setPermissions(permissionActions_3);
        user_3.addPermission(PermissionAction.USER_READ);
        user_3.addPermission(PermissionAction.USER_WRITE);
        user_3.addPermission(PermissionAction.USER_CHANGE);

        System.out.println(user_1.getPermissions());
        action_1.writeFile(user_1);
        action_1.readFile(user_1);
        action_1.modifyFile(user_1);
        System.out.println();

        System.out.println(user_2.getPermissions());
        action_1.writeFile(user_2);
        action_1.readFile(user_2);
        action_1.modifyFile(user_2);
        System.out.println();

        System.out.println(user_3.getPermissions());
        action_1.writeFile(user_3);
        action_1.readFile(user_3);
        action_1.modifyFile(user_3);

    }
}
