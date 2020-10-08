package hw_441;

public interface Factory< A, B> {

    A createInstance(B object) throws Exception;

}
