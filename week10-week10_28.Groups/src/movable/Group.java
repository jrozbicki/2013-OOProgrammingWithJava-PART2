package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> listMovablesInGroup;

    public Group(){
        this.listMovablesInGroup = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable){
        listMovablesInGroup.add(movable);
    }

    public String toString(){
        String print = "";
        for (Movable each : listMovablesInGroup){
            print+=each;
            print+="\n";
        }
        return print;
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable each : listMovablesInGroup){
            each.move(dx, dy);
        }
    }
}
