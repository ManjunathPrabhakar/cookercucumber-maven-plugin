package CookerCucumberMavenPlugin.FileGenFactory;

public class RandomNumberGenerator {

    /**
     * @return : formatted random number
     * name : genRandomNumber
     * desc : This method is used to get the random number between 0001 and 5000
     * author : Manjunath Prabhakar
     */
    public static String genRandomNumber() {
        int minNum = 1, maxNum = 5000;
        int random = (int) (Math.random() * maxNum + minNum);
        String formattedRandomNum = String.format("%04d", random);

        final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int alpharandom = (int) (Math.random() * 25 + 0);
        String res = formattedRandomNum + ALPHA.charAt(alpharandom);
        return res;
    }

}
