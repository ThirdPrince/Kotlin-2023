package basic.nullables;

import org.jetbrains.annotations.NotNull;

/**
 * 平台类型
 * 客观存在，主观无法定义
 * 例如 getTitle String！
 */
public class Person {


    public String getTitle(){
        return null;
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getTitle());
    }
}
