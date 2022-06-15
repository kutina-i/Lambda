import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tests {
    @Test
    public void getStringLengthTest(){
        String s = "hi";
        Function<String, Integer> lambda = LambdaDemo.getStringLength;
        assertEquals(Optional.of(2), Optional.of(LambdaRunner.run(lambda, s)));
    }
    @Test
    public void getFirstSymbolTest1() {
        String s = "hi";
        Function<String, Character> lambda = LambdaDemo.getFirstSymbol;
        assertEquals(Optional.of('h'), Optional.of(LambdaRunner.run(lambda, s)));
    }
    @Test
    public void getFirstSymbolTest2() {
        String s = "";
        Function<String, Character> lambda = LambdaDemo.getFirstSymbol;
        assertEquals(Optional.empty(), Optional.ofNullable(LambdaRunner.run(lambda, s)));
    }

    @Test
    public void spaceTest() {
        String s = "hello world";
        Function<String, Boolean> lambda = LambdaDemo.space;
        assertFalse( LambdaRunner.run(lambda, s));
    }
    @Test
    public void countWordsInStringTest1() {
        String s = "hello,world";
        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(2), Optional.ofNullable(LambdaRunner.run(lambda, s)));
    }

    @Test
    public void countWordsInStringTest2() {
        String s = "";
        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(0), Optional.ofNullable(LambdaRunner.run(lambda, s)));
    }

    @Test
    public void getAgeHumanTest(){
        Human human = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Function<? super Human, Integer> lambda = LambdaDemo.getAgeHuman;
        assertEquals(Optional.of(20), Optional.ofNullable(LambdaRunner.run(lambda, human)));
    }

    @Test
    public void equalsSurnameTest(){
        Human human = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Student student = new Student("Асаевич", "Никита", "Сергеевич", 19, Gender.WOMAN, "OмГУ", "ИМИТ", "математик");
        BiFunction<? super Human, ? super Human, Boolean> lambda = LambdaDemo.equalsSurname;
        assertEquals(false, LambdaRunner.biFunctionRunner(lambda, human, student));
    }

    @Test
    public void getStringTest(){
        Human human = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Function<? super Human, String> lambda = LambdaDemo.getString;
        assertEquals("Кутина Ирина Андреевна", LambdaRunner.run(lambda, human));

    }

    @Test
    public void doOlderTest(){
        Human human = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Function<Human, Human> lambda = LambdaDemo.doOlder;
        assertEquals(21, LambdaRunner.run(lambda, human).getAge());
    }

    @Test
    public void checkYoungerMaxAgeTest1(){
        Human human1 = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Human human2 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.WOMAN);
        Human human3 = new Human("Асаевич", "Никитка", "Сергеевич", 15, Gender.MAN);
        int maxAge = 21;
        assertTrue(LambdaDemo.checkYoungerMaxAge.checkHumansMaxAge(human1, human2, human3, maxAge));
    }

    @Test
    public void checkYoungerMaxAgeTest2(){
        Human human1 = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Human human2 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.WOMAN);
        Human human3 = new Human("Асаевич", "Никитка", "Сергеевич", 15, Gender.MAN);
        int maxAge = 20;
        assertFalse(LambdaDemo.checkYoungerMaxAge.checkHumansMaxAge(human1, human2, human3, maxAge));
    }

    @Test
    public void checkAgeRunnerTest() {
        Human human1 = new Human("Кутина", "Ирина", "Андреевна", 20, Gender.WOMAN);
        Human human2 = new Human("Асаевич", "Никита", "Сергеевич", 19, Gender.WOMAN);
        Human human3 = new Human("Асаевич", "Никитка", "Сергеевич", 15, Gender.MAN);

        assertTrue(LambdaRunner.checkAgeRunner(LambdaDemo.checkYoungerMaxAge, human1, human2, human3, 21));
    }

}
