import javax.swing.*;

public class PracticeDialouge {

    public static class Dialouge{
        public void show(){
            String name = JOptionPane.showInputDialog("Enter name");
            String message = String.format("Hey its %s!", name);
            JOptionPane.showMessageDialog(null, message);
        }

    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hey");
        PracticeDialouge.Dialouge d = new Dialouge();
        d.show();

    }

}
