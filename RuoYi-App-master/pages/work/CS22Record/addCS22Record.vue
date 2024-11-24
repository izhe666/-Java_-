<template>
	<view>
		<uni-section title="路面混凝土配合比设计试验检测记录表（二）" type="line">
			<view class="example">
				<!-- 基础用法，不包含校验规则 -->
				<!-- uni- easyinput输入框， uni-data-checkbox -->
				<!-- <uni-forms ref="valiForm" :rules="rules" :modelValue="user">
					<uni-forms-item label="账号" required name="jcdwmc">
						<uni-easyinput v-model="user.username" placeholder="请输入账号" />
					</uni-forms-item>
					<uni-forms-item label="密码" required name="password">
						<uni-easyinput v-model="user.password" placeholder="请输入密码" />
					</uni-forms-item>
					<uni-forms-item label="用户类型" required name="userType">
						<uni-data-checkbox v-model="user.userTyper" :localdata="types" />
					</uni-forms-item>
					<uni-forms-item label="年龄" required name="age">
						<uni-easyinput v-model="user.age" placeholder="请输入年龄/" />
					</uni-forms-item>
					<uni-forms-item label="性别" required name="gener">
						<uni-data-checkbox v-model="user.gener" :localdata="gener" />
					</uni-forms-item>
					<uni-forms-item label="电话\n号码" required name="phone">
						<uni-easyinput v-model="user.phone" placeholder="请输入电话号码" />
					</uni-forms-item>
					<!-- 上传头像 -->
				<!-- <uni-forms-item label="头像" required name="image">
						<view class="example-body">
							<uni-file-picker limit="1" title="请选择头像" @select="uploadFile"></uni-file-picker>
						</view>
					</uni-forms-item> -->
				<uni-forms ref="valiForm" :rules="rules" :modelValue="user" label-position="top" labelWidth="106px">
					</uni-forms-item>

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
					<!-- 单挂一行  -->
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="工程部位/用途" required name="gcbwyt">
							<uni-easyinput v-model="user.gcbwyt" placeholder="请输入工程部位/用途" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="样品信息" required name="ypxx">
							<uni-easyinput v-model="user.ypxx" placeholder="请输入样品信息" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="试验检测日期时间">
							<uni-datetime-picker type="datetime" return-type="timestamp"
								v-model="user.datetimesingle" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="实验条件的温度(℃)" required name="sytj_wd">
							<uni-easyinput v-model="user.sytj_wd" placeholder="请输入实验条件的温度(℃)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="实验条件的湿度(%)" required name="sytj_sd">
							<uni-easyinput v-model="user.sytj_sd" placeholder="请输入实验条件的湿度(%)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="测试依据" required name="csyj">
							<uni-easyinput v-model="user.csyj" placeholder="请输入测试依据" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="判定依据" required name="pdyj">
							<uni-easyinput v-model="user.pdyj" placeholder="请输入判定依据" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="主要仪器设备名称和编号" required name="zyyjsbmcjbh">
							<uni-easyinput v-model="user.zyyjsbmcjbh" placeholder="请输入主要仪器设备名称和编号" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="试扮混泥土性能,提出试伴配合比" required name="sbhntxnphb">
							<uni-easyinput v-model="user.sbhntxnphb" placeholder="请输入试扮混泥土性能,提出试伴配合比" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="坍落度a1单值(mm)" required name="dld_A1">
							<uni-easyinput v-model="user.dld_A1" placeholder="请输入坍落度a1单值(mm)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="坍落度a2单值(mm)" required name="dld_A2">
							<uni-easyinput v-model="user.dld_A2" placeholder="请输入坍落度a2单值(mm)" />
						</uni-forms-item>
					</uni-col>
					<!-- 计算平均 A-->
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="扩展度b1单值(mm)" required name="kzd_B1">
							<uni-easyinput v-model="user.kzd_B1" placeholder="请输入扩展度b1单值(mm)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="扩展度b2单值(mm)" required name="kzd_B2">
							<uni-easyinput v-model="user.kzd_B2" placeholder="请输入扩展度b2单值(mm)" />
						</uni-forms-item>
					</uni-col>
					<!-- 计算平均B -->
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼拌合物_棍度" required name="tbhw_gd">
							<uni-easyinput v-model="user.tbhw_gd" placeholder="请输入砼拌合物_棍度" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼拌合物_含沙情况" required name="tbhw_hsqk">
							<uni-easyinput v-model="user.tbhw_hsqk" placeholder="请输入砼拌合物_含沙情况" />
						</uni-forms-item>
					</uni-col>
					<!-- <uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="检测单位名称" required name="tbhw_hsqk">
							<uni-easyinput v-model="user.tbhw_hsqk" placeholder="请输入检测单位名称" />
						</uni-forms-item>
					</uni-col> -->
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼拌合物_粘聚性" required name="tbhw_njx">
							<uni-easyinput v-model="user.tbhw_njx" placeholder="请输入砼拌合物_粘聚性" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼拌合物_保水性" required name="tbhw_bsx">
							<uni-easyinput v-model="user.tbhw_bsx" placeholder="请输入砼拌合物_保水性" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="备注" required name="bz">
							<uni-easyinput v-model="user.bz" placeholder="请输入备注" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水胶比" required name="sjb_C">
							<uni-easyinput v-model="user.sjb_C" placeholder="请输入水胶比" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="筒+砼质量1(kg)" required name="t_tzl_D1">
							<uni-easyinput v-model="user.t_tzl_D1" placeholder="请输入筒+砼质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="筒+砼质量2(kg)" required name="t_tzl_D2">
							<uni-easyinput v-model="user.t_tzl_D2" placeholder="请输入筒+砼质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="筒质量1(kg)" required name="t_zl_E1">
							<uni-easyinput v-model="user.t_zl_E1" placeholder="请输入筒质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="桶质量2(kg)" required name="t_zl_E2">
							<uni-easyinput v-model="user.t_zl_E2" placeholder="请输入桶质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼质量1(kg)" required name="t_zl_F1">
							<uni-easyinput v-model="user.t_zl_F1" placeholder="请输入砼质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砼质量2(kg)" required name="t_zl_F2">
							<uni-easyinput v-model="user.t_zl_F2" placeholder="请输入砼质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="筒容积1(L)" required name="t_rj_G1">
							<uni-easyinput v-model="user.t_rj_G1" placeholder="请输筒筒容积1(L)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="筒容积2(L)" required name="t_rj_G2">
							<uni-easyinput v-model="user.t_rj_G2" placeholder="请输入筒容积2(L)" />
						</uni-forms-item>
					</uni-col>
					<!-- <uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="实测表观密度单值1" required name="t_zl_E2">
							<uni-easyinput v-model="user.t_zl_E2" placeholder="请输入桶质量2" />
						</uni-forms-item>
					</uni-col> -->
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="表观密度计算值(kg/m^3)" required name="bjmdjsz_p">
							<uni-easyinput v-model="user.bjmdjsz_p" placeholder="请输入表观密度计算值(kg/m^3)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="配合比校正系数δ" required name="phjjzxs_sigma">
							<uni-easyinput v-model="user.phjjzxs_sigma" placeholder="请输入配合比校正系数δ" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="试板配比1" required name="sbpb_1">
							<uni-easyinput v-model="user.sbpb_1" placeholder="请输入试板配比1" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="试板配比2" required name="sbpb_2">
							<uni-easyinput v-model="user.sbpb_2" placeholder="请输入试板配比2" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="基准水胶比" required name="jjsjb">
							<uni-easyinput v-model="user.jjsjb" placeholder="请输入基准水胶比" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="设计计算方法" required name="sjjsff">
							<uni-easyinput v-model="user.sjjsff" placeholder="请输入设计计算方法" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="假定密度(kg/m^3)" required name="jdmd">
							<uni-easyinput v-model="user.jdmd" placeholder="请输入假定密度(kg/m^3)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水胶比1" required name="sjb_I1">
							<uni-easyinput v-model="user.sjb_I1" placeholder="请输入水胶比1" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水胶比2" required name="sjb_I2">
							<uni-easyinput v-model="user.sjb_I2" placeholder="请输入水胶比2" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水泥1(kg)" required name="sn_J1">
							<uni-easyinput v-model="user.sn_J1" placeholder="请输入水泥1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水泥2(kg)" required name="sn_J2">
							<uni-easyinput v-model="user.sn_J2" placeholder="请输入水泥2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="细集料1(kg)" required name="xjl_K1">
							<uni-easyinput v-model="user.xjl_K1" placeholder="请输入细集料1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="细集料2(kg)" required name="cjl_L1">
							<uni-easyinput v-model="user.cjl_L1" placeholder="请输入细集料2(kg)" />
						</uni-forms-item>
					</uni-col>
					
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="粗集料1(kg)" required name="cjl_L2">
							<uni-easyinput v-model="user.cjl_L2" placeholder="请输入粗集料1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="粗集料2(kg)" required name="xjl_K2">
							<uni-easyinput v-model="user.xjl_K2" placeholder="请输入粗集料2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水1(kg)" required name="s_M1">
							<uni-easyinput v-model="user.s_M1" placeholder="请输入水1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="水2(kg)" required name="s_M2">
							<uni-easyinput v-model="user.s_M2" placeholder="请输入水2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂名称1" required name="wjj_mc1">
							<uni-easyinput v-model="user.wjj_mc1" placeholder="请输入外加剂名称1" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂1质量1(kg)" required name="wjjzlmc1_N1">
							<uni-easyinput v-model="user.wjjzlmc1_N1" placeholder="请输入外加剂1质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂1质量2(kg)" required name="wjjzlmc1_N2">
							<uni-easyinput v-model="user.wjjzlmc1_N2" placeholder="请输入外加剂1质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂名称2" required name="wjj_mc2">
							<uni-easyinput v-model="user.wjj_mc2" placeholder="请输入外加剂名称2" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂2质量1(kg)" required name="wjjzlmc2_O1">
							<uni-easyinput v-model="user.wjjzlmc2_O1" placeholder="请输入外加剂2质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="外加剂2质量2(kg)" required name="wjjzlmc2_O2">
							<uni-easyinput v-model="user.wjjzlmc2_O2" placeholder="请输入外加剂2质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称1" required name="kwchl_mc1">
							<uni-easyinput v-model="user.kwchl_mc1" placeholder="请输入矿物掺和料名称1" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称1质量1(kg)" required name="kwchlmc1_P1">
							<uni-easyinput v-model="user.kwchlmc1_P1" placeholder="请输入矿物掺和料名称1质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称1质量2(kg)" required name="kwchlmc1_P2">
							<uni-easyinput v-model="user.kwchlmc1_P2" placeholder="请输入矿物掺和料名称1质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称2" required name="kwchl_mc2">
							<uni-easyinput v-model="user.kwchl_mc2" placeholder="请输入矿物掺和料名称2" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称2质量1(kg)" required name="kwchlmc2_Q1">
							<uni-easyinput v-model="user.kwchlmc2_Q1" placeholder="请输入矿物掺和料名称2质量1(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="矿物掺和料名称2质量2(kg)" required name="kwchlmc2_Q2">
							<uni-easyinput v-model="user.kwchlmc2_Q2" placeholder="请输入矿物掺和料名称2质量2(kg)" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砂率1" required name="sl_R1">
							<uni-easyinput v-model="user.sl_R1" placeholder="请输入砂率1" />
						</uni-forms-item>
					</uni-col>
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="砂率2" required name="sl_R2">
							<uni-easyinput v-model="user.sl_R2" placeholder="请输入砂率2" />
						</uni-forms-item>
					</uni-col>
					
					<uni-col :span="12" style="padding-right: 3px;">
						<uni-forms-item label="其他" required name="qt">
							<uni-easyinput v-model="user.qt" placeholder="请输入其他" />
						</uni-forms-item>
					</uni-col>


					<button type="primary" @click="submit('valiForm')">提交</button>

				</uni-forms>
			</view>
		</uni-section>
	</view>
</template>

<script>
	//导入函数 
	import {
		addCS22Record
	} from '@/api/system/CS22Record';
	
	export default {
		data() {
			return {
				// 基础表单数据
				user: {
					jcdwmc: '', // 检测单位名称
					jlbh: '',   //记录编号
					gcmc: '',  //工程名称
					htd: '',   // 合同段
					sgdw: '',  //施工单位
					jldw: '',  // 监理单位
					gcbwyt: '',  // 工程部门/用途
					ypxx: '',  // 样品信息
					syjcrq: '',  //试验检测日期
					sytj_wd: '',  //实验条件的温度(℃)
					sytj_sd: '',  //实验条件的湿度(%)
					csyj: '',  //测试依据
					pdyj: '',  //试验检测日期
					sytj_wd: '',  //判定依据
					zyyjsbmcjbh: '',  //主要仪器设备名称和编号
					sbhntxnphb: '',  //试扮混泥土性能,提出试伴配合比
					dld_A1: '',  //坍落度a1单值(mm)
					dld_A2: '',  //坍落度a2单值(mm)
					dld_A: '',  //坍落度a平均值(mm)
					kzd_B1: '',  //扩展度b1单值(mm)
					kzd_B2: '',  //扩展度b2单值(mm)
					kzd_B: '',  //扩展度b平均值(mm)
					tbhw_gd: '',  //砼拌合物_棍度
					tbhw_hsqk: '',  //砼拌合物_含沙情况
					tbhw_njx: '',  //砼拌合物_粘聚性
					tbhw_bsx: '',  //砼拌合物_保水性
					bz: '',  //备注
					sjb_C: '',  //水胶比
					t_tzl_D1: '',  //筒+砼质量1(kg)
					t_tzl_D2: '',  //筒+砼质量2(kg)
					t_zl_E1: '',  //筒质量1(kg)
					t_zl_E2: '',  //桶质量2(kg)
					t_zl_F1: '',  //砼质量1(kg)
					t_zl_F2: '',  //砼质量2(kg)
					t_rj_G1: '',  //筒容积1(L)
					t_rj_G2: '',  //筒容积2(L)
					scbgmd_dz_H1: '',  //实测表观密度单值1(kg/m^3)
					scbgmd_dz_H2: '',  //实测表观密度单值2(kg/m^3)
					scbgmd_dz_H: '',  //实测表观密度平均值(kg/m^3)
					bjmdjsz_p: '',  //表观密度计算值(kg/m^3)
					phjjzxs_sigma: '',  //配合比较正系数δ
					sbpb_1: '',  //试板配比1
					sbpb_2: '',  //试板配比2
					jjsjb: '',  //基准水胶比
					sjjsff: '',  //设计计算方法
					jdmd: '',  //假定密度(kg/m^3)
					sjb_I1: '',  //水胶比1
					sjb_I2: '',  //水胶比2
					sn_J1: '',  //水泥1(kg)
					sn_J2: '',  //水泥2(kg)
					xjl_K1: '',  //细集料1(kg)
					xjl_K2: '',  //细集料2(kg)
					cjl_L1: '',  //粗集料1(kg)
					cjl_L2: '',  //粗集料2(kg)
					s_M1: '',  //水1(kg)
					s_M2: '',  //水2(kg)
					wjj_mc1: '',  //外加剂名称1
					wjjzlmc1_N1: '',  //外加剂1质量1(kg)
					wjjzlmc1_N2: '',  //外加剂1质量2(kg)
					wjj_mc2: '',  //外加剂名称2
					wjjzlmc2_O1: '',  //外加剂2质量1(kg)
					wjjzlmc2_O2: '',  //外加剂2质量2(kg)
					kwchl_mc1: '',  //矿物掺和料名称1
					kwchlmc1_P1: '',  //矿物掺和料名称1质量1(kg)
					kwchlmc1_P2: '',  //矿物掺和料名称1质量2(kg)
					kwchl_mc2: '',  //矿物掺和料名称2
					kwchlmc2_Q1: '',  //矿物掺和料名称2质量1(kg)
					kwchlmc2_Q2: '',  //矿物掺和料名称2质量2(kg)
					sl_R1: '',  //砂率1(%)
					sl_R2: '',  //砂率2(%)
					
				},
				// imageUrl: '',
				// // 表单数据
				// alignmentFormData: {
				// 	username: '',
				// 	password: '',
				// 	age: '',

				// },
				// // 单选数据源
				// gener: [{
				// 	text: '男',
				// 	value: '男'
				// }, {
				// 	text: '女',
				// 	value: '女'
				// }, {
				// 	text: '保密',
				// 	value: "保密"
				// }],
				// types: [{
				// 	text: '管理员',
				// 	value: '管理员'
				// }, {
				// 	text: '普通用户',
				// 	value: '普通用户'
				// }],
				// // 分段器数据
				// current: 0,

				// //校验表单数据
				// valiFormData: {
				// 	username: '',
				// 	password: '',
				// 	userType: '管理员',
				// 	age: '',
				// 	gener: '男',
				// 	phone: ''
				// },
				// imageUrl: '',
				// // 校验规则
				// rules: {
				// 	username: {
				// 		rules: [{
				// 			required: true,
				// 			errorMessage: '账号不能为空'
				// 		}]
				// 	},
				// 	password: {
				// 		rules: [{
				// 			required: true,
				// 			errorMessage: '密码不能为空'
				// 		}]
				// 	},
				// 	age: {
				// 		rules: [{
				// 			required: true,
				// 			errorMessage: '年龄不能为空'
				// 		}, {
				// 			format: 'number',
				// 			errorMessage: '年龄只能输入数字'
				// 		}]
				// 	}
				// }
			}
		},
		computed: {},
		onLoad() {},
		onReady() {
			// 设置自定义表单校验规则，必须在节点渲染完毕后执行
			// this.$refs.customForm.setRules(this.customRules)
		},
		methods: {
			onClickItem(e) {
				console.log(e);
				this.current = e.currentIndex
			},
			add() {},
			del(id) {
				// let index = this.dynamicLists.findIndex(v => v.id === id)
				// this.dynamicLists.splice(index, 1)
			},
			submit(ref) {
				var that = this;
				this.$refs[ref].validate().then(res => {
					console.log('success', res);
					// uni.showToast({
					// 	title: `校验通过`
					// })
					res.image = that.imageUrl;
					console.log(res);
					//一般报405就是前后端格式不正确
					// uni.request({
					// 	url: '/api/addCS22Record',  // addUser
					// 	// type: "post",
					// 	method: "post",
					// 	data: JSON.stringify(res),
					// 	header: {
					// 		"Content-Type": "application/json"
					// 	},
					// 	success: function(data) {
					// 		console.log(777);
					// 		console.log(data);
					// 		uni.showToast({
					// 			title: "添加成功"
					// 		});
					// 		that.user = {}
					// 	}
					// })
					addCS22Record(res).then(data =>{
						console.log(44);
						console.log(data);
						uni.showToast({
							title:"添加成功"
						})
					})
				}).catch(err => {
					console.log('err', err);
				})
			},
			//添加图片点击事件
			uploadFile(e) {
				var that = this;
				console.log(55);
				console.log(e);
				uni.uploadFile({
					url: "/api/uploadFile",
					filePath: e.tempFilePaths[0],
					name: "file",
					// methoed:"post",
					// data: formData,
					success: function(data) {
						console.log(555);
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