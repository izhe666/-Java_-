import upload from '@/utils/upload'
import request from '@/utils/request'

// 列表查询
export function getCS22Records(pageNum, pageSize) {
  const data = {
    pageNum,
    pageSize
  }
  return request({
    url: '/getCS22Records',
    method: 'get',
    params: data
  })
}

// 添加数据
export function addCS22Record(data) {
  return request({
    url: '/addCS22Record',
    method: 'post',
	data: data
  })
}

