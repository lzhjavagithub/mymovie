import request from '@/utils/request'

// 查询视频基础列表
export function listBase(query) {
  return request({
    url: '/video/info/list',
    method: 'get',
    params: query
  })
}

// 查询视频基础详细
export function getBase(id) {
  return request({
    url: '/video/info/' + id,
    method: 'get'
  })
}

// 新增视频基础
export function addBase(data) {
  return request({
    url: '/video/info',
    method: 'post',
    data: data
  })
}

// 修改视频基础
export function updateBase(data) {
  return request({
    url: '/video/info',
    method: 'put',
    data: data
  })
}

// 删除视频基础
export function delBase(id) {
  return request({
    url: '/video/info/' + id,
    method: 'delete'
  })
}
