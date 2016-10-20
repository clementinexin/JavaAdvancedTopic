package groovy

/**
 * Created by daijiajia on 16/10/20.
 */
class NullableDemo {

    public static void main(def args) {
        def person = new Person()
        println(person?.car?.insurance?.name)
    }
}
