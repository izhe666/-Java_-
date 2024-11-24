import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询土壤数据列表
export function getCL11s(query) {
  return request({
    url: '/getCL11s',
    method: 'get',
    params: query
  })
}

// 查询土壤数据详细
export function getCL11(id) {
  return request({
    url: '/getCL11/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增土壤数据
export function addCL11(data) {
  return request({
    url: '/addCL11',
    method: 'post',
    data: data
  })
}

// 修改土壤数据
export function editCL11(data) {
  return request({
    url: '/editCL11',
    method: 'put',
    data: data
  })
}

// 删除土壤数据
export function deleteCL11(id) {
  return request({
    url: '/deleteCL11/' + id,
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