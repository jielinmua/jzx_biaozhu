import request from '@/utils/request'

export function getAnnotateData(data) {
  return request({
    url: '/biaozhu/pic/'+data.pId,
    method: 'get',
  })
}

/**
 * 根据pid更新标注数据
 * @param data 数据
 * @param data.pid 数据id
 * @returns {*}
 */
export function updateAnnotateData(data){
  return request({
    url:'/biaozhu/pic',
    method:'put',
    data:data
  })
}
