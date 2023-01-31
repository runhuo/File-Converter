package com.runhuo.fileconverter.controller;

import com.runhuo.fileconverter.service.ConverterService;
import com.runhuo.fileconverter.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/3 14:18
 */
@RestController
@RequestMapping("converter")
public class ConverterController {
    @Autowired
    private ConverterService converterService;

    /**
     * pdf转word
     *
     * @param file
     * @param response
     * @return
     * @throws IOException
     */
    @PostMapping("/PDFToWord")
    public Result pdfToWord(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        return converterService.pdfToWord(file, response);
    }

    /**
     * pdf转ppt
     * @param file
     * @param response
     * @return
     * @throws Exception
     */

    @PostMapping("/PDFToPPT")
    public Result pdfToPpt(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws Exception {
        return converterService.pdfToPpt(file,response);
    }

    /**
     * pdf转excel
     * @param file
     * @param response
     * @return
     * @throws Exception
     */
    @PostMapping("/PDFToExcel")
    public Result pdfToExcel(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        return converterService.pdfToExcel(file,response);
    }

    @PostMapping("PDFToImage")
    public Result pdfToImage(@RequestParam("file") MultipartFile file,HttpServletResponse response) throws Exception {
        return converterService.pdfToImage(file,response);
    }


}
