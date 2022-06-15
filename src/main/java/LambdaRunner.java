import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaRunner{
    public static<T, V> V run(Function<T, V> lambda, T param)
    {
        return lambda.apply(param);
    }

    public static <T extends Human> Boolean biFunctionRunner(BiFunction<? super Human, ? super Human, Boolean> lambda, Human human1, Human human2){
        return lambda.apply(human1, human2);
    }

    public static Boolean checkAgeRunner(EqualsHumansAndMaxAge lambda, Human human1, Human human2, Human human3, int maxAge)
    {
        return lambda.checkHumansMaxAge(human1, human2, human3, maxAge);
    }
}