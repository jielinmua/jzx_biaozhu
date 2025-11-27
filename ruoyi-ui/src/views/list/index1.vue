<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="患者id" prop="patientId">-->
<!--        <el-input-->
<!--          v-model="queryParams.patientId"-->
<!--          placeholder="请输入患者id"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
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
          v-hasPermi="['system:patient:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:patient:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:patient:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:patient:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="patientList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="患者id" align="center" prop="patientId" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="全部数据" align="center" prop="all">
        <template slot-scope="scope">
          <el-tag>{{scope.row.all}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="已标注" align="center" prop="yi">
        <template slot-scope="scope">
          <el-tag type="success">{{scope.row.yi}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="未标注" align="center" prop="wei">
        <template slot-scope="scope">
          <el-tag type="warning" >{{scope.row.wei}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="已丢弃" align="center" prop="diu">
        <template slot-scope="scope">
          <el-tag type="danger">{{ scope.row.diu }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleJump(scope.row)"
            v-hasPermi="['info:biao:lock']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:patient:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:patient:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改患者对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="患者id" prop="patientId">-->
<!--          <el-input v-model="form.patientId" placeholder="请输入患者id" />-->
<!--        </el-form-item>-->
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别" />
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
import {listPatient, getPatient, delPatient, addPatient, updatePatient, uploadFile, addBiao} from "@/api/info/biao";

export default {
  name: "Index1",
  dicts: ['jzx_is_biaozhu', 'sys_user_sex'],
  data() {
    return {
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
      // 患者表格数据
      patientList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        patientId: null,
        age: null,
        gender: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        pId: [
          { required: true, message: "不能为空", trigger: "blur" }
        ],
      },
      uploadId: Math.random().toString(36).substr(2).toLocaleUpperCase(),
      //页面上存的暂时图片地址List
      fileList: [],
      dialogVisible: false,
      imageUrl: "",
    };
  },
  created() {
    this.getList();
  },
  methods: {
    handleJump(row) {
      console.log(row.patientId)
      this.queryParams.isBiaozhu=this.queryParams.isBiaozhu == undefined? null : this.queryParams.isBiaozhu
      this.$router.push({
        name: 'Biao',
        query: {
          patientId: row.patientId,
          isBiaozhu:this.queryParams.isBiaozhu,
          pageNum:this.queryParams.pageNum,
          pageSize:this.queryParams.pageSize,
        }
      })
    },
    /** 查询患者列表 */
    getList() {
      this.loading = true;
      listPatient(this.queryParams).then(response => {
        console.log(response)
        this.patientList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        patientId: null,
        age: null,
        gender: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加患者";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPatient(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改患者";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.uploadFiles)
      console.log(this.fileList)
      this.$refs["form"].validate(valid => {
        console.log(valid)
        // return
        if (valid) {
          if (this.form.id != null) {
            console.log(this.form)
            updatePatient(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            console.log("确定新增")
            console.log(this.form)
            addPatient(this.form).then(response => {
              console.log("新增后的数据")
              console.log(response)
              // this.$modal.msgSuccess("新增成功");
              // this.open = false;
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
                  this.form.patientId = response.data.patientId
                  console.log("新增的图片在form中")
                  console.log(this.form)
                  addBiao(this.form).then(response => {
                    this.$modal.msgSuccess("新增成功");
                    this.open = false;
                    this.getList();
                  });
                })

              }
              // this.getList();
            });
          }
        }
      });
    },
    // response.data.patientId
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除患者编号为"' + ids + '"的数据项？').then(function() {
        return delPatient(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/patient/export', {
        ...this.queryParams
      }, `patient_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

