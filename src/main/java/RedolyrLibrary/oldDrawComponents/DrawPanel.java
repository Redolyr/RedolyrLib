package RedolyrLibrary.oldDrawComponents;

import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends Panel {
    private final int id;
    private List<Component> list = new ArrayList<Component>();

    public DrawPanel(int id) {
        this.id = id;
    }

    public Component add(Component component) {
        return component;
    }

    public List<Component> getComponentList() {
        List<Component> component = new ArrayList<Component>();
        for (Component components : list) component.add(components);
        return component;
    }

    public int getId() {
        return id;
    }
}
