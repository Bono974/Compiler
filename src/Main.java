import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Main {

        /**
         * @param args
         */
        public static void main(String[] args) {
                try {
                        FileReader  myFile = new FileReader(args[0]);
                        CompilerLexer myLex = new CompilerLexer(myFile);
                        CompilerParser myParser = new CompilerParser(myLex);
                        try {
                                Symbol result=myParser.parse();
                        }
                        catch (Exception e) {
                                System.out.println("parse error");
                                e.printStackTrace(System.out);
                        }
                }
                catch (Exception e){
                        System.out.println("invalid file");
                }
        }
}
