package backjoon.others;

import java.io.FileReader;

public class fr {
    public static void main(String[] args) throws Exception {
        // .. -> 부모
        // . -> 현재

        FileReader fr = new FileReader("C:/apache-tomcat-8.0.20/webapps/thisisjava/src/FileReaderExample.java");

        int readCharNo;
        while ((readCharNo = fr.read()) != -1) {
            System.out.print((char)readCharNo);
        }
        fr.close();
    }
}
