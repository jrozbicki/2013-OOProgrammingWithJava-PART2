package dungeon;

import java.util.*;

public class Dungeon {
    private Scanner reader;
    private int lenght;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private String[][] field;
    private Player player;
    private Vampire vampire;
    private char[] userMovesInput;
    private List<Vampire> squad;

    public Dungeon(int lenght, int height, int vampires, int moves, boolean vampiresMove) {
        this.reader = new Scanner(System.in);
        this.lenght = lenght;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.field = new String[lenght][height];
        this.player = new Player(lenght, height);
        this.squad = new ArrayList<Vampire>();
        this.vampire = new Vampire(lenght,height,vampiresMove,squad,field);

    }


    public void createField() {
        addToSquad(vampires);
        for (int y = 0; y <this.height; y++) {
            //System.out.println();
            for (int x = 0; x <this.lenght; x++){
                field[x][y] = ".";
            }
        }
    }

    public void addToSquad(int vampires){
        int vampireCounter = vampires;
        while (vampireCounter>0) {
            squad.add(new Vampire(lenght,height,vampiresMove,squad,field));
            vampireCounter--;
        }
    }

    public boolean ifWin(){
        if(squad.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void ifVampireIsDead() {
        List<Vampire> copySquad = new ArrayList<Vampire>();
        for (Vampire each : squad) {
            copySquad.add(each);
        }
        for (Vampire each2 : copySquad) {
            if (player.getX() == each2.getX() && player.getY() == each2.getY()) {
                copySquad.remove(each2);
                field[each2.getX()][each2.getY()]= ".";
                break;
            }
        }
        this.squad = new ArrayList<Vampire>();
        for (Vampire each3 : copySquad){
            this.squad.add(each3);
        }
    }

    public void playerMove(){
        field[player.getX()][player.getY()] = ".";
        for (char each : userMovesInput){
            player.move(each);
        }
    }

    public void vampireStep(int howMany){
        for (Vampire each : squad) {
            field[each.getX()][each.getY()] = ".";
            for (int i = 0; i < howMany; i++) {
                each.move(each.randomMove());
            }
        }
    }

    public void printField() {
        System.out.println(this.moves);
        System.out.println();
        System.out.println(player.printPosition());
        for (Vampire each : squad) {
            System.out.println(each.printPosition());
            field[each.getX()][each.getY()] = "v";
        }
        field[player.getX()][player.getY()] = "@";


        for (int y = 0; y < this.height; y++) {
            System.out.println();
            for (int x = 0; x < this.lenght; x++) {
                System.out.print(field[x][y]);
            }
        }
        System.out.println();
        System.out.println();
    }

    public void run() {
        createField();
        printField();
        while (this.moves>=0){
            String userInput = this.reader.nextLine();
            userMovesInput = userInput.toCharArray();
            vampire.vampireStepCounter(userMovesInput);
            playerMove();
            ifVampireIsDead();
            if(ifWin()){
                System.out.println("YOU WIN");
                break;
            }
            vampireStep(vampire.vampireStepCounter(userMovesInput));
            this.moves--;
            printField();
            if(this.moves==0){
                System.out.println("YOU LOSE");
                break;
            }
        }
    }
}
