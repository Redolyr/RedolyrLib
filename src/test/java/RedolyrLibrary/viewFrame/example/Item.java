package RedolyrLibrary.viewFrame.example;

import RedolyrLibrary.viewFrame.Texture;

import java.util.List;

/**
 * Created by redolyr on 2015/02/09.
 */
public class Item {

    public static final Item[] items = new Item[32000];

    public static final Item item = new Item(1);

    public final int itemID;

    public Item(int itemID) {

        if (this.items[itemID] != null) {
            throw new IllegalArgumentException("Item has from itemID: " + itemID);
        }

        this.items[this.itemID = itemID] = this;
    }

    public Texture bindTexture() {

//        BufferedImage bufferedImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB_PRE);
//        Graphics2D graphics2D = bufferedImage.createGraphics();
//        if (this.itemID == 1) {
//            graphics2D.setColor(new Color(255, 255, 255));
//            graphics2D.fillRect(0, 0, 32, 32);
//            graphics2D.drawString("Test", 16, 16);
//        }
//        try {
//            return TextureManager.getTexture(bufferedImage);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public void addInformation(Item item, List list) {
        list.add("Test");
    }
}
