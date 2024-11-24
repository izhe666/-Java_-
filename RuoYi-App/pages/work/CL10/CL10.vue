<template>
	<view>
		<!-- <view v-for="item in userList">
			<view>{{item.id}}-{{item.username}}
				-{{item.password}}</view>
		</view> -->
		<!-- <uni-list-chat v-for="item in CL10List" 
		    :title="item.gcmc"
			:note="'记录编号:'+item.jlbh +  '\n施工单位：'+item.sgdw + '\n监理单位:'+item.jldw"
			:time="item.syjcrq"
			badge-positon="left"></uni-list-chat> -->

		<uni-list>
			<uni-list-item v-for="item in CL10List" :title="item.gcmc"
				:note="'记录编号:'+item.jlbh +  '\n施工单位：'+item.sgdw + '\n监理单位:'+item.jldw + '\n试验时间:' + item.syjcrq"
				@click="onClick(item.id)" clickable>
			</uni-list-item>
		</uni-list>

		<uni-fab ref="fab" :pattern="pattern" :horizontal="horizontal" :vertical="vertical" :direction="direction"
			@trigger="trigger" @fabClick="fabClick" />

	</view>
</template>

<script>
	import {
		getCurrentScope,
		useSlots
	} from 'vue';
	import {
		getCL10s,
		getCL10,
		getCL10sOrderByCreatedTime
	} from '@/api/system/CL10.js';

	export default {
		data() {
			return {
				CL10List: [{
					id: '',
					jlbh: '',
					gcmc: '',
					ypxx: '',
					syjcrq: '',

				}],
				pageNum: 1,
				/* 悬浮按钮参数 */
				title: 'uni-fab',
				directionStr: '垂直',
				horizontal: 'right',
				vertical: 'bottom',
				direction: 'horizontal',
				pattern: {
					color: '#7A7E83',
					backgroundColor: '#fff',
					selectedColor: '#007AFF',
					buttonColor: '#007AFF',
					iconColor: '#fff'
				},
			}
		},
		onLoad() {
			this.getCLs();
		},
		onReady() {

		},
		onPullDownRefresh() { //下拉刷新
			console.log('下拉刷新');
			var that = this;
			setTimeout(function() {
				that.getCLs();
				uni.stopPullDownRefresh(); //终止下拉刷新
			}, 1500);
		},
		onReachBottom() {
			console.log("到底了");
			var that = this;
			setTimeout(function() {
				that.pageNum = that.pageNum + 1;
				console.log("页数+1");
				console.log(that.pageNum);
				getCL10s(that.pageNum, 7).then(res => {
					that.CL10List = [...that.CL10List, ...res.data.list];
					console.log(44);
					console.log(res);
				});
				uni.stopPullDownRefresh(); //终止下拉刷新
			}, 1500);

		},
		methods: {
			getCLs() {
				console.log(888)
				getCL10s(1, 7).then(res => {
					console.log(44);
					console.log(res);
					this.CL10List = res.data.list;
				})
			},

			fabClick() {
				/*悬浮按钮点击事件 */
				uni.navigateTo({
					/* 页面跳转 */
					url: "/pages/work/CL10/addCL10"
				})
			},



			onClick: function(id) {
				this.$router.push({
					path: '/pages/work/CL10/CL10Detail',
					
					query: {
						cl10id: id 
					}
				})
			},
		}
	}
</script>

<style>
	.title {
		font-size: 20px;
		margin: 0px;
		color: green;
		width: 100%;
		padding-left: 3px;
		padding-top: 8px;
		padding-bottom: 15px;
		padding-right: 8px;
	}

	.userbtn {
		width: 100px;
		font-size: 12px;
		background-color: aqua;
	}

	uni-navigator {
		display: inline-block;
		float: right;
		margin-right: 8px;
	}
</style>