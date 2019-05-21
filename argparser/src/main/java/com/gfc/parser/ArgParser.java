package com.gfc.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ArgParser
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 19:47
 **/
public class ArgParser implements Parser {
    private Map<String, ArgInfo> map = new HashMap<>();
    private String configPath;

    public ArgParser(String configPath) throws IOException {
        this.configPath = configPath;
        //创建ArgParser时初始化map（）默认配置
        BufferedReader br = new BufferedReader(new FileReader(configPath));
        String line;
        br.readLine(); //忽略第一行
        while((line = br.readLine()) != null){
            String[] s = line.split(" ");
            String type = s[1]; String argname = s[0];
            if("Boolean".equals(type)){
                this.map.put(argname, new ArgInfo<>(false, type, s[2]));
            }else if("Integer".equals(type)){
                this.map.put(argname, new ArgInfo<>(0, type, s[2]));
            }else if("String".equals(type)){
                this.map.put(argname, new ArgInfo<>("", type, s[2]));
            }else{  //针对list
                this.map.put(argname, new ArgInfo<>(null, type, s[2]));
            }
        }
    }

    @Override
    public void parse(String cmd) throws ArgNotAllowedException, NotStartWithException {
        if(cmd == null){
            return;
        }
        String[] s = cmd.split(" ");
        int i = 0;
        while (i < s.length){

            String arg = s[i];
            if(arg.startsWith("-")) {
                if (this.map.containsKey(arg)) {
                    String type = this.map.get(arg).getType();
                    if ("Boolean".equals(type)) {
                        this.map.get(arg).setValue(true);
                        i++;
                    } else if ("IntegerList".equals(type)) {

                        String[] listEle = s[i + 1].split(",");  //这里默认list用,隔开
                        Integer[] integers = new Integer[listEle.length];
                        for (int j = 0; j < listEle.length; j++) {
                            integers[j] = Integer.parseInt(listEle[j]);

                        }
                        this.map.get(arg).setValue(Arrays.asList(integers));
                        i = i + 2;
                    } else if ("StringList".equals(type)) {
                        String[] listEle = s[i + 1].split(",");  //这里默认list用,隔开

                        this.map.get(arg).setValue(Arrays.asList(listEle));
                        i = i + 2;
                    } else {  //针对string和int
                        this.map.get(arg).setValue(s[i + 1]);
                        i = i + 2;
                    }
                } else {
                    throw new ArgNotAllowedException(arg);
                }
            }else{

                throw new NotStartWithException(arg);
            }


        }
    }

    @Override
    public ArgInfo getArg(String arg) {
        return this.map.get(arg);
    }

    public void output() {
        for (String s : map.keySet()) {
            System.out.println(s + " :" + this.map.get(s).getValue());
        }

    }

    public void reset() {
        for (String key : map.keySet()) {
            ArgInfo argInfo = this.map.get(key);
            String type = argInfo.getType();
            if("Boolean".equals(type)){
                argInfo.setValue(false);
            }else if("StringList".equals(type) || "IntegerList".equals(type)){
                argInfo.setValue(null);
            }else if("Integer".equals(type)){
                argInfo.setValue(0);
            }else{
                argInfo.setValue("");
            }
        }
    }
}
