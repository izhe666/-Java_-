<template>
	<view>
		<uni-section title="沥青闪点与燃点" type="line">
			<view class="example">
				<!-- 基础用法，不包含校验规则 -->
				<uni-forms ref="valiForm" :rules="rules" :modelValue="user" lable-position="top" label-width="106px">
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="检测单位名称" required name="jcdwmc">
							<uni-easyinput v-model="user.jcdwmc" placeholder="请输入检测单位名称" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="记录编号" required name="jlbh">
							<uni-easyinput v-model="user.jlbh" placeholder="请输入记录编号" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="工程名称" required name="gcmc">
							<uni-easyinput v-model="user.gcmc" placeholder="请输入工程名称" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="合同段" required name="htd">
							<uni-easyinput v-model="user.htd" placeholder="请输入合同段" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="施工单位" required name="sgdw">
							<uni-easyinput v-model="user.sgdw" placeholder="请输入施工单位" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="监理单位" required name="jldw">
							<uni-easyinput v-model="user.jldw" placeholder="请输入监理单位" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="工程部位/用途" required name="gcbw">
							<uni-easyinput v-model="user.gcbw" placeholder="请输入工程部位/用途" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="样品信息" required name="ypxx">
							<uni-easyinput v-model="user.ypxx" placeholder="请输入样品信息" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="8" style="padding-right: 3px;">
						<uni-forms-item label="检测日期" required name="syjcrq">
							<uni-datetime-picker type="datetime" return-type="timestamp"
								v-model="user.syjcrqdatetimesingle" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="2" style="padding-right: 0px;">
						<uni-forms-item label="试验条件" required name="sytj">
							<!-- <uni-easyinput v-model="user.sytj" placeholder="请输入试验条件" /> -->
						</uni-forms-item>
					</uni-col>
					<uni-col :span="7" style="padding-right: 3px;">
						<uni-forms-item label="温度" required name="wd">
							<uni-easyinput v-model="user.wd" placeholder="请输入温度" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="7" style="padding-right: 3px;">
						<uni-forms-item label="相对湿度" required name="xdsd">
							<uni-easyinput v-model="user.xdsd" placeholder="请输入相对湿度" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="检测依据" required name="jcyj">
							<uni-easyinput v-model="user.jcyj" placeholder="请输入检测依据" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="判定依据" required name="pdyj">
							<uni-easyinput v-model="user.pdyj" placeholder="请输入判定依据" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="主要仪器设备名称和标号" required name="zyyqsbmchbh">
							<uni-easyinput v-model="user.zyyqsbmchbh" placeholder="请输入主要仪器设备名称和标号" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="沥青种类" required name="lqzl">
							<uni-easyinput v-model="user.lqzl" placeholder="请输入沥青种类" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="沥青标号" required name="lqbh">
							<uni-easyinput v-model="user.lqbh" placeholder="请输入沥青标号" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="8" style="padding-right: 3px;">
						<uni-forms-item label="生产厂家" required name="sccj">
							<uni-easyinput v-model="user.sccj" placeholder="请输入生产厂家" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="8" style="padding-right: 3px;">
						<uni-forms-item label="生产日期" required name="scrq">
							<uni-datetime-picker type="datetime" return-type="timestamp"
								v-model="user.scrqdatetimesingle" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="8" style="padding-right: 3px;">
						<uni-forms-item label="批号" required name="ph">
							<uni-easyinput v-model="user.ph" placeholder="请输入批号" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="试验次数" required name="sycs">
							<uni-easyinput v-model="user.sycs" placeholder="请输入试验次数" />
						</uni-forms-item>
					</uni-col>
					<uni-forms ref="valiForm" :rules="rules" :modelValue="user" lable-position="top"
						label-width="139px">
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="初始温度1（℃）" required name="cswd1">
								<uni-easyinput v-model="user.cswd1" placeholder="请输入初始温度1" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="初始温度2（℃）" required name="cswd2">
								<uni-easyinput v-model="user.cswd2" placeholder="请输入初始温度2" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第1次温度记录" required name="a1">
								<uni-easyinput v-model="user.a1" placeholder="请输入1组第1次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第1次温度记录" required name="b1">
								<uni-easyinput v-model="user.b1" placeholder="请输入2组第1次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第2次温度记录" required name="a2">
								<uni-easyinput v-model="user.a2" placeholder="请输入1组第2次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第2次温度记录" required name="b2">
								<uni-easyinput v-model="user.b2" placeholder="请输入2组第2次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第3次温度记录" required name="a3">
								<uni-easyinput v-model="user.a3" placeholder="请输入1组第3次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第3次温度记录" required name="b3">
								<uni-easyinput v-model="user.b3" placeholder="请输入2组第3次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第4次温度记录" required name="a4">
								<uni-easyinput v-model="user.a4" placeholder="请输入1组第4次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第4次温度记录" required name="b4">
								<uni-easyinput v-model="user.b4" placeholder="请输入2组第4次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第5次温度记录" required name="a5">
								<uni-easyinput v-model="user.a5" placeholder="请输入1组第5次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第5次温度记录" required name="b5">
								<uni-easyinput v-model="user.b5" placeholder="请输入2组第5次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第6次温度记录" required name="a6">
								<uni-easyinput v-model="user.a6" placeholder="请输入1组第6次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第6次温度记录" required name="b6">
								<uni-easyinput v-model="user.b6" placeholder="请输入2组第6次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第7次温度记录" required name="a7">
								<uni-easyinput v-model="user.a7" placeholder="请输入1组第7次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第7次温度记录" required name="b7">
								<uni-easyinput v-model="user.b7" placeholder="请输入2组第7次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第8次温度记录" required name="a8">
								<uni-easyinput v-model="user.a8" placeholder="请输入1组第8次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第8次温度记录" required name="b8">
								<uni-easyinput v-model="user.b8" placeholder="请输入2组第8次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第9次温度记录" required name="a9">
								<uni-easyinput v-model="user.a9" placeholder="请输入1组第9次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第9次温度记录" required name="b9">
								<uni-easyinput v-model="user.b9" placeholder="请输入2组第9次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第10次温度记录" required name="a10">
								<uni-easyinput v-model="user.a10" placeholder="请输入1组第10次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第10次温度记录" required name="b10">
								<uni-easyinput v-model="user.b10" placeholder="请输入2组第10次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第11次温度记录" required name="a11">
								<uni-easyinput v-model="user.a11" placeholder="请输入1组第11次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第11次温度记录" required name="b11">
								<uni-easyinput v-model="user.b11" placeholder="请输入2组第11次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第12次温度记录" required name="a12">
								<uni-easyinput v-model="user.a12" placeholder="请输入1组第12次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第12次温度记录" required name="b12">
								<uni-easyinput v-model="user.b12" placeholder="请输入2组第12次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第13次温度记录" required name="a13">
								<uni-easyinput v-model="user.a13" placeholder="请输入1组第13次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第13次温度记录" required name="b13">
								<uni-easyinput v-model="user.b13" placeholder="请输入2组第13次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="1组第14次温度记录" required name="a14">
								<uni-easyinput v-model="user.a14" placeholder="请输入1组第14次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
						<uni-col :span="12" style="padding-right: 3px;">
							<uni-forms-item label="2组第14次温度记录" required name="b14">
								<uni-easyinput v-model="user.b14" placeholder="请输入2组第14次温度记录" type="number" />
							</uni-forms-item>
						</uni-col>
					</uni-forms>
					<!-- Repeat similar structure for each Float field (e.g., cswd1, cswd2, a1, b1, dqyq, etc.) with placeholders and appropriate names -->
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="大气压强（kPa）" required name="dqyq">
							<uni-easyinput v-model="user.dqyq" placeholder="请输入大气压强（kPa）" type="number" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="气压修正值（℃）" required name="qyxzz">
							<uni-easyinput v-model="user.qyxzz" placeholder="请输入气压修正值（℃）" type="number" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="闪点测值1" required name="sdcz1">
							<uni-easyinput v-model="user.sdcz1" placeholder="请输入闪点测值1" type="number" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="闪点测值2" required name="sdcz2">
							<uni-easyinput v-model="user.sdcz2" placeholder="请输入闪点测值2" type="number" />
						</uni-forms-item>
					</uni-col>
					<!-- <uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="闪点平均值" required name="sdpjz">
							<uni-easyinput :value="calculateAverage()" placeholder="请输入闪点平均值" type="number"/>
						</uni-forms-item>
					</uni-col> -->
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="闪点修正值" required name="sdxcz">
							<uni-easyinput v-model="user.sdxcz" placeholder="请输入闪点修正值" type="number"/>
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="燃点测值1" required name="rdcz1">
							<uni-easyinput v-model="user.rdcz1" placeholder="请输入燃点测值1" type="number" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="燃点测值2" required name="rdcz2">
							<uni-easyinput v-model="user.rdcz2" placeholder="请输入燃点测值2" type="number" />
						</uni-forms-item>
					</uni-col>
					<!-- uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="燃点平均值" required name="rdpjz">
							<uni-easyinput v-model="user.rdpjz" placeholder="请输入燃点平均值" type="number" />
						</uni-forms-item> -->
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="燃点修正值" required name="rdxcz">
							<uni-easyinput v-model="user.rdxcz" placeholder="请输入燃点修正值" type="number" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="附加声明" required name="fjsm">
							<uni-easyinput v-model="user.fjsm" placeholder="请输入附加声明" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="地点" required name="position">
							<uni-easyinput v-model="user.position" placeholder="请输入地点" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="24" style="padding-right: 3px;">
						<uni-forms-item label="采集人员编号" required name="userid">
							<uni-easyinput v-model="user.userid" placeholder="请输入采集人员编号" />
						</uni-forms-item>
					</uni-col>

					<button type="primary" @click="submit('valiForm')">提交</button>
				</uni-forms>
			</view>
		</uni-section>
	</view>
</template>


<script>
	import {
		addCL11
	} from '@/api/system/CL11'
	export default {
		data() {
			return {
				// 基础表单数据
				user: {
					username: '',
					password: '',
					userType: '管理员',
					age: '',
					sex: '男',
					datetimesingle: 1627529992399
				},
				// 表单数据
				alignmentFormData: {
					username: '',
					password: '',
					age: '',
				},
				// 单选数据源
				sexs: [{
					text: '男',
					value: '男'
				}, {
					text: '女',
					value: '女'
				}, {
					text: '保密',
					value: '保密'
				}],
				// 单选数据源
				types: [{
					text: '管理员',
					value: '管理员'
				}, {
					text: '普通用户',
					value: '普通用户'
				}],
				// 分段器数据
				current: 0,
				// 校验表单数据
				valiFormData: {
					username: '',
					password: '',
					age: '',
				},
				imageUrl: '',
				// 校验规则,
				rules: {
					username: {
						rules: [{
							required: true,
							errorMessage: '账号不能为空'
						}]
					},
					password: {
						rules: [{
							required: true,
							errorMessage: '密码不能为空'
						}]
					},
					age: {
						rules: [{
							required: true,
							errorMessage: '年龄不能为空'
						}, {
							format: 'number',
							errorMessage: '年龄只能输入数字'
						}]
					}
				}
			}
		},
		computed: {},
		onLoad() {},
		onReady() {
			// 设置自定义表单校验规则，必须在节点渲染完毕后执行
			// this.$refs.customForm.setRules(this.customRules)
		},
		
		/* methods: {
		    calculateAverage() {
		        const val1 = parseFloat(this.user.sdcz1) || 0;
		        const val2 = parseFloat(this.user.sdcz2) || 0;
		        return ((val1 + val2) / 2).toFixed(2);
		    },
		    submit(ref) {
		        // 提交逻辑...
		    },
		    // 其他方法...
		}, */

		methods: {
			onClickItem(e) {
				console.log(e);
				this.current = e.currentIndex
			},
			add() {},
			del(id) {
				//let index = this.dynamicLists.findIndex(v => v.id === id)
				//this.dynamicLists.splice(index, 1)
			},
			submit(ref) {
				var that = this;
				this.$refs[ref].validate().then(res => {
					console.log('success', res);
					// uni.showToast({
					// 	title: `检验通过`
					// })
					res.image = that.imageUrl;
					console.log(res);
					// uni.request({
					// 	url: "/api/addUser",
					// 	/* type: "POST", */
					// 	method: "post",
					// 	data: JSON.stringify(res),
					// 	header: {
					// 		"content-Type": "application/json",
					// 	},
					// 	success: function(data) {
					// 		console.log(777);
					// 		console.log(data);
					// 		uni.navigateBack();
					// 		uni.showToast({
					// 			title: `添加成功`
					// 		});
					// 		that.user = {}

					// 	}
					// })
					addCL11(res).then(data => {
						console.log(44);
						console.log(data);

						uni.showToast({
							titlt: `添加成功`
						})
					})
				}).catch(err => {
					console.log('err', err);
				})
			},
			uploadFile(e) {
				var that = this;
				console.log(55)
				console.log(e);
				// var formDate = new FormData(); // form表单对象
				// formDate.append("file", e.tempFilePaths[0]); // 组装表单数据
				uni.uploadFile({
					url: "/api/uploadFile",
					filePath: e.tempFilePaths[0],
					name: "file",
					// method: "post",
					// data: formData,
					success: function(data) {
						console.log(555)
						console.log(JSON.parse(data.data).src);
						that.imageUrl = JSON.parse(data.data).src;
					}
				})
			}
		}
	}
</script>

<style>
	.example {
		padding: 15px;
		background-color: #fff;
	}

	.segmented-control {
		margin-bottom: 15px;
	}

	.button-group {
		margin-top: 15px;
		display: flex;
		justify-content: space-around;
	}

	.form-item {
		display: flex;
		align-items: center;
	}

	.button {
		display: flex;
		align-items: center;
		height: 35px;
		margin-left: 10px;
	}
</style>