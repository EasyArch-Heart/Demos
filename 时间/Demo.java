package Demos.file.时间;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*SimpleDateFormat类的例子
  yyyy 四个y是四位年份 如2019
 */
public class Demo {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        String data="2019-9-13 10:01:20";
        try {
            Date a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data);
            System.out.println(a);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
