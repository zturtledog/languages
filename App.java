import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String[] str_cells = new String[256];
        int[] int_cells = new int[256];

        int index = 0;

        String str_con = "";
        int int_con = 0;
        boolean bool_con = false;

        try {
            File myObj = new File("D:/javas/lang_in_30/equls/src/compFile/test"+".fast");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String[] data = assemble(myReader.nextLine().split(" ")).split(":");

                if (numerate(data[0]) == numerate("3110")) {
                    index = Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("2870")) {
                    int_con += Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("3221")) {
                    int_con -= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("3241")) {
                    int_con *= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("3099")) {
                    int_con /= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("3111")) {
                    int_con %= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("2985")) {
                    str_con += data[1];
                }
                if (numerate(data[0]) == numerate("3117")) {
                    if (numerate(data[1]) == numerate("3338")) {
                        if (str_con == str_cells[index]) {
                            bool_con = true;
                        }else{
                            bool_con = false;
                        }
                    }
                    if (numerate(data[1]) == numerate("3188")) {
                        if (int_con == int_cells[index]) {
                            bool_con = true;
                        }else{
                            bool_con = false;
                        }
                    }
                }
                if (numerate(data[0]) == numerate("6909")) {
                    index += Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("6760")) {
                    index -= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("3189")) {
                    // System.out.println("set");
                    if (numerate(data[1]) == numerate("3338")) {
                        // System.out.println("--str");
                        str_cells[index] = data[2];
                    }
                    if (numerate(data[1]) == numerate("3188")) {
                        // System.out.println("--int");
                        int_cells[index] = Integer.parseInt(data[2]);
                    }
                }
                if (numerate(data[0]) == numerate("3069")) {
                    // System.out.println("get");
                    if (numerate(data[1]) == numerate("3338")) {
                        // System.out.println("--str");
                        str_con = str_cells[Integer.parseInt(data[2])];
                    }
                    if (numerate(data[1]) == numerate("3188")) {
                        // System.out.println("--int");
                        int_con = int_cells[Integer.parseInt(data[2])];
                    }
                }
                if (numerate(data[0]) == numerate("5828")) {
                    if (numerate(data[1]) == numerate("3338")) {
                        System.out.println(str_con);
                    }
                    if (numerate(data[1]) == numerate("3188")) {
                        System.out.println(int_con);
                    }
                }
            }
            myReader.close();
        } catch (Exception e) {
            printEndArray(int_cells,str_cells);
            System.out.println("\n\n "+index+"|"+int_cells[index]+"|"+int_con+" \n\n");
            e.printStackTrace();
        }
    }

    public static int numerate(String in) {
        int end = 0;
        for (int i = 0; i < in.length(); i++) {
            end+=in.charAt(i)*(10^i);
        }
        return(end);
    }

    public static String assemble(String[] strings)
    {
        String end = "";

        for (String string : strings) {
            end+=string;
        }

        return(end);
    }

    static void printEndArray(int[] in,String[] st)
    {
        String end = "[";
        for (int i = 0; i < in.length; i++) {
            end+=in[i]+",";
        }
        end+="]\n\n[";
        for (int i = 0; i < in.length; i++) {
            end+=st[i]+",";
        }
        System.out.println(end+"]");
    }
}


/*

idx    : cellId
add    : null
sub    : null
mul    : null
div    : null
mod    : null
cat    : null
eql    : type
incIdx : amt
decIdx : amt
set    : type value
get
print

*/
