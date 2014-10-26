package main;

/**
 * Class whose sole purpose is to start the program.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Main {

    /**
     * Runs the program.
     * 
     * @param args Input from command line if run from a terminal.
     */
    public static void main(final String[] args) {
        final Initializer init = new Initializer();
        init.begin(args);
    }
}