public class TestClass1 {
    @BeforeSuite
    public static void BeforeMethod(){
        System.out.println("Класс TestClass1, метод BeforeSuite");
    }

    @Test(priority = 5)
    public static void Test1(){
        System.out.println("TestClass1, Test1");
    }

    @Test(priority = 3)
    public static void Test2(){
        System.out.println("TestClass1, Test2");
    }

    @AfterSuite
    public static void AfterMethod(){
        System.out.println("Класс TestClass1, метод AfterSuite");
    }
}
