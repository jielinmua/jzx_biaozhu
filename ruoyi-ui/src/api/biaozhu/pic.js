import request from '@/utils/request'

// 查询标注列表
export function listPic(query) {
  return request({
    url: '/biaozhu/pic/list',
    method: 'get',
    params: query
  })
}

// 查询标注详细
export function getPic(pId) {
  return request({
    url: '/biaozhu/pic/' + pId,
    method: 'get'
  })
}

// 新增标注
export function addPic(data) {
  return request({
    url: '/biaozhu/pic',
    method: 'post',
    data: data
  })
}

// 修改标注
export function updatePic(data) {
  return request({
    url: '/biaozhu/pic',
    method: 'put',
    data: data
  })
}

// 删除标注
export function delPic(pId) {
  return request({
    url: '/biaozhu/pic/' + pId,
    method: 'delete'
  })
}
