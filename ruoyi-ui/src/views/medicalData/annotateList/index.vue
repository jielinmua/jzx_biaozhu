<template>
  <div>

    <button @click="test">测试</button>
  </div>
</template>

<script>
export default {
  methods: {

    test() {
      //跳转页面
      this.$router.push({
        path: '/medicalData/annotate'
      })
    }
  },
}
</script>

<style scoped lang="scss"></style>