package TestAnnotation2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by stas on 12.08.2017.
 */
public class Action {

   @MyPermission(value = {PermissionAction.USER_READ})
    public void readFile(User user){
       String[] strings = user.getPermissions().toString().split(",");
       try {
           Method m = getClass().getMethod("readFile", User.class);
           for (int i = 0; i < m.getAnnotations().length; i++) {
               int k = 0;
               for (int j = 0; j <strings.length; j++) {
                    if(m.getAnnotations()[i].toString().contains(strings[i]))
                    ++k;
               }
               if (k == strings.length)
                   System.out.println(user.getName() + " read file");
               else
                   System.out.println(user.getName() + " tried to read file" + " Access denied");
           }
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       }
    }
    @MyPermission(value = {PermissionAction.USER_READ, PermissionAction.USER_WRITE})
    public void writeFile(User user){
        String[] strings = user.getPermissions().toString().split(",");
        try {
            Method m = getClass().getMethod("writeFile", User.class);
            for (int i = 0; i < m.getAnnotations().length; i++) {
                int k = 0;
                for (int j = 0; j <strings.length; j++) {
                    if(m.getAnnotations()[i].toString().contains(strings[i]))
                        ++k;
                }
                if (k == strings.length)
                    System.out.println(user.getName() + " write file");
                else
                    System.out.println(user.getName() + " tried to write file" + " Access denied");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @MyPermission(value = {PermissionAction.USER_READ, PermissionAction.USER_WRITE,
                           PermissionAction.USER_CHANGE})
    public void modifyFile(User user){
        String[] strings = user.getPermissions().toString().split(",");
        try {
            Method m = getClass().getMethod("modifyFile", User.class);
            for (int i = 0; i < m.getAnnotations().length; i++) {
                int k = 0;
                for (int j = 0; j <strings.length; j++) {
                    if(m.getAnnotations()[i].toString().contains(strings[i]))
                        ++k;
                }
                if (k == strings.length)
                    System.out.println(user.getName() + " modify file");
                else
                    System.out.println(user.getName() + " tried to modify file." + " Access denied");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
