import request from '@/utils/request'

// 查询视频分组列表
export function listBase(query) {
  return request({
    url: '/video/group/list',
    method: 'get',
    params: query
  })
}

// 查询视频分组详细
export function getBase(id) {
  return request({
    url: '/video/group/' + id,
    method: 'get'
  })
}

// 新增视频分组
export function addBase(data) {
  return request({
    url: '/video/group',
    method: 'post',
    data: data
  })
}

// 修改视频分组
export function updateBase(data) {
  return request({
    url: '/video/group',
    method: 'put',
    data: data
  })
}

// 删除视频分组
export function delBase(id) {
  return request({
    url: '/video/group/' + id,
    method: 'delete'
  })
}
