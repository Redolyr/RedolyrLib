package RedolyrLibrary.test;

/**
 * Created by redolyr on 2015/02/12.
 */
public class NodeCharacter extends NodeObject<Character> {

    public NodeCharacter(char par1) {
        super(Character.class, new Character(par1), 9, ((Character) par1).charValue());
    }
}
