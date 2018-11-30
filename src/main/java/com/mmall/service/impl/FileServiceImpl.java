package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 上传文件
     * @param file
     * @param path
     * @return 返回是 上传ftp服务器 的文件名字
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public String upload(MultipartFile file, String path) {

        String fileName = file.getOriginalFilename(); //获取文件 原始名称  例如：abc.jpg

        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);  //获取 文件名的后缀 例如：  jpg

        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;

        logger.info("开始上传文件，上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);  //打日志

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);  // 文件已经上传成功了

            FTPUtil.uploadFile(Lists.newArrayList(targetFile)); //将targetFile 上传到我们的FTP服务器上

            targetFile.delete();//上传完之后，删除upload下面的文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetFile.getName();
    }
}
