package com.runhuo.fileconverter.service;

import com.runhuo.fileconverter.vo.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/3 14:19
 */
public interface ConverterService {
    Result pdfToWord(MultipartFile file, HttpServletResponse response) throws Exception;
    Result pdfToPpt(MultipartFile file, HttpServletResponse response) throws Exception;
    Result pdfToExcel(MultipartFile file, HttpServletResponse response) throws Exception;
    Result pdfToImage(MultipartFile file, HttpServletResponse response) throws Exception;
}

