package com.runhuo.fileconverter.utils;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfMargins;
import com.spire.pdf.widget.PdfPageCollection;
import com.spire.presentation.Presentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * created by IntelliJ IDEA 2022.2.2
 *
 * @author run huo
 * @date 2022/10/4 10:32
 */
@Component
public class PdfToPptUtils {

    @Value("${custom.filePath}")
    private String filePath;

    private List<String> files = new ArrayList<>();

    public List<String> fileConverter(MultipartFile file, FileFormat type, String fileType) throws IOException {
        //加载文件
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromBytes(file.getBytes());
        //切割文件
        PdfPageCollection pages = pdfDocument.getPages();
        //获取页数
        int count = pages.getCount();
        System.out.println(count);
        PdfDocument pdfDocument1 = new PdfDocument();
        PdfPageBase pageBase = null;
        String uri = UUID.randomUUID().toString();
        if (count > 3) {
            for (int i = 0; i < count; i++) {
                pageBase = pdfDocument1.getPages().add(pdfDocument.getPages().get(i).getSize(), new PdfMargins(0));
                pdfDocument.getPages().get(i).createTemplate().draw(pageBase, new Point2D.Float(0, 0));
                System.out.println(i + "---------->" + pdfDocument1.getPages().getCount());
                //每四页分一次
                if (pdfDocument1.getPages().getCount() == 3 || (i + 1) == count) {
                    pdfDocument1.saveToFile(filePath + uri + i + "." + fileType, type);
                    files.add(filePath + uri + i + "." + fileType);
                    pdfDocument1 = new PdfDocument();
                }
            }
        } else {
            //页数小于等于3页时直接转换
            String download = filePath + UUID.randomUUID() + ".pptx";
            FileOutputStream fileOutputStream = new FileOutputStream(download);
            Document document = new Document(file.getBytes());
            document.save(fileOutputStream, SaveFormat.Pptx);
            fileOutputStream.close();
            files.add(download);
        }
        return files;
    }

    public String merger(List<String> pdfList, String fileType) throws Exception {
        //将拆分的各个pdf依次转换为pptx，并且保存文件路径
        List<String> temp = new ArrayList<>();
        for (String link : pdfList) {
            String pptName = filePath + UUID.randomUUID() + "." + fileType;
            FileOutputStream os = new FileOutputStream(pptName);
            Document document = new Document(link);
            document.save(os, SaveFormat.Pptx);
            os.close();
            temp.add(pptName);
        }
        //合并ppt
        String finalName=filePath+UUID.randomUUID()+"."+fileType;
        Presentation newPpt = new Presentation();
        newPpt.loadFromFile(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            Presentation presentation = new Presentation();
            presentation.loadFromFile(temp.get(i));
            for (int j = 0; j < presentation.getSlides().getCount(); j++) {
                newPpt.getSlides().append(presentation.getSlides().get(j));
            }
        }
        newPpt.saveToFile(finalName, com.spire.presentation.FileFormat.PPTX_2016);
        return finalName;
    }
}
