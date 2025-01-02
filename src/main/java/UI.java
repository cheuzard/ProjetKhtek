import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class UI{
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
        for(property property : manager.getSellingList()){
            listingModel.addElement(property);
        }
        JFrame mainFrame = createMainFrame();
        mainFrame.add(createSlit());
        mainFrame.setVisible(true);
    }

    private static JFrame createMainFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(width, height);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return mainFrame;
    }

    private static JSplitPane createSlit() {
        JSplitPane mainSplit = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                createListingPanel(),
                createSecondaryPanel()
        );
        mainSplit.setOneTouchExpandable(false);
//        mainSplit.setResizeWeight(0.33);
        mainSplit.setDividerLocation(.33);
        return mainSplit;
    }

    private static JPanel createListingPanel() {
        int maxWidth =  width/3;
        JPanel listingPanel = new JPanel();
        listingPanel.setLayout(new BorderLayout(5, 5));
        listingPanel.setSize(maxWidth, height);
        listingPanel.add(CreateTypeButton(), BorderLayout.NORTH);
        listingPanel.add(Listing, BorderLayout.CENTER);
        return listingPanel;
    }

    static JButton CreateTypeButton(){
        JButton typeButton = new JButton("pending");
        typeButton.addActionListener(e -> {
            listingSold.set(!listingSold.get());
            toggleList();
            typeButton.setText(!listingSold.get() ? "pending" : "sold");
        });
        return typeButton;
    }

    private static void toggleList() {
        listingModel.removeAllElements();
        if(listingSold.get()) {
            for(property property : manager.getSoldList()){
                listingModel.addElement(property);
            }
        }
        else{
            for(property property : manager.getSellingList()){
                listingModel.addElement(property);
            }
        }
    }
    static JPanel createSecondaryPanel(){
        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLayout(new BoxLayout(secondaryPanel,BoxLayout.Y_AXIS));
        secondaryPanel.setSize(width-(width/3), height);
        secondaryPanel.setBackground(Color.BLACK);
        return secondaryPanel;
    }
}
