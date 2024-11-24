<template>
	<div class="app-container">
		<el-row :gutter="24">
			<!--用户数据-->
			<el-col :span="24" :xs="24">
				<el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
					<el-form-item label="检测单位" prop="jcdwmc ">
						<el-input v-model="queryParams.jcdwmc " placeholder="请输入检测单位名称" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item>
						<el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
						<el-button icon="Refresh" @click="resetQuery">重置</el-button>
					</el-form-item>
				</el-form>


				<!-- 功能选项 -->
				<el-row :gutter="10" class="mb8">
					<el-col :span="1.5">
						<el-button type="primary" plain icon="Plus" @click="handleAdd"
							v-hasPermi="['system:contract:add']">新增</el-button>
					</el-col>
					<el-col :span="1.5">
						<el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate"
							v-hasPermi="['system:contract:edit']">修改</el-button>
					</el-col>
					<el-col :span="1.5">
						<el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete"
							v-hasPermi="['system:contract:remove']">删除</el-button>
					</el-col>
					<el-col :span="1.5">
						<el-button type="info" plain icon="Upload" @click="handleImport"
							v-hasPermi="['system:contract:import']">导入</el-button>
					</el-col>
					<el-col :span="1.5">
						<el-button type="warning" plain icon="Download" @click="handleExport"
							v-hasPermi="['system:contract:export']">导出</el-button>
					</el-col>
					<right-toolbar v-model:showSearch="showSearch" @queryTable="getList"
						:columns="columns"></right-toolbar>
				</el-row>
				<!-- 这里是要实现的功能业务 -->
				<el-table v-loading="loading" :data="contractList" @selection-change="handleSelectionChange">
					<el-table-column type="selection" width="50" align="center" />
					<el-table-column label="检测单位名称" align="center" key="jcdwmc" prop="jcdwmc" />
					<el-table-column label="记录编号" align="center" key="jlbh" prop="jlbh" />
					<el-table-column label="工程名称" align="center" key="gcmc" prop="gcmc" />
					<el-table-column label="合同段" align="center" key="htd" prop="htd" />
					<el-table-column label="施工单位" align="center" key="sgdw" prop="sgdw" />
					<el-table-column label="监理单位" align="center" key="jldw" prop="jldw" />
					<el-table-column label="工程部门/用途" align="center" key="gcbwyt" prop="gcbwyt" />
					<el-table-column label="样品信息" align="center" key="ypxx" prop="ypxx" />
					<el-table-column label="试验检测日期" align="center" key="syjcrq" prop="syjcrq" />
					<!-- 实验条件 -->
					<el-table-column label="实验条件的温度(℃)" align="center" key="sytj_wd" prop="sytj_wd" />
					<el-table-column label="实验条件的湿度(%)" align="center" key="sytj_sd" prop="sytj_sd" />
					<!-- 实验条件的温度 和 湿度  -->
					<el-table-column label="测试依据" align="center" key="csyj" prop="csyj" />
					<el-table-column label="判定依据" align="center" key="pdyj" prop="pdyj" />
					<el-table-column label="主要仪器设备名称和编号" align="center" key="zyyjsbmcjbh" prop="zyyjsbmcjbh" />
					<el-table-column label="试扮混泥土性能,提出试伴配合比" align="center" key="sbhntxnphb" prop="sbhntxnphb" />
					<el-table-column label="坍落度a1单值(mm)" align="center" key="dld_A1" prop="dld_A1" />
					<el-table-column label="坍落度a2单值(mm)" align="center" key="dld_A2" prop="dld_A2" />
					<el-table-column label="坍落度a平均值(mm)" align="center" key="dld_A" prop="dld_A" />
					<el-table-column label="扩展度b1单值(mm)" align="center" key="kzd_B1" prop="kzd_B1" />
					<el-table-column label="扩展度b2单值(mm)" align="center" key="kzd_B2" prop="kzd_B2" />
					<el-table-column label="扩展度b平均值(mm)" align="center" key="kzd_B" prop="kzd_B" />
					<el-table-column label="砼拌合物_棍度" align="center" key="tbhw_gd" prop="tbhw_gd" />
					<el-table-column label="砼拌合物_含沙情况" align="center" key="tbhw_hsqk" prop="tbhw_hsqk" />
					<el-table-column label="砼拌合物_粘聚性" align="center" key="tbhw_njx" prop="tbhw_njx" />
					<el-table-column label="砼拌合物_保水性" align="center" key="tbhw_bsx" prop="tbhw_bsx" />
					<el-table-column label="备注" align="center" key="bz" prop="bz" />
					<el-table-column label="水胶比" align="center" key="sjb_C" prop="sjb_C" />
					<el-table-column label="筒+砼质量1(kg)" align="center" key="t_tzl_D1" prop="t_tzl_D1" />
					<el-table-column label="筒+砼质量2(kg)" align="center" key="t_tzl_D2" prop="t_tzl_D2" />
					<el-table-column label="筒质量1(kg)" align="center" key="t_zl_E1" prop="t_zl_E1" />
					<el-table-column label="桶质量2(kg)" align="center" key="t_zl_E2" prop="t_zl_E2" />
					<el-table-column label="砼质量1(kg)" align="center" key="t_zl_F1" prop="t_zl_F1" />
					<el-table-column label="砼质量2(kg)" align="center" key="t_zl_F2" prop="t_zl_F2" />
					<el-table-column label="筒容积1(L)" align="center" key="t_rj_G1" prop="t_rj_G1" />
					<el-table-column label="筒容积2(L)" align="center" key="t_rj_G2" prop="t_rj_G2" />
					<el-table-column label="实测表观密度单值1(kg/m^3)" align="center" key="scbgmd_dz_H1" prop="scbgmd_dz_H1" />
					<el-table-column label="实测表观密度单值2(kg/m^3)" align="center" key="scbgmd_dz_H2" prop="scbgmd_dz_H2" />
					<el-table-column label="实测表观密度平均值(kg/m^3)" align="center" key="scbgmd_dz_H" prop="scbgmd_dz_H" />
					<el-table-column label="表观密度计算值(kg/m^3)" align="center" key="bjmdjsz_p" prop="bjmdjsz_p" />
					<el-table-column label="配合比较正系数δ" align="center" key="phjjzxs_sigma" prop="phjjzxs_sigma" />
					<el-table-column label="试板配比1" align="center" key="sbpb_1" prop="sbpb_1" />
					<el-table-column label="试板配比2" align="center" key="sbpb_2" prop="sbpb_2" />
					<el-table-column label="基准水胶比" align="center" key="jjsjb" prop="jjsjb" />
					<el-table-column label="设计计算方法" align="center" key="sjjsff" prop="sjjsff" />
					<el-table-column label="假定密度(kg/m^3)" align="center" key="jdmd" prop="jdmd" />
					<el-table-column label="水胶比1" align="center" key="sjb_I1" prop="sjb_I1" />
					<el-table-column label="水胶比2" align="center" key="sjb_I2" prop="sjb_I2" />
					<el-table-column label="水泥1(kg)" align="center" key="sn_J1" prop="sn_J1" />
					<el-table-column label="水泥2(kg)" align="center" key="sn_J2" prop="sn_J2" />
					<el-table-column label="细集料1(kg)" align="center" key="xjl_K1" prop="xjl_K1" />
					<el-table-column label="细集料2(kg)" align="center" key="xjl_K2" prop="xjl_K2" />
					<el-table-column label="粗集料1(kg)" align="center" key="cjl_L1" prop="cjl_L1" />
					<el-table-column label="粗集料2(kg)" align="center" key="cjl_L2" prop="cjl_L2" />
					<el-table-column label="水1(kg)" align="center" key="s_M1" prop="s_M1" />
					<el-table-column label="水2(kg)" align="center" key="s_M2" prop="s_M2"/>
					<el-table-column label="外加剂名称1" align="center" key="wjj_mc1" prop="wjj_mc1" />
					<el-table-column label="外加剂1质量1(kg)" align="center" key="wjjzlmc1_N1" prop="wjjzlmc1_N1" />
					<el-table-column label="外加剂1质量2(kg)" align="center" key="wjjzlmc1_N2" prop="wjjzlmc1_N2" />
					<el-table-column label="外加剂名称2" align="center" key="wjj_mc2" prop="wjj_mc2" />
					<el-table-column label="外加剂2质量1(kg)" align="center" key="wjjzlmc2_O1" prop="wjjzlmc2_O1" />
					<el-table-column label="外加剂2质量2(kg)" align="center" key="wjjzlmc2_O2" prop="wjjzlmc2_O2" />
					<el-table-column label="矿物掺和料名称1" align="center" key="kwchl_mc1" prop="kwchl_mc1" />
					<el-table-column label="矿物掺和料名称1质量1(kg)" align="center" key="kwchlmc1_P1" prop="kwchlmc1_P1" />
					<el-table-column label="矿物掺和料名称1质量2(kg)" align="center" key="kwchlmc1_P2" prop="kwchlmc1_P2" />
					<el-table-column label="矿物掺和料名称2" align="center" key="kwchl_mc2" prop="kwchl_mc2" />
					<el-table-column label="矿物掺和料名称2质量1(kg)" align="center" key="kwchlmc2_Q1" prop="kwchlmc2_Q1" />
					<el-table-column label="矿物掺和料名称2质量2(kg)" align="center" key="kwchlmc2_Q2" prop="kwchlmc2_Q2" />
					<el-table-column label="砂率1(%) " align="center" key="sl_R1" prop="sl_R1" />
					<el-table-column label="砂率2(%) " align="center" key="sl_R2" prop="sl_R2" />
					<!-- 前端数据表格的位置 -->
					<el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
						<template #default="scope">
							<el-tooltip content="修改" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
									v-hasPermi="['system:contract:edit']"></el-button>
							</el-tooltip>
							<el-tooltip content="删除" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
									v-hasPermi="['system:contract:remove']"></el-button>
							</el-tooltip>
							<!-- 导出表格 -->
							<el-tooltip content="查看详情" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Edit" @click="handleDetail(scope.row)"
									v-hasPermi="['system:contract:remove']"></el-button>
							</el-tooltip>

						</template>
					</el-table-column>
				</el-table>
				<pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum"
					v-model:limit="queryParams.pageSize" @pagination="getList" />
			</el-col>
		</el-row>

		<!-- 添加或修改砼测试配置对话框 -->
		<el-dialog :title="title" v-model="open" width="600px" append-to-body>

			<el-form :model="form" :rules="rules" ref="contractRef" label-width="80px">
				<!-- 基础信息  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="基础信息的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 检测单位名称 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="检测单位名称" prop="jcdwmc" label-width="100">
							<el-input v-model="form.jcdwmc" placeholder="请输入检测单位名称" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 记录编号 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="记录编号 " prop="jlbh">
							<el-input v-model="form.jlbh" placeholder="请输入记录编号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 工程名称 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="工程名称" prop="gcmc">
							<el-input v-model="form.gcmc" placeholder="请输入工程名称" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 合同段 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="合同段" prop="htd">
							<el-input v-model="form.htd" placeholder="请输入合同段" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 施工单位名称 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="施工单位" prop="sgdw">
							<el-input v-model="form.sgdw" placeholder="请输入施工单位" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 监理单位  -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="监理单位" prop="jldw">
							<el-input v-model="form.jldw" placeholder="请输入监理单位" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 工程部门 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="工程部门" prop="gcbwyt">
							<el-input v-model="form.gcbwyt" placeholder="请输入工程部门" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 样品信息 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="样品信息" prop="ypxx">
							<el-input v-model="form.ypxx" placeholder="请输入样品信息" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 试验检测日期 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="试验检测日期(年/月/日)" prop="syjcrq" label-width="170">
							<!-- <el-input v-model="form.syjcrq" placeholder="试验检测日期" maxlength="30" /> -->
							<el-date-picker v-model="form.syjcrq" value-format="YYYY-MM-DD HH:mm:ss" type="datetime"
								style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>


				<button> + </button>

				<!-- 实验条件 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="实验条件的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 实验条件的温度  -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="实验条件的温度(℃)" prop="sytj_wd" label-width="150">
							<el-input v-model="form.sytj_wd" placeholder="请输入实验条件的温度(℃)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 实验条件的湿度  -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="实验条件的湿度(%)" prop="sytj_sd" label-width="150">
							<el-input v-model="form.sytj_sd" placeholder="请输入实验条件湿度(%)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>


				<!-- 两种依据-->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种依据的输入" prop="sytj" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 测试依据 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="测试依据" prop="csyj">
							<el-input v-model="form.csyj" placeholder="请输入测试依据" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 判定依据 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="判定依据" prop="pdyj">
							<el-input v-model="form.pdyj" placeholder="请输入判定依据" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>


				<!-- 其他  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="其他1输入" label-width="170">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 主要仪器设备名称和编号 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="主要仪器设备名称和编号" prop="zyyjsbmcjbh" label-width="170">
							<el-input v-model="form.zyyjsbmcjbh" placeholder="请输入主要仪器设备名称和编号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 试扮混泥土性能,提出试伴配合比 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="试扮混泥土性能,提出试伴配合比" prop="sbhntxnphb" label-width="220">
							<el-input v-model="form.sbhntxnphb" placeholder="请输入试扮混泥土性能,提出试伴配合比" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 坍落度  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种坍落度(mm)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 坍落度a1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="坍落度a1(mm)" prop="dld_A1" label-width="120">
							<el-input v-model="form.dld_A1" placeholder="请输入坍落度a1(mm)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 坍落度a2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="坍落度a2(mm)" prop="dld_A2" label-width="120">
							<el-input v-model="form.dld_A2" placeholder="请输入坍落度a2(mm)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 坍落度a 由 a1、a2自动计算  -->
				<!-- <el-row>
					<el-col :span="24">
						<el-form-item label="坍落度a" prop="dld_A">
							<el-input v-model="form.dld_A" placeholder="请输入坍落度a" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->

				<!-- 扩展度 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种扩展度(mm)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 扩展度b1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="扩展度b1(mm)" prop="kzd_B1" label-width="120">
							<el-input v-model="form.kzd_B1" placeholder="请输入扩展度b1(mm)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 扩展度b2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="扩展度b2(mm)" prop="kzd_B2" label-width="120">
							<el-input v-model="form.kzd_B2" placeholder="请输入扩展度b2(mm)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 扩展度b -->
				<!-- <el-row> 由 b1、b2计算
					<el-col :span="24">
						<el-form-item label="扩展度b" prop="kzd_B">
							<el-input v-model="form.kzd_B" placeholder="请输入扩展度b" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->

				<!-- 砼拌化合物的性能 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="砼拌化合物4种的性能" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砼拌合物_棍度 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砼拌合物的棍度" prop="tbhw_gd" label-width="120">
							<el-input v-model="form.tbhw_gd" placeholder="请输入砼拌合物的棍度" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砼拌合物_含沙情况 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砼拌合物的含沙情况" prop="tbhw_hsqk" label-width="140">
							<el-input v-model="form.tbhw_hsqk" placeholder="请输入砼拌合物的含沙情况" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砼拌合物_粘聚性 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砼拌合物的粘聚性" prop="tbhw_njx" label-width="130">
							<el-input v-model="form.tbhw_njx" placeholder="请输入砼拌合物的粘聚性" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砼拌合物_保水性 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砼拌合物的保水性" prop="tbhw_bsx" label-width="130">
							<el-input v-model="form.tbhw_bsx" placeholder="请输入砼拌合物的保水性" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 其他  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="其他2输入" label-width="170">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 备注 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="备注" prop="bz">
							<el-input v-model="form.bz" placeholder="请输入备注" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水胶比 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水胶比" prop="sjb_C">
							<el-input v-model="form.sjb_C" placeholder="请输入水胶比" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 筒+砼质量 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种筒+砼质量(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 筒+砼质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒+砼质量1(kg)" prop="t_tzl_D1" label-width="120">
							<el-input v-model="form.t_tzl_D1" placeholder="请输入筒+砼质量1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 筒+砼质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒+砼质量2(kg)" prop="t_tzl_D2" label-width="120">
							<el-input v-model="form.t_tzl_D2" placeholder="请输入筒+砼质量2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 桶质量 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种桶质量(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 筒质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒1质量(kg)" prop="t_zl_E1" label-width="100">
							<el-input v-model="form.t_zl_E1" placeholder="请输入筒1质量(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 桶质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒2质量(kg)" prop="t_zl_E2" label-width="100">
							<el-input v-model="form.t_zl_E2" placeholder="请输入筒2质量(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 砼质量1 自动计算 
				<el-row>  
					<el-col :span="24">
						<el-form-item label="砼质量1" prop="t_zl_F1">
							<el-input v-model="form.t_zl_F1" placeholder="请输入砼质量1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				-- 砼质量2  自动计算 
				<el-row>
					<el-col :span="24">
						<el-form-item label="砼质量2" prop="t_zl_F2">
							<el-input v-model="form.t_zl_F2" placeholder="请输入砼质量2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->

				<!-- 筒容积 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种筒容积(L)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 筒容积111 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒1容积(L)" prop="t_rj_G1">
							<el-input v-model="form.t_rj_G1" placeholder="请输入筒1容积(L)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 筒容积2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="筒2容积(L)" prop="t_rj_G2">
							<el-input v-model="form.t_rj_G2" placeholder="请输入筒2容积(L)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- -- 实测表观密度单值1 -
				<el-row>
					<el-col :span="24">
						<el-form-item label="实测表观密度单值1" prop="scbgmd_dz_H1">
							<el-input v-model="form.scbgmd_dz_H1" placeholder="请输入实测表观密度单值1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				-- 实测表观密度单值2 --
				<el-row>
					<el-col :span="24">
						<el-form-item label="实测表观密度单值2" prop="scbgmd_dz_H2">
							<el-input v-model="form.scbgmd_dz_H2" placeholder="请输入实测表观密度单值2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				-- 实测表观密度平均值 --
				<el-row>
					<el-col :span="24">
						<el-form-item label="实测表观密度平均值" prop="scbgmd_dz_H">
							<el-input v-model="form.scbgmd_dz_H" placeholder="请输入实测表观密度平均值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->
				<!-- 其他  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="其他3输入" label-width="170">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 表观密度计算值 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="表观密度计算值(kg/m^3)" prop="bjmdjsz_p" label-width="170">
							<el-input v-model="form.bjmdjsz_p" placeholder="请输入表观密度计算值(kg/m^3)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 配合比较正系数sigma -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="配合比较正系数δ" prop="phjjzxs_sigma" label-width="120">
							<el-input v-model="form.phjjzxs_sigma" placeholder="请输入配合比较正系数δ" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 试板配比 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种试板配比的输入" prop="sytj" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 试板配比1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="试板配比1" prop="sbpb_1">
							<el-input v-model="form.sbpb_1" placeholder="请输入试板配比1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 试板配比2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="试板配比2" prop="sbpb_2">
							<el-input v-model="form.sbpb_2" placeholder="请输入试板配比2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 其他  -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="其他4输入" label-width="170">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 基准水胶比 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="基准水胶比" prop="jjsjb" label-width="90">
							<el-input v-model="form.jjsjb" placeholder="请输入基准水胶比" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 设计计算方法-->
				<el-row>
					<el-col :span="24">
						<el-form-item label="设计计算方法" prop="sjjsff" label-width="100">
							<el-input v-model="form.sjjsff" placeholder="请输入设计计算方法" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 假定密度 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="假定密度(kg/m^3)" prop="jdmd" label-width="130">
							<el-input v-model="form.jdmd" placeholder="请输入假定密度(kg/m^3)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>


				<!-- 水胶比 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种水胶比的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水胶比1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水胶比1" prop="sjb_I1">
							<el-input v-model="form.sjb_I1" placeholder="请输入水胶比1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水胶比2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水胶比2" prop="sjb_I2">
							<el-input v-model="form.sjb_I2" placeholder="请输入水胶比2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 水泥 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种水泥(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水泥1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水泥1(kg)" prop="sn_J1">
							<el-input v-model="form.sn_J1" placeholder="请输入水泥1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水泥2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水泥2(kg)" prop="sn_J2">
							<el-input v-model="form.sn_J2" placeholder="请输入水泥2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 细集料 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种细集料(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 细集料1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="细集料1(kg)" prop="xjl_K1" label-width="100">
							<el-input v-model="form.xjl_K1" placeholder="请输入细集料1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 细集料2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="细集料2(kg)" prop="xjl_K2" label-width="100">
							<el-input v-model="form.xjl_K2" placeholder="请输入细集料2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 粗集料 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种粗集料(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 粗集料1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="粗集料1(kg)" prop="cjl_L1" label-width="100">
							<el-input v-model="form.cjl_L1" placeholder="请输入粗集料1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 粗集料2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="粗集料2(kg)" prop="cjl_L2" label-width="100">
							<el-input v-model="form.cjl_L2" placeholder="请输入粗集料2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 水 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两次水(kg)的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水1(kg)" prop="s_M1">
							<el-input v-model="form.s_M1" placeholder="请输入水1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 水2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="水2(kg)" prop="s_M2">
							<el-input v-model="form.s_M2" placeholder="请输入水2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 外加剂 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种外加剂名称和质量的输入" label-width="200">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂名称1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂名称1" prop="wjj_mc1" label-width="100">
							<el-input v-model="form.wjj_mc1" placeholder="请输入外加剂名称1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂1质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂1质量1(kg)" prop="wjjzlmc1_N1" label-width="130">
							<el-input v-model="form.wjjzlmc1_N1" placeholder="请输入外加剂1质量1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂1质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂1质量2(kg)" prop="wjjzlmc1_N2" label-width="130">
							<el-input v-model="form.wjjzlmc1_N2" placeholder="请输入外加剂1质量2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂名称2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂名称2" prop="wjj_mc2" label-width="100">
							<el-input v-model="form.wjj_mc2" placeholder="请输入外加剂名称2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂2质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂2质量1(kg)" prop="wjjzlmc2_O1" label-width="130">
							<el-input v-model="form.wjjzlmc2_O1" placeholder="请输入外加剂2质量1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 外加剂2质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="外加剂2质量2(kg)" prop="wjjzlmc2_O2" label-width="130">
							<el-input v-model="form.wjjzlmc2_O2" placeholder="请输入外加剂2质量2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 矿物掺合料 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种矿物掺合料名称和质量(kg)的输入" label-width="250">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺合料名称1" prop="kwchl_mc1" label-width="130">
							<el-input v-model="form.kwchl_mc1" placeholder="请输入矿物掺合料名称1" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称1质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺合料名称1质量1(kg)" prop="kwchlmc1_P1" label-width="190">
							<el-input v-model="form.kwchlmc1_P1" placeholder="请输入矿物掺合料名称1质量1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称1质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺和料名称1质量2(kg)" prop="kwchlmc1_P2" label-width="190">
							<el-input v-model="form.kwchlmc1_P2" placeholder="请输入矿物掺和料名称1质量2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺和料名称2" prop="kwchl_mc2" label-width="130">
							<el-input v-model="form.kwchl_mc2" placeholder="请输入矿物掺和料名称2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称2质量1 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺和料名称2质量1(kg)" prop="kwchlmc2_Q1" label-width="190">
							<el-input v-model="form.kwchlmc2_Q1" placeholder="请输入矿物掺和料名称2质量1(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 矿物掺和料名称2质量2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="矿物掺和料名称2质量2(kg)" prop="kwchlmc2_Q2" label-width="190">
							<el-input v-model="form.kwchlmc2_Q2" placeholder="请输入矿物掺和料名称2质量2(kg)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 砂率 -->
				<el-row>
					<el-col :span="12" :offset="6">
						<el-form-item label="两种砂率(%)输入" label-width="170">
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砂率1-->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砂率1(%)" prop="sl_R1">
							<el-input v-model="form.sl_R1" placeholder="请输入砂率1(%)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>
				<!-- 砂率2 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="砂率2(%)" prop="sl_R2">
							<el-input v-model="form.sl_R2" placeholder="请输入砂率2(%)" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>




			</el-form>
			<template #footer>
				<div class="dialog-footer">
					<el-button type="primary" @click="submitForm">确 定</el-button>
					<el-button @click="cancel">取 消</el-button>
				</div>
			</template>
		</el-dialog>

		<!-- 砼测试导入对话框 -->
		<el-dialog :title="upload.title" v-model="upload.open" width="400px" append-to-body>
			<el-upload ref="uploadRef" :limit="1" accept=".xlsx, .xls" :headers="upload.headers"
				:action="upload.url + '?updateSupport=' + upload.updateSupport" :disabled="upload.isUploading"
				:on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false" drag>
				<el-icon class="el-icon--upload"><upload-filled /></el-icon>
				<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
				<template #tip>
					<div class="el-upload__tip text-center">
						<div class="el-upload__tip">
							<el-checkbox v-model="upload.updateSupport" />是否更新已经存在的砼测试数据
						</div>
						<span>仅允许导入xls、xlsx格式文件。</span>
						<el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
							@click="importTemplate">下载模板</el-link>
					</div>
				</template>
			</el-upload>
			<template #footer>
				<div class="dialog-footer">
					<el-button type="primary" @click="submitFileForm">确 定</el-button>
					<el-button @click="upload.open = false">取 消</el-button>
				</div>
			</template>
		</el-dialog>

		<!-- 导出表格 -->
		<el-dialog :title="title" v-model="openExcel" width="1850px" append-to-body>
			<el-form :model="form" :rules="rules" ref="contractRef" label-width="100px">
				<!-- 编写表格 -->
				<table id="CS22Record">
					<!-- 一个 tr 是 表格相当于 换行 、 colspan属性 合并列的表格 长度  rowspan属性是合并行的表格  -->
					<tr style="border: 1px solid black;">
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">砼试表CS22</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="20" style="height:60; font-size: 40px ; border:1px solid black;">
							路面混凝土配合比设计试验检测记录表(二)
						</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							记录编号：{{form.jlbh}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							检测单位名称：{{form.jlbh}}
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">工程名称：{{form.gcmc}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">合同段：{{form.htd}}
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">施工单位：{{form.sgdw}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">监理单位：{{form.jldw}}
						</td>
					</tr>
					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">
							工程部位/用途：{{form.gcbwyt}}
						</td>
					</tr>
					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">
							样品信息：{{form.ypxx}}
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							试验检测日期：{{form.syjcrq}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							试验条件：温度：{{form.sytj_wd}} (℃) 湿度：{{form.sytj_sd}} (%)
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">测试依据：{{form.csyj}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">判定依据：{{form.pdyj}}
						</td>
					</tr>
					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">主要仪器设备
							名称及编号：{{form.zyyjsbmcjbh}}
						</td>
					</tr>
					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">
							试拌混凝土性能，提出试拌配合比：{{form.sbhntxnphb}}
						</td>
					</tr>


					<!-- 表格的合并与考虑 -->
					<tr>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">坍落度(mm)
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">扩展度(mm)
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">砼拌合物性能
						</td>
						<td colspan="5" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">备注
						</td>
					</tr>
					<!-- 单值、平均值、说明  -->
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">单值
						</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">平均值
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">单值
						</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">平均值
						</td>
						<td colspan="1" style="height:50; font-size: 35px ; border:1px solid black;">棍度
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">含沙情况
						</td>
						<td colspan="1" style="height:50; font-size: 35px ; border:1px solid black;">粘聚性
						</td>
						<td colspan="1" style="height:50; font-size: 35px ; border:1px solid black;">保水性
						</td>
					</tr>
					<!-- 1行赋值 操作  -->
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.dld_A1}}
						</td>
						<td colspan="3" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							avarage_valueA <!-- 平均值 占两行 -->
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.kzd_B1}}
						</td>
						<td colspan="3" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							avarage_valueB <!-- 平均值占两行 -->
						</td>
						<td colspan="1" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.tbhw_gd}} <!-- 棍度的值-->
						</td>
						<td colspan="2" rowspan="2" sytle="height:50; font-size: 35px ; border:1px solid black;">
							{{form.tbhw_hsqk}} <!-- 含沙情况 -->
						</td>
						<td colspan="1" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.tbhw_njx}} <!-- 粘聚性  -->
						</td>
						<td colspan="1" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.tbhw_bsx}} <!-- 保水性  -->
						</td>
						<td colspan="5" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.bz}} <!-- 备注  -->
						</td>
					</tr>
					<!-- 2行赋值 操作  -->
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.dld_A2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.kzd_B2}}
						</td>
					</tr>

					<!-- 18、19-->
					<tr>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">胶水比
						</td>
						<td colspan="3" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							筒+砼质量(kg)
						</td>
						<td colspan="4" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">筒质量(kg)
						</td>
						<td colspan="4" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">砼质量(kg)
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">筒容积(L)
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">实测表观密度(kg/m3)
						</td>
					</tr>
					<!-- 实测表观密度的单值合平均值 -->
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">单值
						</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">平均值
						</td>
					</tr>
					<!-- 单值1 合平均值 -->
					<tr>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.sjb_C}}
						</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_tzl_D1}}
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_zl_E1}}
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_tzl_D1-form.t_zl_E1}}
							<!-- 计算字段值：砼质量1 -->
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_rj_G1}}
							<!-- 筒容积1 -->
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{(form.t_tzl_D1-form.t_zl_E1)/form.t_rj_G1}}
							<!-- 计算字段 -->
						</td>
						<td colspan="3" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{ ( ( (form.t_tzl_D2-form.t_zl_E2)/form.t_rj_G2) + ((form.t_tzl_D2-form.t_zl_E2)/form.t_rj_G2)) /2}}  <!-- 平均值：计算字段   -->
						</td>
					</tr>
					<!-- 单值2 -->
					<tr>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_tzl_D2}}
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_zl_E2}}
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_tzl_D2-form.t_zl_E2}}</td>
						<!-- 计算字段值：砼质量2 -->
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.t_rj_G2}}
							<!-- 筒容积1 -->
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{(form.t_tzl_D2-form.t_zl_E2)/form.t_rj_G2}}
							<!-- 计算字段 -->
						</td>
					</tr>

					<!-- 表观目睹  -->
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							表观密度计算值(kg/m3)：{{form.bjmdjsz_p}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							配合比校正系数δ：{{form.phjjzxs_sigma}}
						</td>
					</tr>

					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">
							备注：当混凝土拌合物表观密度实测值与计算值之差的绝对值不超过计算值的2%，配合比可维持不变；
							当两者之差超过2%时，应将配合比中每项材料用量均乘以校正系数
						</td>
					</tr>

					<!-- 配合比   -->
					<tr>
						<td colspan="10" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">试办配合比
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sbpb_1}}
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sbpb_2}}
						</td>
					</tr>
					<!-- 表3  -->
					<tr>
						<td colspan="20" style="height:50; font-size: 35px ; border:1px solid black;">3、检验表格：
						</td>
					</tr>

					<!-- 1   -->
					<tr>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">
							基准胶水比：{{form.jjsjb}}
						</td>
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">
							设计计算方法：{{form.sjjsff}}
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">
							假定密度(kg/m3)：{{form.jdmd}}
						</td>
					</tr>

					<!-- 最后一个表格 -->
					<tr>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">水胶比
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">水泥(kg)
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">细集料(kg)
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">粗集料(kg)
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">水(kg)
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">外加剂(kg)
						</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">矿物掺合料(kg)
						</td>
						<td colspan="2" rowspan="2" style="height:50; font-size: 35px ; border:1px solid black;">砂率(%)
						</td>
					</tr>

					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.wjj_mc1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.wjj_mc2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.kwchl_mc1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.kwchl_mc2}}
						</td>
					</tr>

					<!-- 最后一个表格的值  -->
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sjb_I1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sn_J1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.xjl_K1}})
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.cjl_L1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.s_M1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.wjjzlmc1_N1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.wjjzlmc2_O1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.kwchlmc1_P1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.kwchlmc2_Q1}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sl_R1}}
						</td>
					</tr>
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sjb_I2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sn_J2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.xjl_K2}})
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.cjl_L2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.s_M2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.wjjzlmc1_N2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.wjjzlmc2_O2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.kwchlmc1_P2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.kwchlmc2_Q2}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sl_R2}}
						</td>
					</tr>

					<tr>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">检测：
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">记录：
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">复合:
						</td>
						<td colspan="5" style="height:50; font-size: 35px ; border:1px solid black;">日期：
						</td>
					</tr>

				</table>

			</el-form>
			<template #footer>
				<div class="dialog-footer">
					<el-button type="primary">修改</el-button>
					<el-button type="success" @click="uploadExcel">下载</el-button>
				</div>
			</template>
		</el-dialog>


	</div>
</template>

<!-- contract -->
<!--
// vue 中的 script 标签定义组件的逻辑和行为，包括数据、方法、计算属性、侦听器和生命周期钩子。
// 它还提供组件模板，并与其他 vue 标签协同工作，通过编译器解析后转换为可执行的 javascript 代码。
-->
<script setup name="contract">
	import $ from 'jquery'; // npm install jquery | revise add ''
	import {
		getToken
	} from "@/utils/auth";
	import {
		// 后端 对应的实现函数 
		getCS22Records,
		getCS22Record,
		addCS22Record,
		editCS22Record,
		deleteCS22Record
	} from "@/api/class224/CS22";

	const router = useRouter();
	const {
		proxy
	} = getCurrentInstance();

	const contractList = ref([]);
	const open = ref(false);
	const openExcel = ref(false);
	const loading = ref(true);
	const showSearch = ref(true);
	const ids = ref([]);
	const single = ref(true);
	const multiple = ref(true);
	const total = ref(0);
	const title = ref("");
	const dateRange = ref([]);
	const deptName = ref("");
	const deptOptions = ref(undefined);
	const initPassword = ref(undefined);
	const postOptions = ref([]);
	const roleOptions = ref([]);
	/*** 砼测试导入参数 */
	const upload = reactive({
		// 是否显示弹出层（砼测试导入）
		open: false,
		// 弹出层标题（砼测试导入）
		title: "",
		// 是否禁用上传
		isUploading: false,
		// 是否更新已经存在的砼测试数据
		updateSupport: 0,
		// 设置上传的请求头部
		headers: {
			Authorization: "Bearer " + getToken()
		},
		// 上传的地址
		url: import.meta.env.VITE_APP_BASE_API + "/system/contract/importData"
	});

	const data = reactive({
		form: {},
		queryParams: {
			pageNum: 1,
			pageSize: 10,
			name: undefined
		},
		rules: {
			contractName: [{
				required: true,
				message: "砼测试名称不能为空",
				trigger: "blur"
			}, {
				min: 2,
				max: 20,
				message: "砼测试名称长度必须介于 2 和 20 之间",
				trigger: "blur"
			}],
			nickName: [{
				required: true,
				message: "砼测试昵称不能为空",
				trigger: "blur"
			}],
			password: [{
				required: true,
				message: "砼测试密码不能为空",
				trigger: "blur"
			}, {
				min: 5,
				max: 20,
				message: "砼测试密码长度必须介于 5 和 20 之间",
				trigger: "blur"
			}, {
				pattern: /^[^<>"'|\\]+$/,
				message: "不能包含非法字符：< > \" ' \\\ |",
				trigger: "blur"
			}],
			// email: [{
			// 	type: "email",
			// 	message: "请输入正确的邮箱地址",
			// 	trigger: ["blur", "change"]
			// }],
			// phonenumber: [{
			// 	pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
			// 	message: "请输入正确的手机号码",
			// 	trigger: "blur"
			// }]
		}
	});

	const {
		queryParams,
		form,
		rules
	} = toRefs(data);

	/** 通过条件过滤节点  */
	const filterNode = (value, data) => {
		if (!value) return true;
		return data.label.indexOf(value) !== -1;
	};

	/** 查询砼测试列表 */
	function getList() {
		loading.value = true;
		console.log(555);
		getCS22Records(queryParams.value).then(res => {
			console.log(123);
			console.log(res);
			loading.value = false;
			contractList.value = res.data.list;
			total.value = res.data.total;
		});
	};

	/** 节点单击事件 */
	function handleNodeClick(data) {
		queryParams.value.deptId = data.id;
		handleQuery();
	};

	/** 搜索按钮操作 */
	function handleQuery() {
		queryParams.value.pageNum = 1;
		getList();
	};

	/** 重置按钮操作 */
	function resetQuery() {
		//dateRange.value = [];
		proxy.resetForm("queryRef");
		//queryParams.value.deptId = undefined;
		//proxy.$refs.deptTreeRef.setCurrentKey(null);
		handleQuery();
	};

	/** 删除按钮操作 */
	function handleDelete(row) {
		const cl11Ids = row.id || ids.value;
		proxy.$modal.confirm('是否确认删除砼测试编号为"' + cl11Ids + '"的数据项？').then(function() {
			return deleteCS22Record(cl11Ids);
		}).then(() => {
			getList();
			proxy.$modal.msgSuccess("删除成功");
		}).catch(() => {});
	};

	/** 导出按钮操作 */
	function handleExport() {
		proxy.download("system/contract/export", {
			...queryParams.value,
		}, `contract_${new Date().getTime()}.xlsx`);
	};

	/** 更多操作 */
	function handleCommand(command, row) {
		switch (command) {
			case "handleResetPwd":
				handleResetPwd(row);
				break;
			case "handleAuthRole":
				handleAuthRole(row);
				break;
			default:
				break;
		}
	};

	/** 选择条数  */
	function handleSelectionChange(selection) {
		ids.value = selection.map(item => item.id);
		single.value = selection.length != 1;
		multiple.value = !selection.length;
	};

	/** 导入按钮操作 */
	function handleImport() {
		upload.title = "砼测试导入";
		upload.open = true;
	};

	/** 下载模板操作 */
	function importTemplate() {
		proxy.download("system/contract/importTemplate", {}, `contract_template_${new Date().getTime()}.xlsx`);
	};

	/**文件上传中处理 */
	const handleFileUploadProgress = (event, file, fileList) => {
		upload.isUploading = true;
	};

	/** 文件上传成功处理 */
	const handleFileSuccess = (response, file, fileList) => {
		upload.open = false;
		upload.isUploading = false;
		proxy.$refs["uploadRef"].handleRemove(file);
		proxy.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" +
			response.msg + "</div>", "导入结果", {
				dangerouslyUseHTMLString: true
			});
		getList();
	};

	/** 提交上传文件 */
	function submitFileForm() {
		proxy.$refs["uploadRef"].submit();
	};

	/** 重置操作表单 */
	function reset() {
		form.value = {
			id: undefined,
			name: undefined,
			wendu: undefined,
			shidu: undefined,
			createdate: undefined
		};
		proxy.resetForm("contractRef");
	};

	/** 取消按钮 */
	function cancel() {
		open.value = false;
		reset();
	};

	/** 新增按钮操作 */
	function handleAdd() {
		open.value = true;
		title.value = "路面混凝土配合比设计试验检测记录表（二）";
		console.log("我点击了")
	};

	/** 修改按钮操作 */
	function handleUpdate(row) {
		reset();
		const id = row.id || ids.value;
		getCS22Record(id).then(response => {
			form.value = response.data;
			open.value = true;
			title.value = "修改砼测试";
		});
	};

	/** 提交按钮 */
	function submitForm() {
		proxy.$refs["contractRef"].validate(valid => {
			if (valid) {
				if (form.value.id != undefined) {
					editCS22Record(form.value).then(response => {
						proxy.$modal.msgSuccess("修改成功");
						open.value = false;
						getList();
					});
				} else {
					addCS22Record(form.value).then(response => {
						proxy.$modal.msgSuccess("新增成功");
						open.value = false;
						getList();
					});
				}
				reset()
			}
		});
	};

	/** 查看详情 (表格) : 有导出 了 */
	function handleDetail(row) {
		reset();
		const id = row.id || ids.value;
		getCS22Record(id).then(response => {
			form.value = response.data;
			openExcel.value = true;
			title.value = "看查砼测试的详情";
		});
	};

	// 下载表格 
	function uploadExcel() {
		$('#CS22Record').table2excel({
			name: "xxx表格",
			filename: 'xxxx文件名',
			exclude_img: true, // 导出图片
			exclude_links: true, // 导出连接
			exclude_inputs: true, // 导出输入框
		})
	}

	getList();
</script>

<style>
	.center-label .el-form-item__label {
		text-align: center;
	}
</style>