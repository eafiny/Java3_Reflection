import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainTestClass {

    private static void start(List<Class> classList) {
        for (Class aClass : classList) {
            Method[] classMethods = aClass.getMethods();
            try {
                testClass1(classMethods);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testClass1(Method[] methods) throws InvocationTargetException, IllegalAccessException {
        boolean flagNoOccurence = true;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class) & flagNoOccurence){
                flagNoOccurence = false;
                try {
                    method.invoke(null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (method.isAnnotationPresent(BeforeSuite.class) & !flagNoOccurence){
                throw new RuntimeException();
            }
        }

        List<Method> testAnnotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)){
                testAnnotatedMethods.add(method);
            }
        }
        for (Method method:testAnnotatedMethods) {
            System.out.println("Выполняется метод с приоритетом " + method.getAnnotation(Test.class).priority());
            method.invoke(null);
        }

        flagNoOccurence = true;
        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class) & flagNoOccurence){
                flagNoOccurence = false;
                try {
                    method.invoke(null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else if (method.isAnnotationPresent(AfterSuite.class) & !flagNoOccurence){
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        Class class1 = TestClass1.class;
        Class class2 = TestClass2.class;
        List<Class> classList = new ArrayList<>();
        classList.add(class1);
        classList.add(class2);
        start(classList);
    }
}
