import request from '@/utils/request'

// 查询视频分类列表
export function listType(query) {
  return request({
    url: '/video/type/list',
    method: 'get',
    params: query
  })
}

// 查询视频分类详细
export function getType(id) {
  return request({
    url: '/video/type/' + id,
    method: 'get'
  })
}

// 新增视频分类
export function addType(data) {
  return request({
    url: '/video/type',
    method: 'post',
    data: data
  })
}

// 修改视频分类
export function updateType(data) {
  return request({
    url: '/video/type',
    method: 'put',
    data: data
  })
}

// 删除视频分类
export function delType(id) {
  return request({
    url: '/video/type/' + id,
    method: 'delete'
  })
}
