package main;

public class RandomDatas {
    public static long getRandom(long min, long max) {
        long number = (long)(Math.random()*1000000000*100000000);
        return number;
    }
    public static String getNationalId() {
        return (long) (Math.random()*1000000000*100000000) + "";
    }

    public static String getMobileNo() {
        return "017" + (long) (Math.random()*1000000000);
    }

    public static String getZipCode() { return ""+(long) (Math.random()*10000);}

    public static void main(String[] args) {
        System.out.println((long)(Math.random()*1000000000*100000000));
    }

}
