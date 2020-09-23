package CookerCucumberMavenPlugin.FileGenFactory;

public class RandomNumberGenerator {

    /**
     * This method is used to get the random number between AA to ZZ & 0001 to 9999 (XX8888)
     * <h5> Author : Manjunath Prabhakar (manjunath189@gmail.com) </h5>
     *
     * @return : formatted random number
     */
    public static String genRandomNumber() {
        int minNum = 1, maxNum = 9999;
        int random = (int) (Math.random() * maxNum + minNum);
        String formattedRandomNum = String.format("%04d", random);

        final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int alpharandom1 = (int) (Math.random() * 25 + 0);
        int alpharandom2 = (int) (Math.random() * 25 + 0);
        String res = "" + ALPHA.charAt(alpharandom1) + ALPHA.charAt(alpharandom2) + formattedRandomNum;
        return res;
    }

}
