package CookerCucumberMavenPlugin.FileGenFactory;

public class RandomNumberGenerator {

    /**
     * @return : formatted random number
     * name : genRandomNumber
     * desc : This method is used to get the random number between 0001 and 5000
     * author : Manjunath Prabhakar
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
