<template>
	<view>
		<table width="100%" :border="true" cellspacing="0" bgcolor="#ffffff">




			<thead>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</thead>

			<!-- <tr>
				<td>{{form.id}}</td>
			</tr> -->

			<!-- <tr>
				<td colspan="8" align="center" height="20" fron-size="10	">沥青溶解度试验检测记录表</td>
			</tr> -->
			<tr>
				<td align="center" height="50" width="70">工程名称</td>
				<td align="center" height="50" colspan="5">{{form.gcmc}}</td>
			</tr>

			<tr>
				<td align="center" height="50">记录编号</td>
				<td align="center" height="50" colspan="5">{{form.jlbh}}</td>
			</tr>

			<tr>
				<td align="center" height="50">检测单位</td>
				<td align="center" height="50" colspan="5">{{form.jcdwmc}}</td>
			</tr>

			<tr>
				<td align="center" height="50">施工单位</td>
				<td align="center" height="50" colspan="5">{{form.sgdw}}</td>
			</tr>

			<tr>
				<td align="center" height="50">监理单位</td>
				<td align="center" height="50" colspan="5">{{form.jldw}}</td>
			</tr>

			<tr>
				<td align="center" height="50">合同段</td>
				<td align="center" height="50" colspan="5">{{form.htd}}</td>
			</tr>

			<tr>
				<td align="center" height="50">工程部位/用途</td>
				<td align="center" height="50" colspan="5">{{form.gcbw_yt}}</td>
			</tr>

			<tr>
				<td align="center" height="50">样品信息</td>
				<td align="center" height="50" colspan="5">{{form.ypxx}}</td>
			</tr>

			<tr>
				<td align="center" height="50">检测依据</td>
				<td align="center" height="50" colspan="5">{{form.jcyj}}</td>
			</tr>

			<tr>
				<td align="center" height="50">判定依据</td>
				<td align="center" height="50" colspan="5">{{form.pdyj}}</td>
			</tr>

			<tr>
				<td align="center" height="50">主要仪器设备名称及编号</td>
				<td align="center" height="50" colspan="5">{{form.zyyqsbmcjbh}}</td>
			</tr>

			<tr>
				<td align="center" height="50">沥青种类</td>
				<td align="center" height="50" colspan="5">{{form.lqzl}}</td>
			</tr>

			<tr>
				<td align="center" height="50">沥青标号</td>
				<td align="center" height="50" colspan="5">{{form.lqbh}}</td>
			</tr>

			<tr>
				<td align="center" height="50">生产厂家</td>
				<td align="center" height="50" colspan="5">{{form.sccj}}</td>
			</tr>



			<tr>
				<td align="center" height="50">生产日期</td>
				<td align="center" height="50" width="70">{{form.scrq}}</td>
				<td align="center" height="50" width="70">生产批号</td>
				<td align="center" height="50" colspan="3">{{form.scph}}</td>
			</tr>

			<tr>
				<td align="center" height="50">试验检测日期</td>
				<td align="center" height="50">{{form.syjcrq}}</td>
				<td align="center" height="50">试验条件</td>
				<td align="center" height="50" colspan="3">摄氏度:{{form.sytj_ssd}}℃ , 相对湿度:{{form.sytj_xdsd}}%</td>
			</tr>

			<tr>
				<td align="center" height="50">试验次数</td>
				<td align="center" height="50" colspan="2">1</td>
				<td align="center" height="50" colspan="3">2</td>
			</tr>

			<tr>
				<td align="center" height="50">古氏坩埚与玻璃纤维滤纸合计质量(g)</td>
				<td align="center" height="50" colspan="2">{{form.m1}}</td>
				<td align="center" height="50" colspan="3">{{form.a1}}</td>
			</tr>

			<tr>
				<td align="center" height="50">锥形瓶与玻璃棒合计质量(g)</td>
				<td align="center" height="50" colspan="2">{{form.m2}}</td>
				<td align="center" height="50" colspan="3">{{form.a2}}</td>
			</tr>

			<tr>
				<td align="center" height="50">锥形瓶、玻璃棒与沥青试样合计质量(g)</td>
				<td align="center" height="50" colspan="2">{{form.m3}}</td>
				<td align="center" height="50" colspan="3">{{form.a3}}</td>
			</tr>

			<tr>
				<td align="center" height="50">古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)</td>
				<td align="center" height="50" colspan="2">{{form.m4}}</td>
				<td align="center" height="50" colspan="3">{{form.a4}}</td>
			</tr>

			<tr>
				<td align="center" height="50">锥形瓶、玻璃棒与粘附不溶物合计质量(g)</td>
				<td align="center" height="50" colspan="2">{{form.m5}}</td>
				<td align="center" height="50" colspan="3">{{form.a5}}</td>
			</tr>


			<tr>
				<td align="center" rowspan="2" height="50">沥青试样溶解度(%)</td>
				<td height="50">单值</td>
				<td align="center" height="50">{{form.sb1}}</td>
				<td align="center" height="50" colspan="3">{{form.sb2}}</td>
			</tr>

			<tr>
				<td height="50">平均值</td>
				<td align="center" height="50" colspan="4">{{form.sb}}</td>
			</tr>

			<tr>
				<td align="left" height="100" colspan="6">附加说明: {{form.fjsm}}</td>
			</tr>


		</table>
	</view>
</template>

<script>
	import {
		getCL10s,
		getCL10,
	} from '@/api/system/CL10.js';
	export default {
		data() {
			return {
				form: {},
			}
		},
		onLoad() {
			this.getCLTable();
		},
		onShow() {
			this.getCLTable();
		},
		// onUnload
		onBackPress(options) {
			console.log(999)
			console.log(options.from)
			//if (options.from === "backbutton") {
			// 当前页面是通过返回按钮进入的，销毁当前页面
			// 返回上一页面，当前页面会被销毁
			uni.redirectTo({
				url: "/pages/work/CL10/CL10",
			});
			//return true; // 阻止默认的返回行为
			// }
			return false; // 不阻止默认的返回行为
		},
		methods: {
			getCLTable() {
				var that = this;
				var id = this.$route.query.cl10id;
				console.log(this.$route.query.cl10id);
				getCL10(id).then(res => {
					console.log(res);
					console.log(123456)
					that.form = res.data;
				})
			}
		}
	}
</script>

<style>

</style>