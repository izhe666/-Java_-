<template>
	<view>

		<!-- 插入表单 -->
		<uni-forms ref="valiForm" :rules="rules" :modelValue="CL10Data" style="margin-top: 5px;" label-position="top"
			label-width="300px">
			<uni-section title="基本信息" type="circle">
				<view class="example-body">
					<uni-row class="demo-uni-row">
						<uni-col>
							<uni-forms-item label="工程名称" name="gcmc" required>
								<uni-easyinput type="text" v-model="CL10Data.gcmc" placeholder="请输入工程名称" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="记录编号" name="jlbh" required>
								<uni-easyinput type="text" v-model="CL10Data.jlbh" placeholder="请输入记录编号" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="检测单位" name="jcdwmc" required>
								<uni-easyinput type="text" v-model="CL10Data.jcdwmc" placeholder="请输入检测单位" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="施工单位" name="sgdw" required>
								<uni-easyinput type="text" v-model="CL10Data.sgdw" placeholder="请输入施工单位" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="监理单位" name="jldw" required>
								<uni-easyinput type="text" v-model="CL10Data.jldw" placeholder="请输入监理单位" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="合同段" name="htd" required>
								<uni-easyinput type="text" v-model="CL10Data.htd" placeholder="请输入合同段" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="工程部位/用途" name="gcbw_yt">
								<uni-easyinput type="text" v-model="CL10Data.gcbw_yt" placeholder="请输入工程部位/用途" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="样品信息" name="ypxx">
								<uni-easyinput type="text" v-model="CL10Data.ypxx" placeholder="请输入样品信息" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="采集人员编号" name="userid" required>
								<uni-easyinput type="text" v-model="CL10Data.userid" placeholder="请输入采集人员编号" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="采集地点" name="position">
								<uni-easyinput type="text" v-model="CL10Data.position" placeholder="请输入采集地点" />
							</uni-forms-item>
						</uni-col>


					</uni-row>
				</view>
			</uni-section>

			<uni-section title="沥青信息" type="circle">
				<view class="example-body">
					<uni-row class="demo-uni-row">
						<uni-col>
							<uni-forms-item label="沥青种类" name="lqzl">
								<uni-easyinput type="text" v-model="CL10Data.lqzl" placeholder="请输入沥青种类" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="沥青标号" name="lqbh">
								<uni-easyinput type="text" v-model="CL10Data.lqbh" placeholder="请输入沥青标号" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="生产厂家" name="sccj">
								<uni-easyinput type="text" v-model="CL10Data.sccj" placeholder="请输入生产厂家" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="生产批号" name="scph">
								<uni-easyinput type="text" v-model="CL10Data.scph" placeholder="请输入生产批号" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="生产日期" name="scrq">
								<uni-datetime-picker type="date" v-model="CL10Data.scrq" return-type="timestamp"
									placeholder="请选择生产日期" />
							</uni-forms-item>
						</uni-col>
					</uni-row>
				</view>
			</uni-section>



			<uni-section title="试验信息" type="circle">
				<view class="example-body">
					<uni-row class="demo-uni-row">

						<uni-col>
							<uni-forms-item label="试验检测日期" name="syjcrq" required>
								<uni-datetime-picker type="date" v-model="CL10Data.syjcrq" return-type="timestamp"
									placeholder="请选择试验检测日期" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="试验条件：摄氏度" name="sytj_ssd">
								<uni-easyinput v-model="CL10Data.sytj_ssd" placeholder="请输入试验条件：摄氏度" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="试验条件：相对湿度" name="sytj_xdsd">
								<uni-easyinput v-model="CL10Data.sytj_xdsd" placeholder="试验条件：相对湿度" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="检测依据" name="jcyj">
								<uni-easyinput type="text" v-model="CL10Data.jcyj" placeholder="请输入检测依据" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="判定依据" name="pdyj">
								<uni-easyinput type="text" v-model="CL10Data.pdyj" placeholder="请输入判定依据" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="主要仪器设备名称及编号" name="zyyqsbmcjbh">
								<uni-easyinput type="text" v-model="CL10Data.zyyqsbmcjbh"
									placeholder="请输入主要仪器设备名称及编号" />
							</uni-forms-item>
						</uni-col>
					</uni-row>
				</view>
			</uni-section>

			<uni-section title="第一次试验" type="line">
				<view class="example-body">
					<uni-row class="demo-uni-row">

						<uni-col>
							<uni-forms-item label="古氏坩埚与玻璃纤维滤纸合计质量(g)" name="m1">
								<uni-easyinput type="number" v-model="CL10Data.m1"
									placeholder="请输入古氏坩埚与玻璃纤维滤纸合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶与玻璃棒合计质量(g)" name="m2">
								<uni-easyinput type="number" v-model="CL10Data.m2" placeholder="请输入锥形瓶与玻璃棒合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶、玻璃棒与沥青试样合计质量(g)" name="m3">
								<uni-easyinput type="number" v-model="CL10Data.m3"
									placeholder="请输入锥形瓶、玻璃棒与沥青试样合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" name="m4">
								<uni-easyinput type="number" v-model="CL10Data.m4"
									placeholder="请输入古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" name="m5">
								<uni-easyinput type="number" v-model="CL10Data.m5"
									placeholder="请输入锥形瓶、玻璃棒与黏附不溶物合计质量(g)" />
							</uni-forms-item>
						</uni-col>
					</uni-row>
				</view>
			</uni-section>


			<uni-section title="第二次试验" type="line">
				<view class="example-body">
					<uni-row class="demo-uni-row">
						<uni-col>
							<uni-forms-item label="古氏坩埚与玻璃纤维滤纸合计质量(g)" name="a1">
								<uni-easyinput type="number" v-model="CL10Data.a1"
									placeholder="请输入古氏坩埚与玻璃纤维滤纸合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶与玻璃棒合计质量(g)" name="a2">
								<uni-easyinput type="number" v-model="CL10Data.a2" placeholder="请输入锥形瓶与玻璃棒合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶、玻璃棒与沥青试样合计质量(g)" name="a3">
								<uni-easyinput type="number" v-model="CL10Data.a3"
									placeholder="请输入锥形瓶、玻璃棒与沥青试样合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" name="a4">
								<uni-easyinput type="number" v-model="CL10Data.a4"
									placeholder="请输入古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" />
							</uni-forms-item>
						</uni-col>

						<uni-col>
							<uni-forms-item label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" name="a5">
								<uni-easyinput type="number" v-model="CL10Data.a5"
									placeholder="请输入锥形瓶、玻璃棒与黏附不溶物合计质量(g)" />
							</uni-forms-item>
						</uni-col>

					</uni-row>
				</view>
			</uni-section>

			<uni-section title="其它" type="line">
				<view class="example-body">
					<uni-row class="demo-uni-row">

						<uni-col>
							<uni-forms-item label="附加声明" name="fjsm">
								<uni-easyinput type="text" v-model="CL10Data.fjsm" placeholder="请输入附加声明" />
							</uni-forms-item>
						</uni-col>

					</uni-row>
				</view>
			</uni-section>
		</uni-forms>
		<button @click="submit('valiForm')" type="primary">提交</button>
	</view>
</template>

<script>
	import {
		addCL10
	} from '@/api/class224/CL10';

	export default {
		data() {
			return {
				CL10Data: {

				},
				valiFormData: {
					jlbh: '',
					gcmc: '',
					sgdw: '',
					jldw: '',
					jcdwmc: '',
					htd: '',
					userid: '',
					a1: 0,
					a2: 0,
					a3: 0,
					a4: 0,
					a5: 0,
					m1: 0,
					m2: 0,
					m3: 0,
					m4: 0,
					m5: 0,
				},
				// 校验规则
				rules: {
					jcdwmc: {
						rules: [{
							required: true,
							errorMessage: '检测单位不能为空'
						}]
					},
					syjcrq: { //试验检测日期
						rules: [{
							required: true,
							errorMessage: '试验检测日期不能为空'
						}, {
							validateFunction: function(rule, value, CL10Data, callback) {
								if (value < CL10Data.scrq) {
									callback('试验检测日期不能早于沥青生产日期')
								}
								return true
							}
						}]
					},

					jlbh: {
						/* 记录编号 */
						rules: [{
							required: true,
							errorMessage: '记录编号不能为空'
						}]
					},
					jcdwmc: {
						/* 检测单位名称 */
						rules: [{
							required: true,
							errorMessage: '检测单位名称不能为空'
						}]
					},
					gcmc: {
						/* 工程名称 */
						rules: [{
							required: true,
							errorMessage: '工程名称不能为空'
						}]
					},
					htd: {
						/* 合同段 */
						rules: [{
							required: true,
							errorMessage: '合同段不能为空'
						}]
					},
					sgdw: {
						/* 施工单位 */
						rules: [{
							required: true,
							errorMessage: '施工单位不能为空'
						}]
					},
					jldw: {
						/* 监理单位 */
						rules: [{
							required: true,
							errorMessage: '监理单位不能为空'
						}]
					},
					gcbw_yt: {
						/* 工程部位/用途 */
						rules: [{
							required: true,
							errorMessage: '工程部位/用途不能为空'
						}]
					},
					ypxx: {
						/* 样品信息 */
						rules: [{
							required: true,
							errorMessage: '样品信息不能为空'
						}]
					},
					fjsm: {
						/* 附加声明 */
						rules: [{
							required: true,
							errorMessage: '附加声明不能为空'
						}]
					},
					sytj_ssd: {
						/* 试验条件：摄氏度 */
						rules: [{
							required: true,
							errorMessage: '试验条件：摄氏度不能为空'
						}]
					},
					sytj_xdsd: {
						/* 试验条件：相对湿度 */
						rules: [{
							required: true,
							errorMessage: '试验条件：相对湿度不能为空'
						}]
					},
					jcyj: {
						/* 检测依据 */
						rules: [{
							required: true,
							errorMessage: '检测依据不能为空'
						}]
					},
					pdyj: {
						/* 判定依据 */
						rules: [{
							required: true,
							errorMessage: '判定依据不能为空'
						}]
					},
					zyyqsbmcjbh: {
						/* 主要仪器设备名称及编号 */
						rules: [{
							required: true,
							errorMessage: '主要仪器设备名称及编号不能为空'
						}]
					},
					lqzl: {
						/* 沥青种类 */
						rules: [{
							required: true,
							errorMessage: '沥青种类不能为空'
						}]
					},
					lqbh: {
						/* 沥青标号 */
						rules: [{
							required: true,
							errorMessage: '沥青标号不能为空'
						}]
					},
					sccj: {
						/* 生产厂家 */
						rules: [{
							required: true,
							errorMessage: '生产厂家不能为空'
						}]
					},
					scph: {
						/* 生产批号 */
						rules: [{
							required: true,
							errorMessage: '生产批号不能为空'
						}]
					},
					m1: {
						/* 第一次 古氏坩埚与玻璃纤维滤纸合计质量(g) */
						rules: [{
							required: true,
							errorMessage: '第一次 古氏坩埚与玻璃纤维滤纸合计质量不能为空'
						}]
					},
					m2: {
						/* 第一次 锥形瓶与玻璃棒合计质量(g) */
						rules: [{
							required: true,
							errorMessage: '第一次 锥形瓶与玻璃棒合计质量不能为空'
						}]
					},
					
					a1: {
						/* 第二次 古氏坩埚与玻璃纤维滤纸合计质量(g) */
						rules: [{
							required: true,
							errorMessage: '第二次 古氏坩埚与玻璃纤维滤纸合计质量不能为空'
						}]
					},
					a2: {
						/* 第二次 锥形瓶与玻璃棒合计质量(g) */
						rules: [{
							required: true,
							errorMessage: '第二次 锥形瓶与玻璃棒合计质量不能为空'
						}]
					},
					
				
				
					sb1: {
						/* 沥青试样溶解度(%)第一次单值 */
						rules: [{
							required: true,
							errorMessage: '沥青试样溶解度(%)第一次单值不能为空'
						}]
					},
					sb2: {
						/* 沥青试样溶解度(%)第二次单值 */
						rules: [{
							required: true,
							errorMessage: '沥青试样溶解度(%)第二次单值不能为空'
						}]
					},
					sb: {
						/* 沥青试样溶解度(%)平均值 */
						rules: [{
							required: true,
							errorMessage: '沥青试样溶解度(%)平均值不能为空'
						}]
					},
					userid: {
						/* 采集人员编号 */
						rules: [{
							required: true,
							errorMessage: '采集人员编号不能为空'
						}]
					},
					position: {
						/* 记录采集地点 */
						rules: [{
							required: true,
							errorMessage: '记录采集地点不能为空'
						}]
					},
					scrq: {
						/* 生产日期 */
						rules: [{
							required: true,
							errorMessage: '生产日期不能为空'
						}]
					},
					sytj_xdsd: { //相对湿度
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (value > 100) {
									callback('相对湿度不能大于100%')
								}
								return true
							}
						}]
					},
					m4: { //古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (Number(value) < Number(CL10Data.m1)) {
									callback('古氏坩埚、玻璃纤维滤纸合计质量不能大于其与不溶物的合计质量')
								}
								return true
							}
						},{
							required: true,
							errorMessage: '第一次 古氏坩埚、玻璃纤维滤纸与不溶物合计质量不能为空'
						}]
					},
					m5: { //锥形瓶、玻璃棒与黏附不溶物合计质量(g)
						rules: [{
							required: true,
							errorMessage: '第一次 锥形瓶、玻璃棒与黏附不溶物合计质量不能为空'
						},{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (Number(value) < Number(CL10Data.m2)) {
									callback('锥形瓶、玻璃棒合计质量不能大于其与黏附不溶物的合计质量')
								}
								return true
							}
						}]
					},
					m3: { //锥形瓶、玻璃棒与沥青试样合计质量(g)
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (Number(value) <= Number(CL10Data.m2)) {
									callback('锥形瓶、玻璃棒合计质量不能大于等于其与沥青试样的合计质量') //m3m2作为分母不能为零
								}
								return true
							}
						},{
							required: true,
							errorMessage: '第一次 锥形瓶、玻璃棒与沥青试样合计质量不能为空'
						}]
					},
					a4: { //古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (Number(value) < Number(CL10Data.a1)) {
									callback('古氏坩埚、玻璃纤维滤纸合计质量不能大于其与不溶物的合计质量')
								}
								return true
							}
						},{
							required: true,
							errorMessage: '第二次 古氏坩埚、玻璃纤维滤纸与不溶物合计质量不能为空'
						}]
					},
					a5: { //锥形瓶、玻璃棒与黏附不溶物合计质量(g)
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {
								if (Number(value) < Number(CL10Data.a2)) {
									callback('锥形瓶、玻璃棒合计质量不能大于其与黏附不溶物的合计质量')
								}
								return true
							}
						},{
							required: true,
							errorMessage: '第二次 锥形瓶、玻璃棒与黏附不溶物合计质量不能为空'
						}]
					},
					a3: { //锥形瓶、玻璃棒与沥青试样合计质量(g)
						rules: [{
							validateFunction: function(rule, value, CL10Data, callback) {

								if (Number(value) <= Number(CL10Data.a2)) {

									callback('锥形瓶、玻璃棒合计质量不能大于等于其与沥青试样的合计质量') //a3-a2作为分母不能为零
								}
								return true
							}
						},{
							required: true,
							errorMessage: '第二次 锥形瓶、玻璃棒与沥青试样合计质量不能为空'
						}]
					}
				}
			}
		},
		onLoad() {

		},
		onReady() {
			// this.$refs.CL10Data.setRules(this.rules)
		},

		methods: {
			submit(ref) {
				var that = this;
				this.$refs[ref].validate().then(res => {
					console.log('success');
					console.log(res);
					addCL10(res).then(data => {
						console.log(data);
						if (data.code == 0) {
							console.log(555);
							uni.showToast({
								title: '添加成功'
							});
						} else {
							uni.showToast({
								icon: "error",
								title: '添加失败',
							});
						}
					})
				}).catch(err => {
					console.log('err', err);
				})
			}
		}
	}
</script>

<style>
	.uni-forms-item {
		margin-left: 10px;
		margin-right: 10px;
	}
</style>