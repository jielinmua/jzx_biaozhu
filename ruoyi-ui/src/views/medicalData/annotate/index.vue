<template>
  <div class="pageBox">
    <div class="canvasBox">
      <div class="canvasTool">
        <div class="canvasToolUp">
          <el-button
            @click="instanceChange(1)"
            :type="instanceStatus == 1 ? 'primary' : ''"
            >方形</el-button
          >
          <el-button
            @click="instanceChange(2)"
            :type="instanceStatus == 2 ? 'primary' : ''"
            >自定义</el-button
          >
          <el-button
            @click="instanceChange(3)"
            :type="instanceStatus == 3 ? 'primary' : ''"
            >点</el-button
          >
          <el-button
            @click="instanceChange(4)"
            :type="instanceStatus == 4 ? 'primary' : ''"
            >线</el-button
          >
          <el-button
            @click="instanceChange(5)"
            :type="instanceStatus == 5 ? 'primary' : ''"
            >圆</el-button
          >
          <el-button
            @click="instanceChange(0)"
            :type="instanceStatus == 0 ? 'primary' : ''"
            >选中</el-button
          >
          <el-button @click="instanceFitting">重置图片位置</el-button>
          <el-button
            @click="instanceFocus"
            :type="hideNoSelect ? 'primary' : ''"
            >隐藏未选中</el-button
          >
          <el-button @click="instanceShowName" :type="hideName ? 'primary' : ''"
            >隐藏标记名称</el-button
          >
          <el-button @click="downImg">下载</el-button>
        </div>
        <div class="canvasToolDown">
          名称:
          <el-input
            type="text"
            v-model="selectLabel"
            :disabled="labelDisabledState"
            class="instanceName"
          />
        </div>
      </div>
      <div class="canvasContainer">
        <canvas class="container"></canvas>
      </div>
    </div>

    <div class="controllerBox">
      <div class="patientInfo">
        <div class="box1">
          <span></span>
          <p>基本信息</p>
        </div>
        <div class="message">
          <div>年龄</div>
          <div>24</div>
          <div>性别</div>
          <div>男</div>
        </div>
      </div>

      <div class="content1">
        <div class="box1" style="margin: 0 0 1.5vh 0">
          <span></span>
          <p>甲状腺病变</p>
        </div>
        <el-collapse
          v-model="activeNames"
          @change="handleChange"
          class="xialakuang"
        >
          <el-collapse-item>
            <template slot="title"> 总体情况描述 </template>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">甲状腺实质弥漫</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio1" label="1">是</el-radio>
                    <el-radio v-model="radio1" label="2">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">是否双侧恶性</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio2" label="1">是</el-radio>
                    <el-radio v-model="radio2" label="2">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">多发病灶(单侧叶)</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio3" label="1">是</el-radio>
                    <el-radio v-model="radio3" label="2">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid Fouritems">
              <el-collapse-item class="jiantou">
                <template slot="title">位置</template>
                <el-row>
                  <el-checkbox-group v-model="location">
                    <el-col :span="6">
                      <el-checkbox label="up">上极</el-checkbox>
                    </el-col>
                    <el-col :span="6">
                      <el-checkbox label="down">下极</el-checkbox>
                    </el-col>
                    <el-col :span="6">
                      <el-checkbox label="central">中部</el-checkbox>
                    </el-col>
                    <el-col :span="6">
                      <el-checkbox label="isthmus">峡部</el-checkbox>
                    </el-col>
                  </el-checkbox-group>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid duoxuan">
              <el-collapse-item class="jiantou">
                <template slot="title">组织病理结果</template>
                <el-row>
                  <el-col :offset="2">
                    <el-checkbox-group v-model="histopathologyResults">
                      <!-- <el-col :span="6"> -->
                      <el-checkbox label="up">良性</el-checkbox>
                      <!-- </el-col>
                      <el-col :span="6"> -->
                      <el-checkbox label="down">乳头状癌</el-checkbox>
                      <!-- </el-col>
                      <el-col :span="6"> -->
                      <el-checkbox label="central">髓样癌</el-checkbox>
                      <!-- </el-col>
                      <el-col :span="6"> -->
                      <el-checkbox label="isthmus">滤泡状癌</el-checkbox>
                      <!-- </el-col>
                      <el-col :span="6"> -->
                      <el-checkbox label="more">其他恶性</el-checkbox>
                      <!-- </el-col> -->
                    </el-checkbox-group>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>
            <!-- ===================================================================================== -->
            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">结节最大径</template>
                <el-row>
                  <el-col>
                    <el-input
                      placeholder="单位（cm）"
                      v-model="input"
                      clearable
                      @blur="inputs($event)"
                    >
                    </el-input>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>
          </el-collapse-item>

          <el-collapse-item>
            <template slot="title"> 结构描述 </template>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">内部结构</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio4" label="1">是</el-radio>
                    <el-radio v-model="radio4" label="2">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">回声</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio5" label="1">是</el-radio>
                    <el-radio v-model="radio5" label="2">否</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">形状</template>
                <el-row>
                  <el-col :offset="2">
                    <el-radio v-model="radio6" label="1">纵横比≥1</el-radio>
                    <el-radio v-model="radio6" label="2">{{
                      "纵横比<1"
                    }}</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">边缘</template>
                <el-row>
                  <el-col :offset="2" :span="20">
                    <el-radio v-model="radio7" label="1">边缘光整</el-radio>
                    <el-radio v-model="radio7" label="2">边缘不规则</el-radio>
                    <el-radio v-model="radio7" label="3">边缘分叶状</el-radio>
                    <el-radio v-model="radio7" label="4">边缘模糊</el-radio>
                    <el-radio v-model="radio7" label="5">ETE</el-radio>
                    <el-radio v-model="radio7" label="5">无法确定</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>

            <div class="thyroid">
              <el-collapse-item class="jiantou">
                <template slot="title">局灶强回声</template>
                <el-row>
                  <el-col :offset="2" :span="20">
                    <el-radio v-model="radio8" label="1">点状强回声</el-radio>
                    <el-radio v-model="radio8" label="2">粗大钙化</el-radio>
                    <el-radio v-model="radio8" label="3">边缘钙化</el-radio>
                    <el-radio v-model="radio8" label="4">彗星尾</el-radio>
                  </el-col>
                </el-row>
              </el-collapse-item>
            </div>
          </el-collapse-item>
        </el-collapse>

        <!-- <el-row>
          <el-col :span="10" :offset="1">总体情况描述：</el-col>
        </el-row>
        <el-row>
          <el-col :span="10" :offset="2">甲状腺实质弥漫：</el-col>
        </el-row>
        <el-row>
          <el-col :span="10" :offset="2">是否双侧恶性：</el-col>
        </el-row>

        <el-row>
          <el-col :offset="4">
            <el-radio v-model="radio9" label="1">是</el-radio>
            <el-radio v-model="radio9" label="2">否</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10" :offset="2">多发病灶(单侧叶)：</el-col>
        </el-row>

        <el-row>
          <el-col :span="10" :offset="2">位置：</el-col>
        </el-row>
        <el-row>
          <el-col :span="20" :offset="4">
            <el-checkbox-group v-model="location">
              <el-checkbox label="up">上极</el-checkbox>
              <el-checkbox label="down">下极</el-checkbox>
              <el-checkbox label="central">中部</el-checkbox>
              <el-checkbox label="isthmus">峡部</el-checkbox>
            </el-checkbox-group>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="10" :offset="2">组织病理结果：</el-col>
        </el-row>
        <el-row>
          <el-col :span="20" :offset="4">
            <el-checkbox-group v-model="histopathologyResults">
              <el-checkbox label="up">良性</el-checkbox>
              <el-checkbox label="down">乳头状癌</el-checkbox>
              <el-checkbox label="central">髓样癌</el-checkbox>
              <el-checkbox label="isthmus">滤泡状癌</el-checkbox>
              <el-checkbox label="more">其他恶性</el-checkbox>
            </el-checkbox-group>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="2">结节最大径：</el-col>
        </el-row> -->
      </div>

      <div class="content1">
        <div class="box1" style="margin: 1.5vh 0 0 0">
          <span></span>
          <p>淋巴结病变</p>
        </div>
        <el-collapse v-model="activeNames" @change="handleChange">
          <div class="thyroid">
            <el-collapse-item class="jiantou daxiao">
              <template slot="title">大小</template>
              <el-row>
                <el-col :offset="2">
                  <!-- <el-radio v-model="radio9" label="1">水平径</el-radio>
                  <el-radio v-model="radio9" label="2">垂直径</el-radio> -->
                  <div>
                    水平径:
                  <el-input
                      placeholder="（单位cm）"
                      v-model="Levelsize "
                      clearable
                      @blur="Levelsizes($event)"
                    >
                    </el-input>
                  </div>
                  <div>
                    垂直径:
                    <el-input
                      placeholder="（单位cm）"
                      v-model="Verticalsize"
                      clearable
                      @blur="Verticalsizes($event)"
                    >
                    </el-input>
                  </div>
                    
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">形状</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio10" label="1">椭圆形</el-radio>
                  <el-radio v-model="radio10" label="2">类圆形</el-radio>
                  <el-radio v-model="radio10" label="3">不规则</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">边缘</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio11" label="1">边缘不规则</el-radio>
                  <el-radio v-model="radio11" label="2">边缘光整</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">淋巴门</template>
              <el-row class="buju">
                <el-col :offset="2">
                  <el-radio v-model="radio12" label="1">正常</el-radio>
                  <el-radio v-model="radio12" label="2">偏心</el-radio>
                  <el-radio v-model="radio12" label="3">消失</el-radio>
                  <el-radio v-model="radio12" label="4">高回声团块</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">皮质</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio13" label="1">均匀增厚</el-radio>
                  <el-radio v-model="radio13" label="2">不均匀增厚</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">内均质高回声</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio14" label="1">是</el-radio>
                  <el-radio v-model="radio14" label="2">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">液化</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio15" label="1">是</el-radio>
                  <el-radio v-model="radio15" label="2">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">钙化</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio16" label="1">是</el-radio>
                  <el-radio v-model="radio16" label="2">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">血流</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio17" label="1">正常</el-radio>
                  <el-radio v-model="radio17" label="2">门型</el-radio>
                  <el-radio v-model="radio17" label="3">边缘为主型</el-radio>
                  <el-radio v-model="radio17" label="4">混合型</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>

          <div class="thyroid">
            <el-collapse-item class="jiantou">
              <template slot="title">病理结果</template>
              <el-row>
                <el-col :offset="2">
                  <el-radio v-model="radio18" label="1">是</el-radio>
                  <el-radio v-model="radio18" label="2">否</el-radio>
                </el-col>
              </el-row>
            </el-collapse-item>
          </div>
        </el-collapse>
      </div>

      
            <el-button type="primary" plain class="tijiao" @click="submit">提交</el-button>
          
      <!-- <div class="content2">
        <el-row>
          <el-col :offset=1>结节描述：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">内部结构：</el-col>
        </el-row>
        <el-row>

        </el-row>
        <el-row>
          <el-col :offset="2">回声：</el-col>
        </el-row>
        <el-row>

        </el-row>
        <el-row>
          <el-col :offset="2">形状：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="4">
            <el-radio v-model="radio1" label="1">纵横比>1</el-radio>
            <el-radio v-model="radio1" label="2">{{ '纵横比<1' }}</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">边缘：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="4" :span="20">
            <el-radio v-model="radio2" label="1">边缘光整</el-radio>
            <el-radio v-model="radio2" label="2">边缘不规则</el-radio>
            <el-radio v-model="radio2" label="3">边缘分叶状</el-radio>
            <el-radio v-model="radio2" label="4">边缘模糊</el-radio>
            <el-radio v-model="radio2" label="5">ETE</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=2>局灶强回声：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="4" :span="20">
            <el-radio v-model="radio3" label="1">点状强回声</el-radio>
            <el-radio v-model="radio3" label="2">粗大钙化</el-radio>
            <el-radio v-model="radio3" label="3">边缘钙化</el-radio>
            <el-radio v-model="radio3" label="4">彗星尾</el-radio>
          </el-col>
        </el-row>
      </div>
      <div class="content3">
        <el-row>
          <el-col>淋巴结病变：</el-col>
        </el-row>
        <el-row>
          <el-col :span="4" :offset="1">大小：</el-col>
        </el-row>
        <el-row>

        </el-row>
        <el-row>
          <el-col :offset="1">形状：</el-col>
        </el-row>
        <el-row>
          <el-col :offset=2>
            <el-radio v-model="radio4" label="1">椭圆形</el-radio>
            <el-radio v-model="radio4" label="2">类圆形</el-radio>
            <el-radio v-model="radio4" label="3">不规则</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset="1">边缘：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio5" label="1">边缘不规则</el-radio>
            <el-radio v-model="radio5" label="2">边缘光整</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset="1">淋巴门：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio6" label="1">正常</el-radio>
            <el-radio v-model="radio6" label="2">偏心</el-radio>
            <el-radio v-model="radio6" label="3">消失</el-radio>
            <el-radio v-model="radio6" label="4">高回声团块</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>皮质：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio7" label="1">均匀增厚</el-radio>
            <el-radio v-model="radio7" label="2">不均匀增厚</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>内均质高回声：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio9" label="1">是</el-radio>
            <el-radio v-model="radio9" label="2">否</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>液化：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio9" label="1">是</el-radio>
            <el-radio v-model="radio9" label="2">否</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>钙化：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio9" label="1">是</el-radio>
            <el-radio v-model="radio9" label="2">否</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>血流：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio8" label="1">正常</el-radio>
            <el-radio v-model="radio8" label="2">门型</el-radio>
            <el-radio v-model="radio8" label="3">边缘为主型</el-radio>
            <el-radio v-model="radio8" label="4">混合型</el-radio>
          </el-col>
        </el-row>
        <el-row>
          <el-col :offset=1>病理结果：</el-col>
        </el-row>
        <el-row>
          <el-col :offset="2">
            <el-radio v-model="radio9" label="1">是</el-radio>
            <el-radio v-model="radio9" label="2">否</el-radio>
          </el-col>
        </el-row>
      </div>
      <div class="content4">
        <el-row>
          <el-col :offset=2 :span="6">
            <el-button type="primary" plain>提交</el-button>
          </el-col>
        </el-row>
      </div> -->
    </div>
  </div>
</template>

<script>
import CanvasSelect from "canvas-select";
export default {
  name: "annotate",
  data() {
    return {
      activeNames: ["1"],
      option: [
        {
          label: "acbs",
          coor: [
            [184, 183],
            [275, 238],
          ],
          active: false,
          creating: false,
          dragging: false,
          uuid: "c50e3f69-8e1e-441b-90ae-c362b63797bf",
          index: 0,
          labelFillStyle: "#f00",
          textFillStyle: "#fff",
          fillStyle: "rgba(130,22,220,.6)",
          type: 1,
        },
        {
          label: "polygon",
          coor: [
            [135, 291],
            [129, 319],
            [146, 346],
            [174, 365],
            [214, 362],
            [196, 337],
            [161, 288],
          ],
          active: false,
          creating: false,
          dragging: false,
          uuid: "f3143c91-4922-4a4f-959e-e649cd89607f",
          index: 1,
          type: 2,
        },
        {
          label: "dot",
          coor: [345, 406],
          active: false,
          creating: false,
          dragging: false,
          uuid: "ae227dcd-abfb-43eb-b272-9abf39ff0722",
          index: 2,
          type: 3,
        },
        {
          label: "line",
          coor: [
            [456, 153],
            [489, 228],
            [492, 296],
          ],
          active: false,
          creating: false,
          dragging: false,
          uuid: "2ca7f0a6-e849-45a2-802f-fad95ebadda3",
          index: 3,
          type: 4,
        },
        {
          label: "circle",
          coor: [369, 197],
          active: false,
          creating: false,
          dragging: false,
          uuid: "da0bc425-4b9e-4521-85f8-5ee422db0d58",
          index: 4,
          radius: 38,
          type: 5,
        },
      ],
      instance: null,
      instanceStatus: 0,
      labelDisabledState: true,
      selectLabel: "",
      selectShape: null,
      hideNoSelect: false,
      hideName: false,
      imgUrl:
        "https://gd-hbimg.huaban.com/8938fcf7a544ac3e26e34e9c5cf26f000a09d87eb0fe-fxfdGY",
        // 水平大小
      Levelsize:'',
      // 垂直大小
      Verticalsize:'',
      // 结节最大径
      input: "",
      location: [],
      histopathologyResults: [],
      radio1: "",
      radio2: "",
      radio3: "",
      radio4: "",
      radio5: "",
      radio6: "",
      radio7: "",
      radio8: "",
      radio9: "",
      radio10: "",
      radio11: "",
      radio12: "",
      radio13: "",
      radio14: "",
      radio15: "",
      radio16: "",
      radio17: "",
      radio18: "",
    };
  },
  watch: {
    option: {
      handler(val) {
        this.instance.setData(val);
      },
      deep: true,
    },
    selectLabel(val) {
      if (!this.labelDisabledState) {
        this.selectShape.label = val;
        this.instance.update();
      }
    },
  },
  methods: {
    submit(){
      console.log("点击了提交");
      console.log(
       "甲状腺实质弥漫："+ this.radio1,
"是否双侧恶性:"+this.radio2,
"多发病灶(单侧叶):"+this.radio3 + "位置:"+this.location+"组织病理结果:"+this.histopathologyResults+"结节最大径:"+this.input+"内部结构:"+this.radio4+"回声:"+this.radio5+
"形状:"+this.radio6+"边缘:"+this.radio7+"局灶强回声:"+this.radio8+"水平径:"+this.Levelsize+"垂直径:"+this.Verticalsize+"淋巴结病变形状:"+this.radio10+"淋巴结病变边缘:"+this.radio11+
"淋巴门:"+this.radio12+"皮质:"+this.radio13+"内均质高回声:"+this.radio14+"液化:"+this.radio15+"钙化:"+this.radio16+"血流:"+this.radio17+"病理结果:"+this.radio18
      );
    },
    inputs(e){
      let value = e.target.value;
      if (isNaN(value)|| value > 50 || value < 0) {
        this.input = ''; // 清空输入框的值
        this.$message.error('请输入正确的数字（0-50之间）'); // 提示用户输入数字
      }
    },
    Levelsizes(e){
      let value = e.target.value;
      if (isNaN(value)|| value > 50 || value < 0) {
        this.Levelsize = ''; // 清空输入框的值
        this.$message.error('请输入正确的数字（0-50之间）'); // 提示用户输入数字
      }
    },
    Verticalsizes(e){
      let value = e.target.value;
      if (isNaN(value)|| value > 50 || value < 0) {
        this.Verticalsize = ''; // 清空输入框的值
        this.$message.error('请输入正确的数字（0-50之间）'); // 提示用户输入数字
      }
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
      this.instance.on("updated", (result) => {
        // console.log('标注结果', result)
        const list = [...result];
        list.sort((a, b) => a.index - b.index);
        this.option = JSON.stringify(list, null, 2);
      });
    },
  },
  mounted() {
    this.instance = new CanvasSelect(".container", this.imgUrl);
    this.instanceInit();
  },
};
</script>

<style scoped lang="scss">
div {
  box-sizing: border-box;
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

.canvasTool {
  width: 100%;
  height: 84px;
  border: 1px solid black;
  display: flex;
  padding: 0 10px;
  justify-content: space-around;
  flex-direction: column;
}

.canvasContainer {
  width: 100%;
  flex: 1;
  border: 1px solid black;
  background-color: #ffcc99;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

.container {
  width: 100%;
  height: 100%;
  position: relative;
}

.controllerBox {
  height: calc(100vh - 84px);
  width: 25%;
  background-color: #ffffff;
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
  span {
    width: 6px;
    background-color: #00afff;
  }
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
  padding-left: 1.5vw;
  background-color: #f2f6fe;
}
// ::v-deep .biaoti{
//   padding-left: 1.5vw;
//   background-color: #F2F6FE;
//   width: 100%;
// }
::v-deep .el-collapse-item__wrap {
  // border: 1px solid red;
}
// ::v-deep .is-active{
//   // background-color: #FFFFFF;
// }
.thyroid ::v-deep .el-collapse-item__header {
  background-color: #ffffff;
  border-bottom: 0px solid;
  padding-left: 1.5vw;
}
::v-deep .el-row {
  background-color: #f4f4f4;
}
// .Fouritems ::v-deep .el-col{
//   text-align: center;
// }
// .duoxuan ::v-deep .el-col{
//   text-align: center;

// }
// ::v-deep .el-checkbox__label{
//   padding-left: 6px;
//   font-size: 13px;
// }
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

::v-deep .jiantou {
  position: relative;
  top: 0;
}
.jiantou ::v-deep {
  position: relative;
  top: 0;
}
.jiantou ::v-deep .el-collapse-item__arrow {
  position: absolute;
  left: 5px;
}
// ::v-deep .el-collapse-item__header{
//   &:before {
//           border: solid 1px black;
//           height: 5px;
//           width: 2px;
//         }
// }
.thyroid ::v-deep .el-collapse-item__header:before {
  content: "";
  border: solid 1px #dadada;
  // height: 10px;
  height: 40%;
  width: 1px;
  margin-right: 1vw;
  margin-left: 0.5vw;
}
// ::v-deep .el-icon-arrow-right ::
::v-deep .xialakuang {
  border-radius: 5px;
  overflow: hidden;
}
::v-deep .el-collapse {
    border-top: 0px solid #e6ebf5; 
    border-bottom: 0px solid #e6ebf5; 
}
.daxiao ::v-deep .el-col-offset-2{
  margin-left:11px;

}
.daxiao ::v-deep .el-input{
  width: 74%;
}
::v-deep .tijiao{
  margin: 5px 0 5px 0;
}
</style>
