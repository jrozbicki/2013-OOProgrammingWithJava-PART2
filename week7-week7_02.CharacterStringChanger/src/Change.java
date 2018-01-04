public class Change {
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter){
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String change(String characterString) {
        String changedString = characterString.replace(fromCharacter, toCharacter);
        return changedString;
    }

    public char getFromCharacter(){
        return fromCharacter;
    }

    public char getToCharacter(){
        return toCharacter;
    }

}
