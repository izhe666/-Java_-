<template>
	<div class="app-container">
		<el-row :gutter="24">

			<!--用户数据-->
			<el-col :span="24" :xs="24">
				<el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
					<el-form-item label="检测单位" prop="jcdwmc">
						<el-input v-model="queryParams.jcdwmc" placeholder="请输入检测单位名称" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>

					<el-form-item>
						<el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
						<el-button icon="Refresh" @click="resetQuery">重置</el-button>
					</el-form-item>
				</el-form>

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
					<!-- <el-col :span="1.5">
						<el-button type="info" plain icon="Upload" @click="handleImport"
							v-hasPermi="['system:contract:import']">导入</el-button>
					</el-col>
					<el-col :span="1.5">
						<el-button type="warning" plain icon="Download" @click="handleExport"
							v-hasPermi="['system:contract:export']">导出</el-button>
					</el-col> -->
					<right-toolbar v-model:showSearch="showSearch" @queryTable="getList"
						:columns="columns"></right-toolbar>
				</el-row>

				<el-table v-loading="loading" :data="contractList" @selection-change="handleSelectionChange">
					<el-table-column type="selection" width="50" align="center" />
					<el-table-column label="检测单位名称" align="center" key="jcdwmc" prop="jcdwmc" />
					<el-table-column label="记录编号" align="center" key="jlbh" prop="jlbh" />
					<el-table-column label="工程名称" align="center" key="gcmc" prop="gcmc" />
					<el-table-column label="合同段" align="center" key="htd" prop="htd" />
					<el-table-column label="施工单位" align="center" key="sgdw" prop="sgdw" />
					<el-table-column label="监理单位" align="center" key="jldw" prop="jldw" />
					<el-table-column label="工程部位" align="center" key="gcbw" prop="gcbw" />
					<el-table-column label="样品信息" align="center" key="ypxx" prop="ypxx" />
					<el-table-column label="试验检测日期" align="center" key="syjcrq" prop="syjcrq" />


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


		<!-- 添加或修改沥青闪点与燃点数据配置对话框 -->
		<el-dialog :title="title" v-model="open" width="1200px" append-to-body>
			<el-form :model="form" :rules="rules" ref="contractRef" label-width="100px">

				<el-row>
					<el-col :span="12">
						<el-form-item label="检测单位" prop="jcdwmc">
							<el-input v-model="form.jcdwmc" placeholder="请输入检测单位名称" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="记录编号" prop="jlbh">
							<el-input v-model="form.jlbh" placeholder="请输入记录编号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="工程名称" prop="gcmc">
							<el-input v-model="form.gcmc" placeholder="请输入工程名称" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="合同段" prop="htd">
							<el-input v-model="form.htd" placeholder="请输入合同段" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="施工单位" prop="sgdw">
							<el-input v-model="form.sgdw" placeholder="请输入施工单位" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="监理单位" prop="jldw">
							<el-input v-model="form.jldw" placeholder="请输入监理单位" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="工程部位" prop="gcbw">
							<el-input v-model="form.gcbw" placeholder="请输入工程部位" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="样品信息" prop="ypxx">
							<el-input v-model="form.ypxx" placeholder="请输入样品信息" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="8">
						<el-form-item label="检测日期" prop="syjcrq">
							<!-- <el-input v-model="form.syjcrq" placeholder="试验检测日期" maxlength="30" /> -->
							<el-date-picker v-model="form.syjcrq" value-format="YYYY-MM-DD HH:mm:ss" type="datetime"
								style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="2">
						<el-form-item label="试验条件" prop="sytj">
							<!-- <el-input v-model="form.sytj" placeholder="请输入试验条件" maxlength="30" /> -->
						</el-form-item>
					</el-col>
					<el-col :span="7">
						<el-form-item label="温度" prop="wd">
							<el-input v-model="form.wd" placeholder="请输入温度" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="7">
						<el-form-item label="相对湿度" prop="xdsd">
							<el-input v-model="form.xdsd" placeholder="请输入相对湿度" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="检测依据" prop="jcyj">
							<el-input v-model="form.jcyj" placeholder="请输入检测依据" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="判定依据" prop="pdyj">
							<el-input v-model="form.pdyj" placeholder="请输入判定依据" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="主要仪器设备名称及编号" prop="zyyqsbmchbh">
							<el-input v-model="form.zyyqsbmchbh" placeholder="请输入设备名称及编号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="沥青种类" prop="lqzl">
							<el-input v-model="form.lqzl" placeholder="请输入沥青种类" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="沥青编号" prop="lqbh">
							<el-input v-model="form.lqbh" placeholder="请输入沥青编号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="8">
						<el-form-item label="生产厂家" prop="sccj">
							<el-input v-model="form.sccj" placeholder="请输入生产厂家" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="生产日期" prop="scrq">
							<!-- <el-input v-model="form.scrq" placeholder="请输入生产日期" maxlength="30" /> -->
							<el-date-picker v-model="form.scrq" value-format="YYYY-MM-DD HH:mm:ss" type="datetime"
								style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="批号" prop="ph">
							<el-input v-model="form.ph" placeholder="请输入批号" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- <el-row>
					<el-col :span="24">
						<el-form-item label="试验次数" prop="sycs">
							<el-input v-model="form.sycs" placeholder="请输入试验次数" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->


				<!-- 循环显示14次记录 -->
				<el-form :model="form" :rules="rules" ref="contractRef" label-width="134px">

					<el-row>
						<!-- 试验次数标签部分，跨两列高度 -->
						<el-col :span="4" class="label-col">
							<el-form-item label="试验次数">
							</el-form-item>
						</el-col>

						<!-- 编号1和2 -->
						<el-col :span="12">
							<el-form-item>
								<div>1</div>
							</el-form-item>
						</el-col>
						<el-col :span="8">
							<el-form-item>
								<div>2</div>
							</el-form-item>
						</el-col>
					</el-row>

					<el-row>
						<el-col :span="12">
							<el-form-item label="初始温度1" prop="cswd1">
								<el-input v-model="form.cswd1" placeholder="请输入温度" maxlength="30" />
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item label="初始温度2" prop="cswd2">
								<el-input v-model="form.cswd2" placeholder="请输入温度" maxlength="30" />
							</el-form-item>
						</el-col>
					</el-row>

					<el-row v-for="i in 14" :key="i">
						<el-col :span="12">
							<el-form-item :label="`1组第${i}次温度记录`" :prop="`a${i}`">
								<el-input v-model="form[`a${i}`]" placeholder="请输入温度记录" type="number" />
							</el-form-item>
						</el-col>
						<el-col :span="12">
							<el-form-item :label="`2组第${i}次温度记录`" :prop="`b${i}`">
								<el-input v-model="form[`b${i}`]" placeholder="请输入温度记录" type="number" />
							</el-form-item>
						</el-col>
					</el-row>
				</el-form>

				<el-row>
					<el-col :span="24">
						<el-form-item label="大气压强" prop="dqyq">
							<el-input v-model="form.dqyq" placeholder="请输入大气压强" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="气压修正值" prop="qyxzz">
							<el-input v-model="form.qyxzz" placeholder="请输入气压修正值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="闪点测值1" prop="sdcz1">
							<el-input v-model="form.sdcz1" placeholder="请输入闪点测值1" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="闪点测值2" prop="sdcz2">
							<el-input v-model="form.sdcz2" placeholder="请输入闪点测值2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- <el-row>
					<el-col :span="24">
						<el-form-item label="闪点平均值" prop="sdpjz">
							<el-input v-model="form.sdpjz" placeholder="请输入闪点平均值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->

				<el-row>
					<el-col :span="24">
						<el-form-item label="闪点修正值" prop="sdxcz">
							<el-input v-model="form.sdxcz" placeholder="请输入闪点修正值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="12">
						<el-form-item label="燃点测值1" prop="rdcz1">
							<el-input v-model="form.rdcz1" placeholder="请输入燃点测值1" maxlength="30" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="燃点测值2" prop="rdcz2">
							<el-input v-model="form.rdcz2" placeholder="请输入燃点测值2" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- <el-row>
					<el-col :span="24">
						<el-form-item label="燃点平均值" prop="rdpjz">
							<el-input v-model="form.rdpjz" placeholder="请输入燃点平均值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row> -->

				<el-row>
					<el-col :span="24">
						<el-form-item label="燃点修正值" prop="rdxcz">
							<el-input v-model="form.rdxcz" placeholder="请输入燃点修正值" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="附加说明" prop="fjsm">
							<el-input v-model="form.fjsm" placeholder="请输入附加说明" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="地点" prop="position">
							<el-input v-model="form.position" placeholder="请输入地点" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="24">
						<el-form-item label="采集人员编号" prop="userid">
							<el-input v-model="form.userid" placeholder="请输入采集人员编号" maxlength="30" />
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



		<!-- 沥青闪点与燃点数据导入对话框 -->
		<el-dialog :title="upload.title" v-model="upload.open" width="400px" append-to-body>
			<el-upload ref="uploadRef" :limit="1" accept=".xlsx, .xls" :headers="upload.headers"
				:action="upload.url + '?updateSupport=' + upload.updateSupport" :disabled="upload.isUploading"
				:on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false" drag>
				<el-icon class="el-icon--upload"><upload-filled /></el-icon>
				<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
				<template #tip>
					<div class="el-upload__tip text-center">
						<div class="el-upload__tip">
							<el-checkbox v-model="upload.updateSupport" />是否更新已经存在的沥青闪点与燃点数据数据
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
		<el-dialog :title="title" v-model="openExcel" width="1200px" append-to-body>
			<el-form :model="form" :rules="rules" ref="contractRef" label-width="80px">
				<body>
					<!-- <table>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">沥青闪点与燃点试验检测记录表</td>
						<tr style="border: 1px solid black;">
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">检测单位名称：</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.jcdwmc}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">
								记录编号：{{form.jlbh}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">工程名称</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.gcmc}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">合同段</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.htd}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">施工单位</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sgdw}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">监理单位</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.jldw}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">工程部位/用途</td>
							<td colspan="8" style="height:50; font-size: 35px ; border:1px solid red;">{{form.gcbw}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">样品信息</td>
							<td colspan="8" style="height:50; font-size: 35px ; border:1px solid red;">{{form.ypxx}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">试验检测日期</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.syjcrq}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">试验条件</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">
								温度：{{form.wd}}相对湿度：{{form.xdsd}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">检测依据</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.jcyj}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">判定依据</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.pdyj}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">主要仪器设备名称及编号</td>
							<td colspan="8" style="height:50; font-size: 35px ; border:1px solid red;">
								{{form.zyyqsbmchbh}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">沥青种类</td>
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">{{form.lqzl}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">沥青标号</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.lqbh}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">生产厂家</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sccj}}
							</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">生产日期</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">{{form.scrq}}
							</td>
							<td colspan="1" style="height:50; font-size: 35px ; border:1px solid red;">批号</td>
							<td colspan="1" style="height:50; font-size: 35px ; border:1px solid red;">{{form.ph}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">试验次数</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">1</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">2</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">初始温度(℃)</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.cswd1}}
							</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.cswd2}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td rowspan="14" colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">
								点火器试焰每次扫过后温度上升记录(℃)</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第1次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a1}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b1}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第2次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a2}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b2}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第3次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a3}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b3}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第4次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a4}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b4}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第5次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a5}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b5}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第3次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a6}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b6}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第7次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a7}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b7}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第8次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a8}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b8}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第9次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a9}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b9}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第10次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a10}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b10}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第11次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a11}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b11}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第12次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a12}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b12}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第13次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a13}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b13}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">第14次</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.a14}}</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.b14}}</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">大气压强 (kPa)</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.dqyq}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="4" style="height:50; font-size: 35px ; border:1px solid red;">气压修正值 (℃)</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.qyxzz}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td rowspan="3" colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">闪点
								(℃)</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">测值</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sdcz1}}
							</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sdcz2}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">平均值</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sdpjz}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">修正值</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.sdxcz}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td rowspan="3" colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">燃点
								(℃)</td>
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">测值</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.rdcz1}}
							</td>
							<td colspan="3" style="height:50; font-size: 35px ; border:1px solid red;">{{form.rdcz2}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">平均值</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.rdpjz}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="2" style="height:50; font-size: 35px ; border:1px solid red;">修正值</td>
							<td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.rdxcz}}
							</td>
						</tr>
						<tr style="border: 1px solid black;">
							<td colspan="10" style="height:50; font-size: 35px ; border:1px solid red;">附加说明:
								{{form.fjsm}}
							</td>
						</tr>
					</table> -->
				</body>


				<!-- 编写表格 -->
				<table id="CL11">
					<tr>
						<td colspan="2" style="height:50; font-size: 35px ;">
							沥青试标CL11
						</td>
						<td colspan="6" style="height:50; font-size: 35px ;">
						</td>
						<td colspan="2" style="height:50; font-size: 35px ;">
							第1页，共1页
						</td>
					</tr>
					<tr>
						<td colspan="10" style="height:50; font-size: 35px ;">
							沥青闪点与燃点试验检测记录表
						</td>
					</tr>
					<tr>
						<td colspan="3" style="height:50; font-size: 35px ;">检测单位名称：</td>
						<td colspan="4" style="height:50; font-size: 35px ;">{{form.jcdwmc}}
						</td>
						<td colspan="1" style="height:50; font-size: 35px ;">
						</td>
						<td colspan="2" style="height:50; font-size: 35px ;">记录编号：{{form.jlbh}}
						</td>
						<!-- <td colspan="6" style="height:50; font-size: 35px ; border:1px solid red;">{{form.jlbh}}</td> -->
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">工程名称</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.gcmc}}</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">合同段</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.htd}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">施工单位</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sgdw}}</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">监理单位</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.jldw}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">工程部位/用途</td>
						<td colspan="8" style="height:50; font-size: 35px ; border:1px solid black;">{{form.gcbw}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">样品信息</td>
						<td colspan="8" style="height:50; font-size: 35px ; border:1px solid black;">{{form.ypxx}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">试验检测日期</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.syjcrq}}
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">试验条件</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							温度：{{form.wd}}相对湿度：{{form.xdsd}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">检测依据</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.jcyj}}</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">判定依据</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.pdyj}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">主要仪器设备名称及编号</td>
						<td colspan="8" style="height:50; font-size: 35px ; border:1px solid black;">
							{{form.zyyqsbmchbh}}
						</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">沥青种类</td>
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">{{form.lqzl}}</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">沥青标号</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.lqbh}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">生产厂家</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sccj}}</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">生产日期</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">{{form.scrq}}</td>
						<td colspan="1" style="height:50; font-size: 35px ; border:1px solid black;">批号</td>
						<td colspan="1" style="height:50; font-size: 35px ; border:1px solid black;">{{form.ph}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">试验次数</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">1</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">2</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">初始温度(℃)</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.cswd1}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.cswd2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td rowspan="14" colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">
							点火器试焰每次扫过后温度上升记录(℃)</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第1次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a1}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b1}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第2次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a2}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第3次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a3}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b3}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第4次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a4}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b4}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第5次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a5}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b5}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第3次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a6}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b6}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第7次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a7}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b7}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第8次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a8}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b8}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第9次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a9}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b9}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第10次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a10}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b10}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第11次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a11}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b11}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第12次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a12}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b12}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第13次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a13}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b13}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">第14次</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.a14}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.b14}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">大气压强 (kPa)</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">{{form.dqyq}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">气压修正值 (℃)</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">{{form.qyxzz}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td rowspan="3" colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">闪点 (℃)
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">测值</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sdcz1}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sdcz2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">平均值</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">
							{{(form.sdcz1+form.sdcz2)/2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">修正值</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">{{form.sdxcz}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td rowspan="3" colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">燃点 (℃)
						</td>
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">测值</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.rdcz1}}</td>
						<td colspan="3" style="height:50; font-size: 35px ; border:1px solid black;">{{form.rdcz2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">平均值</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">
							{{(form.rdcz1+form.rdcz2)/2}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="2" style="height:50; font-size: 35px ; border:1px solid black;">修正值</td>
						<td colspan="6" style="height:50; font-size: 35px ; border:1px solid black;">{{form.rdxcz}}</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">附加说明:
							{{form.fjsm}}
						</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">地点:
							{{form.position}}
						</td>
					</tr>
					<tr style="border: 1px solid black;">
						<td colspan="10" style="height:50; font-size: 35px ; border:1px solid black;">采集人员编号:
							{{form.userid}}
						</td>
					</tr>
				</table>
			</el-form>
			<template #footer>
				<div class="dialog-footer">
					<!-- <el-button type="primary" @click="handleUpdate">修改</el-button> -->
					<el-button type="success" @click="uploadExcel">下载</el-button>
				</div>
			</template>
		</el-dialog>




		<!-- <el-dialog :title="title" v-model="openExcel" width="900px" append-to-body>
			<el-form :model="form" :rules="rules" ref="contractRef" label-width="80px">
				<table>
					<tr>
						<td>123</td>
						<td>456</td>
						<td>{{form.jcdwmc}}</td>
					</tr>
				</table>
			</el-form>
		</el-dialog> -->

	</div>
</template>

<script setup name="contract">
	import $ from 'jquery';
	import {
		getToken
	} from "@/utils/auth";
	import {
		getCL11s,
		getCL11,
		addCL11,
		editCL11,
		deleteCL11
	} from "@/api/class224/cl11";

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
	/*** 沥青闪点与燃点数据导入参数 */
	const upload = reactive({
		// 是否显示弹出层（沥青闪点与燃点数据导入）
		open: false,
		// 弹出层标题（沥青闪点与燃点数据导入）
		title: "",
		// 是否禁用上传
		isUploading: false,
		// 是否更新已经存在的沥青闪点与燃点数据数据
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
				message: "沥青闪点与燃点数据名称不能为空",
				trigger: "blur"
			}, {
				min: 2,
				max: 20,
				message: "沥青闪点与燃点数据名称长度必须介于 2 和 20 之间",
				trigger: "blur"
			}],
			nickName: [{
				required: true,
				message: "沥青闪点与燃点数据昵称不能为空",
				trigger: "blur"
			}],
			password: [{
				required: true,
				message: "沥青闪点与燃点数据密码不能为空",
				trigger: "blur"
			}, {
				min: 5,
				max: 20,
				message: "沥青闪点与燃点数据密码长度必须介于 5 和 20 之间",
				trigger: "blur"
			}, {
				pattern: /^[^<>"'|\\]+$/,
				message: "不能包含非法字符：< > \" ' \\\ |",
				trigger: "blur"
			}],
			email: [{
				type: "email",
				message: "请输入正确的邮箱地址",
				trigger: ["blur", "change"]
			}],
			phonenumber: [{
				pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
				message: "请输入正确的手机号码",
				trigger: "blur"
			}]
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

	/** 查询沥青闪点与燃点数据列表 */
	function getList() {
		loading.value = true;
		console.log(555);
		getCL11s(queryParams.value).then(res => {
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
		proxy.$modal.confirm('是否确认删除沥青闪点与燃点数据编号为"' + cl11Ids + '"的数据项？').then(function() {
			return deleteCL11(cl11Ids);
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

	// /** 导入按钮操作 */
	// function handleImport() {
	// 	upload.title = "沥青闪点与燃点数据导入";
	// 	upload.open = true;
	// };

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
		title.value = "添加沥青闪点与燃点数据";
	};

	/** 修改按钮操作 */
	function handleUpdate(row) {
		reset();
		const id = row.id || ids.value;
		getCL11(id).then(response => {
			form.value = response.data;
			open.value = true;
			title.value = "修改沥青闪点与燃点数据";
		});
	};

	/** 提交按钮 */
	function submitForm() {
		proxy.$refs["contractRef"].validate(valid => {
			if (valid) {
				if (form.value.id != undefined) {
					editCL11(form.value).then(response => {
						proxy.$modal.msgSuccess("修改成功");
						open.value = false;
						getList();
					});
				} else {
					addCL11(form.value).then(response => {
						proxy.$modal.msgSuccess("新增成功");
						open.value = false;
						getList();
					});
				}
				reset()
			}
		});
	};

	/* 查看详情 (表格) : 有导出 了 */
	function handleDetail(row) {
		reset();
		const id = row.id || ids.value;
		getCL11(id).then(response => {
			form.value = response.data;
			openExcel.value = true;
			title.value = "沥青试标CL11";
		});
	};

	// 下载表格 
	function uploadExcel() {
		$('#CL11').table2excel({
			name: "沥青闪点与燃点试验检测记录表格",
			filename: '沥青闪点与燃点试验检测记录表',
			exclude_img: true, // 导出图片
			exclude_links: true, // 导出连接
			exclude_inputs: true, // 导出输入框
		})
	}


	getList();
</script>