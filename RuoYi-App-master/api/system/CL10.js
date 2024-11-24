import upload from '@/utils/upload'
import request from '@/utils/request'

// 列表查询
export function getCL10s(pageNum, pageSize) {
  const data = {
    pageNum,
    pageSize
  }
  return request({
    url: '/getCL10s',
    method: 'get',
    params: data
  })
}

export function getCL10sOrderByCreatedTime(pageNum, pageSize) {
  const data = {
    pageNum,
    pageSize
  }
  return request({
    url: '/getCL10sgetCL10sOrderByCreatedTime',
    method: 'get',
    params: data
  })
}

// 添加数据
export function addCL10(data) {
  return request({
    url: '/addCL10',
    method: 'post',
	data: data
  })
}

export function getCL10(id) {
  return request({
    url: '/getCL10/' + id,
    method: 'get'
  })
}