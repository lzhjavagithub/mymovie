import request from '@/utils/request'

// 查询导航基础列表
export function listBase(query) {
  return request({
    url: '/system/base/list',
    method: 'get',
    params: query
  })
}

// 查询导航基础详细
export function getBase(id) {
  return request({
    url: '/system/base/' + id,
    method: 'get'
  })
}

// 新增导航基础
export function addBase(data) {
  return request({
    url: '/system/base',
    method: 'post',
    data: data
  })
}

// 修改导航基础
export function updateBase(data) {
  return request({
    url: '/system/base',
    method: 'put',
    data: data
  })
}

// 删除导航基础
export function delBase(id) {
  return request({
    url: '/system/base/' + id,
    method: 'delete'
  })
}
