<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0假1真" prop="jiazhuangxianshizhimiman">
        <el-input
          v-model="queryParams.jiazhuangxianshizhimiman"
          placeholder="请输入0假1真"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxShifoushuangceexing">
        <el-input
          v-model="queryParams.jzxShifoushuangceexing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxDuofabingzhao">
        <el-input
          v-model="queryParams.jzxDuofabingzhao"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxWeizhiShangji">
        <el-input
          v-model="queryParams.jzxWeizhiShangji"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxWeizhiXiaji">
        <el-input
          v-model="queryParams.jzxWeizhiXiaji"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxWeizhiZhongbu">
        <el-input
          v-model="queryParams.jzxWeizhiZhongbu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxWeizhiXiabu">
        <el-input
          v-model="queryParams.jzxWeizhiXiabu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxZuzhibingliLiangxing">
        <el-input
          v-model="queryParams.jzxZuzhibingliLiangxing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxZuzhibingliRutouzhuangai">
        <el-input
          v-model="queryParams.jzxZuzhibingliRutouzhuangai"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxZuzhibingliSuiyangai">
        <el-input
          v-model="queryParams.jzxZuzhibingliSuiyangai"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxZuzhibinbliLvpaozhuangai">
        <el-input
          v-model="queryParams.jzxZuzhibinbliLvpaozhuangai"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxZuzhibingliQitaexing">
        <el-input
          v-model="queryParams.jzxZuzhibingliQitaexing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxJiejiezuidajing">
        <el-input
          v-model="queryParams.jzxJiejiezuidajing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouShixing">
        <el-input
          v-model="queryParams.jzxNeibujiegouShixing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouShixingweizhu">
        <el-input
          v-model="queryParams.jzxNeibujiegouShixingweizhu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouNangxingweizhu">
        <el-input
          v-model="queryParams.jzxNeibujiegouNangxingweizhu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouNangshixing">
        <el-input
          v-model="queryParams.jzxNeibujiegouNangshixing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouHaimianyang">
        <el-input
          v-model="queryParams.jzxNeibujiegouHaimianyang"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouNangxing">
        <el-input
          v-model="queryParams.jzxNeibujiegouNangxing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxNeibujiegouWufapanduan">
        <el-input
          v-model="queryParams.jzxNeibujiegouWufapanduan"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxHuishengGaohuisheng">
        <el-input
          v-model="queryParams.jzxHuishengGaohuisheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxHuishengDenghuisheng">
        <el-input
          v-model="queryParams.jzxHuishengDenghuisheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxHuishengDihuisheng">
        <el-input
          v-model="queryParams.jzxHuishengDihuisheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxHuishengJidihuisheng">
        <el-input
          v-model="queryParams.jzxHuishengJidihuisheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxHuishengWufapanduan">
        <el-input
          v-model="queryParams.jzxHuishengWufapanduan"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxXingzhuangDayudengyu">
        <el-input
          v-model="queryParams.jzxXingzhuangDayudengyu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxXingzhuangXiaoyu">
        <el-input
          v-model="queryParams.jzxXingzhuangXiaoyu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxBianyuanGuangzheng">
        <el-input
          v-model="queryParams.jzxBianyuanGuangzheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxBianyuanBuguize">
        <el-input
          v-model="queryParams.jzxBianyuanBuguize"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxBianyuanFenyezhuang">
        <el-input
          v-model="queryParams.jzxBianyuanFenyezhuang"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxBianyuanMohu">
        <el-input
          v-model="queryParams.jzxBianyuanMohu"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxBianyuanEte">
        <el-input
          v-model="queryParams.jzxBianyuanEte"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengDianzhuang">
        <el-input
          v-model="queryParams.jzxJuzhaoqianghuishengDianzhuang"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengCudagaihua">
        <el-input
          v-model="queryParams.jzxJuzhaoqianghuishengCudagaihua"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengBianyuangaihua">
        <el-input
          v-model="queryParams.jzxJuzhaoqianghuishengBianyuangaihua"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengHuixingwei">
        <el-input
          v-model="queryParams.jzxJuzhaoqianghuishengHuixingwei"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjDaxiaoShuipingjing">
        <el-input
          v-model="queryParams.lbjDaxiaoShuipingjing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjDaxiaoCuizhijing">
        <el-input
          v-model="queryParams.lbjDaxiaoCuizhijing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXingzhuangTuoyuan">
        <el-input
          v-model="queryParams.lbjXingzhuangTuoyuan"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXingzhuangLeiyuan">
        <el-input
          v-model="queryParams.lbjXingzhuangLeiyuan"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXingzhuangBuguize">
        <el-input
          v-model="queryParams.lbjXingzhuangBuguize"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjBianyuanBuguize">
        <el-input
          v-model="queryParams.lbjBianyuanBuguize"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjBianyuanGuangzheng">
        <el-input
          v-model="queryParams.lbjBianyuanGuangzheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjLinbamenZhengchang">
        <el-input
          v-model="queryParams.lbjLinbamenZhengchang"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjLinbamenPianxin">
        <el-input
          v-model="queryParams.lbjLinbamenPianxin"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjLinbamenXiaoshi">
        <el-input
          v-model="queryParams.lbjLinbamenXiaoshi"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjLinbamenGaohuishengtuankuai">
        <el-input
          v-model="queryParams.lbjLinbamenGaohuishengtuankuai"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjPizhiJunyunzenghou">
        <el-input
          v-model="queryParams.lbjPizhiJunyunzenghou"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjPizhiBujunyunzenghou">
        <el-input
          v-model="queryParams.lbjPizhiBujunyunzenghou"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjNeijunzhigaohuisheng">
        <el-input
          v-model="queryParams.lbjNeijunzhigaohuisheng"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjYehua">
        <el-input
          v-model="queryParams.lbjYehua"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjGaihua">
        <el-input
          v-model="queryParams.lbjGaihua"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXueliuZhengchang">
        <el-input
          v-model="queryParams.lbjXueliuZhengchang"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXueliuMenxing">
        <el-input
          v-model="queryParams.lbjXueliuMenxing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXueliuBianyuanweizhuxing">
        <el-input
          v-model="queryParams.lbjXueliuBianyuanweizhuxing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjXueliuHunhexing">
        <el-input
          v-model="queryParams.lbjXueliuHunhexing"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="lbjBinglijieguo">
        <el-input
          v-model="queryParams.lbjBinglijieguo"
          placeholder="请输入${comment}"
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
          v-hasPermi="['biaozhu:pic:add']"
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
          v-hasPermi="['biaozhu:pic:edit']"
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
          v-hasPermi="['biaozhu:pic:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['biaozhu:pic:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="picList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="pId" />
      <el-table-column label="${comment}" align="center" prop="age" />
      <el-table-column label="${comment}" align="center" prop="gender" />
      <el-table-column label="0假1真" align="center" prop="jiazhuangxianshizhimiman" />
      <el-table-column label="${comment}" align="center" prop="jzxShifoushuangceexing" />
      <el-table-column label="${comment}" align="center" prop="jzxDuofabingzhao" />
      <el-table-column label="${comment}" align="center" prop="jzxWeizhiShangji" />
      <el-table-column label="${comment}" align="center" prop="jzxWeizhiXiaji" />
      <el-table-column label="${comment}" align="center" prop="jzxWeizhiZhongbu" />
      <el-table-column label="${comment}" align="center" prop="jzxWeizhiXiabu" />
      <el-table-column label="${comment}" align="center" prop="jzxZuzhibingliLiangxing" />
      <el-table-column label="${comment}" align="center" prop="jzxZuzhibingliRutouzhuangai" />
      <el-table-column label="${comment}" align="center" prop="jzxZuzhibingliSuiyangai" />
      <el-table-column label="${comment}" align="center" prop="jzxZuzhibinbliLvpaozhuangai" />
      <el-table-column label="${comment}" align="center" prop="jzxZuzhibingliQitaexing" />
      <el-table-column label="${comment}" align="center" prop="jzxJiejiezuidajing" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouShixing" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouShixingweizhu" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouNangxingweizhu" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouNangshixing" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouHaimianyang" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouNangxing" />
      <el-table-column label="${comment}" align="center" prop="jzxNeibujiegouWufapanduan" />
      <el-table-column label="${comment}" align="center" prop="jzxHuishengGaohuisheng" />
      <el-table-column label="${comment}" align="center" prop="jzxHuishengDenghuisheng" />
      <el-table-column label="${comment}" align="center" prop="jzxHuishengDihuisheng" />
      <el-table-column label="${comment}" align="center" prop="jzxHuishengJidihuisheng" />
      <el-table-column label="${comment}" align="center" prop="jzxHuishengWufapanduan" />
      <el-table-column label="${comment}" align="center" prop="jzxXingzhuangDayudengyu" />
      <el-table-column label="${comment}" align="center" prop="jzxXingzhuangXiaoyu" />
      <el-table-column label="${comment}" align="center" prop="jzxBianyuanGuangzheng" />
      <el-table-column label="${comment}" align="center" prop="jzxBianyuanBuguize" />
      <el-table-column label="${comment}" align="center" prop="jzxBianyuanFenyezhuang" />
      <el-table-column label="${comment}" align="center" prop="jzxBianyuanMohu" />
      <el-table-column label="${comment}" align="center" prop="jzxBianyuanEte" />
      <el-table-column label="${comment}" align="center" prop="jzxJuzhaoqianghuishengDianzhuang" />
      <el-table-column label="${comment}" align="center" prop="jzxJuzhaoqianghuishengCudagaihua" />
      <el-table-column label="${comment}" align="center" prop="jzxJuzhaoqianghuishengBianyuangaihua" />
      <el-table-column label="${comment}" align="center" prop="jzxJuzhaoqianghuishengHuixingwei" />
      <el-table-column label="${comment}" align="center" prop="lbjDaxiaoShuipingjing" />
      <el-table-column label="${comment}" align="center" prop="lbjDaxiaoCuizhijing" />
      <el-table-column label="${comment}" align="center" prop="lbjXingzhuangTuoyuan" />
      <el-table-column label="${comment}" align="center" prop="lbjXingzhuangLeiyuan" />
      <el-table-column label="${comment}" align="center" prop="lbjXingzhuangBuguize" />
      <el-table-column label="${comment}" align="center" prop="lbjBianyuanBuguize" />
      <el-table-column label="${comment}" align="center" prop="lbjBianyuanGuangzheng" />
      <el-table-column label="${comment}" align="center" prop="lbjLinbamenZhengchang" />
      <el-table-column label="${comment}" align="center" prop="lbjLinbamenPianxin" />
      <el-table-column label="${comment}" align="center" prop="lbjLinbamenXiaoshi" />
      <el-table-column label="${comment}" align="center" prop="lbjLinbamenGaohuishengtuankuai" />
      <el-table-column label="${comment}" align="center" prop="lbjPizhiJunyunzenghou" />
      <el-table-column label="${comment}" align="center" prop="lbjPizhiBujunyunzenghou" />
      <el-table-column label="${comment}" align="center" prop="lbjNeijunzhigaohuisheng" />
      <el-table-column label="${comment}" align="center" prop="lbjYehua" />
      <el-table-column label="${comment}" align="center" prop="lbjGaihua" />
      <el-table-column label="${comment}" align="center" prop="lbjXueliuZhengchang" />
      <el-table-column label="${comment}" align="center" prop="lbjXueliuMenxing" />
      <el-table-column label="${comment}" align="center" prop="lbjXueliuBianyuanweizhuxing" />
      <el-table-column label="${comment}" align="center" prop="lbjXueliuHunhexing" />
      <el-table-column label="${comment}" align="center" prop="lbjBinglijieguo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['biaozhu:pic:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['biaozhu:pic:remove']"
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

    <!-- 添加或修改标注对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="age">
          <el-input v-model="form.age" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="0假1真" prop="jiazhuangxianshizhimiman">
          <el-input v-model="form.jiazhuangxianshizhimiman" placeholder="请输入0假1真" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxShifoushuangceexing">
          <el-input v-model="form.jzxShifoushuangceexing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxDuofabingzhao">
          <el-input v-model="form.jzxDuofabingzhao" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxWeizhiShangji">
          <el-input v-model="form.jzxWeizhiShangji" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxWeizhiXiaji">
          <el-input v-model="form.jzxWeizhiXiaji" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxWeizhiZhongbu">
          <el-input v-model="form.jzxWeizhiZhongbu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxWeizhiXiabu">
          <el-input v-model="form.jzxWeizhiXiabu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxZuzhibingliLiangxing">
          <el-input v-model="form.jzxZuzhibingliLiangxing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxZuzhibingliRutouzhuangai">
          <el-input v-model="form.jzxZuzhibingliRutouzhuangai" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxZuzhibingliSuiyangai">
          <el-input v-model="form.jzxZuzhibingliSuiyangai" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxZuzhibinbliLvpaozhuangai">
          <el-input v-model="form.jzxZuzhibinbliLvpaozhuangai" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxZuzhibingliQitaexing">
          <el-input v-model="form.jzxZuzhibingliQitaexing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxJiejiezuidajing">
          <el-input v-model="form.jzxJiejiezuidajing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouShixing">
          <el-input v-model="form.jzxNeibujiegouShixing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouShixingweizhu">
          <el-input v-model="form.jzxNeibujiegouShixingweizhu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouNangxingweizhu">
          <el-input v-model="form.jzxNeibujiegouNangxingweizhu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouNangshixing">
          <el-input v-model="form.jzxNeibujiegouNangshixing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouHaimianyang">
          <el-input v-model="form.jzxNeibujiegouHaimianyang" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouNangxing">
          <el-input v-model="form.jzxNeibujiegouNangxing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxNeibujiegouWufapanduan">
          <el-input v-model="form.jzxNeibujiegouWufapanduan" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxHuishengGaohuisheng">
          <el-input v-model="form.jzxHuishengGaohuisheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxHuishengDenghuisheng">
          <el-input v-model="form.jzxHuishengDenghuisheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxHuishengDihuisheng">
          <el-input v-model="form.jzxHuishengDihuisheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxHuishengJidihuisheng">
          <el-input v-model="form.jzxHuishengJidihuisheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxHuishengWufapanduan">
          <el-input v-model="form.jzxHuishengWufapanduan" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxXingzhuangDayudengyu">
          <el-input v-model="form.jzxXingzhuangDayudengyu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxXingzhuangXiaoyu">
          <el-input v-model="form.jzxXingzhuangXiaoyu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxBianyuanGuangzheng">
          <el-input v-model="form.jzxBianyuanGuangzheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxBianyuanBuguize">
          <el-input v-model="form.jzxBianyuanBuguize" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxBianyuanFenyezhuang">
          <el-input v-model="form.jzxBianyuanFenyezhuang" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxBianyuanMohu">
          <el-input v-model="form.jzxBianyuanMohu" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxBianyuanEte">
          <el-input v-model="form.jzxBianyuanEte" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengDianzhuang">
          <el-input v-model="form.jzxJuzhaoqianghuishengDianzhuang" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengCudagaihua">
          <el-input v-model="form.jzxJuzhaoqianghuishengCudagaihua" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengBianyuangaihua">
          <el-input v-model="form.jzxJuzhaoqianghuishengBianyuangaihua" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="jzxJuzhaoqianghuishengHuixingwei">
          <el-input v-model="form.jzxJuzhaoqianghuishengHuixingwei" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjDaxiaoShuipingjing">
          <el-input v-model="form.lbjDaxiaoShuipingjing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjDaxiaoCuizhijing">
          <el-input v-model="form.lbjDaxiaoCuizhijing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXingzhuangTuoyuan">
          <el-input v-model="form.lbjXingzhuangTuoyuan" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXingzhuangLeiyuan">
          <el-input v-model="form.lbjXingzhuangLeiyuan" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXingzhuangBuguize">
          <el-input v-model="form.lbjXingzhuangBuguize" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjBianyuanBuguize">
          <el-input v-model="form.lbjBianyuanBuguize" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjBianyuanGuangzheng">
          <el-input v-model="form.lbjBianyuanGuangzheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjLinbamenZhengchang">
          <el-input v-model="form.lbjLinbamenZhengchang" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjLinbamenPianxin">
          <el-input v-model="form.lbjLinbamenPianxin" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjLinbamenXiaoshi">
          <el-input v-model="form.lbjLinbamenXiaoshi" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjLinbamenGaohuishengtuankuai">
          <el-input v-model="form.lbjLinbamenGaohuishengtuankuai" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjPizhiJunyunzenghou">
          <el-input v-model="form.lbjPizhiJunyunzenghou" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjPizhiBujunyunzenghou">
          <el-input v-model="form.lbjPizhiBujunyunzenghou" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjNeijunzhigaohuisheng">
          <el-input v-model="form.lbjNeijunzhigaohuisheng" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjYehua">
          <el-input v-model="form.lbjYehua" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjGaihua">
          <el-input v-model="form.lbjGaihua" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXueliuZhengchang">
          <el-input v-model="form.lbjXueliuZhengchang" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXueliuMenxing">
          <el-input v-model="form.lbjXueliuMenxing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXueliuBianyuanweizhuxing">
          <el-input v-model="form.lbjXueliuBianyuanweizhuxing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjXueliuHunhexing">
          <el-input v-model="form.lbjXueliuHunhexing" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="lbjBinglijieguo">
          <el-input v-model="form.lbjBinglijieguo" placeholder="请输入${comment}" />
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
import { listPic, getPic, delPic, addPic, updatePic } from "@/api/biaozhu/pic";

export default {
  name: "Pic",
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
      // 标注表格数据
      picList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        age: null,
        gender: null,
        jiazhuangxianshizhimiman: null,
        jzxShifoushuangceexing: null,
        jzxDuofabingzhao: null,
        jzxWeizhiShangji: null,
        jzxWeizhiXiaji: null,
        jzxWeizhiZhongbu: null,
        jzxWeizhiXiabu: null,
        jzxZuzhibingliLiangxing: null,
        jzxZuzhibingliRutouzhuangai: null,
        jzxZuzhibingliSuiyangai: null,
        jzxZuzhibinbliLvpaozhuangai: null,
        jzxZuzhibingliQitaexing: null,
        jzxJiejiezuidajing: null,
        jzxNeibujiegouShixing: null,
        jzxNeibujiegouShixingweizhu: null,
        jzxNeibujiegouNangxingweizhu: null,
        jzxNeibujiegouNangshixing: null,
        jzxNeibujiegouHaimianyang: null,
        jzxNeibujiegouNangxing: null,
        jzxNeibujiegouWufapanduan: null,
        jzxHuishengGaohuisheng: null,
        jzxHuishengDenghuisheng: null,
        jzxHuishengDihuisheng: null,
        jzxHuishengJidihuisheng: null,
        jzxHuishengWufapanduan: null,
        jzxXingzhuangDayudengyu: null,
        jzxXingzhuangXiaoyu: null,
        jzxBianyuanGuangzheng: null,
        jzxBianyuanBuguize: null,
        jzxBianyuanFenyezhuang: null,
        jzxBianyuanMohu: null,
        jzxBianyuanEte: null,
        jzxJuzhaoqianghuishengDianzhuang: null,
        jzxJuzhaoqianghuishengCudagaihua: null,
        jzxJuzhaoqianghuishengBianyuangaihua: null,
        jzxJuzhaoqianghuishengHuixingwei: null,
        lbjDaxiaoShuipingjing: null,
        lbjDaxiaoCuizhijing: null,
        lbjXingzhuangTuoyuan: null,
        lbjXingzhuangLeiyuan: null,
        lbjXingzhuangBuguize: null,
        lbjBianyuanBuguize: null,
        lbjBianyuanGuangzheng: null,
        lbjLinbamenZhengchang: null,
        lbjLinbamenPianxin: null,
        lbjLinbamenXiaoshi: null,
        lbjLinbamenGaohuishengtuankuai: null,
        lbjPizhiJunyunzenghou: null,
        lbjPizhiBujunyunzenghou: null,
        lbjNeijunzhigaohuisheng: null,
        lbjYehua: null,
        lbjGaihua: null,
        lbjXueliuZhengchang: null,
        lbjXueliuMenxing: null,
        lbjXueliuBianyuanweizhuxing: null,
        lbjXueliuHunhexing: null,
        lbjBinglijieguo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询标注列表 */
    getList() {
      this.loading = true;
      listPic(this.queryParams).then(response => {
        this.picList = response.rows;
        this.total = response.total;
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
        jiazhuangxianshizhimiman: null,
        jzxShifoushuangceexing: null,
        jzxDuofabingzhao: null,
        jzxWeizhiShangji: null,
        jzxWeizhiXiaji: null,
        jzxWeizhiZhongbu: null,
        jzxWeizhiXiabu: null,
        jzxZuzhibingliLiangxing: null,
        jzxZuzhibingliRutouzhuangai: null,
        jzxZuzhibingliSuiyangai: null,
        jzxZuzhibinbliLvpaozhuangai: null,
        jzxZuzhibingliQitaexing: null,
        jzxJiejiezuidajing: null,
        jzxNeibujiegouShixing: null,
        jzxNeibujiegouShixingweizhu: null,
        jzxNeibujiegouNangxingweizhu: null,
        jzxNeibujiegouNangshixing: null,
        jzxNeibujiegouHaimianyang: null,
        jzxNeibujiegouNangxing: null,
        jzxNeibujiegouWufapanduan: null,
        jzxHuishengGaohuisheng: null,
        jzxHuishengDenghuisheng: null,
        jzxHuishengDihuisheng: null,
        jzxHuishengJidihuisheng: null,
        jzxHuishengWufapanduan: null,
        jzxXingzhuangDayudengyu: null,
        jzxXingzhuangXiaoyu: null,
        jzxBianyuanGuangzheng: null,
        jzxBianyuanBuguize: null,
        jzxBianyuanFenyezhuang: null,
        jzxBianyuanMohu: null,
        jzxBianyuanEte: null,
        jzxJuzhaoqianghuishengDianzhuang: null,
        jzxJuzhaoqianghuishengCudagaihua: null,
        jzxJuzhaoqianghuishengBianyuangaihua: null,
        jzxJuzhaoqianghuishengHuixingwei: null,
        lbjDaxiaoShuipingjing: null,
        lbjDaxiaoCuizhijing: null,
        lbjXingzhuangTuoyuan: null,
        lbjXingzhuangLeiyuan: null,
        lbjXingzhuangBuguize: null,
        lbjBianyuanBuguize: null,
        lbjBianyuanGuangzheng: null,
        lbjLinbamenZhengchang: null,
        lbjLinbamenPianxin: null,
        lbjLinbamenXiaoshi: null,
        lbjLinbamenGaohuishengtuankuai: null,
        lbjPizhiJunyunzenghou: null,
        lbjPizhiBujunyunzenghou: null,
        lbjNeijunzhigaohuisheng: null,
        lbjYehua: null,
        lbjGaihua: null,
        lbjXueliuZhengchang: null,
        lbjXueliuMenxing: null,
        lbjXueliuBianyuanweizhuxing: null,
        lbjXueliuHunhexing: null,
        lbjBinglijieguo: null
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
      this.title = "添加标注";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const pId = row.pId || this.ids
      getPic(pId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改标注";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.pId != null) {
            updatePic(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPic(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除标注编号为"' + pIds + '"的数据项？').then(function() {
        return delPic(pIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('biaozhu/pic/export', {
        ...this.queryParams
      }, `pic_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
