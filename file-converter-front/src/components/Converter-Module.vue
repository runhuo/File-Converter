<template>
  <main>
    <div id="converter-container">
      <div class="module-title">
        <a @click="toHomePage">返回首页</a>
        <h2>在线{{ prefix }}转{{ suffix }}免费的转换器工具</h2>
        <p class="description">免费的、完美的{{
            prefix
          }}转换成{{ suffix }}文档工具，每台设备限用5次，如果您登录，则可以无限使用。</p>
      </div>
      <div class="converter">
        <div class="converter-result">
          <div class="load" v-show="isDownload">
            <video autoplay loop width="200" height="200">
              <source type="video/mp4" src="../assets/video/loading.mp4">
            </video>
            <p>文件正在转换中，请等待！</p>
          </div>
          <div class="download" v-show="isSuccess">
            <p>文件转换成功，请下载！</p>
            <a @click="download">下载</a>
          </div>
          <div class="submit" v-show="!isSubmit">
            <input type="button" value="提交" @click="submit">
          </div>
        </div>
        <div class="converter-upload">
          <input type="text" class="filename" v-model="fileName" placeholder="请选择文件！" disabled>
          <input type="button" value="选择..." class="file-check-btn" @click="checkFile">
          <input type="file" style="display: none" id="file" @input="selectCondition" :accept="fileType">
        </div>
      </div>
    </div>
  </main>
</template>

<script>

export default {
  name: "Converter-Module",
  data() {
    return {
      type: '',
      fileType: '',
      prefix: '',
      suffix: '',
      file: '',
      fileName: '',
      isClick: false,

      isSuccess: false,
      isSubmit: false,
      isDownload: false,


      fileLink: ''
    }
  },
  mounted() {
    this.type = this.$route.params.type;
    const temp = this.type;
    this.prefix = temp.split("To")[0];
    this.suffix = temp.split("To")[1];
    document.documentElement.scrollTop = 0;
    if (this.prefix === "PDF") {
      console.log("你好")
      this.fileType = "application/pdf";
    }
    //设置文件上传类型
    if (this.prefix === "Excel") {
      this.fileType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel";
    }
    if (this.prefix === "Word") {
      this.fileType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/msword";
    }
    if (this.prefix === "PPT") {
      this.fileType = "application/vnd.ms-powerpoint,application/vnd.openxmlformats-officedocument.presentationml.presentation"
    }
    if (this.prefix === "Image") {
      this.fileType = "image/png,image/jpeg"
    }


  },
  methods: {
    //返回到主页
    toHomePage() {
      this.$router.push("/");
    },
    //选择文件
    checkFile() {
      this.file = '';
      document.getElementById("file").click();
    },
    //获取文件，监听input标签的内容变化从而触发
    selectCondition(event) {
      this.file = event.target.files[0];
      this.fileName = event.target.files[0].name;
      this.isSubmit = false;
      this.isDownload = false;
      this.isSuccess = false;
    },
    submit() {
      const suffix = this.fileName.split(".")[1];
      if (this.file === '') {
        this.$message.error("请选择文件");
      }   //判断文件上传类型
      else if (this.prefix === "PDF") {
        if (suffix!=="pdf") {
          this.$message.error("请选择后缀为pdf的文件！");
        }
      }
      else if (this.prefix === "Word") {
        if (suffix!=="dot"&&suffix!=="doc"&&suffix!=="docx") {
          this.$message.error("请选择后缀为doc或docx的文件！");
        }
      }
      else if (this.prefix === "Excel") {
        if (suffix!=="xls"&&suffix!=="xlsx") {
          this.$message.error("请选择后缀为doc或docx的文件！");
        }
      }
      else if (this.prefix === "PPT") {
        if (suffix!=="ppt"&&suffix!=="pptx") {
          this.$message.error("请选择后缀为ppt或pptx的文件！");
        }
      }
      else if (this.prefix === "Image") {
        if (suffix!=="png"&&suffix!=="jpg"&&suffix!=="jpeg") {
          this.$message.error("请选择后缀为png或jpg的图片！");
        }
      }
      else {
        this.isSubmit = true;
        //直接上传文件会报错，需要封装的表单上传
        const fileData = new FormData();
        fileData.append('file', this.file);
        this.isSubmit = true;
        this.isDownload = true;
        this.isSuccess = false;
        this.$http.post('/converter/' + this.type, fileData).then(res => {
          console.log(res)
          this.fileLink = res.data.data;
          this.isSubmit = true;
          this.isDownload = false;
          this.isSuccess = true;
        })
      }
    },
    download() {
      this.$http.get("/file/download?address=" + this.fileLink, {responseType: 'blob'}).then(res => {
        const blob = res.data;
        const reader = new FileReader();
        reader.readAsDataURL(blob);
        reader.onload = (e) => {
          const a = document.createElement("a");
          a.download = this.fileLink.substring(25);
          a.href = e.target.result;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
        };
      });
    }
  }
}
</script>

<style scoped>
main {
  padding-top: 80px;
  background: #f6f6f6;
  border-bottom: solid 1px #eeeeee;
  min-width: 1170px;
}

#converter-container {
  width: 1170px;
  height: 561px;
  margin: 20px auto;
  background: #ffffff;
border-radius: 5px;
}

.module-title {
  padding: 30px 0;
}

.module-title a {
  text-decoration: none;
  color: #666666;
  font-family: "Microsoft YaHei UI", serif;
  font-size: 15px;
  padding-left: 20px;
}

.module-title a:hover {
  color: #007bff;
  cursor: pointer;
}

.module-title h2 {
  font-family: "Microsoft YaHei UI", serif;
  text-align: center;
}

.description {
  font-family: "Microsoft YaHei UI", serif;
  font-size: 14px;
  text-align: center;
  color: #666666;
  margin-bottom: 0;
}

.converter-result {
  position: relative;
  width: 800px;
  height: 300px;
  margin: 20px auto;
  border: solid 5px #75BCFA;
  border-radius: 10px;
}

.load {
  position: absolute;
  width: 200px;
  height: 300px;
  left: 0;
  right: 0;
  margin: auto;
  top: 5%;
}

.load p, .download p {
  font-family: "Microsoft YaHei UI", serif;
  font-size: 14px;
  text-align: center;
  color: #666666;
  margin: 0;
}

.download, .submit {
  position: absolute;
  width: 200px;
  height: 40px;
  left: 0;
  right: 0;
  margin: auto;
  top: 40%;
}

.submit input {
  width: 200px;
  height: 40px;
  font-size: 18px;
  font-family: "Microsoft YaHei UI", serif;
  background: #007bff;
  border: solid 1px #007bff;
  color: #ffffff;
  letter-spacing: 1px;
  border-radius: 8px;
  margin-top: 30px;
}

.download a {
  display: block;
  text-decoration: none;
  color: #ffffff;
  background: #007bff;
  margin-top: 40px;
  border-radius: 5px;
  text-align: center;
  padding: 7px 20px;
  border: solid 1px #007bff;
}

.download a:hover, .submit input:hover {
  background: #58A7FA;
  border: solid 1px #58A7FA;
  cursor: pointer;
}

.converter-upload {
  width: 800px;
  margin: 20px auto;
  padding-bottom: 30px;
}

.filename {
  width: 690px;
  height: 26px;
  border: solid 2px #eeeeee;
  outline: none;
  vertical-align: middle;
  border-radius: 3px;
}

.file-check-btn {
  width: 100px;
  height: 32px;
  font-family: "Microsoft YaHei UI", serif;

  background: #007bff;
  border: solid 2px #007bff;
  color: #ffffff;
  letter-spacing: 2px;
  font-size: 15px;
  vertical-align: middle;
  border-radius: 3px;
}

.file-check-btn:hover {
  background: #58A7FA;
  border: solid 2px #58A7FA;
  cursor: pointer;
}

</style>