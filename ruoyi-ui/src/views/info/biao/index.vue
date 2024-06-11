<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="pid" prop="pId">
        <el-input
          v-model="queryParams.pId"
          placeholder="请输入id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--<el-form-item label="图片地址" prop="imgAddress">-->
      <!--  <el-input-->
      <!--    v-model="queryParams.imgAddress"-->
      <!--    placeholder="请输入图片地址"-->
      <!--    clearable-->
      <!--    @keyup.enter.native="handleQuery"-->
      <!--  />-->
      <!--</el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['info:biao:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['info:biao:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['info:biao:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['info:biao:export']"
        >导出
        </el-button>
        <el-button
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['info:biao:export']"
        >导入
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>


    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="全部数据" name="first">    <el-table v-loading="loading" :data="biaoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column label="pid" align="center" prop="pId"/>
        <el-table-column label="患者id" align="center" prop="patientId"/>
        <el-table-column label="年龄" align="center" prop="age" width="50"/>
        <el-table-column label="性别" align="center" prop="gender" width="50" />
        <el-table-column label="图片地址" align="center" prop="imgAddress">
          <template v-slot:default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.imgAddress"
              :preview-src-list="[scope.row.imgAddress]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column label="上传时间" align="center" prop="createTime"/>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-view"
              @click="handleJump(scope.row)"
              v-hasPermi="['info:biao:lock']"
            >查看
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['info:biao:edit']"
            >修改
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['info:biao:remove']"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      </el-tab-pane>
      <el-tab-pane label="未标注" name="second">    <el-table v-loading="loading" :data="biaoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column label="pid" align="center" prop="pId"/>
        <el-table-column label="年龄" align="center" prop="age"/>
        <el-table-column label="性别" align="center" prop="gender"/>
        <el-table-column label="图片地址" align="center" prop="imgAddress">
          <template v-slot:default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.imgAddress"
              :preview-src-list="[scope.row.imgAddress]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column label="上传时间" align="center" prop="createTime"/>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-view"
              @click="handleJump(scope.row)"
              v-hasPermi="['info:biao:lock']"
            >查看
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['info:biao:edit']"
            >修改
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['info:biao:remove']"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      </el-tab-pane>
      <el-tab-pane label="已标注" name="third">    <el-table v-loading="loading" :data="biaoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column label="pid" align="center" prop="pId"/>
        <el-table-column label="年龄" align="center" prop="age"/>
        <el-table-column label="性别" align="center" prop="gender"/>
        <el-table-column label="图片地址" align="center" prop="imgAddress">
          <template v-slot:default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.imgAddress"
              :preview-src-list="[scope.row.imgAddress]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column label="上传时间" align="center" prop="createTime"/>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-view"
              @click="handleJump(scope.row)"
              v-hasPermi="['info:biao:lock']"
            >查看
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['info:biao:edit']"
            >修改
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['info:biao:remove']"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      </el-tab-pane>
      <el-tab-pane label="已丢弃" name="fourth">    <el-table v-loading="loading" :data="biaoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column label="pid" align="center" prop="pId"/>
        <el-table-column label="年龄" align="center" prop="age" />
        <el-table-column label="性别" align="center" prop="gender"/>
        <el-table-column label="图片地址" align="center" prop="imgAddress">
          <template v-slot:default="scope">
            <el-image
              style="width: 100px; height: 100px"
              :src="scope.row.imgAddress"
              :preview-src-list="[scope.row.imgAddress]">
            </el-image>
          </template>
        </el-table-column>
        <el-table-column label="上传时间" align="center" prop="createTime"/>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-view"
              @click="handleJump(scope.row)"
              v-hasPermi="['info:biao:lock']"
            >查看
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['info:biao:edit']"
            >修改
            </el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['info:biao:remove']"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      </el-tab-pane>
    </el-tabs>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改数据图表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item v-if="control" label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄"/>
        </el-form-item>
        <el-form-item v-if="control" label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别"/>
        </el-form-item>
        <el-form-item label="图片" prop="gender">
          <el-upload
            action=""
            :name="uploadId"
            :ref="`Uploader-${uploadId}`"
            list-type="picture-card"
            multiple
            accept="image/*"
            :before-upload="beforeAvatarUpload"
            :on-preview="handlePictureCardPreview"
            :on-change="handleChange"
            :file-list="fileList"
            :auto-upload="false"
            :http-request="httpRequest"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" v-if="imageUrl" :src="imageUrl" alt="">
          </el-dialog>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listBiao, getBiao, delBiao, addBiao, updateBiao, uploadFile} from "@/api/info/biao";
import request from '@/utils/request'
import {getToken} from "@/utils/auth";
import {nextTick} from "vue";

export default {
  name: "Biao",
  data() {
    return {
      // 控制年龄性别显示
      control:true,
      imgFiles: [],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据图表表格数据
      biaoList: [],
      activeName:'first',
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pId: null,
        age: null,
        gender: null,
        imgAddress: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        pId: [
          {required: true, message: "$comment不能为空", trigger: "blur"}
        ],
      },
      imgUpload: {
        // 设置上传的请求头部
        headers: {
          Authorization: "Bearer " + getToken()
        },
        // 图片上传的方法地址:
        url: process.env.VUE_APP_BASE_API + "/info/biao/fileUpload",
      },
      //页面上存的暂时图片地址List
      fileList: [],
      //图片地址
      imageUrl: "",
      dialogVisible: false,
      uploadId: Math.random().toString(36).substr(2).toLocaleUpperCase(),
      uploadFiles: [],
      fm: new FormData(),
    };
  },
  created() {
    this.getList();
  },
  methods: {
    handleClick(tab, event) {
      if (tab.paneName === "first"){
        this.queryParams.isBiaozhu=null
        this.getList()
      }else if (tab.paneName === "second"){
        this.queryParams.isBiaozhu=0
        this.getList()
      }else if (tab.paneName === "third"){
        this.queryParams.isBiaozhu=1
        this.getList()
      }else if (tab.paneName === "fourth"){
        this.queryParams.isBiaozhu=2
        this.getList()
      }
    },
    // 批量上传
    httpRequest(file) {
      this.fm.append('file', file.file);
      if (this.fm.getAll('file').length === this.fileTotal) {
        uploadFile( this.fm).then(res => {
          this.$message.success('图片上传成功！')
          console.log(res)
        }).catch(res => {
          this.$message.success('图片上传失败！')
        })
      }

    },

    //图片上传前的相关判断
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 5;
      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 5MB!');
      }
      return isJPG && isLt2M;
    },
    handleChange(file, fileList) {
      this.uploadFiles = fileList
      console.log(this.uploadFiles)
      // console.log(file)
      // //获取添加文件进来的状态



    },
//图片预览
    handlePictureCardPreview(file) {
      this.imageUrl = file.url;
      this.dialogVisible = true;
    },
    //图片上传成功后的回调
    handlePictureSuccess(res, file, fileList) {
      console.log(fileList)
      //设置图片访问路径 （articleImg 后台传过来的的上传地址）
      // this.imageUrl = file.response.url;
      this.fileList.push({
        url: file.response.url,
      })
    },
    /** 查询数据图表列表 */
    getList() {
      // console.log(this.$route.query)
      // console.log("跳转到了数据标注页面")

      this.queryParams.patientId = this.$route.query.patientId
      // console.log(this.queryParams)
      this.loading = true;
      listBiao(this.queryParams).then(response => {
        this.biaoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.control= true
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        pId: null,
        age: null,
        gender: null,
        imgAddress: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    handleJump(row) {
      console.log(row)
      this.queryParams.isBiaozhu=this.queryParams.isBiaozhu == undefined? null : this.queryParams.isBiaozhu
      // return
      this.$router.push({
        path: '/medicalData/annotate',
        query: {
          patientId:row.patientId,
          pId: row.pId,
          isBiaozhu:this.queryParams.isBiaozhu,
          pageNum:this.queryParams.pageNum,
          pageSize:this.queryParams.pageSize,
        }
      })
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.pId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.fileList=[]
      this.reset();
      this.control= false
      this.open = true;
      this.title = "添加数据图表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.fileList=[]
      this.reset();
      const pId = row.pId || this.ids
      getBiao(pId).then(response => {
        this.form = response.data;
        this.fileList.push({
          url: response.data.imgAddress,
        })
        this.open = true;
        this.title = "修改数据图表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.control= true
      console.log(this.fileList)
      this.$refs["form"].validate(valid => {
        if (valid) {
          console.log(this.uploadFiles)
          if (this.uploadFiles&& this.uploadFiles.length>0){
            let form = new FormData();
            for (let i = 0; i < this.uploadFiles.length; i++) {
              form.append('files',this.uploadFiles[i].raw);
            }
            uploadFile(form).then(res => {
              res.urls.split(",").forEach(item => {
                this.fileList.push({
                  url: item,
                });
              });
              let arr= []
              this.fileList.forEach(item => {
                arr.push(item.url)
              })
              this.form.fileList = arr
              console.log(this.form)
              if (this.form.pId != null) {
                updateBiao(this.form).then(response => {
                  this.$modal.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                });
              } else {
                this.form.patientId = this.biaoList[0].patientId
                this.form.age = this.biaoList[0].age
                this.form.gender = this.biaoList[0].gender
                console.log(this.form)
                    addBiao(this.form).then(response => {
                  this.$modal.msgSuccess("新增成功");
                  this.open = false;
                  this.getList();
                });
              }
              return
            })
          }else {
            console.log(this.form)
            if (this.form.pId != null) {
              updateBiao(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addBiao(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }

          }




        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const pIds = row.pId || this.ids;
      this.$modal.confirm('是否确认删除数据图表编号为"' + pIds + '"的数据项？').then(function () {
        return delBiao(pIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('info/biao/export', {
        ...this.queryParams
      }, `biao_${new Date().getTime()}.xlsx`)
    },
    /**导入图片**/
    handleImport() {
      this.fileList=[]
      this.open = true;
      this.title = "导入图片";
    },
    fileInputChange() {
      //选择多张图片，存入imgFiles数组中，并调用接口上传,非uniapp
      const fileInput = document.getElementById('fileInput');
      const files = fileInput.files;
      if (files.length == 0) return
      //此处上传
      const formData = new FormData();
      let arr = [];
      for (let i = 0; i < files.length; i++) {
        // const formData = new FormData();
        // formData.append('images',files[i]);
        arr.push(files[i])
        formData.append('images', files[i]);
      }
      // return
      request({
        url: '/biaozhu/pic',
        method: 'post',
        // data:formData
        data: formData
      }).then(res=>{
        console.log(res)
        if(res.code==200){
          this.$message.success("上传成功")
          this.getList()
        }else(
          this.$message.error("上传失败")
        )
      })
    }
  }
};
</script>
