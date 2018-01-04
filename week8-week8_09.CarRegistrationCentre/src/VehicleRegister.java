import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();

    public boolean add(RegistrationPlate plate, String owner){
        if (!owners.containsKey(plate)){
            owners.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }

    public String get(RegistrationPlate plate){
        if (owners.containsKey(plate)){
            return owners.get(plate);
        } else {
            return null;
        }
    }

    public boolean delete(RegistrationPlate plate){
        if(owners.containsKey(plate)){
            owners.remove(plate);
            return true;
        } else {
            return false;
        }
    }

    public void printRegistrationPlates(){
        for (RegistrationPlate each : owners.keySet()){
            System.out.println(each);
        }
    }

    public void printOwners() {
        ArrayList<String> listOfowners = new ArrayList<String>();
        for (RegistrationPlate eachPlate : this.owners.keySet()){
            if(!listOfowners.contains(this.owners.get(eachPlate)))
            listOfowners.add(this.owners.get(eachPlate));
        }
        for (String eachOwner : listOfowners){
            System.out.println(eachOwner);
        }
    }
}
