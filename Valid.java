public class Valid {
    public static boolean isNumber(String line){
        try{
            int x = Integer.parseInt(line);
            return true;
        }catch (NumberFormatException e){
            return false;
        }


    }
}
