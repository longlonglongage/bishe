package com.ming.hospital.web;

import cn.hutool.core.util.IdUtil;
import com.ming.hospital.model.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 文件上传接口
 *
 * @author Haotian
 * @version 1.0.0
 * @date 2020/5/4 22:37
 */
@RestController
public class FileUploadController {
    /**
     * 文件上传
     *
     * @param imgFile 文件
     * @param session 对象
     * @return 上传提示
     * @throws IOException 文件异常
     */
    @RequestMapping("/upload")
    public Result<Object> upload(MultipartFile imgFile, HttpSession session) throws IOException {
        if (imgFile.isEmpty()) {
            return Result.error( "上传失败，请选择文件" );
        }
        // 获取原始文件名
        String originalFilename = imgFile.getOriginalFilename();
        // 拆分字符串获取文件后缀
        String type = Objects.requireNonNull( originalFilename ).substring( originalFilename.lastIndexOf( "." ) );
        // 创建UUID.文件类型新文件名防止覆盖 类似于：b17f24ff026d40949c85a24f4f375d42.jpg
        String filename = IdUtil.simpleUUID() + type;
        // 获取上传路径
        String uploadPath = session.getServletContext().getRealPath( "images" );
        // 上传文件
        File file = new File( uploadPath, filename );
        imgFile.transferTo( file );
        return Result.ok( filename, "上传成功" );
    }
}