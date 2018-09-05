package com.test.api.common;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuildParams {
    public static  String formatTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public static Boolean checkNotNull(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            //获得私有的成员属性
            Field[] fields = clazz.getDeclaredFields();
            if(fields!=null && fields.length>0){
                for(Field f : fields){
                    f.setAccessible(true);
                    //判断AllowNull注解是否存在
                    if(f.isAnnotationPresent(AllowNull.class)){
                        continue;
                    }else {
                        if(f.get(obj)==null || "".equals(f.get(obj))){
                            return false;
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            return false;
        }
        return true;
    }
}
