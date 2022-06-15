import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaDemo {
    //для строки символов получить ее длину
    public static final Function<String, Integer> getStringLength = String::length;

    //для строки символов получить ее первый символ, если он существует, или null иначе
    public static final Function<String, Character> getFirstSymbol = (s) -> Optional.ofNullable(s).filter(x -> !x.isEmpty()).map(y -> y.charAt(0)).orElse(null);

    //для строки проверить, что она не содержит пробелов
    public static final Function<String, Boolean> space = (s) -> !s.contains(" ");

    //слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> countWordsInString = (s)-> {
        if( (s == null)|| (s.isEmpty())){
            return 0;
        }
        int i = 0;
        for(String S : s.split(",")){
            if((!S.isEmpty() && !S.equals(" "))){
                i++;
            }
        }
        return i;
    };

    //по человеку получить его возраст
    public static final Function<? super Human, Integer> getAgeHuman = Human::getAge;

    //по двум людям проверить, что у них одинаковая фамилия
    public static final BiFunction<? super Human, ? super Human, Boolean> equalsSurname = (h1, h2) -> h1.getSurname().equals(h2.getSurname());

    //получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    public static final Function<? super Human, String> getString = (h) -> String.format("%s %s %s",h.getSurname(), h.getName(), h.getPatronymic());

    //сделать человека старше на один год (по объекту Human создать новый объект)
    public static final Function<Human, Human> doOlder = (h) -> new Human(h.getSurname(),h.getName(), h.getPatronymic(), h.getAge() + 1, h.getGender());

    //по трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge
    public static final EqualsHumansAndMaxAge checkYoungerMaxAge = (h1,h2,h3,maxAge) -> (h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge);

}
