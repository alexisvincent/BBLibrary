package toolkit;

/**
 *
 * @author Dylan Vorster
 */
public class OSFunctions {

    private static boolean isMac = false;
    private static boolean isWindows = false;
    private static boolean isUnix = false;

    static {
        if(System.getProperty("os.name").startsWith("Mac")){
            isMac = true;
        }else if(System.getProperty("os.name").startsWith("Windows")){
            isWindows = true;
        }else{
            isUnix = true;
        }
    }

    public static boolean isMac() {
        return isMac;
    }

    public static boolean isUnix() {
        return isUnix;
    }

    public static boolean isWindows() {
        return isWindows;
    }
}
