
public class Main {

    public static void main(String[] args) {
        int[] t = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder stringBuilder = new StringBuilder(t.length);
        int lines = 0;
        if(t.length%4!=0){
            lines = (t.length/4)+1;
        } else {
            lines = t.length/4;
        }
        //System.out.println(lines);
        int max;
        if(t.length<4){
            max = t.length;
        } else {
            max = 4;
        }
        int min = 0;
        for(int i=0; i<lines; i++){
            stringBuilder.append("\n");
            stringBuilder.append(" ");
            for(int a=min; a<max; a++){
                if(a!=max-1) {
                    stringBuilder.append(t[a]);
                    stringBuilder.append(", ");
                } else {
                    if(a!=t.length-1) {
                        stringBuilder.append(t[a]);
                        stringBuilder.append(",");
                    } else {
                        stringBuilder.append(t[a]);
                    }
                }
            }

            min=max;
            max=4+((i+1)*4);
            if(max<t.length){

            } else {
                max=t.length;
            }
        }
        return "{"+stringBuilder+"\n}";
    }
}
