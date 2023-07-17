package t06_java8.feature.lambda;

public interface Foo {
    String aMethod(String str);

    default String defaultBar() {
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }
    default String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
