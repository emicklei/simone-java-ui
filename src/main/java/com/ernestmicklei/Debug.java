package com.ernestmicklei;

public class Debug {
    static boolean enabled;

    public static void log(Object ...args) {
        StringBuilder b = new StringBuilder();
        b.append("DEBUG ");
        for(int i=0;i<args.length;i++) {
            b.append(args[i]);
            b.append(' ');
        }
        System.out.println(b.toString());
    }
}
