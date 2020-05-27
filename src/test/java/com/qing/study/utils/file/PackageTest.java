package com.qing.study.utils.file;

import java.util.List;

public class PackageTest {

    public static void main(String[] args) throws Exception {
        String packageName = "com.qing.study.utils";
        // List<String> classNames = getClassName(packageName);
        List<String> classNames = Package.getClassName(packageName);
        if (classNames != null) {
            for (String className : classNames) {
                System.out.println(className);
            }
        }
    }
}
