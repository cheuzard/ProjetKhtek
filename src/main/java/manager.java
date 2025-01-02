import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class manager{
    static int width = 800;
    static int height = 540;
    static DefaultListModel<property> listingModel = new DefaultListModel<>();
    static JList<property> Listing;
    static AtomicBoolean listingSold = new AtomicBoolean(false);
    static Manager manager = new Manager();
    public static void main(String[] args) {
        // Create the frame
        manager.addProperty("slimania","ouled fait",200);
        manager.addProperty("anisia","ouled fait",300);
        manager.addProperty("hachmia","ain benian",500);
        Listing = new JList<>(listingModel);
        listingModel.addAll(manager.getSellingList());
        JFrame mainFrame = createMainFrame();
        mainFrame.add(CreateListingPanel());
        mainFrame.add(createSecondaryPanel());
        mainFrame.setVisible(true);
    }

    private static JFrame createMainFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        return mainFrame;
    }

    static JPanel CreateListingPanel(){
          int maxWidth =  width/3;
          JPanel listingPanel = new JPanel();
          listingPanel.setLayout(new BoxLayout(listingPanel,BoxLayout.Y_AXIS));
          listingPanel.setBounds(0, 0, maxWidth, height);
          listingPanel.add(CreateTypeButton());
          listingPanel.add(Listing);
          listingPanel.setBackground(Color.red);
        return listingPanel;
    }
    static JButton CreateTypeButton(){
        JButton typeButton = new JButton("Type");
        typeButton.addActionListener(e -> toggleList());
        return typeButton;
    }

    private static void toggleList() {
        listingModel.removeAllElements();
        if(listingSold.compareAndSet(false, !listingSold.get())) {
            listingModel.addAll(manager.getSellingList());
        }
        else{
            listingModel.addAll(manager.getSoldList());
        }
    }
    static JPanel createSecondaryPanel(){
        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLayout(new BoxLayout(secondaryPanel,BoxLayout.Y_AXIS));
        secondaryPanel.setBounds(0, 0, width-(width/3), height);
        secondaryPanel.setBackground(Color.BLACK);
        return secondaryPanel;
    }
}
