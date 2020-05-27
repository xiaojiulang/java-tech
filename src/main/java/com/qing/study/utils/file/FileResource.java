package com.qing.study.utils.file;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * jar包内resource资源文件相关操作
 */
public class FileResource {

    private static Logger logger = Logger.getLogger(FileResource.class);

    /**
     * 获取jar包内的资源文件
     * @param filePathInProject
     *      e.g; reource/conf/aaa.json
     *      /分割
     *      起始位置不用/
     * @return
     * @throws Exception
     */
    public static String getFullContentInJar(String filePathInProject) throws Exception {
        return getFullContentInJar(filePathInProject, false);
    }

    /**
     * 获取jar包内的资源文件
     * @param filePathInProject
     *      e.g; reource/conf/aaa.json
     *      /分割
     *      起始位置不用/
     * @param isIgnoreNotes
     *      是否忽略注释
     * @return
     * @throws Exception
     */
    public static String getFullContentInJar(String filePathInProject, boolean isIgnoreNotes) throws Exception {
        logger.info("开始获取内部配置: "+filePathInProject);
        InputStream resource = FileResource.class.getResourceAsStream(filePathInProject);
        BufferedReader read = new BufferedReader(new InputStreamReader(resource));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = read.readLine()) != null) {
            if (isIgnoreNotes) {
                int nodesIndex = s.indexOf("//");
                if (nodesIndex == -1) {
                    sb.append(s);
                }
                else {
                    sb.append(s.substring(0, nodesIndex));
                }
            }
            else {
                sb.append(s);
            }
        }
        String result = sb.toString();
        logger.info("获取内部配置成功: " + result);
        return result;
    }
}
