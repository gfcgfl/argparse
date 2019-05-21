package com.gfc.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: top
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 19:47
 **/
public class top {
    public static void main(String[] args) {
        ArgParser parser = null;
        try {
            parser = new ArgParser("E:\\Pro\\JAVA\\argparser\\src\\main\\resources\\config.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cmdline = null;
            while(true){

                System.out.println("input cmd line:");

                cmdline = br.readLine();

                try {
                    parser.parse(cmdline);

                    parser.output();
                    parser.reset();
                }catch (ArgNotAllowedException ee){

                }catch (NotStartWithException eee){

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
