package RedolyrLibrary.blender;

/**
 * Created by redolyr on 2015/02/28.
 */
public enum BoxType {

    PLANE(1),
    CUBE(1),
    CIRCLE(1),
    UV_SPHERE(1),
    ICO_SPHERE(1),
    CYLINDER(1),
    CONE(1),
    TORUS(1),
    GRID(2),
    MONKEY(2);

    public final int objectType;

    private BoxType(int objectType) {
        this.objectType = objectType;
    }

    public String getType() {
        switch (this.objectType) {
            case 1: return "Primitive";
            case 2: return "Special";
            default: return "Unknown";
        }
    }

    public String toString() {
        return String.format("{'boxType':'%s'}", this.getType()).replace('\'', '"');
    }
}
