import request from '@/utils/request'

// 查询数据图表列表
export function listBiao(query) {
  return request({
    url: '/info/biao/list',
    method: 'get',
    params: query
  })
}

// 查询数据图表详细
export function getBiao(pId) {
  return request({
    url: '/info/biao/' + pId,
    method: 'get'
  })
}

// 新增数据图表
export function addBiao(data) {
  return request({
    url: '/info/biao',
    method: 'post',
    data: data
  })
}

// 修改数据图表
export function updateBiao(data) {
  return request({
    url: '/info/biao',
    method: 'put',
    data: data
  })
}

// 删除数据图表
export function delBiao(pId) {
  return request({
    url: '/info/biao/' + pId,
    method: 'delete'
  })
}
export function uploadFile(file) {
  return request({
    url: '/info/biao/fileUploads',
    method: 'post',
    data: file,
    headers: {
      "Content-Type": "multipart/form-data"
    }
  })
}
export function getPatientList(query) {
  return request({
    url: '/info/biao/getPatientList',
    method: 'get',
    params: query
  })
}
