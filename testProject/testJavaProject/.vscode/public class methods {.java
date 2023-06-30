public class methods {
    public static void method1(){
        System.out.println("Static method ");
    }
    public void method2(){
        System.out.println("Non-Static Method ");
    }
    public static void mein(String[]args){
        methods obj=new methods();
        obj.method2();
        method1();
        
    }
}
