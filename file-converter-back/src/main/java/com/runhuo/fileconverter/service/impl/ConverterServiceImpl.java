package com.runhuo.fileconverter.service.impl;

import com.runhuo.fileconverter.service.ConverterService;
import com.runhuo.fileconverter.utils.PdfToExcelUtils;
import com.runhuo.fileconverter.utils.PdfToImageUtils;
import com.runhuo.fileconverter.utils.PdfToPptUtils;
import com.runhuo.fileconverter.utils.PdfToWordUtils;
import com.runhuo.fileconverter.vo.Result;
import com.spire.pdf.FileFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/3 14:20
 */
@Service
public class ConverterServiceImpl implements ConverterService {


    @Autowired
    private PdfToWordUtils pdfToWordUtils;

    @Autowired
    private PdfToPptUtils pdfToPptUtils;

    @Autowired
    private PdfToExcelUtils pdfToExcelUtils;

    @Autowired
    private PdfToImageUtils pdfToImageUtils;


    @Override
    public Result pdfToWord(MultipartFile file, HttpServletResponse response) throws Exception {
        List<String> docxList = pdfToWordUtils.fileConverter(file, com.spire.pdf.FileFormat.DOCX, "docx");
        String downloadLink = null;
        if (docxList.size() == 1) {
            downloadLink = docxList.get(0);
        } else {
            downloadLink = pdfToWordUtils.merger(docxList, "docx");
        }
        return Result.success(downloadLink);
    }

    @Override
    public Result pdfToPpt(MultipartFile file, HttpServletResponse response) throws Exception {
        List<String> pdfList = pdfToPptUtils.fileConverter(file, FileFormat.PDF, "pdf");
        String downloadLink = null;
        if (pdfList.size() == 1) {
            downloadLink = pdfList.get(0);
        } else {
            downloadLink = pdfToPptUtils.merger(pdfList, "pptx");
        }
        return Result.success(downloadLink);
    }

    @Override
    public Result pdfToExcel(MultipartFile file, HttpServletResponse response) throws Exception {
        List<String> docxList = pdfToExcelUtils.fileConverter(file, FileFormat.XLSX, "xlsx");
        String downloadLink = null;
        if (docxList.size() == 1) {
            downloadLink = docxList.get(0);
        } else {
            downloadLink = pdfToExcelUtils.merger(docxList, "xlsx");
        }
        return Result.success(downloadLink);
    }

    @Override
    public Result pdfToImage(MultipartFile file, HttpServletResponse response) throws Exception {
//        List<String> docxList = pdfToImageUtils.fileConverter(file, FileFormat., "xlsx");
//        String downloadLink = null;
//        if (docxList.size() == 1) {
//            downloadLink = docxList.get(0);
//        } else {
//            downloadLink = pdfToImageUtils.merger(docxList, "xlsx");
//        }
        return Result.success(null);
    }

}
