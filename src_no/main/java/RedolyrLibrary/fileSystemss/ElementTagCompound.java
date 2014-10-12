package RedolyrLibrary.fileSystems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by redolyr on 2014/10/07.
 */
public class ElementTagCompound extends ElementBase
{
    private Map<String, ElementBase> root = new HashMap<String, ElementBase>();

    public ElementTagCompound() {}
    private ElementTagCompound(Map<String, ElementBase> root)
    {
        this.root = root;
    }

    public void read(ElementImport elementImport)
    {
        this.root.clear();
        String root;
        while ((root = elementImport.readString()) != null)
        {
            if (root == "null") break;
            System.out.println(root);
        }
    }

    public void write(ElementExport elementExport)
    {
        String line = System.getProperty("line.separator");
        Iterator<String> it = this.root.keySet().iterator();

        elementExport.writeString("{" + line);
        while (it.hasNext())
        {
            String key = it.next();
            ElementBase value = this.root.get(key);
            elementExport.writeString("id:");
            elementExport.writeByte(value.getId());

            elementExport.writeString("|");

            elementExport.writeString("key:");
            elementExport.writeString(key);

            elementExport.writeString("|");
            elementExport.writeString("value:");
            value.write(elementExport);
            elementExport.writeString(line);
        }
        elementExport.writeString("}" + line);
    }

    public byte getId()
    {
        return 1;
    }

    public ElementTagCompound copy()
    {
        Map<String, ElementBase> data = new HashMap<String, ElementBase>();
        Iterator<String> it = this.root.keySet().iterator();
        while (it.hasNext())
        {
            String key = it.next();
            ElementBase value = this.root.get(key);
            root.put(key, value);
        }
        return new ElementTagCompound(data);
    }

    public String toString()
    {
        return "ElementTagCompound{" +
                "root=" + root +
                '}';
    }

    public boolean hasKey(String key)
    {
        return this.root.containsKey(key);
    }

    public boolean hasKey(String key, int id)
    {
        ElementBase base = hasKey(key) ? this.root.get(key) : null;
        return base != null ? (base.getId() == id) : false;
    }

    public ElementBase getTag(String key)
    {
        return this.root.get(key);
    }

    public void setTag(String key, ElementBase value)
    {
        this.root.put(key, value);
    }
}
