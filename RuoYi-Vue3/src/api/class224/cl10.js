import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询沥青溶解度试验检测记录列表
export function getCL10s(query) {
  return request({
    url: '/getCL10s',
    method: 'get',
    params: query
  })
}

// 查询沥青溶解度试验检测记录详细
export function getCL10(id) {
  return request({
    url: '/getCL10/' + parseStrEmpty(id),
    method: 'get'
  })
}

export function getCL10ByJlbh(jlbh) {
  return request({
    url: '/getCL10ByJlbh/' + parseStrEmpty(jlbh),
    method: 'get'
  })
}


// 新增沥青溶解度试验检测记录
export function addCL10(data) {
  return request({
    url: '/addCL10',
    method: 'post',
    data: data
  })
}

// 修改沥青溶解度试验检测记录
export function editCL10(data) {
  return request({
    url: '/editCL10',
    method: 'put',
    data: data
  })
}

// 删除沥青溶解度试验检测记录
export function deleteCL10ById(id) {
  return request({
    url: '/deleteCL10ById/' + id,
    method: 'delete'
  })
}

export function deleteCL10ByIds(ids) {
  return request({
    url: '/deleteCL10ByIds/' + ids,
    method: 'delete'
  })
}

// 沥青溶解度试验检测记录头像上传
export function uploadAvatar(data) {
  return request({
    url: '//profile/avatar',
    method: 'post',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    data: data
  })
}