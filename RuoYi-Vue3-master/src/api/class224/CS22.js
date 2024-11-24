import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询土壤数据列表
export function getCS22Records(query) {
  return request({
    url: '/getCS22Records',
    method: 'get',
    params: query
  })
}

// 查询土壤数据详细
export function getCS22Record(id) {
  return request({
    url: '/getCS22Record/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增土壤数据
export function addCS22Record(data) {
  return request({
    url: '/addCS22Record',
    method: 'post',
    data: data
  })
}

// 修改土壤数据
export function editCS22Record(data) {
  return request({
    url: '/editCS22Record',
    method: 'put',
    data: data
  })
}

// 删除土壤数据
export function deleteCS22Record(id) {
  return request({
    url: '/deleteCS22Record/' + id,
    method: 'delete'
  })
}

// 土壤数据头像上传
export function uploadAvatar(data) {
  return request({
    url: '//profile/avatar',
    method: 'post',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    data: data
  })
}