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

                if (numerate(data[0]) == numerate("idx")) {
                    index = Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("add")) {
                    int_con += Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("sub")) {
                    int_con -= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("mul")) {
                    int_con *= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("div")) {
                    int_con /= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("mod")) {
                    int_con %= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("cat")) {
                    str_con += data[1];
                }
                if (numerate(data[0]) == numerate("eql")) {
                    if (numerate(data[1]) == numerate("str")) {
                        if (str_con == str_cells[index]) {
                            bool_con = true;
                        }else{
                            bool_con = false;
                        }
                    }
                    if (numerate(data[1]) == numerate("int")) {
                        if (int_con == int_cells[index]) {
                            bool_con = true;
                        }else{
                            bool_con = false;
                        }
                    }
                }
                if (numerate(data[0]) == numerate("incIdx")) {
                    index += Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("decIdx")) {
                    index -= Integer.parseInt(data[1]);
                }
                if (numerate(data[0]) == numerate("set")) {
                    // System.out.println("set");
                    if (numerate(data[1]) == numerate("str")) {
                        // System.out.println("--str");
                        str_cells[index] = data[2];
                    }
                    if (numerate(data[1]) == numerate("int")) {
                        // System.out.println("--int");
                        int_cells[index] = Integer.parseInt(data[2]);
                    }
                }
                if (numerate(data[0]) == numerate("get")) {
                    // System.out.println("get");
                    if (numerate(data[1]) == numerate("str")) {
                        // System.out.println("--str");
                        str_con = str_cells[Integer.parseInt(data[2])];
                    }
                    if (numerate(data[1]) == numerate("int")) {
                        // System.out.println("--int");
                        int_con = int_cells[Integer.parseInt(data[2])];
                    }
                }
                if (numerate(data[0]) == numerate("print")) {
                    if (numerate(data[1]) == numerate("str")) {
                        System.out.println(str_con);
                    }
                    if (numerate(data[1]) == numerate("int")) {
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