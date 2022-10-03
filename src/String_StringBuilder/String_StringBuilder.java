
package String_StringBuilder;

import java.util.Date;

public class String_StringBuilder {

    public static void main(String[] args) {
        String s = "";
        int db = 50_000;
        long start, stop;
//        Date time = new Date();
//        Date time2 = new Date();
        start = System.currentTimeMillis();
        for (int i = 0; i < db; i++) {
            s+=i;
        }
        stop = System.currentTimeMillis();
        System.out.println("Sima string összefűzés: "+ (stop-start));
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < db; i++) {
            sb.append(i);
        }
        stop = System.currentTimeMillis();
        System.out.println("StringBuilder összefűzés : "+ (stop-start));

    }
    
}
