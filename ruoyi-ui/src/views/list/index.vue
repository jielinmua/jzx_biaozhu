<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="pId" prop="pId">-->
<!--        <el-input-->
<!--          v-model="queryParams.pId"-->
<!--          placeholder="请输入"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="病人id" prop="patientId">
        <el-input
          v-model="queryParams.patientId"
          placeholder="请输入病人id"
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
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否标注" prop="isBiaozhu">
        <el-select v-model="queryParams.isBiaozhu" placeholder="请选择是否标注" clearable>
          <el-option
            v-for="dict in dict.type.jzx_is_biaozhu"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['info:biao:add']"
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
          v-hasPermi="['info:biao:edit']"
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
          v-hasPermi="['info:biao:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['info:biao:export']"
        >导出</el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
<!--      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="biaoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column
        label="序号"
        width="50"
        align="center">
        <template slot-scope="scope">
          {{ startIndex + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="上传时间" align="center" prop="createTime" />
      <el-table-column label="病人id" align="center" prop="patientId" width="200" />
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
<!--      <el-table-column label="图片地址" align="center" prop="imgAddress" width="100">-->
<!--        <template slot-scope="scope">-->
<!--          <image-preview :src="scope.row.imgAddress" :width="50" :height="50"/>-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="是否标注" align="center" prop="isBiaozhu">-->
<!--        <template slot-scope="scope">-->
<!--          <dict-tag :options="dict.type.jzx_is_biaozhu" :value="scope.row.isBiaozhu"/>-->
<!--        </template>-->
<!--      </el-table-column>-->
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
            v-hasPermi="['info:biao:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['info:biao:remove']"
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

    <!-- 添加或修改数据图表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="" prop="pId">
          <el-input v-model="form.pId" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="图片地址" prop="imgAddress">
          <image-upload v-model="form.imgAddress"/>
        </el-form-item>
        <el-form-item label="病人id" prop="patientId">
          <el-input v-model="form.patientId" placeholder="请输入病人id" />
        </el-form-item>
        <el-form-item label="是否标注" prop="isBiaozhu">
          <el-select v-model="form.isBiaozhu" placeholder="请选择是否标注">
            <el-option
              v-for="dict in dict.type.jzx_is_biaozhu"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
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
import {getPatientList,listBiao, getBiao, delBiao, addBiao, updateBiao, uploadFile} from "@/api/info/biao";
import request from '@/utils/request'
import {getToken} from "@/utils/auth";
import log from "@/views/monitor/job/log.vue";

export default {
  name: "Biao",
  dicts: ['jzx_is_biaozhu', 'sys_user_sex'],
  data() {
    return {
      startIndex: 0, // 用于计算连续索引的起始值
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
        imgAddress: null,
        patientId: null,
        isBiaozhu: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        pId: [
          { required: true, message: "不能为空", trigger: "blur" }
        ],
      }
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
    /** 查询数据图表列表 */
    getList() {
      this.loading = true;
      getPatientList(this.queryParams).then(response => {
        console.log(response)
        this.biaoList = response.rows;
        this.total = response.total;
        this.startIndex = (this.queryParams.pageNum - 1) * this.queryParams.pageSize;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        pId: null,
        age: null,
        gender: null,
        imgAddress: null,
        patientId: null,
        createTime: null,
        updateTime: null,
        isBiaozhu: null
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
      this.ids = selection.map(item => item.pId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加数据图表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pId = row.pId || this.ids
      getBiao(pId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改数据图表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
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
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const pIds = row.pId || this.ids;
      this.$modal.confirm('是否确认删除数据图表编号为"' + pIds + '"的数据项？').then(function() {
        return delBiao(pIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('info/biao/export', {
        ...this.queryParams
      }, `biao_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

