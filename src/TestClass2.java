public class TestClass2 {
    @BeforeSuite
    public static void BeforeMethod(){
        System.out.println("Класс TestClass2, метод BeforeSuite");
    }

    @Test(priority = 2)
    public static void Test1(){
        System.out.println("TestClass2, Test1");
    }

    @Test(priority = 6)
    public static void Test2(){
        System.out.println("TestClass2, Test2");
    }

    @AfterSuite
    public static void AfterMethod(){
        System.out.println("Класс TestClass2, метод AfterSuite");
    }
}
