<template>
  <main>
    <div class="main-title">
      <p>免费的在线文件格式转换工具</p>
    </div>
    <section>
      <div class="functional-module">
        <img src="../assets/icon/convert-pdf-to-word.png" alt="convert pdf to word">
        <h3 @click="fileConverter('PDFToWord')">PDF转Word</h3>
        <p>将PDF文件转换成可编辑的Word文档（DOC，DOCX）</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-pdf-to-excel.png" alt="convert pdf to excel">
        <h3 @click="fileConverter('PDFToExcel')">PDF转Excel</h3>
        <p>将PDF文件转换成可编辑的Excel电子表格（XLS，XLSX）</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-pdf-to-ppt.png" alt="convert pdf to ppt">
        <h3 @click="fileConverter('PDFToPPT')">PDF转PPT</h3>
        <p>将PDF转换成可编辑的PowerPoint演示文稿（PPT，PPTX）</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-pdf-to-jpg.png" alt="convert pdf to jpg">
        <h3 @click="fileConverter('PDFToImage')">PDF转图片</h3>
        <p>从PDF提取图片或将每个页面另存为单独的图片</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-word-to-pdf.png" alt="convert word to pdf">
        <h3 @click="fileConverter('WordToPDF')">Word转PDF</h3>
        <p>将Microsoft Word文档格式转换成PDF文件格式</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-excel-to-pdf.png" alt="convert excel to pdf">
        <h3 @click="fileConverter('ExcelToPDF')">Excel转PDF</h3>
        <p>将Microsoft Excel电子表格转换成PDF文档格式</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-ppt-to-pdf.png" alt="convert ppt to pdf">
        <h3 @click="fileConverter('PPTToPDF')">PPT转PDF</h3>
        <p>将Microsoft PowerPoint演示文稿转换成PDF文档格式</p>
      </div>
      <div class="functional-module">
        <img src="../assets/icon/convert-jpg-to-pdf.png" alt="convert jpg to pdf">
        <h3 @click="fileConverter('ImageToPDF')">图片转PDF</h3>
        <p>将JPG，PNG，BMP，GIF和TIFF图片转换成PDF文件格式</p>
      </div>
    </section>
  </main>
</template>

<script>
export default {
  name: "Home-Main",
  methods:{
    fileConverter(type){
      this.$router.push("/file-Converter/"+type)
    }
  }

}
</script>

<style scoped>
main {
  min-width: 1170px;
  background: #f6f6f6;
}

.main-title p {
  font-family: "Microsoft YaHei UI", serif;
  font-weight: 500;
  font-size: 30px;
  text-align: center;
  margin: 0;
  padding: 30px 0;
}

section {
  width: 1170px;
  margin: 0 auto;
  padding-bottom: 40px;
}

.functional-module {
  width: 280px;
  height: 190px;
  background: #ffffff none repeat scroll 0 0;;
  display: inline-block;
  margin: 5px 5px;
  padding-top: 30px;
  border-radius: 10px;
}

.functional-module img {
  display: block;
  width: 50px;
  height: 50px;
  margin: 0 auto;
}

.functional-module h3 {
  text-align: center;
}
.functional-module h3:hover{
  color: #007bff;
  cursor: pointer;
}
.functional-module p {
  width: 250px;
  margin: 0 auto;
  font-family: "Microsoft YaHei UI", serif;
  color: #666666;
  font-size: 15px;
  text-align: center;
}

.functional-module:hover {
  -moz-box-shadow: 1px 1px 10px #909090;
  -webkit-box-shadow: 1px 1px 10px #909090;
  box-shadow: 1px 1px 10px #bbbbbb;

}
</style>