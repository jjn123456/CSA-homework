import java.lang.reflect.Field;

public class StringtoClass {

    public static <T> StringBuffer ObjectToJson(T t){
        Class<?> c=t.getClass();
        Field[] fields=c.getDeclaredFields();
        StringBuffer sb=new StringBuffer("{");
        for(Field field:fields){
            field.setAccessible(true);
            if(sb.equals("{")){
                sb.append(",");
            }
            sb.append("\n"+"\""+field.getName()+"\":");
            try {
                sb.append(field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("\n}");
        return sb;
    }

    public static void main(String[] args) {
        StringBuffer sb = ObjectToJson(new Student());
        System.out.println(sb);
    }
}
