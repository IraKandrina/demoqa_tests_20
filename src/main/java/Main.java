public class Main {

    public static void main(String[] args) {
        System.out.println("Int 10 + int 20 = " + sumInt(10, 20));
        System.out.println("Int 522 - int 287 = " + subtractInt(522, 287));
        System.out.println("Int 1 * int 10 = " + multiplyInt(1, 10));
        System.out.println("Int 40 / int 90 = " + divideInt(40, 90));
        System.out.println("Remainder after dividing int 12 by int 7 = " + remainderOfDivision(12, 7));
        System.out.println("Increment int 12 = " + intIncrement(12));
        System.out.println("Decrement int 13 = " + intDecrement(13));
        System.out.println("Compare int 100 and int 100 = " + compareInt(100, 100));

        System.out.println("Int 2147483647 + int 2147483647 overflow = " + sumInt(2147483647, 2147483647));
        System.out.println("Int 2147483647 * int 2147483647 overflow = " + multiplyInt(2147483647, 2147483647));

        System.out.println("Int 10 + double 2.0 = " + sumIntDouble(10, 2.0));
        System.out.println("Int 20 - double 20.25 = " + subtractIntDouble(20, 20.25));
        System.out.println("Int 40 * double 30.125 = " + multiplyIntDouble(40, 30.125));
        System.out.println("Int -50 / double 2.0 = " + divideIntDouble(-50, 2.0));
        System.out.println("Compare int 100 and double 100.00 = " + compareIntDouble(100, 100.00));

        System.out.println(getState("Open"));
        System.out.println(getState("In Progress"));
        System.out.println(getState("Done"));

        System.out.println(getSoftwareTestingType("Functional Testing"));
        System.out.println(getSoftwareTestingType("Regression Testing"));
        System.out.println(getSoftwareTestingType("Stress Testing"));
    }

    public static int sumInt(int a, int b) {
        return a + b;
    }

    public static int subtractInt(int a, int b) {
        return a - b;
    }

    public static int multiplyInt(int a, int b) {
        return a * b;
    }

    public static int divideInt(int a, int b) {
        return a / b;
    }

    public static int remainderOfDivision(int a, int b) {
        return a % b;
    }

    public static int intIncrement (int a) {
        return ++a;
    }

    public static int intDecrement(int a) {
        return --a;
    }

    public static boolean compareInt(int a, int b) {
        return a > b;
    }

    public static double sumIntDouble(int a, double b) {
        return a + b;
    }

    public static double subtractIntDouble(int a, double b) {
        return a - b;
    }

    public static double multiplyIntDouble(int a, double b) {
        return a * b;
    }

    public static double divideIntDouble(int a, double b) {
        return a / b;
    }

    public static boolean compareIntDouble(int a, double b) {
        return a > b;
    }

    public static String getState(String state) {

        if (state != null && state.equals("Done")) {
            return "Done";
        } else if (state != null && state.equals("In Progress")) {
            return "In Progress";
        } else {
            return "Open";
        }
    }

    public static String getSoftwareTestingType(String type) {
        switch (type) {
            case "Functional Testing":
                System.out.println("Functional testing is selected");
                break;
            case "Regression Testing":
                System.out.println("Regression Testing is selected");
                break;
            case "Usability Testing":
                System.out.println("Usability Testing is selected");
                break;
            default:
                System.out.println("Smoke Testing is selected");
                break;
        }
        return type;
    }
}
