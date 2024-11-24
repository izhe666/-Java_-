<template>
	<div class="app-container">
		<el-row :gutter="24">
			<!--用户数据-->
			<el-col :span="24" :xs="24">
				<el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="80px">
					<el-form-item label="记录编号" prop="jlbh">
						<el-input v-model="queryParams.jlbh" placeholder="请输入记录编号" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="工程名称" prop="gcmc">
						<el-input v-model="queryParams.gcmc" placeholder="请输入工程名称" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="检测单位" prop="jcdwmc">
						<el-input v-model="queryParams.jcdwmc" placeholder="请输入检测单位" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="施工单位" prop="sgdw">
						<el-input v-model="queryParams.sgdw" placeholder="请输入施工单位" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="监理单位" prop="jldw">
						<el-input v-model="queryParams.jldw" placeholder="请输入监理单位" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="沥青编号" prop="lqbh">
						<el-input v-model="queryParams.lqbh" placeholder="请输入沥青编号" clearable style="width: 240px"
							@keyup.enter="handleQuery" />
					</el-form-item>
					<el-form-item label="采集人员" prop="userid">
						<el-input v-model="queryParams.userid" placeholder="请输入采集人员ID" clearable style="width: 240px"
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
						<el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDeletes"
							v-hasPermi="['system:contract:remove']">删除</el-button>
					</el-col>
					<!-- <el-col :span="1.5">
						<el-button type="info" plain icon="Upload" @click="handleImport"
							v-hasPermi="['system:contract:import']">导入</el-button>
					</el-col> -->
					<!-- <el-col :span="1.5">
						<el-button type="warning" plain icon="Download" @click="handleExport"
							v-hasPermi="['system:contract:export']">导出</el-button>
					</el-col> -->
					<right-toolbar v-model:showSearch="showSearch" @queryTable="getList"
						:columns="columns"></right-toolbar>
				</el-row>

				<el-table v-loading="loading" :data="contractList" @selection-change="handleSelectionChange">
					<el-table-column type="selection" width="50" align="center" />
					<el-table-column width="100" label="ID" align="center" key="id" prop="id" />
					<el-table-column width="150" label="记录编号" align="center" key="jlbh" prop="jlbh" />
					<el-table-column width="150" label="工程名称" align="center" key="gcmc" prop="gcmc" />
					<el-table-column width="150" label="施工单位" align="center" key="sgdw" prop="sgdw" />
					<el-table-column width="150" label="监理单位" align="center" key="jldw" prop="jldw" />
					<el-table-column width="150" label="检测单位" align="center" key="jcdwmc" prop="jcdwmc" />
					<el-table-column width="150" label="合同段" align="center" key="htd" prop="htd" />
					<el-table-column width="150" label="试验检测日期" align="center" key="syjcrq" prop="syjcrq" />
					<el-table-column width="150" label="工程部位/用途" align="center" key="gcbw_yt" prop="gcbw_yt" />
					<el-table-column width="150" label="样品信息" align="center" key="ypxx" prop="ypxx" />

					<el-table-column width="150" label="试验条件：摄氏度" align="center" key="sytj_ssd" prop="sytj_ssd" />
					<el-table-column width="150" label="试验条件：相对湿度" align="center" key="sytj_xdsd" prop="sytj_xdsd" />
					<el-table-column width="150" label="检测依据" align="center" key="jcyj" prop="jcyj" />
					<el-table-column width="150" label="判定依据" align="center" key="pdyj" prop="pdyj" />
					<el-table-column width="150" label="主要仪器设备名称及编号" align="center" key="zyyqsbmcjbh"
						prop="zyyqsbmcjbh" />
					<el-table-column width="150" label="沥青种类" align="center" key="lqzl" prop="lqzl" />
					<el-table-column width="150" label="沥青标号" align="center" key="lqbh" prop="lqbh" />
					<el-table-column width="150" label="生产厂家" align="center" key="sccj" prop="sccj" />
					<el-table-column width="150" label="生产日期" align="center" key="scrq" prop="scrq" />
					<el-table-column width="150" label="生产批号" align="center" key="scph" prop="scph" />

					<el-table-column align="center" label="第一次试验">
						<el-table-column width="150" label="古氏坩埚与玻璃纤维滤纸合计质量(g)" align="center" key="m1" prop="m1" />
						<el-table-column width="120" label="锥形瓶与玻璃棒合计质量(g)" align="center" key="m2" prop="m2" />
						<el-table-column width="160" label="锥形瓶、玻璃棒与沥青试样合计质量(g)" align="center" key="m3" prop="m3" />
						<el-table-column width="180" label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" align="center" key="m4" prop="m4" />
						<el-table-column width="160" label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" align="center" key="m5" prop="m5" />
						<el-table-column width="125" label="沥青试样溶解度(%)" align="center" key="sb1" prop="sb1" />
					</el-table-column>

					<el-table-column align="center" label="第二次试验">
						<el-table-column width="150" label="古氏坩埚与玻璃纤维滤纸合计质量(g)" align="center" key="a1" prop="a1" />
						<el-table-column width="120" label="锥形瓶与玻璃棒合计质量(g)" align="center" key="a2" prop="a2" />
						<el-table-column width="160" label="锥形瓶、玻璃棒与沥青试样合计质量(g)" align="center" key="a3" prop="a3" />
						<el-table-column width="180" label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" align="center" key="a4" prop="a4" />
						<el-table-column width="160" label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" align="center" key="a5" prop="a5" />
						<el-table-column width="125" label="沥青试样溶解度(%)" align="center" key="sb2" prop="sb2" />
					</el-table-column>

					<el-table-column width="150" label="沥青试样溶解度(%)平均值" align="center" key="sb" prop="sb" />

					<el-table-column width="150" label="采集人员编号" align="center" key="userid" prop="userid" />
					<el-table-column width="150" label="采集地点" align="center" key="position" prop="position" />
					<el-table-column width="150" label="记录创建时间" align="center" key="createdTime" prop="createdTime" />
					<el-table-column width="150" label="最近修改时间" align="center" key="lastUpdatedTime"
						prop="lastUpdatedTime" />
					<el-table-column width="250" label="附加声明" align="center" key="fjsm" prop="fjsm" />

					<el-table-column label="操作" align="center" width="150" class-name="small-padding fixed-width">
						<template #default="scope">
							<el-tooltip content="下载" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Download" @click="handleDetail(scope.row)"
									v-hasPermi="['system:contract:edit']"></el-button>
							</el-tooltip>
							<el-tooltip content="修改" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
									v-hasPermi="['system:contract:edit']"></el-button>
							</el-tooltip>
							<el-tooltip content="删除" placement="top" v-if="scope.row.id !== null">
								<el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
									v-hasPermi="['system:contract:remove']"></el-button>
							</el-tooltip>

						</template>
					</el-table-column>
				</el-table>
				<pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum"
					v-model:limit="queryParams.pageSize" @pagination="getList" />
			</el-col>
		</el-row>

		<!-- 新增或修改土壤数据配置对话框 -->
		<el-dialog :title="title" v-model="open" width="800px" append-to-body>
			<el-form :model="form" :rules="rules" ref="contractRef" label-width="80px"> <!-- 输入方框左边的字样设置 -->

				<h2 class="text-center">基本信息</h2>

				<el-row>
					<!-- 工程名称 -->
					<el-col :span="11">
						<el-form-item label="工程名称" prop="gcmc">
							<el-input v-model="form.gcmc" placeholder="请输入工程名称" />
						</el-form-item>
					</el-col>
					<!-- 记录编号 -->
					<el-col :span="12">
						<el-form-item label="记录编号" prop="jlbh" required label-width="100">
							<el-input v-model="form.jlbh" placeholder="请输入记录编号" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 施工单位 -->
				<el-row>
					<el-col :span="7">
						<el-form-item label="施工单位" prop="sgdw">
							<el-input v-model="form.sgdw" placeholder="请输入施工单位" />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="检测单位" prop="jcdwmc" label-width="90px">
							<el-input v-model="form.jcdwmc" placeholder="请输入检测单位" />
						</el-form-item>
					</el-col>
					<el-col :span="8">
						<el-form-item label="监理单位" prop="jldw" label-width="90px">
							<el-input v-model="form.jldw" placeholder="请输入监理单位" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 合同段 -->
				<el-row>
					<el-col :span="9">
						<el-form-item label="合同段" prop="htd">
							<el-input v-model="form.htd" placeholder="请输入合同段" />
						</el-form-item>
					</el-col>
					<el-col :span="14">
						<el-form-item label="工程部位" prop="gcbw_yt" label-width="90">
							<el-input v-model="form.gcbw_yt" placeholder="请输入工程部位（用途）" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 样品信息 -->
				<el-row>
					<el-col :span="15">
						<el-form-item label="样品信息" prop="ypxx">
							<el-input type="textarea" v-model="form.ypxx" placeholder="请输入样品信息" maxlength="30" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<el-col :span="11">
						<el-form-item label="采集人员" prop="userid">
							<el-input v-model="form.userid" placeholder="请输入采集人员ID" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="采集地点" prop="position" label-width="100">
							<el-input v-model="form.position" placeholder="请输入数据采集地点" />
						</el-form-item>
					</el-col>
				</el-row>

				<h2 class="text-center">沥青信息</h2>

				<el-row>
					<!-- 沥青种类 -->
					<el-col :span="11">
						<el-form-item label="沥青种类" prop="lqzl">
							<el-input v-model="form.lqzl" placeholder="请输入沥青种类" />
						</el-form-item>
					</el-col>

					<!-- 沥青编号 -->
					<el-col :span="12">
						<el-form-item label="沥青编号" prop="lqbh" label-width="100">
							<el-input v-model="form.lqbh" placeholder="请输入沥青编号" />
						</el-form-item>
					</el-col>
				</el-row>


				<el-row>
					<!-- 生产厂家 -->
					<el-col :span="11">
						<el-form-item label="生产厂家" prop="sccj">
							<el-input v-model="form.sccj" placeholder="请输入生产厂家" />
						</el-form-item>
					</el-col>

					<!-- 生产批号 -->
					<el-col :span="12">
						<el-form-item label="生产批号" prop="scph" label-width="100">
							<el-input v-model="form.scph" placeholder="请输入生产批号" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 生产日期 -->
				<el-row>
					<el-col :span="6.5">
						<el-form-item label="生产日期" prop="scrq">
							<el-date-picker v-model="form.scrq" value-format="YYYY-MM-DD HH-mm-ss" type="datetime"
								style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
				</el-row>

				<h2 class="text-center">试验信息</h2>

				<el-row>
					<el-col :span="8">
						<el-form-item label="检测日期" prop="syjcrq">
							<el-date-picker v-model="form.syjcrq" value-format="YYYY-MM-DD" type="datetime" 
								style="width: 100%;"></el-date-picker>
						</el-form-item>
					</el-col>
					<el-col :span="15">
						<el-form-item label="主要仪器" prop="zyyqsbmcjbh" label-width="100">
							<el-input v-model="form.zyyqsbmcjbh" placeholder="请输入主要仪器设备名称及编号" />
						</el-form-item>
					</el-col>
				</el-row>

				<el-row>
					<!-- 试验条件：摄氏度 -->
					<el-col :span="11">
						<el-form-item label="摄氏度(℃)" prop="sytj_ssd" label-width="89	">
							<el-input v-model="form.sytj_ssd" placeholder="请输入试验条件：摄氏度" />
						</el-form-item>
					</el-col>

					<!-- 试验条件：相对湿度 -->
					<el-col :span="12">
						<el-form-item label="相对湿度(%)" prop="sytj_xdsd" label-width="120">
							<el-input v-model="form.sytj_xdsd" placeholder="请输入试验条件：相对湿度" />
						</el-form-item>
					</el-col>
				</el-row>

				<!-- 检测依据 -->
				<el-row>
					<el-col :span="11">
						<el-form-item label="检测依据" prop="jcyj">
							<el-input v-model="form.jcyj" placeholder="请输入检测依据" />
						</el-form-item>
					</el-col>
					<el-col :span="12">
						<el-form-item label="判定依据" prop="pdyj" label-width="100">
							<el-input v-model="form.pdyj" placeholder="请输入判定依据" />
						</el-form-item>
					</el-col>
				</el-row>


				<h3 class="text-center">第一次试验数据</h3>
				<el-row>
					<el-col :span="22">
						<el-form-item label="古氏坩埚与玻璃纤维滤纸合计质量(g)" prop="m1" label-width="300">
							<el-input type="number" v-model="form.m1" placeholder="" />
						</el-form-item>
					</el-col>

				</el-row>
				<el-col :span="22">
					<el-form-item label="锥形瓶与玻璃棒合计质量(g)" prop="m2" label-width="300">
						<el-input type="number" v-model="form.m2" placeholder="" />
					</el-form-item>
				</el-col>
				<el-row>
					<el-col :span="22">
						<el-form-item label="锥形瓶、玻璃棒与沥青试样合计质量(g)" prop="m3" label-width="300">
							<el-input type="number" v-model="form.m3" placeholder="" />
						</el-form-item>
					</el-col>
				</el-row>
				<el-col :span="22">
					<el-form-item label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" prop="m4" label-width="305">
						<el-input type="number" v-model="form.m4" placeholder="" />
					</el-form-item>
				</el-col>

				<el-row>
					<el-col :span="22">
						<el-form-item label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" prop="m5" label-width="300">
							<el-input type="number" v-model="form.m5" placeholder="" />
						</el-form-item>
					</el-col>
				</el-row>


				<h3 class="text-center">第二次试验数据</h3>

				<!--  古氏坩埚与玻璃纤维滤纸合计质量(g) -->
				<el-row>
					<el-col :span="22">
						<el-form-item label="古氏坩埚与玻璃纤维滤纸合计质量(g)" prop="a1" label-width="300">
							<el-input type="number" v-model="form.a1" placeholder="" />
						</el-form-item>
					</el-col>

				</el-row>
				<el-col :span="22">
					<el-form-item label="锥形瓶与玻璃棒合计质量(g)" prop="a2" label-width="300">
						<el-input type="number" v-model="form.a2" placeholder="" />
					</el-form-item>
				</el-col>
				<el-row>
					<el-col :span="22">
						<el-form-item label="锥形瓶、玻璃棒与沥青试样合计质量(g)" prop="a3" label-width="300">
							<el-input type="number" v-model="form.a3" placeholder="" />
						</el-form-item>
					</el-col>
				</el-row>
				<el-col :span="22">
					<el-form-item label="古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)" prop="a4" label-width="305">
						<el-input type="number" v-model="form.a4" placeholder="" />
					</el-form-item>
				</el-col>

				<el-row>
					<el-col :span="22">
						<el-form-item label="锥形瓶、玻璃棒与黏附不溶物合计质量(g)" prop="a5" label-width="300">
							<el-input type="number" v-model="form.a5" placeholder="" />
						</el-form-item>
					</el-col>
				</el-row>


				<h3 class="text-center">其他</h3>
				<!-- 附加说明 -->
				<el-row>
					<el-col :span="24">
						<el-form-item label="附加说明" prop="fjsm">
							<el-input type="textarea" v-model="form.fjsm" placeholder="请输入附加说明" />
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

		<!-- 数据导入对话框 -->
		<!-- 		<el-dialog :title="upload.title" v-model="upload.open" width="400px" append-to-body>
			<el-upload ref="uploadRef" :limit="1" accept=".xlsx, .xls" :headers="upload.headers"
				:action="upload.url + '?updateSupport=' + upload.updateSupport" :disabled="upload.isUploading"
				:on-progress="handleFileUploadProgress" :on-success="handleFileSuccess" :auto-upload="false" drag>
				<el-icon class="el-icon--upload"><upload-filled /></el-icon>
				<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
				<template #tip>
					<div class="el-upload__tip text-center">
						<div class="el-upload__tip">
							<el-checkbox v-model="upload.updateSupport" />是否更新已经存在的土壤数据数据
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
		</el-dialog> -->


		<!-- 下载对话框 -->
		<el-dialog :title="title" v-model="openExcel" width="800px">


			<table id="CL10Table" width="100%" :border="true" cellspacing="0" cellpadding="20" bgcolor="#ffffff">
				<thead>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</thead>

				<tr>
					<td colspan="16" align="center" height="100" fron-size="50">沥青溶解度试验检测记录表</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">检测单位名称</td>
					<td colspan="8" align="center" height="50">{{form.jcdwmc}}</td>
					<td colspan="2" align="center" height="50">记录编号</td>
					<td colspan="4" align="center" height="50">{{form.jlbh}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">工程名称</td>
					<td colspan="7" align="center" height="50">{{form.gcmc}}</td>
					<td colspan="2" align="center" height="50">合同段</td>
					<td colspan="5" align="center" height="50">{{form.htd}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">施工单位</td>
					<td colspan="6" align="center" height="50">{{form.sgdw}}</td>
					<td colspan="2" align="center" height="50">监理单位</td>
					<td colspan="6" align="center" height="50">{{form.jldw}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">工程部位/用途</td>
					<td colspan="14" align="center" height="50">{{form.gcbw_yt}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">样品信息</td>
					<td colspan="14" align="center" height="50">{{form.ypxx}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">试验检测日期</td>
					<td colspan="6" align="center" height="50">{{form.syjcrq}}</td>
					<td colspan="2" align="center" height="50">试验条件</td>
					<td colspan="6" align="center" height="50">摄氏度:{{form.sytj_ssd}}℃ , 相对湿度:{{form.sytj_xdsd}}%</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">检测依据</td>
					<td colspan="6" align="center" height="50">{{form.jcyj}}</td>
					<td colspan="2" align="center" height="50">判定依据</td>
					<td colspan="6" align="center" height="50">{{form.pdyj}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">主要仪器设备名称及编号</td>
					<td colspan="14" align="center" height="50">{{form.zyyqsbmcjbh}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">沥青种类</td>
					<td colspan="6" align="center" height="50">{{form.lqzl}}</td>
					<td colspan="2" align="center" height="50">沥青标号</td>
					<td colspan="6" align="center" height="50">{{form.lqbh}}</td>
				</tr>

				<tr>
					<td colspan="2" align="center" height="50">生产厂家</td>
					<td colspan="4" align="center" height="50">{{form.sccj}}</td>
					<td colspan="2" align="center" height="50">生产日期</td>
					<td colspan="4" align="center" height="50">{{form.scrq}}</td>
					<td colspan="1" align="center" height="50">批号</td>
					<td colspan="3" align="center" height="50">{{form.scph}}</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">试验次数</td>
					<td colspan="5" align="center" height="50">一</td>
					<td colspan="5" align="center" height="50">二</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">古氏坩埚与玻璃纤维滤纸合计质量(g)</td>
					<td colspan="5" align="center" height="50">{{form.m1}}</td>
					<td colspan="5" align="center" height="50">{{form.a1}}</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">锥形瓶与玻璃棒合计质量(g)</td>
					<td colspan="5" align="center" height="50">{{form.m2}}</td>
					<td colspan="5" align="center" height="50">{{form.a2}}</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">锥形瓶、玻璃棒与沥青试样合计质量(g)</td>
					<td colspan="5" align="center" height="50">{{form.m3}}</td>
					<td colspan="5" align="center" height="50">{{form.a3}}</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)</td>
					<td colspan="5" align="center" height="50">{{form.m4}}</td>
					<td colspan="5" align="center" height="50">{{form.a4}}</td>
				</tr>

				<tr>
					<td colspan="6" align="center" height="50">锥形瓶、玻璃棒与粘附不溶物合计质量(g)</td>
					<td colspan="5" align="center" height="50">{{form.m5}}</td>
					<td colspan="5" align="center" height="50">{{form.a5}}</td>
				</tr>

				<tr>
					<td colspan="4" align="center" rowspan="2" height="50">沥青试样溶解度(%)</td>
					<td colspan="2" height="50">单值</td>
					<td colspan="5" align="center" height="50">{{form.sb1}}</td>
					<td colspan="5" align="center" height="50">{{form.sb2}}</td>
				</tr>

				<tr>
					<td colspan="2" height="50">平均值</td>
					<td colspan="10" align="center" height="50">{{form.sb}}</td>
				</tr>

				<tr>
					<td colspan="16" align="left" height="100">附加说明: {{form.fjsm}}</td>
				</tr>
				<tr>
					<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">检测：
					</td>
					<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">记录：
					</td>
					<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">复合:
					</td>
					<td colspan="4" style="height:50; font-size: 35px ; border:1px solid black;">日期：
					</td>
				</tr>

			</table>
			<template #footer>
				<div class="dialog-footer"><el-button type="success" @click="downloadExcel()">下 载</el-button><el-button
						type="default" @click="cancel()">取 消</el-button></div>
			</template>
		</el-dialog>
	</div>
</template>
<script setup name="contract">
	import $ from 'jquery'; //安装命令 npm install jquery

	import {
		getToken
	}

	from "@/utils/auth";

	import {
		getCL10s,
		getCL10,
		addCL10,
		editCL10,
		deleteCL10ById,
		deleteCL10ByIds,
		getCL10ByJlbh,
	}

	from "@/api/class224/cl10";

	const router = useRouter();

	const {
		proxy
	}

	= getCurrentInstance();

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
	


	const data = reactive({
		form: {
			// jlbh: '', // 记录编号
			// gcmc: '', // 工程名称
			// sgdw: '', // 施工单位
			// jcdwmc: '', // 检测单位
			// htd: '', // 合同段
			// jldw: '', // 监理单位
			// gcbw_yt: '', // 工程部位（用途）
			// ypxx: '', // 样品信息
			// lqzl: '', // 沥青资料
			// lqbh: '', // 沥青编号
			// sccj: '', // 生产厂家
			// scrq: '', // 生产日期
			// scph: '', // 生产批号
			// syjcrq: '',
			// sytj_ssd: '', // 试验条件：摄氏度
			// sytj_xdsd: '', // 试验条件：相对湿度
			// jcyj: '', // 检测依据
			// pdyj: '', // 判定依据
			// zyyqsbmcjbh: '', // 主要仪器设备名称及编号
			// m1: '',
			// m2: '',
			// m3: '',
			// m4: '',
			// m5: '',
			// a1: '',
			// a2: '',
			// a3: '',
			// a4: '',
			// a5: '',
			// sb1: '',
			// sb2: '',
			// sb: '',
			// fjsm: '', // 附加说明
		}

		,
		queryParams: {
			pageNum: 1,
			pageSize: 10,
			jlbh: undefined, // 记录编号
			gcmc: undefined, // 工程名称
			sgdw: undefined, // 施工单位
			jcdwmc: undefined, // 检测单位
			jldw: undefined, // 监理单位
			lqbh: undefined, // 沥青编号
			userid: undefined, //
		}

		,
		rules: {
			jlbh: {
				required: true,
				message: "记录编号不能为空",
				trigger: ["blur", "change"]
			}

			,
			/* 	{
					min: 2,
					max: 20,
					message: "土壤数据名称长度必须介于 2 和 20 之间",
					trigger: "blur"
				}, */
			gcmc: {
				required: true,
				message: "工程名称不能为空",
				trigger: ["blur", "change"]
			}

			,
			sgdw: {
				required: true,
				message: "施工单位不能为空",
				trigger: ["blur", "change"]
			}

			,
			jldw: {
				required: true,
				message: "监理单位不能为空",
				trigger: ["blur", "change"]
			}

			,
			jcdwmc: {
				required: true,
				message: "检测单位不能为空",
				trigger: ["blur", "change"]
			}

			,
			syjcrq: [
				{
					required: true,
					message: "试验检测日期不能为空",
					trigger: ["blur", "change"]
				},
			],
			htd: {
				required: true,
				message: "合同段不能为空",
				trigger: ["blur", "change"]
			},
			userid: {
				required: true,
				message: "采集人员ID不能为空",
				trigger: ["blur", "change"]
			},
		}
	});

	const {
		queryParams,
		form,
		rules
	}

	= toRefs(data);

	/** 通过条件过滤节点  */
	const filterNode = (value, data) => {
		if (!value) return true;
		return data.label.indexOf(value) !== -1;
	}

	;

	/** 查询列表 */
	function getList() {
		loading.value = true;
		console.log(555);

		getCL10s(queryParams.value).then(res => {
			console.log(123);
			console.log(res);
			contractList.value = res.data.list;
			total.value = res.data.total;
			loading.value = false;
		});
	}

	;

	/** 节点单击事件 */
	function handleNodeClick(data) {
		queryParams.value.deptId = data.id;
		handleQuery();
	}

	;

	/** 搜索按钮操作 */
	function handleQuery() {
		queryParams.value.pageNum = 1;
		// getCL10ByJlbh();
		getList();
	}

	;

	/** 重置按钮操作 */
	function resetQuery() {
		//dateRange.value = [];
		proxy.resetForm("queryRef");
		//queryParams.value.deptId = undefined;
		//proxy.$refs.deptTreeRef.setCurrentKey(null);
		handleQuery();
	}

	;

	/** 删除按钮操作 */
	function handleDelete(row) {
		const cl10Ids = row.id;
		
		proxy.$modal.confirm('是否确认删除ID为"' + cl10Ids + '"沥青溶解度试验检测记录项？').then(function() {
			return deleteCL10ById(cl10Ids);

		}).then(() => {
			getList();
			proxy.$modal.msgSuccess("删除成功");

		}).catch(() => {});
	};
	
	function handleDeletes() {
		const cl10Ids = ids.value;
		
		proxy.$modal.confirm('是否确认删除ID为"' + cl10Ids + '"沥青溶解度试验检测记录项？').then(function() {
			return deleteCL10ByIds(cl10Ids);
	
		}).then(() => {
			getList();
			proxy.$modal.msgSuccess("删除成功");
	
		}).catch(() => {});
	};


	/** 导出按钮操作 */
	function handleExport() {
		proxy.download("system/contract/export", {
				...queryParams.value,
			}

			, `contract_${new Date().getTime()}.xlsx`);
	}

	;


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
	}

	;

	/** 选择条数  */
	function handleSelectionChange(selection) {
		ids.value = selection.map(item => item.id);
		single.value = selection.length != 1;
		multiple.value = !selection.length;
	}

	;

	/** 下载模板操作 */
	function importTemplate() {
		proxy.download("system/contract/importTemplate", {}

			, `contract_template_${new Date().getTime()}.xlsx`);
	}

	;

	/**文件上传中处理 */
	const handleFileUploadProgress = (event, file, fileList) => {
		upload.isUploading = true;
	}

	;

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
	}

	;

	/** 提交上传文件 */
	function submitFileForm() {
		proxy.$refs["uploadRef"].submit();
	}

	;

	/** 重置操作表单 */
	function reset() {
		form.value = {}

		;
		proxy.resetForm("contractRef");
	}

	;

	/** 取消按钮 */
	function cancel() {
		open.value = false;
		openExcel.value = false;
		reset();
	}

	;

	/** 新增按钮操作 */
	function handleAdd() {
		open.value = true;
		title.value = "添加沥青溶解度试验检测记录	";
	}

	;

	/** 修改按钮操作 */
	function handleUpdate(row) {
		reset();
		const id = row.id || ids.value;

		getCL10(id).then(response => {
			form.value = response.data;
			open.value = true;
			title.value = "修改沥青溶解度试验检测记录	";
		});
	}

	;

	/** 预览下载操作 */
	function handleDetail(row) {
		reset();
		const id = row.id || ids.value;

		getCL10(id).then(response => {
			form.value = response.data;
			openExcel.value = true;
			title.value = "查看沥青溶解度试验检测记录详情";
		});
	}

	;

	function downloadExcel() {
		$('#CL10Table').table2excel({
			name: "CL10Table",
			exclu_img: true, //导出图片
			exclu_links: true, //导出连接
			exclu_inputs: true, //导出输入框
		})
	}

	/** 导出按钮操作 */
	// function handleExport() {
	// 	proxy.download("system/contract/export", {
	// 		...queryParams.value,
	// 	}, `contract_${new Date().getTime()}.xlsx`);
	// };


	/** 提交按钮 */
	function submitForm() {
		proxy.$refs["contractRef"].validate(valid => {
			if (valid) {
				if (form.value.id != undefined) {
					editCL10(form.value).then(response => {
						proxy.$modal.msgSuccess("修改成功");
						open.value = false;
						getList();
					});
				} else {
					addCL10(form.value).then(response => {
						console.log(form.value);
						proxy.$modal.msgSuccess("新增成功");
						open.value = false;
						getList();
					});
				}
				reset()
			}
		});
	};

	getList();
</script>