import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

class fileClass{
    public String FileToString(String path) 
    throws IOException{
        FileInputStream filess = new FileInputStream(path);
        int data;
        char dataincr;
        String datainString = "";
        while(( data = filess.read())!= -1){
            dataincr = (char) data ;
            datainString += Character.toString(dataincr);
        }
        return datainString;
    }
    public byte[] convertToByteArrayWithPaddingInfo(String binaryString) {
        int length = binaryString.length();
        int paddingLength = (8 - length % 8) % 8; 
        String paddedBinaryString = "0".repeat(paddingLength) + binaryString; 

        byte[] byteArray = new byte[paddedBinaryString.length() / 8];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(paddedBinaryString.substring(i * 8, (i + 1) * 8), 2);
        }
    
        byte[] result = new byte[byteArray.length + 1];  
        result[0] = (byte) paddingLength; 
        System.arraycopy(byteArray, 0, result, 1, byteArray.length); 
    
        return result;
    }
    
    public  String recoverBinaryStringFromByteArray(byte[] byteArrayWithPaddingInfo) {
        int paddingLength = byteArrayWithPaddingInfo[0];
        byte[] byteArray = Arrays.copyOfRange(byteArrayWithPaddingInfo, 1, byteArrayWithPaddingInfo.length);

        StringBuilder binaryStringBuilder = new StringBuilder();
        for (byte b : byteArray) {
            String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            binaryStringBuilder.append(binaryString);
        }

        String recoveredBinaryString = binaryStringBuilder.toString();

        String finalBinaryString = recoveredBinaryString.substring(paddingLength);    
        return finalBinaryString;
    }
    
    
}