package algorithm;

public class App {

    public static void main(String[] args) {
        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(App.class.getClassLoader());
        System.out.println(App.class.getClassLoader().getParent());
        System.out.println(App.class.getClassLoader().getParent().getParent());
    }
}
