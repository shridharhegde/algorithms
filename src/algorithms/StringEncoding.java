package algorithms;

public class StringEncoding {

	public static void main(String[] args) {
		System.out.println(decodeString(3, "Mnes_ya____mi"));

	}
	
	public static String decodeString(int numberOfRows, String encodedString) {
        int lenght, rowlen, extra, extra_dupl, i,j;
        int [] arr = new int[numberOfRows];
        lenght = encodedString.length();
        lenght = lenght-numberOfRows*(numberOfRows-1)/2;
        rowlen = lenght/numberOfRows;
        extra = lenght%numberOfRows;
        extra_dupl = extra;
        arr[0] = 0;
        for (i = 1; i< numberOfRows; i++) {
            arr[i] = arr[i-1] + rowlen + i;
            if(extra > 0) {
                arr[i] += 1;
                extra -= 1;
            }
        }
        String result = "";
        for (i =0 ; i< rowlen; i++) {
            for (j = 0; j < numberOfRows; j++) {
                result = result + encodedString.charAt(arr[j]);
                arr[j] += 1;
            }
        }
        i = 0;
        while (extra_dupl > 0) {
            result = result + encodedString.charAt(arr[i]);
            extra_dupl -= 1;
            i+=1;    
        }
        System.out.println(result);
        for(i =0; i<lenght; i++) {
            if(result.charAt(i) == '_') {
                result = result.substring(0, i) + ' ' + result.substring(i + 1);
            }
        }
        return result;
    }

}

