package TestDateTime;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.time.LocalDateTime;

/**
 * Created by stas on 14.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime birthDay = LocalDateTime.of(1995,6,20,14,1);
        int yearsOfLife = currentDate.getYear() - birthDay.getYear();
        System.out.println(yearsOfLife);
    }
}
