public class xmldocumentCreator {
    private String name;
    private int number;
    private boolean isCurrent;

    public String read(){
        System.out.println("Document read");
        return "Document read again";
    }

    public static void write(){
        System.out.println("Document written");
    }

    public static void add(int a, int b){
        int result = a + b;
        System.out.println("The sum is = " + result);
    }


    public static void main(String[] args) {
        xmldocumentCreator obj = new xmldocumentCreator();
        obj.read();
        xmldocumentCreator.write();
        xmldocumentCreator.add(5, 6);
    }

}