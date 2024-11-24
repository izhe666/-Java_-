import upload from '@/utils/upload'
import request from '@/utils/request'

// 列表查询
export function getCL11s(pageNum, pageSize) {
	const data = {
		pageNum,
		pageSize
	}
	return request({
		url: '/getCL11s',
		method: 'get',
		params: data
	})
}

// 添加数据
export function addCL11(data) {
	return request({
		url: '/addCL11',
		method: 'post',
		data: data
	})
}