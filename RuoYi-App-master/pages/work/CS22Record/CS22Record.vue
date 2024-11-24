<template>
	<view>
		<!-- 自定义右侧内容 -->
		<uni-list-chat v-for="item in userList" :title="item.jcdw" avatar=""
			:note="'检测单位名称：'+item.jcdwmc+'\n'+
			'记录编号：'+item.jlbh+'\n'+
			'工程名称：'+item.gcmc+'\t'+
			'合同段：'+item.htd+'\n'+
			'施工单位：'+item.sgdw+'\n'+
			'监理单位：'+item.jldw+'\n'+
			'工程部门/用途：'+item.gcbwyt+'\n'+
			'样品信息：'+item.ypxx+'\n'+
			'试验检测日期：'+item.syjcrq+'\n'+
			'实验条件的温度(℃)：'+item.sytj_wd+'\n'+
			'实验条件的湿度(%)：'+item.sytj_sd+'\n'+
			'测试依据：'+item.csyj+'\n'+
			'判定依据：'+item.pdyj+'\n'+
			'主要仪器设备名称和编号：'+item.zyyjsbmcjbh+'\n'+
			'试扮混泥土性能,提出试伴配合比：'+item.sbhntxnphb+'\n'+
			'坍落度a1单值(mm)：'+item.dld_A1+'\n'+
			'坍落度a2单值(mm)：'+item.dld_A2+'\n'+
			'坍落度a平均值(mm)：'+item.dld_A+'\n'+
			'扩展度b1单值(mm)：'+item.kzd_B1+'\n'+
			'扩展度b2单值(mm)：'+item.kzd_B2+'\n'+
			'扩展度b平均值(mm)：'+item.kzd_B+'\n'+
			'砼拌合物_棍度：'+item.tbhw_gd+'\n'+
			'砼拌合物_含沙情况：'+item.tbhw_hsqk+'\n'+
			'砼拌合物_粘聚性：'+item.tbhw_njx+'\n'+
			'砼拌合物_保水性：'+item.tbhw_bsx+'\n'+
			'备注：'+item.bz+'\n'+
			'筒+砼质量1(kg)：'+item.t_tzl_D1+'\n'+
			'筒+砼质量2(kg)：'+item.t_tzl_D2+'\n'+
			'筒质量1(kg)：'+item.t_zl_E1+'\n'+
			'桶质量2(kg)：'+item.t_zl_E2+'\n'+
			'砼质量1(kg)：'+item.t_zl_F1+'\n'+
			'砼质量2(kg)：'+item.t_zl_F2+'\n'+
			'筒容积1(L)：'+item.t_rj_G1+'\n'+
			'筒容积2(L)：'+item.t_rj_G2+'\n'+
			'实测表观密度单值1(kg/m^3)：'+item.scbgmd_dz_H1+'\n'+
			'实测表观密度单值2(kg/m^3)：'+item.scbgmd_dz_H2+'\n'+
			'实测表观密度平均值(kg/m^3)：'+item.scbgmd_dz_H+'\n'+
			'表观密度计算值(kg/m^3)：'+item.bjmdjsz_p+'\n'+
			'配合比较正系数δ：'+item.phjjzxs_sigma+'\n'+
			'试板配比1：'+item.sbpb_1+'\n'+
			'试板配比2：'+item.sbpb_2+'\n'+
			'基准水胶比：'+item.sjb_C+'\n'+
			'设计计算方法：'+item.sjjsff+'\n'+
			'假定密度(kg/m^3)：'+item.jdmd+'\n'+
			'水胶比1：'+item.sjb_I1+'\n'+
			'水胶比2：'+item.sjb_I2+'\n'+
			'水泥1(kg)：'+item.sn_J1+'\n'+
			'水泥2(kg)：'+item.sn_J2+'\n'+
			'细集料1(kg)：'+item.xjl_K1+'\n'+
			'细集料2(kg)：'+item.xjl_K2+'\n'+
			'粗集料1(kg)：'+item.cjl_L1+'\n'+
			'粗集料2(kg)：'+item.cjl_L2+'\n'+
			'水1(kg)：'+item.s_M1+'\n'+
			'水2(kg)：'+item.s_M2+'\n'+
			'外加剂名称1：'+item.wjj_mc1+'\n'+
			'外加剂1质量1(kg)：'+item.wjjzlmc1_N1+'\n'+
			'外加剂1质量2(kg)：'+item.wjjzlmc1_N2+'\n'+
			'外加剂名称2：'+item.wjj_mc2+'\n'+
			'外加剂2质量1(kg)：'+item.wjjzlmc2_O1+'\n'+
			'外加剂2质量2(kg)：'+item.wjjzlmc2_O2+'\n'+
			'矿物掺和料名称1：'+item.kwchl_mc1+'\n'+
			'矿物掺和料名称1质量1(kg)：'+item.kwchlmc1_P1+'\n'+
			'矿物掺和料名称1质量2(kg)：'+item.kwchlmc1_P2+'\n'+
			'矿物掺和料名称2：'+item.kwchl_mc2+'\n'+
			'矿物掺和料名称2质量1(kg)：'+item.kwchlmc2_Q1+'\n'+
			'矿物掺和料名称2质量2(kg)：'+item.kwchlmc2_Q22+'\n'+
			'砂率1(%)：'+item.sl_R1+'\n'+
			'砂率2(%)：'+item.sl_R2+'\n'+
			
			
			item.sgdw" 
			badge-positon="left">
		</uni-list-chat>
		<!-- 添加悬浮按钮 : 就是动态数据要定义 		-->
		<uni-fab ref="fab" :pattern="pattern" :horizontal="horizontal" :vertical="vertical" :direction="direction"
			@trigger="trigger" @fabClick="fabClick" />
	</view>
</template>

<script>
	import {
		getCS22Records
	} from '@/api/system/CS22Record';
	export default {
		data() {
			return {
				//点击悬浮的动态定义
				title: 'uni-fab',
				directionStr: '垂直',
				horizontal: 'left',
				vertical: 'bottom',
				direction: 'horizontal',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF',
					iconColor: '#fff'
				},
				//返回接受列表 
				userList: [{
						id: 1,
						username: "张杰",
						password: "123",
						age: 12,
						gener: "男",
						phone: "1000",
						image: "/static/logo.png"
					},
					{
						id: 2,
						username: "张杰杰",
						password: "123",
						age: 12,
						gener: "男",
						phone: "1000",
						image: "123"
					}
				],
			}
		},
		// 启动页面的时候加载 数据函数 
		onLoad() {
			this.getUsers();
			//this.getCS22Records();
		},
		// 实现下拉刷新
		onPullDownRefresh() {
			console.log('在刷新数据');
			var that = this;
			setTimeout(function() {
				uni.request({
					url: "/api/getUsers",
					type: "get",
					success: res => {
						console.log(88);
						console.log(res.data);
						// res.data[0].username = res.data[0].username + new Date().getTime();
						console.log(that.userList);
						that.userList = [...res.data, ...that.userList];
					}
				})
				uni.stopPullDownRefresh();
			}, 2000);
		},

		onReachBottom() {
			console.log('我已经到底部了');
			var that = this;
			//执行数据库的下一页查询
			uni.request({
				url: "/api/getUsers",
				type: "get",
				success: res => {
					console.log(88);
					console.log(res.data);
					// res.data[0].gener = res.data[0].gener + new Date().getTime();
					console.log(that.userList);
					that.userList = [...that.userList, ...res.data];
				}
			})
			// getUsers();
		},
		methods: {
			//<!-- 悬浮点击事件函数 -->
			fabClick() {
				// uni.showToast({
				// 	title: '点击了悬浮按钮',
				// 	icon: 'none'
				// })
				//点击跳转
				uni.navigateTo({
					url: "/pages/work/CS22Record/addCS22Record"
				})
			},
			getUsers() {
				// uni.request({
				// url: "/api/getUsers",
				// type: "get",
				// success: res => {
				// 	console.log(888);
				// 	console.log(res.data);
				// 	//请求回数据
				// 	this.userList = res.data;
				// }
				getCS22Records(1, 20).then(res => {
					console.log(44);
					console.log(res);
					this.userList = res.data.list;
				})
				// }
			},
			
		}
	}
</script>

<style>

</style>