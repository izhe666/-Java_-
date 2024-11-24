<template>
	<view>
		<!-- 自定义右侧内容 -->
		<uni-list-chat v-for="item in userList" :title="item.jcdw" avatar=""
			:note="item.jcdwmc+'\n'+item.gcmc+'\n'+item.jlbh+'\n'+item.sgdw" badge-positon="left">
		</uni-list-chat>

		<!-- 添加悬浮按钮 : 就是动态数据要定义         -->
		<uni-fab ref="fab" :pattern="pattern" :horizontal="horizontal" 
		:vertical="vertical" :direction="direction"
			@trigger="trigger" @fabClick="fabClick" />
	</view>
</template>

<script>
	import {
		getCL11s
	} from '@/api/system/CL11';
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
						res.data[0].username = res.data[0].username + new Date().getTime();
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
					res.data[0].gener = res.data[0].gener + new Date().getTime();
					console.log(that.userList);
					that.userList = [...that.userList, ...res.data];
				}
			})
		},
		methods: {
			//<!-- 悬浮点击事件函数 -->
			fabClick() {
				// uni.showToast({
				//     title: '点击了悬浮按钮',
				//     icon: 'none'
				// })
				//点击跳转
				uni.navigateTo({
					url: "/pages/work/CL11/addCL11"
				})
			},
			getUsers() {
				// uni.request({
				// url: "/api/getUsers",
				// type: "get",
				// success: res => {
				console.log(888);
				//     console.log(res.data);
				//     //请求回数据
				//     this.userList = res.data;
				// }
				getCL11s(1, 20).then(res => {
					console.log(44);
					console.log(res);
					this.userList = res.data.list;
				})
				// }
			}
		}
	}
</script>

<style>

</style>