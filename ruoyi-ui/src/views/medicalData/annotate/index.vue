<template>
  <div class="pageBox">
    <div class="canvasBox">
      <div class="canvasTool" style="display:none">
        <div class="canvasToolUp">
          <el-button @click="instanceChange(1)" :type="instanceStatus == 1 ? 'primary' : ''">方形</el-button>
          <el-button @click="instanceChange(2)" :type="instanceStatus == 2 ? 'primary' : ''">自定义</el-button>
          <el-button @click="instanceChange(3)" :type="instanceStatus == 3 ? 'primary' : ''">点</el-button>
          <el-button @click="instanceChange(4)" :type="instanceStatus == 4 ? 'primary' : ''">线</el-button>
          <el-button @click="instanceChange(5)" :type="instanceStatus == 5 ? 'primary' : ''">圆</el-button>
          <el-button @click="instanceChange(0)" :type="instanceStatus == 0 ? 'primary' : ''">选中</el-button>
          <el-button @click="instanceFitting">重置图片位置</el-button>
          <el-button @click="instanceFocus" :type="hideNoSelect? 'primary' : ''">隐藏未选中</el-button>
          <el-button @click="instanceShowName" :type="hideName? 'primary' : ''">隐藏标记名称</el-button>
          <el-button @click="downImg">下载</el-button>
        </div>
        <div class="canvasToolDown">
          名称:
          <el-input type="text" v-model="selectLabel" :disabled="labelDisabledState" class="instanceName"/>
        </div>
      </div>
      <div class="canvasContainer">
        <div class="canvasTool switchShow">
          <el-button @click="instanceFocus" :type="hideNoSelect? 'primary' : ''"><i class="icon el-icon-view"/>隐藏未选中
          </el-button>
        </div>
        <div class="canvasTool selectTool">
          <!--<i class="el-icon-rank"/>-->
          <el-select @change="instanceChange" v-model="instanceStatus">
            <el-option :key="1" label="方形" :value="1"/>
            <el-option :key="2" label="自定义" :value="2"/>
            <el-option :key="3" label="点" :value="3"/>
            <el-option :key="4" label="线" :value="4"/>
            <el-option :key="5" label="圆" :value="5"/>
            <el-option :key="0" label="默认鼠标" :value="0"/>
          </el-select>
        </div>
        <div class="canvasTool tagName">
          <el-input type="text" v-model="selectLabel" :disabled="labelDisabledState"></el-input>
        </div>
        <div class="canvasTool resetBtn">
          <el-button @click="instanceFitting"><i class="icon el-icon-refresh-left"/>重置图片位置</el-button>
        </div>
        <canvas class="container"></canvas>
      </div>
    </div>

    <div class="controllerBox">
      <div class="patientInfo">
        <div class="box1 leftBlue leftVertical">
          <span></span>
          <p>基本信息</p>
        </div>
        <div class="message">
          <div>年龄</div>
          <div>{{ patientAge }}</div>
          <div>性别</div>
          <div>{{ patientSex }}</div>
        </div>
      </div>
      <div class="content1">
        <div class="box1 leftBlue leftVertical" style="margin: 0 0 1.5vh 0">
          <span></span>
          <p>甲状腺病变</p>
        </div>
        <el-collapse
          v-model="activeNames"
          @change="handleChange"
          class="xialakuang"
        >
          <el-collapse-item>
            <span class="large-title" slot="title"> 总体情况描述</span>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">甲状腺实质弥漫</span>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="markData.jiazhuangxianshizhimiman" :label="1">是</el-radio>
                    <el-radio v-model="markData.jiazhuangxianshizhimiman" :label="0">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">是否双侧恶性</span>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="markData.jzxShiFoushuangceexing" :label="1">是</el-radio>
                    <el-radio v-model="markData.jzxShiFoushuangceexing" :label="0">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">多发病灶(单侧叶)</span>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="markData.jzxDuofabingzhao" :label="1">是</el-radio>
                    <el-radio v-model="markData.jzxDuofabingzhao" :label="0">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid Fouritems">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">位置</span>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox v-model="markData.jzxWeizhiShangji" @change="weizhiChange(1)" :true-label="1"
                                 :false-label="0">上极
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxWeizhiXiaji" @change="weizhiChange(2)" :true-label="1"
                                 :false-label="0">下极
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxWeizhiZhongbu" @change="weizhiChange(3)" :true-label="1"
                                 :false-label="0">中部
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxWeizhiXiabu" @change="weizhiChange(4)" :true-label="1"
                                 :false-label="0">峡部
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid duoxuan">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">组织病理结果</span>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox v-model="markData.jzxZuZhibingliLiangxing" @change="bingliChange(1)" :true-label="1"
                                 :false-label="0">良性
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxZuzhibingliRutouzhuangai" @change="bingliChange(2)"
                                 :true-label="1" :false-label="0">乳头状癌
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxZuzhibingliSuiyangai" @change="bingliChange(3)" :true-label="1"
                                 :false-label="0">髓样癌
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxZuzhibingliLvpaozhuangai" @change="bingliChange(4)"
                                 :true-label="1" :false-label="0">滤泡状癌
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxZuzhibingliQitaexing" @change="bingliChange(5)" :true-label="1"
                                 :false-label="0">其他恶性
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>
            <!-- ===================================================================================== -->
            <!--<div class="thyroid">-->
            <!--  <el-collapse-item class="jiantou">-->
            <!--    <span class="collapse-title" slot="title">结节最大径<el-input/></span>-->
            <!--  </el-collapse-item>-->
            <!--</div>-->
            <div class="thyroid-box"><span class="thyroid-box-title">结节最大径</span>
              <el-input class="thyroid-box-input" v-model="markData.jzxJiejiezuidajing"/>
            </div>
          </el-collapse-item>

          <el-collapse-item>
            <span class="large-title" slot="title"> 结构描述</span>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">内部结构</span>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox v-model="markData.jzxNeibujiegouShixing" @change="jiegouChange(1)" :true-label="1"
                                 :false-label="0">实性
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouShixingweizhu" @change="jiegouChange(2)"
                                 :true-label="1" :false-label="0">实性为主
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouNangxingweizhu" @change="jiegouChange(3)"
                                 :true-label="1" :false-label="0">囊性为主
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouNangshixing" @change="jiegouChange(4)" :true-label="1"
                                 :false-label="0">囊实性
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouHaimianyang" @change="jiegouChange(5)" :true-label="1"
                                 :false-label="0">海绵样
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouNangxing" @change="jiegouChange(6)" :true-label="1"
                                 :false-label="0">囊性
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxNeibujiegouWufapanduan" @change="jiegouChange(7)" :true-label="1"
                                 :false-label="0">无法判断
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">回声</span>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox v-model="markData.jzxHuishengGaohuisheng" @change="huishengChange(1)" :true-label="1"
                                 :false-label="0">高回声
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxHuishengDenghuisheng" @change="huishengChange(2)" :true-label="1"
                                 :false-label="0">等回声
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxHuishengDihuisheng" @change="huishengChange(3)" :true-label="1"
                                 :false-label="0">低回声
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxHuishengJidihuisheng" @change="huishengChange(4)" :true-label="1"
                                 :false-label="0">极低回声
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxHuishengWufapanduan" @change="huishengChange(5)" :true-label="1"
                                 :false-label="0">无法判断
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">形状</span>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox v-model="markData.jzxXingzhuangDayuDengyu" @change="jzxxingzhuangChange(1)"
                                 :true-label="1" :false-label="0">纵横比≥1
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxXingzhuangxiaoyu" @change="jzxxingzhuangChange(2)" :true-label="1"
                                 :false-label="0">纵横比<1
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">边缘</span>
                <el-row>
                  <el-col :offset="2" :span="20">
                    <el-checkbox v-model="markData.jzxBianyuanGuangzheng" @change="jzxbianyuanChange(1)" :true-label="1"
                                 :false-label="0">边缘光整
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxBianyuanBuguize" @change="jzxbianyuanChange(2)" :true-label="1"
                                 :false-label="0">边缘不规则
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxBianyuanFenyezhuang" @change="jzxbianyuanChange(3)"
                                 :true-label="1" :false-label="0">边缘分叶状
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxBianyuanMohu" @change="jzxbianyuanChange(4)" :true-label="1"
                                 :false-label="0">边缘模糊
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxBianyuanEte" @change="jzxbianyuanChange(5)" :true-label="1"
                                 :false-label="0">ETE
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxBianyuanWufaqueding" @change="jzxbianyuanChange(6)"
                                 :true-label="1" :false-label="0">无法确定
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <span class="collapse-title" slot="title">局灶强回声</span>
                <el-row>
                  <el-col :offset="2" :span="20">
                    <el-checkbox v-model="markData.jzxJuzhaoqianghuishengDianzhuang" :true-label="1" :false-label="0">
                      点状强回声
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxJuzhaoqianghuishengCudagaihua" :true-label="1" :false-label="0">
                      粗大钙化
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxJuzhaoqianghuishengBianyuangaihua" :true-label="1"
                                 :false-label="0">边缘钙化
                    </el-checkbox>
                    <el-checkbox v-model="markData.jzxJuzhaoqianghuishengHuixingwei" :true-label="1" :false-label="0">
                      彗星尾
                    </el-checkbox>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <div class="content1" style="margin-top: 8px">
        <div class="box1 leftBlue leftVertical">
          <p>淋巴结病变</p>
        </div>
        <el-collapse v-model="activeNames" @change="handleChange">
          <div class="thyroid">
            <el-collapse-item class="jiantou daxiao">
              <span class="collapse-title" slot="title">大小</span>
              <el-row>
                <el-col :span="3" :offset="1">水平径</el-col>
                <el-col :span="8">
                  <el-input v-model="markData.lbjDaxiaoShuipingjing"></el-input>
                </el-col>
                <el-col :span="3" :offset="1">垂直径</el-col>
                <el-col :span="8">
                  <el-input v-model="markData.lbjDaxiaoCuizhijing"></el-input>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">形状</span>
              <el-row>
                <el-col :offset="2">
                  <el-checkbox v-model="markData.lbjXingzhuangTuoyuan" @change="lbjxingzhuangChange(1)" :true-label="1"
                               :false-label="0">椭圆形
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjXingzhuangLeiyuan" @change="lbjxingzhuangChange(2)" :true-label="1"
                               :false-label="0">类圆形
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjXingzhuangBuguize" @change="lbjxingzhuangChange(3)" :true-label="1"
                               :false-label="0">不规则
                  </el-checkbox>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">边缘</span>
              <el-row>
                <el-col :offset="2">
                  <el-checkbox v-model="markData.lbjXingzhuangBuguize" @change="lbjbianyuanChange(1)" :true-label="1"
                               :false-label="0">边缘不规则
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjBianyuanGuangzheng" @change="lbjbianyuanChange(2)" :true-label="1"
                               :false-label="0">边缘光整
                  </el-checkbox>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">淋巴门</span>
              <el-row class="buju">
                <el-col :offset="2">
                  <el-checkbox v-model="markData.lbjLinbamenZhengchang" @change="lbjlinbamenChange(1)" :true-label="1"
                               :false-label="0">正常
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjLinbamenPianxin" @change="lbjlinbamenChange(2)" :true-label="1"
                               :false-label="0">偏心
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjLinbamenXiaoshi" @change="lbjlinbamenChange(3)" :true-label="1"
                               :false-label="0">消失
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjLinbamenGaohuishengTuankuai" @change="lbjlinbamenChange(4)"
                               :true-label="1" :false-label="0">高回声团块
                  </el-checkbox>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">皮质</span>
              <el-row>
                <el-col :offset="2">
                  <el-checkbox v-model="markData.lbjPizhiJunyunZenghou" @change="lbjpizhiChange(1)" :true-label="1"
                               :false-label="0">均匀增厚
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjPizhiBujunyunZenghou" @change="lbjpizhiChange(2)" :true-label="1"
                               :false-label="0">不均匀增厚
                  </el-checkbox>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">内均质高回声</span>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="markData.lbjNeijunzhiGaohuisheng" :label="1">是</el-radio>
                  <el-radio v-model="markData.lbjNeijunzhiGaohuisheng" :label="0">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">液化</span>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="markData.lbjYehua" :label="1">是</el-radio>
                  <el-radio v-model="markData.lbjYehua" :label="0">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">钙化</span>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="markData.lbjGaihua" :label="1">是</el-radio>
                  <el-radio v-model="markData.lbjGaihua" :label="0">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">血流</span>
              <el-row>
                <el-col :offset="2">
                  <el-checkbox v-model="markData.lbjXueliuZhengchang" @change="lbjxueliuChange(1)" :true-label="1"
                               :false-label="0">正常
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjXueliuMenxing" @change="lbjxueliuChange(2)" :true-label="1"
                               :false-label="0">门型
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjXueliuBianyuanweizhuxing" @change="lbjxueliuChange(3)"
                               :true-label="1" :false-label="0">边缘为主型
                  </el-checkbox>
                  <el-checkbox v-model="markData.lbjXueliuHunhexing" @change="lbjxueliuChange(4)" :true-label="1"
                               :false-label="0">混合型
                  </el-checkbox>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <span class="collapse-title" slot="title">病理结果</span>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="markData.lbjBinglijiegou" :label="1">是</el-radio>
                  <el-radio v-model="markData.lbjBinglijiegou" :label="0">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>
        </el-collapse>
      </div>
      <el-button type="primary" plain class="tijiao" @click="submit">提交</el-button>
    </div>
  </div>
</template>

<script>
import CanvasSelect from "canvas-select";
import {getAnnotateData, updateAnnotateData} from "@/api/medicalData/annotate/index.js";
import {copyFields} from "@/utils/validate.js"

export default {
  name: "Annotate",
  data() {
    return {
      patientAge: "",
      patientSex: '',
      pId: "",
      activeNames: ["1"],
      option: [],
      instance: null,
      instanceStatus: 0,
      labelDisabledState: true,
      selectLabel: "",
      selectShape: null,
      hideNoSelect: false,
      hideName: false,
      imgUrl: "https://gd-hbimg.huaban.com/8938fcf7a544ac3e26e34e9c5cf26f000a09d87eb0fe-fxfdGY",
      location: [],
      histopathologyResults: [],
      markData: {
        jiazhuangxianshizhimiman: null,
        jzxShiFoushuangceexing: null,
        jzxDuofabingzhao: null,
        jzxWeizhiShangji: null,
        jzxWeizhiXiaji: null,
        jzxWeizhiZhongbu: null,
        jzxWeizhiXiabu: null,
        jzxZuZhibingliLiangxing: null,
        jzxZuzhibingliRutouzhuangai: null,
        jzxZuzhibingliSuiyangai: null,
        jzxZuzhibingliLvpaozhuangai: null,
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
        jzxXingzhuangDayuDengyu: null,
        jzxXingzhuangxiaoyu: null,
        jzxBianyuanGuangzheng: null,
        jzxBianyuanBuguize: null,
        jzxBianyuanFenyezhuang: null,
        jzxBianyuanMohu: null,
        jzxBianyuanEte: null,
        jzxBianyuanWufaqueding: null,
        jzxJuzhaoqianghuishengDianzhuang: null,
        jzxJuzhaoqianghuishengCudagaihua: null,
        jzxJuzhaoqianghuishengBianyuangaihua: null,
        jzxJuzhaoqianghuishengHuixingwei: null,
        lbjDaxiaoShuipingjing: null,
        lbjDaxiaoCuizhijing: null,
        lbjXingzhuangTuoyuan: null,
        lbjXingzhuangLeiyuan: null,
        lbjXingzhuangBuguize: null,
        lbjBianyuanGuangzheng: null,
        lbjLinbamenZhengchang: null,
        lbjLinbamenPianxin: null,
        lbjLinbamenXiaoshi: null,
        lbjLinbamenGaohuishengTuankuai: null,
        lbjPizhiJunyunZenghou: null,
        lbjPizhiBujunyunZenghou: null,
        lbjNeijunzhiGaohuisheng: null,
        lbjYehua: null,
        lbjGaihua: null,
        lbjXueliuZhengchang: null,
        lbjXueliuMenxing: null,
        lbjXueliuBianyuanweizhuxing: null,
        lbjXueliuHunhexing: null,
        lbjBinglijiegou: null,
      }
    };
  },
  watch: {
    // option: {
    //   handler(val) {
    //     this.instance.setData(val);
    //   },
    //   deep: true,
    // },
    selectLabel(val) {
      if (!this.labelDisabledState) {
        this.selectShape.label = val;
        this.instance.update();
      }
    },
  },
  methods: {
    weizhiChange(val) {
      console.log(val)
      let arr = ["jzxWeizhiShangji", "jzxWeizhiXiaji", "jzxWeizhiZhongbu", "jzxWeizhiXiabu"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    bingliChange(val) {
      console.log(val)
      let arr = ["jzxZuZhibingliLiangxing", "jzxZuzhibingliRutouzhuangai", "jzxZuzhibingliSuiyangai", "jzxZuzhibingliLvpaozhuangai", "jzxZuzhibingliQitaexing"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    jiegouChange(val) {
      console.log(val)
      let arr = ["jzxNeibujiegouShixing", "jzxNeibujiegouShixingweizhu", "jzxNeibujiegouNangxingweizhu", "jzxNeibujiegouNangshixing", "jzxNeibujiegouHaimianyang", "jzxNeibujiegouNangxing", "jzxNeibujiegouWufapanduan"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    huishengChange(val) {
      console.log(val)
      let arr = ["jzxHuishengGaohuisheng", "jzxHuishengDenghuisheng", "jzxHuishengDihuisheng", "jzxHuishengJidihuisheng", "jzxHuishengWufapanduan"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    jzxxingzhuangChange(val) {
      console.log(val)
      let arr = ["jzxXingzhuangDayuDengyu", "jzxXingzhuangxiaoyu"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    jzxbianyuanChange(val) {
      console.log(val)
      let arr = ["jzxBianyuanGuangzheng", "jzxBianyuanBuguize", "jzxBianyuanFenyezhuang", "jzxBianyuanMohu", "jzxBianyuanEte", "jzxBianyuanWufaqueding"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    lbjxingzhuangChange(val) {
      console.log(val)
      let arr = ["lbjXingzhuangTuoyuan", "lbjXingzhuangLeiyuan", "lbjXingzhuangBuguize"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    lbjlinbamenChange(val) {
      console.log(val)
      let arr = ["lbjLinbamenZhengchang", "lbjLinbamenPianxin", "lbjLinbamenXiaoshi", "lbjLinbamenGaohuishengTuankuai"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    lbjpizhiChange(val) {
      console.log(val)
      let arr = ["lbjPizhiJunyunZenghou", "lbjPizhiBujunyunZenghou"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    lbjxueliuChange(val) {
      console.log(val)
      let arr = ["lbjXueliuZhengchang", "lbjXueliuMenxing", "lbjXueliuBianyuanweizhuxing", "lbjXueliuHunhexing"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    lbjbianyuanChange(val) {
      console.log(val)
      let arr = ["lbjXingzhuangBuguize", "lbjBianyuanGuangzheng"]
      for (let i = 1; i <= arr.length; i++) {
        if (i == val) {
          continue
        }
        ;
        console.log(i)
        this.markData[arr[i - 1]] = 0;
      }
    },
    submit() {
      console.log("点击了提交");
      console.log(
        "甲状腺实质弥漫：" + this.radio1,
        "是否双侧恶性:" + this.radio2,
        "多发病灶(单侧叶):" + this.radio3 + "位置:" + this.location + "组织病理结果:" + this.histopathologyResults + "结节最大径:" + this.input + "内部结构:" + this.radio4 + "回声:" + this.radio5 +
        "形状:" + this.radio6 + "边缘:" + this.radio7 + "局灶强回声:" + this.radio8 + "水平径:" + this.Levelsize + "垂直径:" + this.Verticalsize + "淋巴结病变形状:" + this.radio10 + "淋巴结病变边缘:" + this.radio11 +
        "淋巴门:" + this.radio12 + "皮质:" + this.radio13 + "内均质高回声:" + this.radio14 + "液化:" + this.radio15 + "钙化:" + this.radio16 + "血流:" + this.radio17 + "病理结果:" + this.radio18
      );
      let data = {
        ...this.markData,
        pId: this.pId,
        date: JSON.stringify(this.option)
      }
      return
      updateAnnotateData().then(res => {
        if (res.code == 200) {
          this.$message.success('保存成功')
        } else {
          this.$message.error('保存失败')
        }
      })
    },
    inputs(e) {
    },
    Levelsizes(e) {
    },
    Verticalsizes(e) {
    },
    // 点击下拉框时会触发
    handleChange(val) {
      // console.log(val);
    },
    downImg() {
      // 把canvas转换成图片并下载
      let canvas = document.querySelector(".container");
      let a = document.createElement("a");
      a.href = canvas.toDataURL();
      a.download = "image.png";
      a.click();
    },
    instanceShowName() {
      this.instance.hideLabel = !this.instance.hideLabel;
      this.hideName = this.instance.hideLabel;
      this.instance.update();
    },
    instanceChange(val) {
      console.log(val)
      this.instance.createType = val;
      this.instanceStatus = val;
    },
    instanceFitting() {
      this.instance.fitZoom();
    },
    instanceFocus() {
      this.instance.setFocusMode(!this.instance.focusMode);
      this.hideNoSelect = this.instance.focusMode;
    },
    instanceInit() {
      this.instance = new CanvasSelect(".container", this.imgUrl);
      this.instance.labelMaxLen = 10;
      // this.option = [];
      this.instance.setData(this.option);
      this.instance.on("load", (src) => {
        console.log("图片加载完成", src);
      });
      // 添加
      this.instance.on("add", (info) => {
        console.log("add", info);
        if (!!info) {
          console.log("改变label", info.label);
          this.selectLabel = info.label;
          this.labelDisabledState = false;
        } else {
          this.selectLabel = "";
          this.labelDisabledState = true;
        }
        this.selectShape = info;
        window.info = info;
      });
      // 删除
      this.instance.on("delete", (info) => {
        console.log("delete", info);
        this.selectLabel = "";
        this.labelDisabledState = true;
        window.info = info;
      });
      //更新
      this.instance.on('updated', (result) => {
        console.log('标注结果')
        console.log(result)
        this.option = result;
      });
      // 选中
      this.instance.on("select", (shape) => {
        console.log("select", shape);
        if (!!shape) {
          console.log("改变label", shape.label);
          this.selectLabel = shape.label;
          this.labelDisabledState = false;
        } else {
          this.selectLabel = "";
          this.labelDisabledState = true;
        }
        this.selectShape = shape;
        window.shape = shape;
      });
    },
    canvasResize() {
      let canvasContainer = document.querySelector('.canvasContainer');
      let container = document.querySelector('.container');
      container.style.width = canvasContainer.offsetWidth + 'px';
      container.style.height = canvasContainer.offsetHeight + 'px';
      this.instance.resize();
    },
  },
  mounted() {
    this.pId = this.$route.query.pId;
    console.log("mounted")
    getAnnotateData({pId: this.pId}).then(res => {
      this.patientAge = res.data.age;
      this.patientSex = res.data.gender;
      let serverOption = JSON.parse(res.data.date)
      console.log('请求来的数据')
      console.log(res)
      this.imgUrl = res.data.imgAddress
      this.option = typeof (serverOption) == 'Array' ? serverOption : []
      this.instanceInit();
      copyFields(this.markData, res.data)
    })
    window.onresize = this.canvasResize
  },
  activated() {
    if (this.pId != this.$route.query.pId) {
      this.pId = this.$route.query.pId;
      getAnnotateData({pId: this.pId}).then(res => {
        this.patientAge = res.data.age;
        this.patientSex = res.data.gender;
        let serverOption = JSON.parse(res.data.date)
        console.log('请求来的数据')
        console.log(res)
        copyFields(this.markData, res.data)
        this.imgUrl = res.data.imgAddress
        this.instance.setImage(this.imgUrl)
        this.option = typeof (serverOption) == 'Array' ? serverOption : []
        this.instance.setData(this.option)
      })
    }
  }
};
</script>

<style scoped lang="scss">
div {
  box-sizing: border-box;
}

.leftVertical {
  position: relative;
}

.leftVertical::after {
  content: "";
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  left: 0;
  border-radius: 2px;
}

.leftBlue::after {
  background-color: #409eff;
  width: 5px;
  height: 40%;
  left: 2px;
}

.leftAsh::after {
  background-size: #ddd;
  width: 2px;
  height: 80%;
}

.pageBox {
  width: 100%;
  height: calc(100vh - 84px); // 60px是头部高度
  position: relative;
  display: flex;
}

.canvasBox {
  width: 75%;
  min-height: 100%;
  display: flex;
  flex-direction: column;
}

//.canvasTool {
//  width: 100%;
//  height: 84px;
//  border: 1px solid black;
//  display: flex;
//  padding: 0 10px;
//  justify-content: space-around;
//  flex-direction: column;
//}

.canvasContainer {
  position: relative;
  width: 100%;
  height: 100%;
  flex: 1;
  border: 1px solid black;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

.canvasTool {
  position: absolute;
  z-index: 11;

  ::v-deep .el-button {
    height: 100%;
    width: 100%;
  }

  .icon {
    margin-right: 6px;
  }

  box-shadow: 0px 0px 10px #eee;
}

.switchShow {
  left: 24px;
  top: 24px;
  height: 36px;
  width: 140px;
}

.selectTool {
  right: 24px;
  top: 24px;
  height: 36px;
  width: 180px;

  ::v-deep .el-select {
    height: 100%;
    width: 100%;
  }
}

.tagName {
  height: 36px;
  width: 140px;
  left: 24px;
  top: 86px;

  ::v-deep .el-input {
    height: 100%;
    width: 100%;
  }
}

.testbtn {
  height: 36px;
  width: 140px;
  left: 24px;
  bottom: 24px;
}

.resetBtn {
  bottom: 24px;
  right: 24px;
  height: 36px;
  width: 140px;
}

.container {
  width: 100%;
  height: 100%;
  position: relative;
}

.controllerBox {
  height: calc(100vh - 84px);
  width: 25%;
  background-color: #fff;
  padding: 0 20px;
  overflow-x: hidden;
}

.instanceName {
  width: 200px;
}

.patientInfo {
  margin: 1.5vh 0;
}


.box1 {
  display: flex;

  p {
    // height: 40px;
    line-height: 4vh;
    margin: 0;
    margin-left: 1vw;
  }
}

.message {
  margin: 1.5vh 0;
  display: flex;
  text-align: center;
  line-height: 3.5vh;
}

.message div {
  vertical-align: middle;
}

.message div:nth-child(odd) {
  width: 20vw;
}

.message div:nth-child(even) {
  width: 30vw;
  background-color: #f8f8f8;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}

.el-icon-arrow-down {
  font-size: 12px;
}

::v-deep .el-collapse-item__content {
  padding-bottom: 0;
  line-height: 2.769231;
}

::v-deep .el-collapse-item__header {
  background-color: #f2f6fe;
}

.thyroid-box {
  height: 48px;
  display: flex;
  padding-left: 50px;

  &-title {
    //文字不换行
    white-space: nowrap;
  }

  &-input {
    margin: 0 16px;
  }
}

.thyroid ::v-deep .el-collapse-item__header {
  background-color: #ffffff;
  border-bottom: 0px solid;
}

.thyroid ::v-deep .el-collapse-item__arrow {
  width: 30px;
  padding-left: 12px;
}

::v-deep .collapse-title {
  flex: 1 0 90%;
  order: 1;
  padding-left: 12px;
  position: relative;

  &::after {
    content: '';
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    left: 0px;
    width: 1px;
    height: 50%;
    background-color: #ddd;
  }

  .el-collapse-item__header {
    flex: 1 0 auto;
    order: -1;
  }
}

::v-deep .el-row {
  background-color: #f4f4f4;
}

.el-collapse-item__content {
  line-height: 2.769231;
}

::v-deep .el-checkbox__label {
  font-size: 12px;
  padding-left: 8px;
}

::v-deep .el-radio__label {
  font-size: 12px;
  padding-left: 8px;
}

.el-checkbox-group ::v-deep .el-col {
  text-align: center;
}

::v-deep .el-radio__inner {
  border-radius: 5px;
}

::v-deep .buju {
  display: flex;
  flex-wrap: wrap;
}

::v-deep .el-collapse-item__header {
  position: relative;
}

// ::v-deep .el-collapse-item__header{
//   &:before {
//           border: solid 1px black;
//           height: 5px;
//           width: 2px;
//         }
// }

// ::v-deep .el-icon-arrow-right ::
::v-deep .xialakuang {
  border-radius: 5px;
  overflow: hidden;
}

::v-deep .el-collapse {
  border-top: 0px solid #e6ebf5;
  border-bottom: 0px solid #e6ebf5;
}

.daxiao ::v-deep .el-col-offset-2 {
  margin-left: 11px;

}

.large-title {
  padding-left: 1.5vw;
}

.daxiao ::v-deep .el-input {
  width: 74%;
}

::v-deep .tijiao {
  margin: 5px 0 5px 0;
}

.content1 {
  box-shadow: #eee 0px 0px 10px;
}

.jiantou ::v-deep .el-icon-arrow-right:before {
  content: "\e791"
}

</style>
