public class MyArray{
    public static void main(String[] args){
        int[][] inputArray = {{1,2,5,8}, {11,5,7,10}, {111, 110, -5}};
        int inputValue = 11;
        System.out.println(findIndex(inputArray, inputValue));
    }
    /**
	 * Die Methode liefert den Index des zweidimensionalen Arrays, an dem inputValue steht.
	 * Im zweidimensionalen Array (Eingabe) kommt kein Wert doppelt vor.
	 * Wir der gesuchte Wert im zweidimensionalen Array nicht gefunden,
	 * so liefert die Methode einen leeren String.
	 * 
	 * @param inputArray Der zweidimensionale Array (Eingabe) mit int Werten
	 * @param inputValue Der int Wert nach dem gesucht wird
	 * @return String der Index an dem der gesuchte Wert steht (falls existent),
	 *         ein leerer String andernfalls. 
	 */
    static String findIndex(int[][] inputArray, int inputValue){
        for (int i = 0; i < inputArray.length; i++){
            for (int j = 0; j < inputArray[i].length; j++){
                if (inputArray[i][j] == inputValue){
                    return i + "x" + j;  
                }
            }    
        }
        return "";
    }
    

}